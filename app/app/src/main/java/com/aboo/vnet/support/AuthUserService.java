package com.aboo.vnet.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.aboo.vnet.core.data.mapper.SysResMapper;
import com.aboo.vnet.core.data.mapper.SysRoleMapper;
import com.aboo.vnet.core.data.mapper.SysUserMapper;
import com.aboo.vnet.core.model.SysRes;
import com.aboo.vnet.core.model.SysRole;
import com.aboo.vnet.core.model.SysUser;

@Service
public class AuthUserService implements UserDetailsService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Autowired
	private SysResMapper sysResMapper;

	/**
	 * 根据用户名去加载相应的认证信息 完成登录认证
	 * 
	 * @param username
	 *            登录时的用户名
	 * @return 查询出的用户实体类
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1.查询用户
		SysUser sysUser = sysUserMapper.findByName(username);
		// 2.加载角色资源
		Set<String> authCodes = new HashSet<>();
		List<SysRole> roleList = sysRoleMapper.getByUserId(sysUser.getUid());
		if(!CollectionUtils.isEmpty(roleList)){
			for(SysRole role : roleList){
				List<SysRes>  resList = sysResMapper.getByRoleId(role.getId());
				for(SysRes res : resList){
					authCodes.add(res.getCode());
				}
			}
		}
		//3.加载用户资源
		List<SysRes> resList = sysResMapper.getByUserId(sysUser.getUid());
		for(SysRes res : resList){
			authCodes.add(res.getCode());
		}

		//4.将资源放进资源授权中
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(String authCode : authCodes){
			authorities.add(new SimpleGrantedAuthority(authCode));
		}
		
		User securityUser = new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
		return securityUser;
	}

}
