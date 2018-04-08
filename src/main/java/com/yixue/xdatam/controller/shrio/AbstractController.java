package com.yixue.xdatam.controller.shrio;

import com.yixue.xdatam.entity.sys.SysUserEntity;
import com.yixue.xdatam.shiro.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
