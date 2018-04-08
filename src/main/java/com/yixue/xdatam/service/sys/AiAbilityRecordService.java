package com.yixue.xdatam.service.sys;


import com.yixue.xdatam.entity.sys.AiAbilityRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-06-24 15:10:12
 */
public interface AiAbilityRecordService {

    AiAbilityRecordEntity queryObject(Long rid);

    List<AiAbilityRecordEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(AiAbilityRecordEntity aiAbilityRecord);

    void update(AiAbilityRecordEntity aiAbilityRecord);

    void delete(Long rid);

    void deleteBatch(Long[] rids);

    List<AiAbilityRecordEntity> queryListByPage(Map<String, Object> map);
}
