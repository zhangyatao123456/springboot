package com.yixue.xdatam.service.data.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yixue.xdatam.dao.data.AllUserDao;
import com.yixue.xdatam.dynamicDataSource.TargetDataSource;
import com.yixue.xdatam.entity.data.DmAllUserCourseEntity;
import com.yixue.xdatam.service.data.AllUserService;

/**
 * 题目分析
 *
 * @author IBM CHEN ZHI KAN
 * @create 2017/8/25
 */
@Service("allUserService")
public class AllUserServiceImpl implements AllUserService {
    @Autowired
    private AllUserDao allUserDao;


    /**
     * 分页查询列表
     * @param map
     * @return
     */
    @Override
    @TargetDataSource(name="ds2")
    public List<DmAllUserCourseEntity> selectAllUserMapMessageList(Map<String, Object> map) {
        return allUserDao.selectAllUserMapMessageList(map);
    }

    /**
     * 查询列表分页用
     * @param map
     * @return
     */
    @Override
    @TargetDataSource(name="ds2")
    public List<DmAllUserCourseEntity> selectAllUserMapMessageListCount(Map<String, Object> map) {
        return allUserDao.selectAllUserMapMessageListCount(map);
    }

    /**
     * 查询所有学校名称
     * @return
     */
    @Override
    @TargetDataSource(name="ds2")
    public List<String> selectAllSchoolName() {
        List<String> stringList = allUserDao.selectAllSchoolName();
        return stringList;
    }

}
