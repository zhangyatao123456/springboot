package com.yixue.xdatam.service.data;

import com.yixue.xdatam.entity.data.SystemUseRecord;

import java.util.List;
import java.util.Map;

public interface SystemUseService {
  List<SystemUseRecord> listSystemUseRecord(Map<String, Object> map);
  int totalSystemUseRecord(Map<String, Object> map);
}
