package com.aboo.vnet.core.data.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.aboo.vnet.core.model.SysUser;

@Mapper
public interface SysUserMapper {
	
	  // 通过Object新增
    @Insert("INSERT INTO sys_user (username, password) VALUES(#{username}, #{password})")
    int insertByObject(SysUser user);
    
    // Delete By Id
    @Delete("DELETE FROM sys_user WHERE uid =#{id}")
    void delete(Long id);
    
    // Update
    @Update("UPDATE sys_user SET uname=#{uname} WHERE uid=#{id}")
    void update(SysUser user);
    
    // Find by Parameter
    //@Select("select max_connections as id,user as uname from user WHERE user = #{uname}")
//    @Qualifier("msql2DataSource")
    public SysUser findByName(@Param("username") String username);
}
