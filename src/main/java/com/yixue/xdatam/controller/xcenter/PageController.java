package com.yixue.xdatam.controller.xcenter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 跳转页面方法类
 */
@Controller
@RequestMapping("/page/")
public class PageController {

    /**
     * 描述：知识图谱列表查看跳转方法
     *
     * @param
     * @return 作者：王儒作
     * 日期：2017年06月19日
     */

    @RequestMapping(value = "viewsvg")
    public String goViewSvg(Model model, HttpServletRequest request) throws IOException {
        String kmcode = request.getParameter("kmcode");
        model.addAttribute("km_code_", kmcode);
        return "kmap/viewsvg.html";
    }


}
