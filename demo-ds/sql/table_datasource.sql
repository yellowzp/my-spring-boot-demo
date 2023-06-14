DROP TABLE IF EXISTS `datasource`;
CREATE TABLE `datasource`  (
 `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '数据源id',
 `name` varchar(100) NOT NULL COMMENT '数据源展示名称',
 `type` varchar(100) DEFAULT NULL COMMENT '数据源类型',
 `account` varchar(100) DEFAULT NULL COMMENT '帐号',
 `password` varchar(100) DEFAULT NULL COMMENT '密码',
 `ip` varchar(100) DEFAULT NULL COMMENT 'IP',
 `port` varchar(100) DEFAULT NULL COMMENT '端口',
 `database` varchar(100) DEFAULT NULL COMMENT '数据库名',
 `url` varchar(1000) DEFAULT NULL COMMENT 'URL',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `datasource_idx`(`type`, `name`) USING BTREE
) ENGINE = InnoDB COMMENT = '数据源表';

DROP TABLE IF EXISTS `local_info`;
CREATE TABLE `local_info`  (
   `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '数据源id',
   `var` varchar(100) NOT NULL COMMENT '本地变量名',
   `value` varchar(100) DEFAULT NULL COMMENT '变量值',
   PRIMARY KEY (`id`) USING BTREE,
   INDEX `local_info_idx`(`var`) USING BTREE
) ENGINE = InnoDB COMMENT = '本地信息';

insert into datasource (`name`, `type`, `account`, `password`, `ip`, `port`, `database`, `url`)
values ('node2mysql', 'MYSQL_8', 'demo', '123456', '192.168.3.223', '3306', 'demo', 'jdbc:mysql://192.168.3.223:3306/demo?useUnicode=true&characterEncoding=UTF8');