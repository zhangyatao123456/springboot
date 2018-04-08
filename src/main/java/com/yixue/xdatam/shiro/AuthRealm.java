/*
 * Copyright (C) 2016 Shanghai yixue soft Co., Ltd
 *
 * All copyrights reserved by Shanghai yixue.
 * Any copying, transferring or any other usage is prohibited.
 * Or else, Shanghai yixue possesses the right to require legal 
 * responsibilities from the violator.
 * All third-party contributions are distributed under license by
 * Shanghai yixue soft Co., Ltd.
 */
package com.yixue.xdatam.shiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yixue.xdatam.entity.sys.SysMenuEntity;
import com.yixue.xdatam.entity.sys.SysUserEntity;
import com.yixue.xdatam.service.sys.SysMenuService;
import com.yixue.xdatam.service.sys.SysUserService;

/**
 * @author zhang
 * @date 2018年3月18日 上午11:05:09	
 */
public class AuthRealm extends AuthorizingRealm{
	 @Autowired
	 private SysUserService sysUserService;
	 
	 @Autowired
	 private SysMenuService sysMenuService;
	/**
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
	        SysUserEntity user = (SysUserEntity) principals.getPrimaryPrincipal();
	        Long userId = user.getUserId();

	        List<String> permsList = null;

	        //系统管理员，拥有最高权限
	        if (userId == 1) {
	            List<SysMenuEntity> menuList = sysMenuService.queryList(new HashMap<String, Object>());
	            permsList = new ArrayList<>(menuList.size());
	            for (SysMenuEntity menu : menuList) {
	                permsList.add(menu.getPerms());
	            }
	        } else {
	            permsList = sysUserService.queryAllPerms(userId);
	        }

	        //用户权限列表
	        Set<String> permsSet = new HashSet<String>();
	        for (String perms : permsList) {
	            if (StringUtils.isBlank(perms)) {
	                continue;
	            }
	            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
	        }

	        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	        info.setStringPermissions(permsSet);
	        return info;
	}

	/**
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	        String username = (String) token.getPrincipal();
	        String password = new String((char[]) token.getCredentials());

	        //查询用户信息
	        SysUserEntity user = sysUserService.queryByUserName(username);

	        //账号不存在
	        if (user == null) {
	            throw new UnknownAccountException("账号或密码不正确");
	        }

	        //密码错误
	        if (!password.equals(user.getPassword())) {
	            throw new IncorrectCredentialsException("账号或密码不正确");
	        }

	        //账号锁定
	        if (user.getStatus() == 0) {
	            throw new LockedAccountException("账号已被锁定,请联系管理员");
	        }

	        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
	        return info;
	}

}
