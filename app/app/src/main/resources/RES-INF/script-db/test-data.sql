/*--用户数据--*/
INSERT INTO sys_user (username,PASSWORD) VALUE('user1','111'), ('user2','222');

/*--角色数据--*/
INSERT INTO sys_role (name,code) VALUE('管理员', 'ROLE_ADMIN'), ('普通用户', 'ROLE_USER');

/*--权限数据--*/
INSERT INTO sys_res (name,code) VALUE('管理权限', 'auth_admin'), ('一般权限', 'auth_user');

/*--用户-权限关联*/
INSERT INTO sys_user_res (user_id,auth_id) VALUE(1, 1);

/*--用户-角色关联*/
INSERT INTO sys_user_role (user_id,role_id) VALUE(1, 1),(2, 2);

/*--角色-权限关联*/
INSERT INTO sys_role_res (role_id,auth_id) VALUE(1, 1), (1,2), (2, 2);


