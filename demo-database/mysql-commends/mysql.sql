create user demo identified by '123456';

SHOW VARIABLES LIKE 'validate_password%';

set global validate_password.policy=LOW;
set global validate_password.length=6;

CREATE DATABASE demo;

grant ALL PRIVILEGES on demo.* to demo;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
 `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '记录id',
 `user_id` varchar(100) NOT NULL COMMENT '用户名',
 `user_name` varchar(100) DEFAULT NULL COMMENT '姓名',
 `password` varchar(100) DEFAULT NULL COMMENT '密码',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `user_name_idx1`(`user_name`) USING BTREE,
 INDEX `user_name_idx`(`user_id`) USING BTREE
) ENGINE = InnoDB COMMENT = '用户表';