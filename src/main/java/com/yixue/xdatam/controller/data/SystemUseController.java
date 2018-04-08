package com.yixue.xdatam.controller.data;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yixue.common.util.PageUtils;
import com.yixue.xdatam.common.exceptions.R;
import com.yixue.xdatam.common.utils.Query;
import com.yixue.xdatam.entity.data.SystemUseRecord;
import com.yixue.xdatam.service.data.SystemUseService;

/**
 * @author IBM CHEN ZHI KAN
 * @create 2018/1/25
 */
@Controller
@RequestMapping("/systemUse")
public class SystemUseController {
  @Autowired
  SystemUseService systemUseService;

  @RequestMapping("/page")
  public String getPage(){
    return "data/userDataAnalyse.html";
  }
  /**
   * 获取学生系统使用表
   */
    @RequestMapping("/getTable")
    @ResponseBody
    public R getSystemUseTable(@RequestParam Map<String, Object> params){
      Query query = new Query(params);
      List<SystemUseRecord> result=systemUseService.listSystemUseRecord(query);
      int total = systemUseService.totalSystemUseRecord(query);
      PageUtils pageUtil = new PageUtils(result, 1, query.getLimit(), query.getPage());
      return R.ok().put("page", pageUtil);
    }
}
