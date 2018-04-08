package com.yixue.xdatam.dao.sys;

import com.yixue.xdatam.entity.sys.AiAbilityRecordEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-06-24 15:10:12
 */
@Component
public interface AiAbilityRecordDao extends BaseDao<AiAbilityRecordEntity> {
    /**
     * 查询能力值记录表数据分页用
     *
     * @return
     */
    public List<AiAbilityRecordEntity> queryListByPage(Map<String, Object> map);
}
