package com.aboo.vnet.core.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.aboo.vnet.core.data.model.SysRes;

@Mapper
public interface SysResMapper {

	@Select({ "select id, name, code from sys_res ",
			"WHERE id in (select res_id from sys_role_res where role_id=#{roleId})" })
	@ResultType(SysRes.class)
	public List<SysRes> getByRoleId(@Param("roleId") long roleId);

	@Select({ "select id, name, code from sys_res ",
			"WHERE id in (select res_id from sys_user_res where user_id=#{userId})" })
	@ResultType(SysRes.class)
	public List<SysRes> getByUserId(@Param("userId") long userId);

}
