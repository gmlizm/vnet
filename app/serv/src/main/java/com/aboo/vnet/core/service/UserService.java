package com.aboo.vnet.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboo.vnet.core.data.mapper.SysUserMapper;
import com.aboo.vnet.core.data.model.SysUser;

@Service
public class UserService {

	@Autowired
	private SysUserMapper userMapper;

	public SysUser findByName(String username) {
		return userMapper.findByName(username);
	}
	

}
