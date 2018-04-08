package com.yixue.xdatam.service.data.impl;

import com.yixue.xdatam.dao.data.SubjectAnalyseDao;
import com.yixue.xdatam.entity.data.SubjectAnalyseEntity;
import com.yixue.xdatam.service.data.SubjectAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 题目分析
 *
 * @author IBM CHEN ZHI KAN
 * @create 2017/8/25
 */
@Service("subjectAnalyseService")
public class SubjectAnalyseServiceImpl implements SubjectAnalyseService {
    @Autowired
    private SubjectAnalyseDao subjectAnalyDao;

    //按条件分页查询题目数据
    @Override
    public List<SubjectAnalyseEntity> listSubject(Map<String, Object> map) {
        return subjectAnalyDao.listSubject(map);
    }

    @Override
    public int totalSubject(Map<String, Object> map) {
        return subjectAnalyDao.totalSubject(map);
    }

    @Override
    public List<SubjectAnalyseEntity> countRightRate(Map<String, Object> map) {
        return subjectAnalyDao.countRightRate(map);
    }

    @Override
    public List<SubjectAnalyseEntity> countDifficulty(Map<String, Object> map) {
        return subjectAnalyDao.countDifficulty(map);
    }
}
