package com.yixue.xdatam.controller.xcenter;//package com.yixue.controller;
//

import com.yixue.common.util.PageUtils;
import com.yixue.xdatam.common.annotation.SysLog;
import com.yixue.xdatam.entity.sys.AiAbilityRecordEntity;
import com.yixue.xdatam.common.exceptions.R;
import com.yixue.xdatam.service.sys.AiAbilityRecordService;
import com.yixue.xdatam.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 数据管理控制层
 *
 * @version 3.0v
 */
@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private AiAbilityRecordService aiAbilityRecordService;


    /**
     * 描述：分页查询能力值记录表,每次查询当前limit数(当前页面显示的条数)
     *
     * @param params
     * @return 作者：王儒作
     */
    @RequestMapping("/list")
    //    @RequiresPermissions("mytest:kmap:list")
    public R list(@RequestParam Map<String, Object> params) {
        //返回分页参数
        Query query = new Query(params);

        List<AiAbilityRecordEntity> aiAbilityRecordEntityList = aiAbilityRecordService.queryList(query);

        List<AiAbilityRecordEntity> aiAbilityRecordListByPage = aiAbilityRecordService.queryListByPage(query);

        //数据总条数
        int total = aiAbilityRecordListByPage.size();

        //返回分页属性参数及检索结果
        PageUtils pageUtil = new PageUtils(aiAbilityRecordEntityList, total, query.getLimit(), query.getPage());
        //
        return R.ok().put("page", pageUtil);
    }

    /**
     * 删除能力值记录数据
     */
    @SysLog("删除能力值记录数据")
    @RequestMapping("/delete")
//    @Transactional(readOnly = false)
    public R delete(@RequestBody Long[] rids) {
        for (int i = 0; i < rids.length; i++) {
            aiAbilityRecordService.delete(rids[i]);
        }
        return R.ok();

    }
}
