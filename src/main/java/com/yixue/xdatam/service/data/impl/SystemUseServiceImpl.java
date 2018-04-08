package com.yixue.xdatam.service.data.impl;

import com.yixue.xdatam.dao.data.SystemUseDao;
import com.yixue.xdatam.dynamicDataSource.TargetDataSource;
import com.yixue.xdatam.entity.data.SystemUseRecord;
import com.yixue.xdatam.service.data.SystemUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author IBM CHEN ZHI KAN
 * @create 2018/1/25
 */
@Service("systemUseService")
public class SystemUseServiceImpl implements SystemUseService {
  @Autowired
  private SystemUseDao systemUseDao;

  @TargetDataSource(name="ds2")
  public List<SystemUseRecord> listSystemUseRecord(Map<String,Object> map){
    return systemUseDao.listSystemUseRecord(map);
  }

  @Override
  @TargetDataSource(name="ds2")
  public int totalSystemUseRecord(Map<String, Object> map) {
    return systemUseDao.totalSystemUseRecord(map);
  }
}
