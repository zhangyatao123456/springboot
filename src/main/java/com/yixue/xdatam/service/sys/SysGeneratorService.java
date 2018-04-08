package com.yixue.xdatam.service.sys;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年12月19日 下午3:33:38
 */
public interface SysGeneratorService {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    /**
     * 生成代码
     */
    byte[] generatorCode(String[] tableNames);
}