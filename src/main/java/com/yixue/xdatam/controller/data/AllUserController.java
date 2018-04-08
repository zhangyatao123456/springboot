package com.yixue.xdatam.controller.data;//package com.yixue.controller;
//

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yixue.common.util.PageUtils;
import com.yixue.xdatam.common.exceptions.R;
import com.yixue.xdatam.common.utils.Query;
import com.yixue.xdatam.entity.data.DmAllUserCourseEntity;
import com.yixue.xdatam.service.data.AllUserService;

/**
 * 数据管理控制层
 *
 * @version 3.0v
 */
@RestController
@RequestMapping("/user")
public class AllUserController {
    @Autowired
    private AllUserService allUserService;


    /**
     * 描述：分页查询学生学习列表
     *
     * @return 作者：王儒作
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        //返回分页参数
        Query query = new Query(params);

        List<DmAllUserCourseEntity> list = allUserService.selectAllUserMapMessageList(query);

        List<DmAllUserCourseEntity> list1 = allUserService.selectAllUserMapMessageListCount(query);
        //数据总条数
        int total = list1.size();

        //返回分页属性参数及检索结果
        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);


    }
}
