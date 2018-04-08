package com.yixue.xdatam.dao.sys;


import com.yixue.xdatam.entity.sys.SysRoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色管理
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年9月18日 上午9:33:33
 */
@Component
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
