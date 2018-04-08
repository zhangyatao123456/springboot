package com.yixue.xdatam.controller.xcenter;

import com.yixue.xdatam.service.data.AllUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 系统页面视图,页面跳转控制层
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {
    @Autowired
    private AllUserService allUserService;
    /**
     * 系统管理跳转方法
     *
     * @param url
     * @return
     */
    @RequestMapping("sys/{url}.html")
    public String page(@PathVariable("url") String url) {
        return "sys/" + url + ".html";
    }

    @RequestMapping("generator/{url}.html")
    public String generator(@PathVariable("url") String url) {
        return "generator/" + url + ".html";
    }

    /**
     * 描述：图谱管理跳转方法
     *
     * @param url
     * @return 图谱管理模块的页面路径
     * 作者：王儒作
     * 日期：2017年06月05日
     */
    @RequestMapping("kmap/{url}.html")
    public String pageByMap(@PathVariable("url") String url) {
        return "kmap/" + url + ".html";
    }

    /**
     * 描述：缓存页面跳转方法
     *
     * @param url
     * @return 缓存模块的页面路径
     * 作者：王儒作
     * 日期：2017年06月05日
     */
    @RequestMapping("cache/{url}.html")
    public String pageByCacheKey(@PathVariable("url") String url) {
        return "cache/" + url + ".html";
    }

    /**
     * 描述：能力值记录列表页面跳转方法
     *
     * @param url
     * @return 能力值记录列表页面路径
     * 作者：王儒作
     * 日期：2017年06月24日
     */
    @RequestMapping("data/{url}.html")
    public String pageByAibilityRecordList(Model model, @PathVariable("url") String url) {
        List<String> schoolNameList = allUserService.selectAllSchoolName();
        model.addAttribute("schoolNameList", schoolNameList);
        return "data/" + url + ".html";
    }

    @RequestMapping("analyse/userDataAnalyse.html")
    public ModelAndView pageByAibilityRecordList(String account, String subject, String online) {
        ModelAndView model=new ModelAndView("data/userDataAnalyse.html");
        model.addObject("account",account);
        model.addObject("subject",subject);
        model.addObject("online",online);
        return model;
    }
}
