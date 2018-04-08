package com.yixue.xdatam.dao.sys;


import com.yixue.xdatam.entity.sys.SysUserRoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年9月18日 上午9:34:46
 */
@Component
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);
}
