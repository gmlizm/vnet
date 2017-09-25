package com.aboo.vnet.core.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.aboo.vnet.core.model.SysRole;

@Mapper
public interface SysRoleMapper {
	
    @Select({"select id, name, code from sys_role ",
    		"WHERE id in (select role_id from sys_user_role where user_id=#{userId})"})
    @ResultType(SysRole.class)
    public List<SysRole> getByUserId(@Param("userId") Long userId);
    
}
