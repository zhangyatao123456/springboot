package com.yixue.xdatam.service.data;

import com.yixue.xdatam.entity.data.DmAllUserCourseEntity;

import java.util.List;
import java.util.Map;

public interface AllUserService {
      List<DmAllUserCourseEntity> selectAllUserMapMessageList(Map<String, Object> map);
      List<DmAllUserCourseEntity> selectAllUserMapMessageListCount(Map<String, Object> map);
      List<String> selectAllSchoolName();
}




