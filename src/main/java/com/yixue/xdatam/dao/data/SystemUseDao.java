package com.yixue.xdatam.dao.data;

import com.yixue.xdatam.entity.data.SystemUseRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface SystemUseDao {
  List<SystemUseRecord> listSystemUseRecord(Map<String, Object> map);
  int totalSystemUseRecord(Map<String, Object> map);
}
