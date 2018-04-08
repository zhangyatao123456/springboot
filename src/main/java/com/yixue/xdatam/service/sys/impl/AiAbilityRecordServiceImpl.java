package com.yixue.xdatam.service.sys.impl;

import com.yixue.xdatam.dao.sys.AiAbilityRecordDao;
import com.yixue.xdatam.entity.sys.AiAbilityRecordEntity;
import com.yixue.xdatam.service.sys.AiAbilityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("aiAbilityRecordService")
public class AiAbilityRecordServiceImpl implements AiAbilityRecordService {
    @Autowired
    private AiAbilityRecordDao aiAbilityRecordDao;

    @Override
    public AiAbilityRecordEntity queryObject(Long rid) {
        return aiAbilityRecordDao.queryObject(rid);
    }

    @Override
    public List<AiAbilityRecordEntity> queryList(Map<String, Object> map) {
        return aiAbilityRecordDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return aiAbilityRecordDao.queryTotal(map);
    }

    @Override
    public void save(AiAbilityRecordEntity aiAbilityRecord) {
        aiAbilityRecordDao.save(aiAbilityRecord);
    }

    @Override
    public void update(AiAbilityRecordEntity aiAbilityRecord) {
        aiAbilityRecordDao.update(aiAbilityRecord);
    }

    @Override
    public void delete(Long rid) {
        aiAbilityRecordDao.delete(rid);
    }

    @Override
    public void deleteBatch(Long[] rids) {
        aiAbilityRecordDao.deleteBatch(rids);
    }

    @Override
    public List<AiAbilityRecordEntity> queryListByPage(Map<String, Object> map) {
        return aiAbilityRecordDao.queryListByPage(map);
    }

}
