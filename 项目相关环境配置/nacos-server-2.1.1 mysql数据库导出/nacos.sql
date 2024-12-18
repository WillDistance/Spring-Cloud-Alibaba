/*
 Navicat Premium Data Transfer

 Source Server         : nacos
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : nacos2

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 08/01/2024 00:25:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'user-config-Info.yaml', 'DEFAULT_GROUP', 'user:\n  config:\n    userName: 严磊-dev环境-共享配置\n    account: yanlei-dev环境-共享配置', '1b772da24201d935db902b4a851f050c', '2024-01-04 16:05:06', '2024-01-07 05:56:03', '', '127.0.0.1', '', '31d69b98-e73b-4365-aea8-70373cebe240', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` VALUES (4, 'user-config-Info.yaml', 'DEFAULT_GROUP', 'user:\n  config:\n    userName: 严磊-prod环境-共享配置\n    account: yanlei-prod环境-共享配置', '6fb8b6d1ed6b8246afd79579b3373c19', '2024-01-04 16:05:49', '2024-01-07 05:55:51', '', '127.0.0.1', '', '746730a2-53ec-4e1f-9318-8f292a741606', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` VALUES (8, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', 'user:\n  config:\n    userName: 严磊-dev环境-应用配置\n    account: yanlei-dev环境-应用配置', '20867757054318ea59983c6b9ec9fc9b', '2024-01-07 05:46:10', '2024-01-07 05:56:43', '', '127.0.0.1', '', '31d69b98-e73b-4365-aea8-70373cebe240', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` VALUES (9, 'nacos-config-dev.yaml', 'NACOS_CONFIG_GROUP', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.0', 'a3658b1fa784950a1f226cc7a67d9002', '2024-01-07 05:46:24', '2024-01-07 05:46:24', NULL, '127.0.0.1', '', '31d69b98-e73b-4365-aea8-70373cebe240', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (10, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', 'user:\n  config:\n    userName: 严磊-prod环境-应用配置\n    account: yanlei-prod环境-应用配置', 'e9d5b16cd381cba928be592409bd37af', '2024-01-07 05:46:52', '2024-01-07 05:55:32', '', '127.0.0.1', '', '746730a2-53ec-4e1f-9318-8f292a741606', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` VALUES (11, 'nacos-config-prod.yaml', 'NACOS_CONFIG_GROUP', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.1', '4a65909c6fe90280ccf56e1228b52883', '2024-01-07 05:46:52', '2024-01-07 05:46:52', NULL, '127.0.0.1', '', '746730a2-53ec-4e1f-9318-8f292a741606', NULL, NULL, NULL, 'yaml', NULL, '');

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(0) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(0) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `nid` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 1, 'user-config-Info.yaml', 'DEFAULT_GROUP', '', 'user:\r\n  config:\r\n    userName: 严磊-dev环境\r\n    account: yanlei-dev环境', '04133828cd7ad4fd08a0c711592da272', '2024-01-05 00:05:05', '2024-01-04 16:05:06', NULL, '127.0.0.1', 'I', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (0, 2, 'nacos-config-dev.yaml', 'DEFAULT_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.0', 'a3658b1fa784950a1f226cc7a67d9002', '2024-01-05 00:05:19', '2024-01-04 16:05:20', NULL, '127.0.0.1', 'I', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (0, 3, 'nacos-config-dev2.yaml', 'DEFAULT_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.0', 'a3658b1fa784950a1f226cc7a67d9002', '2024-01-05 00:05:34', '2024-01-04 16:05:34', NULL, '127.0.0.1', 'I', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (0, 4, 'user-config-Info.yaml', 'DEFAULT_GROUP', '', 'user:\r\n  config:\r\n    userName: 严磊-prod环境\r\n    account: yanlei-prod环境', '462a388b75080327fc64b02c39cbc608', '2024-01-05 00:05:48', '2024-01-04 16:05:49', NULL, '127.0.0.1', 'I', '746730a2-53ec-4e1f-9318-8f292a741606', '');
INSERT INTO `his_config_info` VALUES (0, 5, 'nacos-config-prod.yaml', 'DEFAULT_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.1', '4a65909c6fe90280ccf56e1228b52883', '2024-01-05 00:06:02', '2024-01-04 16:06:03', NULL, '127.0.0.1', 'I', '746730a2-53ec-4e1f-9318-8f292a741606', '');
INSERT INTO `his_config_info` VALUES (1, 6, 'user-config-Info.yaml', 'DEFAULT_GROUP', '', 'user:\r\n  config:\r\n    userName: 严磊-dev环境\r\n    account: yanlei-dev环境', '04133828cd7ad4fd08a0c711592da272', '2024-01-05 00:10:24', '2024-01-04 16:10:24', '', '127.0.0.1', 'U', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (1, 7, 'user-config-Info.yaml', 'DEFAULT_GROUP', '', 'user:\n  config:\n    userName: 严磊-dev环境11\n    account: yanlei-dev环境11', '0a19c00d96cbcc6bedbe07fd206d4c93', '2024-01-05 00:10:40', '2024-01-04 16:10:41', '', '127.0.0.1', 'U', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (3, 8, 'nacos-config-dev2.yaml', 'DEFAULT_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.0', 'a3658b1fa784950a1f226cc7a67d9002', '2024-01-07 13:45:41', '2024-01-07 05:45:42', NULL, '127.0.0.1', 'D', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (0, 9, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', '', 'user:\n  config:\n    userName: 严磊-dev环境\n    account: yanlei-dev环境', 'f4b508672afac86585cd4fa23bc30a3f', '2024-01-07 13:46:09', '2024-01-07 05:46:10', NULL, '127.0.0.1', 'I', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (0, 10, 'nacos-config-dev.yaml', 'NACOS_CONFIG_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.0', 'a3658b1fa784950a1f226cc7a67d9002', '2024-01-07 13:46:24', '2024-01-07 05:46:24', NULL, '127.0.0.1', 'I', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (2, 11, 'nacos-config-dev.yaml', 'DEFAULT_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.0', 'a3658b1fa784950a1f226cc7a67d9002', '2024-01-07 13:46:28', '2024-01-07 05:46:29', NULL, '127.0.0.1', 'D', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (0, 12, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', '', 'user:\r\n  config:\r\n    userName: 严磊-prod环境\r\n    account: yanlei-prod环境', '462a388b75080327fc64b02c39cbc608', '2024-01-07 13:46:52', '2024-01-07 05:46:52', NULL, '127.0.0.1', 'I', '746730a2-53ec-4e1f-9318-8f292a741606', '');
INSERT INTO `his_config_info` VALUES (0, 13, 'nacos-config-prod.yaml', 'NACOS_CONFIG_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.1', '4a65909c6fe90280ccf56e1228b52883', '2024-01-07 13:46:52', '2024-01-07 05:46:52', NULL, '127.0.0.1', 'I', '746730a2-53ec-4e1f-9318-8f292a741606', '');
INSERT INTO `his_config_info` VALUES (5, 14, 'nacos-config-prod.yaml', 'DEFAULT_GROUP', '', 'module:\r\n  config:\r\n    moduleName: nacos-config\r\n    version: v1.1', '4a65909c6fe90280ccf56e1228b52883', '2024-01-07 13:47:02', '2024-01-07 05:47:02', NULL, '127.0.0.1', 'D', '746730a2-53ec-4e1f-9318-8f292a741606', '');
INSERT INTO `his_config_info` VALUES (8, 15, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', '', 'user:\n  config:\n    userName: 严磊-dev环境\n    account: yanlei-dev环境', 'f4b508672afac86585cd4fa23bc30a3f', '2024-01-07 13:55:09', '2024-01-07 05:55:09', '', '127.0.0.1', 'U', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (10, 16, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', '', 'user:\r\n  config:\r\n    userName: 严磊-prod环境\r\n    account: yanlei-prod环境', '462a388b75080327fc64b02c39cbc608', '2024-01-07 13:55:32', '2024-01-07 05:55:32', '', '127.0.0.1', 'U', '746730a2-53ec-4e1f-9318-8f292a741606', '');
INSERT INTO `his_config_info` VALUES (4, 17, 'user-config-Info.yaml', 'DEFAULT_GROUP', '', 'user:\r\n  config:\r\n    userName: 严磊-prod环境\r\n    account: yanlei-prod环境', '462a388b75080327fc64b02c39cbc608', '2024-01-07 13:55:51', '2024-01-07 05:55:51', '', '127.0.0.1', 'U', '746730a2-53ec-4e1f-9318-8f292a741606', '');
INSERT INTO `his_config_info` VALUES (1, 18, 'user-config-Info.yaml', 'DEFAULT_GROUP', '', 'user:\n  config:\n    userName: 严磊-dev环境\n    account: yanlei-dev环境', 'f4b508672afac86585cd4fa23bc30a3f', '2024-01-07 13:56:02', '2024-01-07 05:56:03', '', '127.0.0.1', 'U', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (8, 19, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', '', 'user:\n  config:\n    userName: 严磊-dev环境-应用配置\n    account: yanlei-dev环境-应用配置', '20867757054318ea59983c6b9ec9fc9b', '2024-01-07 13:56:34', '2024-01-07 05:56:34', '', '127.0.0.1', 'U', '31d69b98-e73b-4365-aea8-70373cebe240', '');
INSERT INTO `his_config_info` VALUES (8, 20, 'user-config-Info.yaml', 'NACOS_CONFIG_GROUP', '', 'user1:\n  config:\n    userName: 严磊-dev环境-应用配置\n    account: yanlei-dev环境-应用配置', '76f81aab796b8ded495aa48b918298eb', '2024-01-07 13:56:42', '2024-01-07 05:56:43', '', '127.0.0.1', 'U', '31d69b98-e73b-4365-aea8-70373cebe240', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '1', '31d69b98-e73b-4365-aea8-70373cebe240', 'dev', '开发环境', 'nacos', 1704384259980, 1704384259980);
INSERT INTO `tenant_info` VALUES (2, '1', '746730a2-53ec-4e1f-9318-8f292a741606', 'prod', '生产环境', 'nacos', 1704384279235, 1704384279235);
INSERT INTO `tenant_info` VALUES (3, '1', '9a5a02e4-a451-4e06-8878-a610de1c2a97', 'openFeign', 'cloud-openFeign模块', 'nacos', 1704611769258, 1704611769258);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
