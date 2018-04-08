package com.yixue.xdatam.dao.sys;

import com.yixue.xdatam.entity.sys.SysConfigEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 系统配置信息
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年12月4日 下午6:46:16
 */
@Component
public interface SysConfigDao extends BaseDao<SysConfigEntity> {

    /**
     * 根据key，查询value
     */
    String queryByKey(String paramKey);

    /**
     * 根据key，更新value
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);

}
