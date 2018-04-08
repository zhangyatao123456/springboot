package com.yixue.xdatam.dao.data;

import com.yixue.xdatam.entity.data.SubjectAnalyseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 题目分析
 *
 * @author IBM CHEN ZHI KAN
 * @create 2017/8/25
 */
@Component
public interface SubjectAnalyseDao {
    List<SubjectAnalyseEntity> listSubject(Map<String, Object> map);

    int totalSubject(Map<String, Object> map);

    List<SubjectAnalyseEntity> countRightRate(Map<String, Object> map);

    List<SubjectAnalyseEntity> countDifficulty(Map<String, Object> map);
}
