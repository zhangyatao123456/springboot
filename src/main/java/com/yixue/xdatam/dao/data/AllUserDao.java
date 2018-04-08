package com.yixue.xdatam.dao.data;

import com.yixue.xdatam.entity.data.DmAllUserCourseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 学生所学课程信息表
 *
 * @author wangruzuo
 * @create 2018-1-24 20:03:05
 */
@Component
public interface AllUserDao {

    List<DmAllUserCourseEntity> selectAllUserMapMessageList(Map<String, Object> map);

    List<DmAllUserCourseEntity> selectAllUserMapMessageListCount(Map<String, Object> map);

    List<String> selectAllSchoolName();

}
