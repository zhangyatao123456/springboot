package com.yixue.xdatam.service.data;

import com.yixue.xdatam.entity.data.SubjectAnalyseEntity;

import java.util.List;
import java.util.Map;

public interface SubjectAnalyseService {
    List<SubjectAnalyseEntity> listSubject(Map<String, Object> map);

    int totalSubject(Map<String, Object> map);

    List<SubjectAnalyseEntity> countRightRate(Map<String, Object> map);

    List<SubjectAnalyseEntity> countDifficulty(Map<String, Object> map);
}




