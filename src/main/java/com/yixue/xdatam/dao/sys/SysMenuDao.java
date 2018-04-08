package com.yixue.xdatam.dao.sys;


import com.yixue.xdatam.entity.sys.SysMenuEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单管理
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年9月18日 上午9:33:01
 */
@Component
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 查询用户的权限列表
     */
    List<SysMenuEntity> queryUserList(Long userId);
}
