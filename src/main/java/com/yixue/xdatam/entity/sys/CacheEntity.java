package com.yixue.xdatam.entity.sys;

import java.io.Serializable;

/**
 * 描述：操作缓存实体类
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-05-25 15:26:57
 */
public class CacheEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //缓存key
    private String key;
    //缓存value
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
