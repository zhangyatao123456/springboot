package com.yixue.xdatam.controller.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yixue.common.util.PageUtils;
import com.yixue.xdatam.controller.shrio.AbstractController;
import com.yixue.xdatam.entity.data.SubjectAnalyseEntity;
import com.yixue.xdatam.common.exceptions.R;
import com.yixue.xdatam.service.data.SubjectAnalyseService;
import com.yixue.xdatam.tool.ExcelUtil;
import com.yixue.xdatam.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 题目分析
 *
 * @author IBM CHEN ZHI KAN
 * @create 2017/8/25
 */
@Controller
@RequestMapping("/data/subject")
public class SubjectAnalyseController extends AbstractController {
    @Autowired
    private SubjectAnalyseService subjectAnalyseService;
    //查询数据库的记录数为0
    private final static Integer ZERO_RECORD;
    private final static String[] RIGHTRATE_GROUP = {"0.0%", "10.0%", "20.0%", "30.0%", "40.0%", "50.0%", "60.0%", "70.0%", "80.0%", "90.0%", "100.0%"};

    static {
        ZERO_RECORD = 0;
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        if (params.get("startDate") == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
            String defaultStartDay = sdf.format(new Date());
            params.put("startDate", defaultStartDay);
        }
        Query query = new Query(params);
        List<SubjectAnalyseEntity> list = subjectAnalyseService.listSubject(query);
        int total = subjectAnalyseService.totalSubject(query);
        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    /**
     * 柱状图：按正确率分组，统计每组中的题目数量
     *
     * @return
     * @RequestParam Map<String, Object> params
     */
    @RequestMapping(value = "/countRightRate")
    @ResponseBody
    public R countRightRate(String startDate, String endDate, String difficulty, String tagCodeCount, String minRightRate, String maxRightRate, String subject) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        params.put("difficulty", difficulty);
        params.put("tagCodeCount", tagCodeCount);
        params.put("minRightRate", minRightRate);
        params.put("maxRightRate", maxRightRate);
        params.put("subject", subject);


        if (params.get("startDate") == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
            String defaultStartDay = sdf.format(new Date());
            params.put("startDate", defaultStartDay);
        }
        List<SubjectAnalyseEntity> results = subjectAnalyseService.countRightRate(params);
        JSONObject vo = new JSONObject();
        //获取折线图数据
        JSONArray datas = this.getLineDatas(results);
        //获取折线图图例
        JSONArray legend = this.getLineLegend(results);
        vo.put("series", datas);
        vo.put("xAxis", RIGHTRATE_GROUP);
        vo.put("legend", legend);
        return R.ok().put("data", vo);
    }

    /**
     * 按难度进行分组
     *
     * @return
     */
    private Map<String, List<SubjectAnalyseEntity>> groupByDiffculty(List<SubjectAnalyseEntity> results) {
        Map<String, List<SubjectAnalyseEntity>> map = new HashMap<String, List<SubjectAnalyseEntity>>();
        for (SubjectAnalyseEntity result : results) {
            if (null == map.get(result.getDifficulty())) {
                List<SubjectAnalyseEntity> list = new ArrayList<SubjectAnalyseEntity>();
                list.add(result);
                map.put(result.getDifficulty(), list);
            } else {
                List<SubjectAnalyseEntity> list = map.get(result.getDifficulty());
                list.add(result);
                map.put(result.getDifficulty(), list);
            }
        }
        return map;
    }

    /**
     * 获取折线图option
     *
     * @return
     */
    private JSONArray getLineDatas(List<SubjectAnalyseEntity> results) {
        Map<String, List<SubjectAnalyseEntity>> map = this.groupByDiffculty(results);
        JSONArray datas = new JSONArray();
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            JSONObject obj = new JSONObject();
            JSONArray data = new JSONArray();
            int group_index = 0;
            String difficulty = iter.next();
            List<SubjectAnalyseEntity> currResults = map.get(difficulty);
            for (int i = 0; i < currResults.size(); i++) {
                //要判断是否有少的百分比要补0
                SubjectAnalyseEntity currResult = currResults.get(i);
                while (!RIGHTRATE_GROUP[group_index].equals(currResult.getRightRate())) {
                    data.add("0");
                    group_index = group_index + 1;
                }
                data.add(currResult.getQuestionId());
                group_index = group_index + 1;
            }
            obj.put("name", "难度级别:" + difficulty);
            obj.put("type", "line");
            obj.put("data", data);
            datas.add(obj);
        }
        return datas;
    }

    /**
     * 获取折线图图例
     *
     * @param results
     * @return
     */
    private JSONArray getLineLegend(List<SubjectAnalyseEntity> results) {
        JSONArray legend = new JSONArray();
        Set<String> legendSet = new TreeSet<String>();
        for (SubjectAnalyseEntity result : results) {
            legendSet.add("难度级别:" + result.getDifficulty());
        }
        Iterator<String> iter = legendSet.iterator();
        while (iter.hasNext()) {
            legend.add(iter.next());
        }
        return legend;
    }

    /**
     * 获取折线图x轴下标
     *
     * @param results
     * @return
     */
    private JSONArray getLinexAxis(List<SubjectAnalyseEntity> results) {
        JSONArray xAxis = new JSONArray();
        for (SubjectAnalyseEntity result : results) {
            xAxis.add(result.getRightRate());
        }
        return xAxis;
    }

    /**
     * 饼图：按难度分组，统计每组中的题目数量
     *
     * @return
     */
    @RequestMapping(value = "/countDifficulty")
    @ResponseBody
    public R countDifficulty(String startDate, String endDate, String difficulty, String tagCodeCount, String minRightRate, String maxRightRate, String subject) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        params.put("difficulty", difficulty);
        params.put("tagCodeCount", tagCodeCount);
        params.put("minRightRate", minRightRate);
        params.put("maxRightRate", maxRightRate);
        params.put("subject", subject);
        if (params.get("startDate") == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
            String defaultStartDay = sdf.format(new Date());
            params.put("startDate", defaultStartDay);
        }
        List<SubjectAnalyseEntity> results = subjectAnalyseService.countDifficulty(params);
        JSONObject vo = new JSONObject();
        //legend
        JSONArray legend = new JSONArray();

        //series data
        JSONArray series = new JSONArray();
        for (SubjectAnalyseEntity result : results) {
            JSONObject json = new JSONObject();
            json.put("name", "难度级别:" + result.getDifficulty());
            json.put("value", result.getQuestionId());
            series.add(json);
            legend.add("难度级别:" + result.getDifficulty());
        }
        vo.put("legend", legend);
        vo.put("series", series);
        return R.ok().put("data", vo);
    }

    /**
     * 导出题目分析报表
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void exportSubjectAnalyse(HttpServletResponse response, @RequestParam Map<String, Object> params) throws IOException {
        OutputStream out = response.getOutputStream();
        try {
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename=" + new String("题目分析报表".getBytes("UTF-8"), "8859_1") + ".xls");// 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            List<SubjectAnalyseEntity> results = subjectAnalyseService.listSubject(params);
            if (results.size() != ZERO_RECORD) {
                ExcelUtil.exportExcel("题目分析报表", results, out);
            } else {
                ExcelUtil.genatorExcel(out, "暂无数据");
            }
        } catch (Exception e) {
            ExcelUtil.genatorExcel(out, "数据异常");
        }
    }

}
