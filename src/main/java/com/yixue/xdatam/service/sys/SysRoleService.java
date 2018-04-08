package com.yixue.xdatam.service.sys;


import com.yixue.xdatam.entity.sys.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年9月18日 上午9:42:52
 */
public interface SysRoleService {

    SysRoleEntity queryObject(Long roleId);

    List<SysRoleEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(SysRoleEntity role);

    void update(SysRoleEntity role);

    void deleteBatch(Long[] roleIds);

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
