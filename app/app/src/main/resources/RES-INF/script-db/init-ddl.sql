CREATE database IF NOT EXISTS arbuu;

use arbuu;

CREATE TABLE IF NOT EXISTS `sysorg` (
  `rid`             bigint(20)    NOT NULL AUTO_INCREMENT  COMMENT '主键RID',
  `prid`           bigint(20)    NOT NULL DEFAULT 0 COMMENT '上级组织RID',
  `name`         varchar(50)   NOT NULL UNIQUE COMMENT '组织名称',
  `ename`       varchar(100) COMMENT '组织名称-英文',
  `rank`           int(11)       NOT NULL COMMENT '组织等级，0顶级 1一级 2二级 以此类推',
  `seqno`        int(11)       NOT NULL DEFAULT 0 COMMENT '排序字段',
  `status`        int(3)        NOT NULL DEFAULT 1 COMMENT '状态',
  `opid`           bigint(20) COMMENT '操作者ID',
  `opname`      varchar(50) COMMENT '操作者名称',
  `gmtnew` datetime COMMENT '创建时间',
  `gmtmod` datetime COMMENT '更新时间',
  `memo`        varchar(100)  NULL  COMMENT '备注',
  PRIMARY KEY  (`rid`)
) ENGINE=INNODB COMMENT='系统组织部门信息表';

------------------------------------------------------------------------
--用户
CREATE TABLE IF NOT EXISTS `sysuser` (
  `uid`          bigint(20)      NOT NULL     AUTO_INCREMENT COMMENT '主键UID',
  `uno`         varchar(30)   NOT NULL     UNIQUE COMMENT '用户编号',
  `unick`       varchar(30)   NOT NULL     UNIQUE COMMENT '用户昵称',
  `uname`     varchar(50)   NOT NULL     UNIQUE COMMENT '用户名[小写字母、数字]',
  `passw`      varchar(80)   NOT NULL     COMMENT '密码',
  `tname`     varchar(20)     COMMENT '真实姓名',
  `sex`         TINYINT(1)     COMMENT '性别',
  `birth`       date              COMMENT '出生日期',
  `email`        varchar(30)   COMMENT '邮箱',
  `phone`        varchar(15)  COMMENT '手机号码',
  `address`     varchar(200)     COMMENT '联系地址',
  `ucode`      varchar(10)   NOT NULL   COMMENT '安全码[字符、数字组成的字符串]',
  `status`      int(3)        NOT NULL DEFAULT 1 COMMENT '状态',
  `opid`        bigint(20) COMMENT '操作者ID',
  `opname`   varchar(50) COMMENT '操作者名称',
  `gmtnew`  datetime COMMENT '创建时间',
  `gmtmod`  datetime COMMENT '更新时间',
  `memo`        varchar(100)  NULL  COMMENT '备注',
  PRIMARY KEY  (`uid`) 
) ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;


--网站用户
CREATE TABLE IF NOT EXISTS `puser` (
  `uid`          bigint(20)      NOT NULL     AUTO_INCREMENT COMMENT '主键UID',
  `unick`       varchar(30)    COMMENT '用户昵称',
  `uname`     varchar(50)    COMMENT '用户名[小写字母、数字]',
  `passw`      varchar(64)    COMMENT '密码',
  `tname`     varchar(20)     COMMENT '真实姓名',
  `sex`         TINYINT(1)   NOT NULL DEFAULT 1  COMMENT '性别',
  `birth`       date              COMMENT '出生日期',
  `email`        varchar(30)   COMMENT '邮箱',
  `phone`        varchar(15)  COMMENT '手机号码',
  `address`     varchar(200)     COMMENT '联系地址',
  `ucode`      varchar(10)   COMMENT '安全码[字符、数字组成的字符串]',
  `status`      int(3)        NOT NULL DEFAULT 1 COMMENT '状态',
  `gmtnew`  datetime COMMENT '创建时间',
  `gmtmod`  datetime COMMENT '更新时间',
  `memo`        varchar(100)  COMMENT '备注',
  PRIMARY KEY  (`uid`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--用户第三方帐号登录方式
CREATE TABLE IF NOT EXISTS `puserlink` (
  `rid`          bigint(20)     AUTO_INCREMENT COMMENT '主键RID',
  `uid`         bigint(20)      NOT NULL     COMMENT '主键UID',
  `uno`        varchar(20)   NOT NULL   COMMENT '账户名[小写字母、数字]',
  `utype`      varchar(64)   NOT NULL  COMMENT '登录类型[QQ,Taobao,Renren]',
  `status`      int(3)        NOT NULL DEFAULT 1 COMMENT '状态',
  `gmtnew`  datetime COMMENT '创建时间',
  `gmtmod`  datetime COMMENT '更新时间',
  PRIMARY KEY  (`rid`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;