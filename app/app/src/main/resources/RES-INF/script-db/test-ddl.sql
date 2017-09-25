--用户
CREATE TABLE IF NOT EXISTS `sys_user` (
  `uid`              varchar(30)   NOT NULL       COMMENT '用户id',
  `username`     varchar(30)   NOT NULL  UNIQUE COMMENT '用户名称',
  `password`      varchar(100)   NOT NULL     COMMENT '密码',
  PRIMARY KEY  (`uid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--角色
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id`          bigint(20)      AUTO_INCREMENT COMMENT '主键ID',
  `code`      varchar(100)   NOT NULL     UNIQUE    COMMENT '角色代码',
  `name`     varchar(30)   NOT NULL      COMMENT '角色名称',
  PRIMARY KEY  (`id`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--权限
CREATE TABLE IF NOT EXISTS `sys_res` (
  `id`          bigint(20)      AUTO_INCREMENT COMMENT '主键ID',
  `code`      varchar(100)   NOT NULL     UNIQUE   COMMENT '权限代码',
  `name`     varchar(30)   NOT NULL       COMMENT '权限名称',
  PRIMARY KEY  (`id`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--用户-资源-关联
CREATE TABLE IF NOT EXISTS `sys_user_res` (
  `id`          bigint(20)      NOT NULL     AUTO_INCREMENT COMMENT '主键ID',
  `user_id`   bigint(20)      NOT NULL    COMMENT '用户id',
  `res_id`   bigint(20)      NOT NULL     COMMENT '角色id',
  PRIMARY KEY  (`id`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--用户-角色-关联
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id`          bigint(20)      NOT NULL     AUTO_INCREMENT COMMENT '主键ID',
  `user_id`   bigint(20)      NOT NULL    COMMENT '用户id',
  `role_id`   bigint(20)      NOT NULL     COMMENT '角色id',
  PRIMARY KEY  (`id`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--角色-资源-关联
CREATE TABLE IF NOT EXISTS `sys_role_res` (
  `id`          bigint(20)      NOT NULL     AUTO_INCREMENT COMMENT '主键ID',
  `role_id`   bigint(20)      NOT NULL    COMMENT '角色id',
  `res_id`   bigint(20)      NOT NULL     COMMENT '权限id',
  PRIMARY KEY  (`id`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;