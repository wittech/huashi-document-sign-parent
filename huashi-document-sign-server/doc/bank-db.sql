/*
Navicat MySQL Data Transfer

Source Server         : 139.196.87.48
Source Server Version : 50723
Source Host           : 139.196.87.48:3306
Source Database       : kitty

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-12-27 11:10:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='机构管理';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('17', '轻尘集团', null, '0', 'admin', '2018-09-23 19:35:22', null, null, '0');
INSERT INTO `sys_dept` VALUES ('18', '牧尘集团', null, '1', 'admin', '2018-09-23 19:35:55', null, null, '0');
INSERT INTO `sys_dept` VALUES ('19', '三国集团', null, '2', 'admin', '2018-09-23 19:36:24', null, null, '0');
INSERT INTO `sys_dept` VALUES ('21', '上海分公司', '18', '0', 'admin', '2018-09-23 19:37:03', null, null, '0');
INSERT INTO `sys_dept` VALUES ('22', '北京分公司', '17', '1', 'admin', '2018-09-23 19:37:17', null, null, '0');
INSERT INTO `sys_dept` VALUES ('23', '北京分公司', '18', '1', 'admin', '2018-09-23 19:37:28', null, null, '0');
INSERT INTO `sys_dept` VALUES ('25', '技术部', '22', '0', 'admin', '2018-09-23 19:38:00', null, null, '0');
INSERT INTO `sys_dept` VALUES ('26', '技术部', '21', '0', 'admin', '2018-09-23 19:38:10', null, null, '0');
INSERT INTO `sys_dept` VALUES ('27', '技术部', '23', '0', 'admin', '2018-09-23 19:38:17', null, null, '0');
INSERT INTO `sys_dept` VALUES ('29', '市场部', '22', '0', 'admin', '2018-09-23 19:38:45', null, null, '0');
INSERT INTO `sys_dept` VALUES ('30', '市场部', '23', '0', 'admin', '2018-09-23 19:39:01', null, null, '0');
INSERT INTO `sys_dept` VALUES ('33', '魏国', '19', '0', 'admin', '2018-09-23 19:40:42', null, null, '0');
INSERT INTO `sys_dept` VALUES ('34', '蜀国', '19', '1', 'admin', '2018-09-23 19:40:54', null, null, '0');
INSERT INTO `sys_dept` VALUES ('35', '吴国', '19', '2', 'admin', '2018-09-23 19:41:04', null, null, '0');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('3', 'male', '男', 'sex', '性别', '0', 'admin', '2018-09-23 19:52:54', null, null, '性别', '0');
INSERT INTO `sys_dict` VALUES ('4', 'female', '女', 'sex', '性别', '1', 'admin', '2018-09-23 19:53:17', null, null, '性别', '0');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1754 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1071', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:16', null, null);
INSERT INTO `sys_log` VALUES ('1072', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:17', null, null);
INSERT INTO `sys_log` VALUES ('1073', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '36', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:18', null, null);
INSERT INTO `sys_log` VALUES ('1074', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', null, null);
INSERT INTO `sys_log` VALUES ('1075', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', null, null);
INSERT INTO `sys_log` VALUES ('1076', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '27', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:21', null, null);
INSERT INTO `sys_log` VALUES ('1077', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:22', null, null);
INSERT INTO `sys_log` VALUES ('1078', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:23', null, null);
INSERT INTO `sys_log` VALUES ('1079', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:30', null, null);
INSERT INTO `sys_log` VALUES ('1080', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:31', null, null);
INSERT INTO `sys_log` VALUES ('1081', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '30', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:37', null, null);
INSERT INTO `sys_log` VALUES ('1082', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:38', null, null);
INSERT INTO `sys_log` VALUES ('1083', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '37', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:39', null, null);
INSERT INTO `sys_log` VALUES ('1084', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '16', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:42', null, null);
INSERT INTO `sys_log` VALUES ('1085', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:44', null, null);
INSERT INTO `sys_log` VALUES ('1086', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:55:11', null, null);
INSERT INTO `sys_log` VALUES ('1087', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:55:13', null, null);
INSERT INTO `sys_log` VALUES ('1088', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:55:20', null, null);
INSERT INTO `sys_log` VALUES ('1089', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '218.1.24.246', 'admin', '2018-11-02 18:55:56', null, null);
INSERT INTO `sys_log` VALUES ('1090', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '218.1.24.246', 'admin', '2018-11-02 18:55:56', null, null);
INSERT INTO `sys_log` VALUES ('1091', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '115.231.109.46', 'admin', '2018-11-02 19:12:01', null, null);
INSERT INTO `sys_log` VALUES ('1092', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '2', '115.231.109.46', 'admin', '2018-11-02 19:12:22', null, null);
INSERT INTO `sys_log` VALUES ('1093', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '2', '115.231.109.46', 'admin', '2018-11-02 19:12:22', null, null);
INSERT INTO `sys_log` VALUES ('1094', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '31', '115.231.109.46', 'admin', '2018-11-02 19:12:22', null, null);
INSERT INTO `sys_log` VALUES ('1095', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '115.231.109.46', 'admin', '2018-11-02 19:12:22', null, null);
INSERT INTO `sys_log` VALUES ('1096', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '115.231.109.46', 'admin', '2018-11-02 19:12:24', null, null);
INSERT INTO `sys_log` VALUES ('1097', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:24', null, null);
INSERT INTO `sys_log` VALUES ('1098', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:40', null, null);
INSERT INTO `sys_log` VALUES ('1099', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:40', null, null);
INSERT INTO `sys_log` VALUES ('1100', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '112.24.214.181', 'admin', '2018-11-02 19:12:41', null, null);
INSERT INTO `sys_log` VALUES ('1101', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:12:41', null, null);
INSERT INTO `sys_log` VALUES ('1102', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:12:45', null, null);
INSERT INTO `sys_log` VALUES ('1103', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:50', null, null);
INSERT INTO `sys_log` VALUES ('1104', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:50', null, null);
INSERT INTO `sys_log` VALUES ('1105', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '112.24.214.181', 'admin', '2018-11-02 19:12:50', null, null);
INSERT INTO `sys_log` VALUES ('1106', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:50', null, null);
INSERT INTO `sys_log` VALUES ('1107', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:54', null, null);
INSERT INTO `sys_log` VALUES ('1108', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '112.24.214.181', 'admin', '2018-11-02 19:12:54', null, null);
INSERT INTO `sys_log` VALUES ('1109', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:54', null, null);
INSERT INTO `sys_log` VALUES ('1110', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:55', null, null);
INSERT INTO `sys_log` VALUES ('1111', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:12:56', null, null);
INSERT INTO `sys_log` VALUES ('1112', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.24.214.181', 'admin', '2018-11-02 19:12:56', null, null);
INSERT INTO `sys_log` VALUES ('1113', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:12:57', null, null);
INSERT INTO `sys_log` VALUES ('1114', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:13:06', null, null);
INSERT INTO `sys_log` VALUES ('1115', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:13:08', null, null);
INSERT INTO `sys_log` VALUES ('1116', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '112.24.214.181', 'admin', '2018-11-02 19:13:08', null, null);
INSERT INTO `sys_log` VALUES ('1117', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:13:09', null, null);
INSERT INTO `sys_log` VALUES ('1118', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:13:10', null, null);
INSERT INTO `sys_log` VALUES ('1119', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.24.214.181', 'admin', '2018-11-02 19:13:10', null, null);
INSERT INTO `sys_log` VALUES ('1120', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:13:24', null, null);
INSERT INTO `sys_log` VALUES ('1121', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:13:31', null, null);
INSERT INTO `sys_log` VALUES ('1122', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:13:32', null, null);
INSERT INTO `sys_log` VALUES ('1123', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:13:33', null, null);
INSERT INTO `sys_log` VALUES ('1124', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:13:42', null, null);
INSERT INTO `sys_log` VALUES ('1125', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:13:57', null, null);
INSERT INTO `sys_log` VALUES ('1126', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:13:57', null, null);
INSERT INTO `sys_log` VALUES ('1127', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '112.24.214.181', 'admin', '2018-11-02 19:13:57', null, null);
INSERT INTO `sys_log` VALUES ('1128', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:13:57', null, null);
INSERT INTO `sys_log` VALUES ('1129', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:14:42', null, null);
INSERT INTO `sys_log` VALUES ('1130', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:14:57', null, null);
INSERT INTO `sys_log` VALUES ('1131', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:15:31', null, null);
INSERT INTO `sys_log` VALUES ('1132', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541157330718,\"icon\":\"\",\"id\":0,\"name\":\"aa\",\"orderNum\":0,\"parentName\":\"顶级菜单\",\"perms\":\"\",\"type\":1,\"url\":\"/jjj\"}', '34', '112.24.214.181', 'admin', '2018-11-02 19:15:31', null, null);
INSERT INTO `sys_log` VALUES ('1133', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:15:31', null, null);
INSERT INTO `sys_log` VALUES ('1134', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:15:36', null, null);
INSERT INTO `sys_log` VALUES ('1135', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:15:36', null, null);
INSERT INTO `sys_log` VALUES ('1136', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '22', '112.24.214.181', 'admin', '2018-11-02 19:15:36', null, null);
INSERT INTO `sys_log` VALUES ('1137', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:15:37', null, null);
INSERT INTO `sys_log` VALUES ('1138', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:15:43', null, null);
INSERT INTO `sys_log` VALUES ('1139', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.24.214.181', 'admin', '2018-11-02 19:15:43', null, null);
INSERT INTO `sys_log` VALUES ('1140', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:15:43', null, null);
INSERT INTO `sys_log` VALUES ('1141', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '112.24.214.181', 'admin', '2018-11-02 19:15:58', null, null);
INSERT INTO `sys_log` VALUES ('1142', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '112.24.214.181', 'admin', '2018-11-02 19:16:08', null, null);
INSERT INTO `sys_log` VALUES ('1143', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '223.88.132.168', 'admin', '2018-11-02 19:18:18', null, null);
INSERT INTO `sys_log` VALUES ('1144', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '113.205.104.93', 'admin', '2018-11-02 19:21:24', null, null);
INSERT INTO `sys_log` VALUES ('1145', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '113.205.104.93', 'admin', '2018-11-02 19:21:43', null, null);
INSERT INTO `sys_log` VALUES ('1146', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '287', '218.1.24.246', 'admin', '2018-11-02 19:54:21', null, null);
INSERT INTO `sys_log` VALUES ('1147', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.delete()', '[{\"id\":37}]', '92', '218.1.24.246', 'admin', '2018-11-02 19:55:23', null, null);
INSERT INTO `sys_log` VALUES ('1148', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '81', '218.1.24.246', 'admin', '2018-11-02 20:01:13', null, null);
INSERT INTO `sys_log` VALUES ('1149', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '218.1.24.246', 'admin', '2018-11-02 20:01:17', null, null);
INSERT INTO `sys_log` VALUES ('1150', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541160134988,\"icon\":\"\",\"id\":0,\"name\":\"服务监控\",\"orderNum\":3,\"parentId\":0,\"parentName\":\"\",\"perms\":\"\",\"type\":1,\"url\":\"http://139.196.87.48:8000/\"}', '23', '218.1.24.246', 'admin', '2018-11-02 20:02:15', null, null);
INSERT INTO `sys_log` VALUES ('1151', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541160135000,\"delFlag\":0,\"icon\":\"el-icon-info\",\"id\":38,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541160153731,\"level\":0,\"name\":\"服务监控\",\"orderNum\":3,\"paren...', '36', '218.1.24.246', 'admin', '2018-11-02 20:02:34', null, null);
INSERT INTO `sys_log` VALUES ('1152', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '57', '218.1.24.246', 'admin', '2018-11-02 20:02:49', null, null);
INSERT INTO `sys_log` VALUES ('1153', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '218.1.24.246', 'admin', '2018-11-02 20:02:51', null, null);
INSERT INTO `sys_log` VALUES ('1154', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '41', '218.1.24.246', 'admin', '2018-11-02 20:02:52', null, null);
INSERT INTO `sys_log` VALUES ('1155', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '66', '218.1.24.246', 'admin', '2018-11-02 20:02:56', null, null);
INSERT INTO `sys_log` VALUES ('1156', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '218.1.24.246', 'admin', '2018-11-02 20:03:17', null, null);
INSERT INTO `sys_log` VALUES ('1157', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '218.1.24.246', 'admin', '2018-11-02 20:03:18', null, null);
INSERT INTO `sys_log` VALUES ('1158', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-tickets\",\"id\":35,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541160229046,\"level\":0,\"name\":\"接口文档\",\"orderNum\":1,\"parentId\":0,\"type\":1,\"url\":\"iframe:/swagger-ui.h...', '15', '218.1.24.246', 'admin', '2018-11-02 20:03:49', null, null);
INSERT INTO `sys_log` VALUES ('1159', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-info\",\"id\":6,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541160235756,\"level\":0,\"name\":\"SQL监控\",\"orderNum\":2,\"parentId\":0,\"type\":1,\"url\":\"iframe:/druid/login.htm...', '15', '218.1.24.246', 'admin', '2018-11-02 20:03:56', null, null);
INSERT INTO `sys_log` VALUES ('1160', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '26', '218.1.24.246', 'admin', '2018-11-02 20:05:25', null, null);
INSERT INTO `sys_log` VALUES ('1161', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '218.1.24.246', 'admin', '2018-11-02 20:05:37', null, null);
INSERT INTO `sys_log` VALUES ('1162', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '218.1.24.246', 'admin', '2018-11-02 20:05:54', null, null);
INSERT INTO `sys_log` VALUES ('1163', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '38', '218.1.24.246', 'admin', '2018-11-02 20:05:58', null, null);
INSERT INTO `sys_log` VALUES ('1164', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541161902575,\"icon\":\"\",\"id\":0,\"name\":\"百度查询\",\"orderNum\":8,\"parentId\":0,\"parentName\":\"\",\"perms\":\"\",\"type\":1,\"url\":\"http://www.baidu.com\"}', '6', '180.173.108.88', 'admin', '2018-11-02 20:31:43', null, null);
INSERT INTO `sys_log` VALUES ('1165', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '55', '180.173.108.88', 'admin', '2018-11-02 20:33:38', null, null);
INSERT INTO `sys_log` VALUES ('1166', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.delete()', '[{\"id\":39}]', '10', '180.173.108.88', 'admin', '2018-11-02 20:33:46', null, null);
INSERT INTO `sys_log` VALUES ('1167', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '35', '180.173.108.88', 'admin', '2018-11-02 20:34:35', null, null);
INSERT INTO `sys_log` VALUES ('1168', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '40', '180.173.108.88', 'admin', '2018-11-02 20:36:58', null, null);
INSERT INTO `sys_log` VALUES ('1169', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '46', '180.173.108.88', 'admin', '2018-11-02 20:37:06', null, null);
INSERT INTO `sys_log` VALUES ('1170', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '39', '180.173.108.88', 'admin', '2018-11-02 20:37:13', null, null);
INSERT INTO `sys_log` VALUES ('1171', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '180.173.108.88', 'admin', '2018-11-02 20:37:17', null, null);
INSERT INTO `sys_log` VALUES ('1172', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '34', '180.173.108.88', 'admin', '2018-11-02 20:37:28', null, null);
INSERT INTO `sys_log` VALUES ('1173', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '180.173.108.88', 'admin', '2018-11-02 20:37:30', null, null);
INSERT INTO `sys_log` VALUES ('1174', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '26', '180.173.108.88', 'admin', '2018-11-02 20:37:32', null, null);
INSERT INTO `sys_log` VALUES ('1175', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:37:34', null, null);
INSERT INTO `sys_log` VALUES ('1176', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '27', '180.173.108.88', 'admin', '2018-11-02 20:37:42', null, null);
INSERT INTO `sys_log` VALUES ('1177', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:37:44', null, null);
INSERT INTO `sys_log` VALUES ('1178', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '180.173.108.88', 'admin', '2018-11-02 20:37:47', null, null);
INSERT INTO `sys_log` VALUES ('1179', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '180.173.108.88', 'admin', '2018-11-02 20:37:50', null, null);
INSERT INTO `sys_log` VALUES ('1180', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '35', '180.173.108.88', 'admin', '2018-11-02 20:37:52', null, null);
INSERT INTO `sys_log` VALUES ('1181', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '26', '180.173.108.88', 'admin', '2018-11-02 20:38:10', null, null);
INSERT INTO `sys_log` VALUES ('1182', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '38', '180.173.108.88', 'admin', '2018-11-02 20:38:12', null, null);
INSERT INTO `sys_log` VALUES ('1183', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '180.173.108.88', 'admin', '2018-11-02 20:38:17', null, null);
INSERT INTO `sys_log` VALUES ('1184', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '180.173.108.88', 'admin', '2018-11-02 20:38:19', null, null);
INSERT INTO `sys_log` VALUES ('1185', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '21', '180.173.108.88', 'admin', '2018-11-02 20:38:23', null, null);
INSERT INTO `sys_log` VALUES ('1186', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '21', '180.173.108.88', 'admin', '2018-11-02 20:38:27', null, null);
INSERT INTO `sys_log` VALUES ('1187', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '180.173.108.88', 'admin', '2018-11-02 20:38:36', null, null);
INSERT INTO `sys_log` VALUES ('1188', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '180.173.108.88', 'admin', '2018-11-02 20:38:38', null, null);
INSERT INTO `sys_log` VALUES ('1189', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '180.173.108.88', 'admin', '2018-11-02 20:38:40', null, null);
INSERT INTO `sys_log` VALUES ('1190', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '180.173.108.88', 'admin', '2018-11-02 20:38:43', null, null);
INSERT INTO `sys_log` VALUES ('1191', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '25', '180.173.108.88', 'admin', '2018-11-02 20:38:45', null, null);
INSERT INTO `sys_log` VALUES ('1192', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '180.173.108.88', 'admin', '2018-11-02 20:39:27', null, null);
INSERT INTO `sys_log` VALUES ('1193', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '44', '180.173.108.88', 'admin', '2018-11-02 20:39:29', null, null);
INSERT INTO `sys_log` VALUES ('1194', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:39:31', null, null);
INSERT INTO `sys_log` VALUES ('1195', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '24', '180.173.108.88', 'admin', '2018-11-02 20:39:32', null, null);
INSERT INTO `sys_log` VALUES ('1196', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '180.173.108.88', 'admin', '2018-11-02 20:39:34', null, null);
INSERT INTO `sys_log` VALUES ('1197', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '23', '180.173.108.88', 'admin', '2018-11-02 20:39:35', null, null);
INSERT INTO `sys_log` VALUES ('1198', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:39:36', null, null);
INSERT INTO `sys_log` VALUES ('1199', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '180.173.108.88', 'admin', '2018-11-02 20:39:39', null, null);
INSERT INTO `sys_log` VALUES ('1200', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:39:41', null, null);
INSERT INTO `sys_log` VALUES ('1201', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '180.173.108.88', 'admin', '2018-11-02 20:39:46', null, null);
INSERT INTO `sys_log` VALUES ('1202', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '112.112.9.140', 'admin', '2018-11-02 20:39:58', null, null);
INSERT INTO `sys_log` VALUES ('1203', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '180.173.108.88', 'admin', '2018-11-02 20:40:09', null, null);
INSERT INTO `sys_log` VALUES ('1204', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '180.173.108.88', 'admin', '2018-11-02 20:40:11', null, null);
INSERT INTO `sys_log` VALUES ('1205', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '180.173.108.88', 'admin', '2018-11-02 20:40:13', null, null);
INSERT INTO `sys_log` VALUES ('1206', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '33', '180.173.108.88', 'admin', '2018-11-02 20:40:20', null, null);
INSERT INTO `sys_log` VALUES ('1207', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '180.173.108.88', 'admin', '2018-11-02 20:40:22', null, null);
INSERT INTO `sys_log` VALUES ('1208', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '180.173.108.88', 'admin', '2018-11-02 20:40:57', null, null);
INSERT INTO `sys_log` VALUES ('1209', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '21', '180.173.108.88', 'admin', '2018-11-02 20:41:00', null, null);
INSERT INTO `sys_log` VALUES ('1210', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:41:03', null, null);
INSERT INTO `sys_log` VALUES ('1211', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:41:13', null, null);
INSERT INTO `sys_log` VALUES ('1212', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:41:16', null, null);
INSERT INTO `sys_log` VALUES ('1213', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '180.173.108.88', 'admin', '2018-11-02 20:41:17', null, null);
INSERT INTO `sys_log` VALUES ('1214', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '180.173.108.88', 'admin', '2018-11-02 20:41:18', null, null);
INSERT INTO `sys_log` VALUES ('1215', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:41:26', null, null);
INSERT INTO `sys_log` VALUES ('1216', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '180.173.108.88', 'admin', '2018-11-02 20:41:49', null, null);
INSERT INTO `sys_log` VALUES ('1217', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '180.173.108.88', 'admin', '2018-11-02 20:41:51', null, null);
INSERT INTO `sys_log` VALUES ('1218', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '180.173.108.88', 'admin', '2018-11-02 20:42:13', null, null);
INSERT INTO `sys_log` VALUES ('1219', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:42:18', null, null);
INSERT INTO `sys_log` VALUES ('1220', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:42:37', null, null);
INSERT INTO `sys_log` VALUES ('1221', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:42:45', null, null);
INSERT INTO `sys_log` VALUES ('1222', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '180.173.108.88', 'admin', '2018-11-02 20:42:47', null, null);
INSERT INTO `sys_log` VALUES ('1223', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '180.173.108.88', 'admin', '2018-11-02 20:42:50', null, null);
INSERT INTO `sys_log` VALUES ('1224', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '180.173.108.88', 'admin', '2018-11-02 20:42:53', null, null);
INSERT INTO `sys_log` VALUES ('1225', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:42:57', null, null);
INSERT INTO `sys_log` VALUES ('1226', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '25', '180.173.108.88', 'admin', '2018-11-02 20:43:16', null, null);
INSERT INTO `sys_log` VALUES ('1227', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:43:18', null, null);
INSERT INTO `sys_log` VALUES ('1228', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '180.173.108.88', 'admin', '2018-11-02 20:43:20', null, null);
INSERT INTO `sys_log` VALUES ('1229', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '180.173.108.88', 'admin', '2018-11-02 20:43:27', null, null);
INSERT INTO `sys_log` VALUES ('1230', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '23', '180.173.108.88', 'admin', '2018-11-02 20:43:45', null, null);
INSERT INTO `sys_log` VALUES ('1231', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:44:03', null, null);
INSERT INTO `sys_log` VALUES ('1232', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:44:05', null, null);
INSERT INTO `sys_log` VALUES ('1233', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:44:36', null, null);
INSERT INTO `sys_log` VALUES ('1234', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:44:37', null, null);
INSERT INTO `sys_log` VALUES ('1235', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:44:39', null, null);
INSERT INTO `sys_log` VALUES ('1236', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:44:40', null, null);
INSERT INTO `sys_log` VALUES ('1237', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '180.173.108.88', 'admin', '2018-11-02 20:44:41', null, null);
INSERT INTO `sys_log` VALUES ('1238', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '180.173.108.88', 'admin', '2018-11-02 20:44:43', null, null);
INSERT INTO `sys_log` VALUES ('1239', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-02 20:44:44', null, null);
INSERT INTO `sys_log` VALUES ('1240', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '180.173.108.88', 'admin', '2018-11-02 20:46:42', null, null);
INSERT INTO `sys_log` VALUES ('1241', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '180.173.108.88', 'admin', '2018-11-02 20:46:46', null, null);
INSERT INTO `sys_log` VALUES ('1242', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '180.173.108.88', 'admin', '2018-11-02 20:46:50', null, null);
INSERT INTO `sys_log` VALUES ('1243', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '180.173.108.88', 'admin', '2018-11-02 20:46:53', null, null);
INSERT INTO `sys_log` VALUES ('1244', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '21', '180.173.108.88', 'admin', '2018-11-02 20:46:59', null, null);
INSERT INTO `sys_log` VALUES ('1245', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '180.173.108.88', 'admin', '2018-11-02 20:47:01', null, null);
INSERT INTO `sys_log` VALUES ('1246', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '180.173.108.88', 'admin', '2018-11-02 20:47:06', null, null);
INSERT INTO `sys_log` VALUES ('1247', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '180.173.108.88', 'admin', '2018-11-02 20:47:14', null, null);
INSERT INTO `sys_log` VALUES ('1248', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-02 20:47:17', null, null);
INSERT INTO `sys_log` VALUES ('1249', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '180.173.108.88', 'admin', '2018-11-02 20:47:22', null, null);
INSERT INTO `sys_log` VALUES ('1250', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '22', '180.173.108.88', 'admin', '2018-11-02 20:47:39', null, null);
INSERT INTO `sys_log` VALUES ('1251', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '117.101.204.199', 'admin', '2018-11-02 21:15:53', null, null);
INSERT INTO `sys_log` VALUES ('1252', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '29', '117.101.204.199', 'admin', '2018-11-02 21:16:05', null, null);
INSERT INTO `sys_log` VALUES ('1253', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '117.101.204.199', 'admin', '2018-11-02 21:16:35', null, null);
INSERT INTO `sys_log` VALUES ('1254', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '117.101.204.199', 'admin', '2018-11-02 21:16:50', null, null);
INSERT INTO `sys_log` VALUES ('1255', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '117.101.204.199', 'admin', '2018-11-02 21:18:07', null, null);
INSERT INTO `sys_log` VALUES ('1256', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '180.173.108.88', 'admin', '2018-11-02 21:56:05', null, null);
INSERT INTO `sys_log` VALUES ('1257', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '22', '180.173.108.88', 'admin', '2018-11-02 22:00:30', null, null);
INSERT INTO `sys_log` VALUES ('1258', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '180.173.108.88', 'admin', '2018-11-02 22:00:34', null, null);
INSERT INTO `sys_log` VALUES ('1259', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '211.161.248.5', 'admin', '2018-11-02 22:12:34', null, null);
INSERT INTO `sys_log` VALUES ('1260', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '211.161.248.5', 'admin', '2018-11-02 22:12:35', null, null);
INSERT INTO `sys_log` VALUES ('1261', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '182.138.167.109', 'admin', '2018-11-02 22:45:12', null, null);
INSERT INTO `sys_log` VALUES ('1262', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '182.138.167.109', 'admin', '2018-11-02 22:45:37', null, null);
INSERT INTO `sys_log` VALUES ('1263', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '182.138.167.109', 'admin', '2018-11-02 22:45:53', null, null);
INSERT INTO `sys_log` VALUES ('1264', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '182.138.167.109', 'admin', '2018-11-02 22:52:02', null, null);
INSERT INTO `sys_log` VALUES ('1265', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '116.23.81.14', 'admin', '2018-11-02 22:53:49', null, null);
INSERT INTO `sys_log` VALUES ('1266', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '116.23.81.14', 'admin', '2018-11-02 22:54:09', null, null);
INSERT INTO `sys_log` VALUES ('1267', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '116.23.81.14', 'admin', '2018-11-02 22:54:16', null, null);
INSERT INTO `sys_log` VALUES ('1268', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '101.105.164.179', 'admin', '2018-11-02 22:57:18', null, null);
INSERT INTO `sys_log` VALUES ('1269', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '101.105.164.179', 'admin', '2018-11-02 22:57:41', null, null);
INSERT INTO `sys_log` VALUES ('1270', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '101.105.164.179', 'admin', '2018-11-02 22:57:46', null, null);
INSERT INTO `sys_log` VALUES ('1271', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '101.105.164.179', 'admin', '2018-11-02 22:58:24', null, null);
INSERT INTO `sys_log` VALUES ('1272', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '33', '111.196.81.1', 'admin', '2018-11-02 23:03:22', null, null);
INSERT INTO `sys_log` VALUES ('1273', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '111.196.81.1', 'admin', '2018-11-02 23:04:01', null, null);
INSERT INTO `sys_log` VALUES ('1274', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '121.237.191.26', 'admin', '2018-11-02 23:09:48', null, null);
INSERT INTO `sys_log` VALUES ('1275', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '121.237.191.26', 'admin', '2018-11-02 23:09:50', null, null);
INSERT INTO `sys_log` VALUES ('1276', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '121.237.191.26', 'admin', '2018-11-02 23:09:51', null, null);
INSERT INTO `sys_log` VALUES ('1277', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDeptServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541171603425,\"id\":0,\"name\":\"测试\",\"orderNum\":0,\"parentId\":24,\"parentName\":\"技术部\"}', '52', '59.109.159.78', 'admin', '2018-11-02 23:13:23', null, null);
INSERT INTO `sys_log` VALUES ('1278', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDeptServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541171639963,\"id\":0,\"name\":\"1\",\"orderNum\":0,\"parentName\":\"顶级菜单\"}', '8', '59.109.159.78', 'admin', '2018-11-02 23:14:00', null, null);
INSERT INTO `sys_log` VALUES ('1279', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '59.109.159.78', 'admin', '2018-11-02 23:14:18', null, null);
INSERT INTO `sys_log` VALUES ('1280', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '115.66.217.131', 'admin', '2018-11-02 23:15:15', null, null);
INSERT INTO `sys_log` VALUES ('1281', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '115.66.217.131', 'admin', '2018-11-02 23:15:22', null, null);
INSERT INTO `sys_log` VALUES ('1282', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '59.109.159.78', 'admin', '2018-11-02 23:18:24', null, null);
INSERT INTO `sys_log` VALUES ('1283', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '59.109.159.78', 'admin', '2018-11-02 23:19:16', null, null);
INSERT INTO `sys_log` VALUES ('1284', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.10.158.229', 'admin', '2018-11-02 23:38:33', null, null);
INSERT INTO `sys_log` VALUES ('1285', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '112.10.158.229', 'admin', '2018-11-02 23:38:49', null, null);
INSERT INTO `sys_log` VALUES ('1286', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '112.10.158.229', 'admin', '2018-11-02 23:38:54', null, null);
INSERT INTO `sys_log` VALUES ('1287', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '112.10.158.229', 'admin', '2018-11-02 23:38:58', null, null);
INSERT INTO `sys_log` VALUES ('1288', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '125.41.138.251', 'admin', '2018-11-03 01:00:04', null, null);
INSERT INTO `sys_log` VALUES ('1289', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '125.41.138.251', 'admin', '2018-11-03 01:00:14', null, null);
INSERT INTO `sys_log` VALUES ('1290', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '24', '14.153.50.170', 'admin', '2018-11-03 01:27:36', null, null);
INSERT INTO `sys_log` VALUES ('1291', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '14.153.50.170', 'admin', '2018-11-03 01:27:38', null, null);
INSERT INTO `sys_log` VALUES ('1292', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '14.153.50.170', 'admin', '2018-11-03 01:28:51', null, null);
INSERT INTO `sys_log` VALUES ('1293', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '14.153.50.170', 'admin', '2018-11-03 01:30:11', null, null);
INSERT INTO `sys_log` VALUES ('1294', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '14.153.50.170', 'admin', '2018-11-03 01:30:25', null, null);
INSERT INTO `sys_log` VALUES ('1295', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '14.153.50.170', 'admin', '2018-11-03 01:30:45', null, null);
INSERT INTO `sys_log` VALUES ('1296', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '26', '14.153.50.170', 'admin', '2018-11-03 01:30:59', null, null);
INSERT INTO `sys_log` VALUES ('1297', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '14.153.50.170', 'admin', '2018-11-03 01:31:02', null, null);
INSERT INTO `sys_log` VALUES ('1298', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '14.153.50.170', 'admin', '2018-11-03 01:31:54', null, null);
INSERT INTO `sys_log` VALUES ('1299', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '14.153.50.170', 'admin', '2018-11-03 01:31:59', null, null);
INSERT INTO `sys_log` VALUES ('1300', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '14.153.50.170', 'admin', '2018-11-03 01:32:10', null, null);
INSERT INTO `sys_log` VALUES ('1301', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '119.33.28.204', 'admin', '2018-11-03 01:34:39', null, null);
INSERT INTO `sys_log` VALUES ('1302', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '119.33.28.204', 'admin', '2018-11-03 01:34:41', null, null);
INSERT INTO `sys_log` VALUES ('1303', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '119.33.28.204', 'admin', '2018-11-03 01:34:42', null, null);
INSERT INTO `sys_log` VALUES ('1304', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '119.33.28.204', 'admin', '2018-11-03 01:34:43', null, null);
INSERT INTO `sys_log` VALUES ('1305', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '119.33.28.204', 'admin', '2018-11-03 01:34:45', null, null);
INSERT INTO `sys_log` VALUES ('1306', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '119.33.28.204', 'admin', '2018-11-03 01:34:46', null, null);
INSERT INTO `sys_log` VALUES ('1307', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '119.33.28.204', 'admin', '2018-11-03 01:34:46', null, null);
INSERT INTO `sys_log` VALUES ('1308', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '119.33.28.204', 'admin', '2018-11-03 01:34:47', null, null);
INSERT INTO `sys_log` VALUES ('1309', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '123.116.169.175', 'admin', '2018-11-03 08:19:41', null, null);
INSERT INTO `sys_log` VALUES ('1310', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '123.116.169.175', 'admin', '2018-11-03 08:19:48', null, null);
INSERT INTO `sys_log` VALUES ('1311', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '24', '123.116.169.175', 'admin', '2018-11-03 08:19:59', null, null);
INSERT INTO `sys_log` VALUES ('1312', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '123.116.169.175', 'admin', '2018-11-03 08:20:08', null, null);
INSERT INTO `sys_log` VALUES ('1313', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '123.116.169.175', 'admin', '2018-11-03 08:20:09', null, null);
INSERT INTO `sys_log` VALUES ('1314', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '223.104.94.18', 'admin', '2018-11-03 08:26:43', null, null);
INSERT INTO `sys_log` VALUES ('1315', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '24', '113.45.45.232', 'admin', '2018-11-03 09:33:55', null, null);
INSERT INTO `sys_log` VALUES ('1316', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '113.45.45.232', 'admin', '2018-11-03 09:33:57', null, null);
INSERT INTO `sys_log` VALUES ('1317', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '113.45.45.232', 'admin', '2018-11-03 09:33:57', null, null);
INSERT INTO `sys_log` VALUES ('1318', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '113.45.45.232', 'admin', '2018-11-03 09:35:25', null, null);
INSERT INTO `sys_log` VALUES ('1319', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '113.45.45.232', 'admin', '2018-11-03 09:36:01', null, null);
INSERT INTO `sys_log` VALUES ('1320', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '113.45.45.232', 'admin', '2018-11-03 09:36:03', null, null);
INSERT INTO `sys_log` VALUES ('1321', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '113.45.45.232', 'admin', '2018-11-03 09:36:06', null, null);
INSERT INTO `sys_log` VALUES ('1322', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '180.172.4.6', 'admin', '2018-11-03 09:39:24', null, null);
INSERT INTO `sys_log` VALUES ('1323', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '180.172.4.6', 'admin', '2018-11-03 09:40:03', null, null);
INSERT INTO `sys_log` VALUES ('1324', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.172.4.6', 'admin', '2018-11-03 09:40:33', null, null);
INSERT INTO `sys_log` VALUES ('1325', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '115.174.235.66', 'admin', '2018-11-03 09:57:03', null, null);
INSERT INTO `sys_log` VALUES ('1326', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '115.174.235.66', 'admin', '2018-11-03 09:57:06', null, null);
INSERT INTO `sys_log` VALUES ('1327', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '115.174.235.66', 'admin', '2018-11-03 09:57:16', null, null);
INSERT INTO `sys_log` VALUES ('1328', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '115.174.235.66', 'admin', '2018-11-03 09:57:33', null, null);
INSERT INTO `sys_log` VALUES ('1329', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '115.174.235.66', 'admin', '2018-11-03 09:57:47', null, null);
INSERT INTO `sys_log` VALUES ('1330', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '180.173.108.88', 'admin', '2018-11-03 10:22:17', null, null);
INSERT INTO `sys_log` VALUES ('1331', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-03 10:22:22', null, null);
INSERT INTO `sys_log` VALUES ('1332', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '180.173.108.88', 'admin', '2018-11-03 10:22:24', null, null);
INSERT INTO `sys_log` VALUES ('1333', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541211787505,\"icon\":\"\",\"id\":0,\"name\":\"fsdf\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"\",\"perms\":\"dfsdf\",\"type\":1,\"url\":\"dfdf\"}', '12', '180.173.108.88', 'admin', '2018-11-03 10:23:08', null, null);
INSERT INTO `sys_log` VALUES ('1334', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.delete()', '[{\"id\":40}]', '17', '180.173.108.88', 'admin', '2018-11-03 10:24:08', null, null);
INSERT INTO `sys_log` VALUES ('1335', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '180.173.108.88', 'admin', '2018-11-03 10:24:53', null, null);
INSERT INTO `sys_log` VALUES ('1336', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDeptServiceImpl.delete()', '[{\"id\":37}]', '34', '180.173.108.88', 'admin', '2018-11-03 10:25:01', null, null);
INSERT INTO `sys_log` VALUES ('1337', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '180.173.108.88', 'admin', '2018-11-03 10:25:11', null, null);
INSERT INTO `sys_log` VALUES ('1338', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '180.173.108.88', 'admin', '2018-11-03 10:25:13', null, null);
INSERT INTO `sys_log` VALUES ('1339', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '180.173.108.88', 'admin', '2018-11-03 10:25:14', null, null);
INSERT INTO `sys_log` VALUES ('1340', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '59.109.159.78', 'admin', '2018-11-03 10:28:01', null, null);
INSERT INTO `sys_log` VALUES ('1341', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '59.109.159.78', 'admin', '2018-11-03 10:28:05', null, null);
INSERT INTO `sys_log` VALUES ('1342', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '211.160.72.27', 'admin', '2018-11-03 10:42:07', null, null);
INSERT INTO `sys_log` VALUES ('1343', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '211.160.72.27', 'admin', '2018-11-03 10:43:06', null, null);
INSERT INTO `sys_log` VALUES ('1344', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '211.160.72.27', 'admin', '2018-11-03 10:44:32', null, null);
INSERT INTO `sys_log` VALUES ('1345', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '106.34.138.154', 'admin', '2018-11-03 10:45:34', null, null);
INSERT INTO `sys_log` VALUES ('1346', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '22', '116.7.218.63', 'admin', '2018-11-03 10:53:49', null, null);
INSERT INTO `sys_log` VALUES ('1347', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '116.7.218.63', 'admin', '2018-11-03 10:53:57', null, null);
INSERT INTO `sys_log` VALUES ('1348', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '116.7.218.63', 'admin', '2018-11-03 10:54:18', null, null);
INSERT INTO `sys_log` VALUES ('1349', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '116.7.218.63', 'admin', '2018-11-03 10:54:26', null, null);
INSERT INTO `sys_log` VALUES ('1350', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findById()', '0', '12', '116.7.218.63', 'admin', '2018-11-03 10:55:11', null, null);
INSERT INTO `sys_log` VALUES ('1351', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541213711210,\"id\":0,\"name\":\"1\",\"remark\":\"\"}', '10', '116.7.218.63', 'admin', '2018-11-03 10:55:11', null, null);
INSERT INTO `sys_log` VALUES ('1352', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '116.7.218.63', 'admin', '2018-11-03 10:55:11', null, null);
INSERT INTO `sys_log` VALUES ('1353', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '180.173.108.88', 'admin', '2018-11-03 10:56:46', null, null);
INSERT INTO `sys_log` VALUES ('1354', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '180.173.108.88', 'admin', '2018-11-03 10:56:48', null, null);
INSERT INTO `sys_log` VALUES ('1355', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541214407553,\"icon\":\"\",\"id\":0,\"name\":\"服务治理\",\"orderNum\":4,\"parentId\":0,\"parentName\":\"\",\"perms\":\"\",\"type\":1,\"url\":\"http://139.196.87.48:8500\"}', '4', '180.173.108.88', 'admin', '2018-11-03 11:06:48', null, null);
INSERT INTO `sys_log` VALUES ('1356', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-edit\",\"id\":29,\"level\":1,\"name\":\"国际化\",\"orderNum\":1,\"parentId\":28,\"parentName\":\"使用案例\",\"type\":1,\"url\":\"/demo/i18n\"},{\"children\":[],\"delFlag\":0,\"ico...', '11', '180.173.108.88', 'admin', '2018-11-03 11:06:57', null, null);
INSERT INTO `sys_log` VALUES ('1357', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\"el-icon-service\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541214434496,\"level\":0,\"name\":\"服务治理\",\"orderNum\":4,\"pa...', '10', '180.173.108.88', 'admin', '2018-11-03 11:07:15', null, null);
INSERT INTO `sys_log` VALUES ('1358', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541160135000,\"delFlag\":0,\"icon\":\"el-icon-view\",\"id\":38,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541214451514,\"level\":0,\"name\":\"服务监控\",\"orderNum\":3,\"paren...', '10', '180.173.108.88', 'admin', '2018-11-03 11:07:32', null, null);
INSERT INTO `sys_log` VALUES ('1359', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '180.173.108.88', 'admin', '2018-11-03 11:07:34', null, null);
INSERT INTO `sys_log` VALUES ('1360', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '180.173.108.88', 'admin', '2018-11-03 11:07:35', null, null);
INSERT INTO `sys_log` VALUES ('1361', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-03 11:07:37', null, null);
INSERT INTO `sys_log` VALUES ('1362', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '253', '180.173.108.88', 'admin', '2018-11-03 11:18:12', null, null);
INSERT INTO `sys_log` VALUES ('1363', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '180.173.108.88', 'admin', '2018-11-03 11:18:15', null, null);
INSERT INTO `sys_log` VALUES ('1364', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '51', '180.173.108.88', 'admin', '2018-11-03 11:18:20', null, null);
INSERT INTO `sys_log` VALUES ('1365', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '48', '36.157.222.184', 'admin', '2018-11-03 11:20:03', null, null);
INSERT INTO `sys_log` VALUES ('1366', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '36.157.222.184', 'admin', '2018-11-03 11:20:06', null, null);
INSERT INTO `sys_log` VALUES ('1367', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '36.157.222.184', 'admin', '2018-11-03 11:20:10', null, null);
INSERT INTO `sys_log` VALUES ('1368', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '47', '120.230.81.54', 'admin', '2018-11-03 11:34:59', null, null);
INSERT INTO `sys_log` VALUES ('1369', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '120.230.81.54', 'admin', '2018-11-03 11:35:04', null, null);
INSERT INTO `sys_log` VALUES ('1370', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '120.230.81.54', 'admin', '2018-11-03 11:35:08', null, null);
INSERT INTO `sys_log` VALUES ('1371', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '120.230.81.54', 'admin', '2018-11-03 11:35:11', null, null);
INSERT INTO `sys_log` VALUES ('1372', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '30', '120.230.81.54', 'admin', '2018-11-03 11:35:44', null, null);
INSERT INTO `sys_log` VALUES ('1373', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '51', '120.230.81.54', 'admin', '2018-11-03 11:35:46', null, null);
INSERT INTO `sys_log` VALUES ('1374', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '230', '180.173.108.88', 'admin', '2018-11-03 11:55:07', null, null);
INSERT INTO `sys_log` VALUES ('1375', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '93', '180.173.108.88', 'admin', '2018-11-03 11:58:13', null, null);
INSERT INTO `sys_log` VALUES ('1376', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '180.173.108.88', 'admin', '2018-11-03 12:03:45', null, null);
INSERT INTO `sys_log` VALUES ('1377', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findById()', '0', '13', '180.173.108.88', 'admin', '2018-11-03 12:03:53', null, null);
INSERT INTO `sys_log` VALUES ('1378', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541217833047,\"id\":0,\"name\":\"2\",\"remark\":\"\"}', '18', '180.173.108.88', 'admin', '2018-11-03 12:03:53', null, null);
INSERT INTO `sys_log` VALUES ('1379', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '180.173.108.88', 'admin', '2018-11-03 12:03:53', null, null);
INSERT INTO `sys_log` VALUES ('1380', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '180.173.108.88', 'admin', '2018-11-03 12:04:00', null, null);
INSERT INTO `sys_log` VALUES ('1381', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '49', '180.173.108.88', 'admin', '2018-11-03 12:27:39', null, null);
INSERT INTO `sys_log` VALUES ('1382', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '180.173.108.88', 'admin', '2018-11-03 12:27:42', null, null);
INSERT INTO `sys_log` VALUES ('1383', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '45', '180.173.108.88', 'admin', '2018-11-03 12:27:47', null, null);
INSERT INTO `sys_log` VALUES ('1384', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '47', '1.86.247.215', 'admin', '2018-11-03 12:52:35', null, null);
INSERT INTO `sys_log` VALUES ('1385', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '59', '1.86.247.215', 'admin', '2018-11-03 12:52:37', null, null);
INSERT INTO `sys_log` VALUES ('1386', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"刘备\"}},\"pageNum\":1,\"pageSize\":8}', '5', '1.86.247.215', 'admin', '2018-11-03 12:52:45', null, null);
INSERT INTO `sys_log` VALUES ('1387', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '35', '1.86.247.215', 'admin', '2018-11-03 12:52:54', null, null);
INSERT INTO `sys_log` VALUES ('1388', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '1.86.247.215', 'admin', '2018-11-03 12:56:15', null, null);
INSERT INTO `sys_log` VALUES ('1389', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '1.86.247.215', 'admin', '2018-11-03 12:56:18', null, null);
INSERT INTO `sys_log` VALUES ('1390', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '76', '122.238.92.248', 'admin', '2018-11-03 13:01:38', null, null);
INSERT INTO `sys_log` VALUES ('1391', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '122.238.92.248', 'admin', '2018-11-03 13:01:43', null, null);
INSERT INTO `sys_log` VALUES ('1392', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '21', '58.62.108.180', 'admin', '2018-11-03 13:19:40', null, null);
INSERT INTO `sys_log` VALUES ('1393', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '41', '58.62.108.180', 'admin', '2018-11-03 13:19:56', null, null);
INSERT INTO `sys_log` VALUES ('1394', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '58.62.108.180', 'admin', '2018-11-03 13:20:15', null, null);
INSERT INTO `sys_log` VALUES ('1395', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '202.110.241.78', 'admin', '2018-11-03 13:29:36', null, null);
INSERT INTO `sys_log` VALUES ('1396', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '202.110.241.78', 'admin', '2018-11-03 13:29:36', null, null);
INSERT INTO `sys_log` VALUES ('1397', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '202.110.241.78', 'admin', '2018-11-03 13:29:38', null, null);
INSERT INTO `sys_log` VALUES ('1398', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '34', '202.110.241.78', 'admin', '2018-11-03 13:30:53', null, null);
INSERT INTO `sys_log` VALUES ('1399', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '202.110.241.78', 'admin', '2018-11-03 13:31:02', null, null);
INSERT INTO `sys_log` VALUES ('1400', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '22', '222.222.242.152', 'admin', '2018-11-03 13:31:35', null, null);
INSERT INTO `sys_log` VALUES ('1401', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '222.222.242.152', 'admin', '2018-11-03 13:31:40', null, null);
INSERT INTO `sys_log` VALUES ('1402', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '222.222.242.152', 'admin', '2018-11-03 13:31:47', null, null);
INSERT INTO `sys_log` VALUES ('1403', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '30', '222.222.242.152', 'admin', '2018-11-03 13:31:53', null, null);
INSERT INTO `sys_log` VALUES ('1404', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '222.222.242.152', 'admin', '2018-11-03 13:31:56', null, null);
INSERT INTO `sys_log` VALUES ('1405', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '222.222.242.152', 'admin', '2018-11-03 13:31:58', null, null);
INSERT INTO `sys_log` VALUES ('1406', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '222.222.242.152', 'admin', '2018-11-03 13:44:18', null, null);
INSERT INTO `sys_log` VALUES ('1407', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '222.222.242.152', 'admin', '2018-11-03 13:45:11', null, null);
INSERT INTO `sys_log` VALUES ('1408', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '25', '222.222.242.152', 'admin', '2018-11-03 13:45:29', null, null);
INSERT INTO `sys_log` VALUES ('1409', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '38', '222.222.242.152', 'admin', '2018-11-03 13:46:17', null, null);
INSERT INTO `sys_log` VALUES ('1410', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '222.222.242.152', 'admin', '2018-11-03 14:38:11', null, null);
INSERT INTO `sys_log` VALUES ('1411', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '43', '116.7.218.63', 'admin', '2018-11-03 15:03:14', null, null);
INSERT INTO `sys_log` VALUES ('1412', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDeptServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541228636281,\"id\":0,\"name\":\"1\",\"orderNum\":4,\"parentName\":\"顶级菜单\"}', '86', '116.7.218.63', 'admin', '2018-11-03 15:03:56', null, null);
INSERT INTO `sys_log` VALUES ('1413', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '116.7.218.63', 'admin', '2018-11-03 15:05:52', null, null);
INSERT INTO `sys_log` VALUES ('1414', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findById()', '0', '11', '116.7.218.63', 'admin', '2018-11-03 15:06:01', null, null);
INSERT INTO `sys_log` VALUES ('1415', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541228760548,\"id\":0,\"name\":\"啊\",\"remark\":\"啊\"}', '5', '116.7.218.63', 'admin', '2018-11-03 15:06:01', null, null);
INSERT INTO `sys_log` VALUES ('1416', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '116.7.218.63', 'admin', '2018-11-03 15:06:01', null, null);
INSERT INTO `sys_log` VALUES ('1417', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '28', '36.17.45.128', 'admin', '2018-11-03 15:17:06', null, null);
INSERT INTO `sys_log` VALUES ('1418', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '26', '36.17.45.128', 'admin', '2018-11-03 15:17:08', null, null);
INSERT INTO `sys_log` VALUES ('1419', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '120.85.77.69', 'admin', '2018-11-03 16:16:13', null, null);
INSERT INTO `sys_log` VALUES ('1420', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '52', '120.85.77.69', 'admin', '2018-11-03 16:16:15', null, null);
INSERT INTO `sys_log` VALUES ('1421', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '35', '115.205.91.160', 'admin', '2018-11-03 16:42:59', null, null);
INSERT INTO `sys_log` VALUES ('1422', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '50', '115.205.91.160', 'admin', '2018-11-03 16:43:01', null, null);
INSERT INTO `sys_log` VALUES ('1423', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '21', '115.205.91.160', 'admin', '2018-11-03 16:43:02', null, null);
INSERT INTO `sys_log` VALUES ('1424', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '115.205.91.160', 'admin', '2018-11-03 16:43:10', null, null);
INSERT INTO `sys_log` VALUES ('1425', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '115.205.91.160', 'admin', '2018-11-03 16:43:33', null, null);
INSERT INTO `sys_log` VALUES ('1426', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '115.205.91.160', 'admin', '2018-11-03 16:43:34', null, null);
INSERT INTO `sys_log` VALUES ('1427', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '112.255.84.8', 'admin', '2018-11-03 16:46:42', null, null);
INSERT INTO `sys_log` VALUES ('1428', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.255.84.8', 'admin', '2018-11-03 16:47:35', null, null);
INSERT INTO `sys_log` VALUES ('1429', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '112.94.161.92', 'admin', '2018-11-03 16:59:28', null, null);
INSERT INTO `sys_log` VALUES ('1430', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '112.94.161.92', 'admin', '2018-11-03 16:59:32', null, null);
INSERT INTO `sys_log` VALUES ('1431', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '112.94.161.92', 'admin', '2018-11-03 16:59:35', null, null);
INSERT INTO `sys_log` VALUES ('1432', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '112.94.161.92', 'admin', '2018-11-03 17:00:02', null, null);
INSERT INTO `sys_log` VALUES ('1433', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '112.94.161.92', 'admin', '2018-11-03 17:00:11', null, null);
INSERT INTO `sys_log` VALUES ('1434', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '112.94.161.92', 'admin', '2018-11-03 17:00:13', null, null);
INSERT INTO `sys_log` VALUES ('1435', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '112.94.161.92', 'admin', '2018-11-03 17:00:56', null, null);
INSERT INTO `sys_log` VALUES ('1436', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '112.94.161.92', 'admin', '2018-11-03 17:00:58', null, null);
INSERT INTO `sys_log` VALUES ('1437', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '43', '58.240.254.2', 'admin', '2018-11-03 17:07:52', null, null);
INSERT INTO `sys_log` VALUES ('1438', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '58.240.254.2', 'admin', '2018-11-03 17:07:56', null, null);
INSERT INTO `sys_log` VALUES ('1439', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '58.240.254.2', 'admin', '2018-11-03 17:08:23', null, null);
INSERT INTO `sys_log` VALUES ('1440', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '58.240.254.2', 'admin', '2018-11-03 17:08:55', null, null);
INSERT INTO `sys_log` VALUES ('1441', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '112.65.12.226', 'admin', '2018-11-03 17:12:52', null, null);
INSERT INTO `sys_log` VALUES ('1442', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '112.65.12.226', 'admin', '2018-11-03 17:13:22', null, null);
INSERT INTO `sys_log` VALUES ('1443', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '25', '112.65.12.226', 'admin', '2018-11-03 17:13:23', null, null);
INSERT INTO `sys_log` VALUES ('1444', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '112.65.12.226', 'admin', '2018-11-03 17:13:27', null, null);
INSERT INTO `sys_log` VALUES ('1445', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '8', '112.65.12.226', 'admin', '2018-11-03 17:13:42', null, null);
INSERT INTO `sys_log` VALUES ('1446', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '112.65.12.226', 'admin', '2018-11-03 17:13:44', null, null);
INSERT INTO `sys_log` VALUES ('1447', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '14', '112.65.12.226', 'admin', '2018-11-03 17:13:46', null, null);
INSERT INTO `sys_log` VALUES ('1448', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '112.65.12.226', 'admin', '2018-11-03 17:13:54', null, null);
INSERT INTO `sys_log` VALUES ('1449', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.65.12.226', 'admin', '2018-11-03 17:15:32', null, null);
INSERT INTO `sys_log` VALUES ('1450', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '28', '112.65.12.226', 'admin', '2018-11-03 17:21:15', null, null);
INSERT INTO `sys_log` VALUES ('1451', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '22', '112.65.12.226', 'admin', '2018-11-03 17:21:19', null, null);
INSERT INTO `sys_log` VALUES ('1452', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '22', '112.65.12.226', 'admin', '2018-11-03 17:21:21', null, null);
INSERT INTO `sys_log` VALUES ('1453', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.65.12.226', 'admin', '2018-11-03 17:27:15', null, null);
INSERT INTO `sys_log` VALUES ('1454', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '112.65.12.226', 'admin', '2018-11-03 17:28:07', null, null);
INSERT INTO `sys_log` VALUES ('1455', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '112.65.12.226', 'admin', '2018-11-03 17:34:54', null, null);
INSERT INTO `sys_log` VALUES ('1456', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '35', '112.65.12.226', 'admin', '2018-11-03 17:35:07', null, null);
INSERT INTO `sys_log` VALUES ('1457', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '29', '112.65.12.226', 'admin', '2018-11-03 17:41:23', null, null);
INSERT INTO `sys_log` VALUES ('1458', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.65.12.226', 'admin', '2018-11-03 17:41:26', null, null);
INSERT INTO `sys_log` VALUES ('1459', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '112.65.12.226', 'admin', '2018-11-03 17:41:28', null, null);
INSERT INTO `sys_log` VALUES ('1460', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '112.65.12.226', 'admin', '2018-11-03 17:44:25', null, null);
INSERT INTO `sys_log` VALUES ('1461', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '112.65.12.226', 'admin', '2018-11-03 17:44:26', null, null);
INSERT INTO `sys_log` VALUES ('1462', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '22', '112.65.12.226', 'admin', '2018-11-03 17:44:30', null, null);
INSERT INTO `sys_log` VALUES ('1463', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.65.12.226', 'admin', '2018-11-03 17:44:33', null, null);
INSERT INTO `sys_log` VALUES ('1464', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '112.65.12.226', 'admin', '2018-11-03 17:44:36', null, null);
INSERT INTO `sys_log` VALUES ('1465', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.65.12.226', 'admin', '2018-11-03 17:44:39', null, null);
INSERT INTO `sys_log` VALUES ('1466', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '112.65.12.226', 'admin', '2018-11-03 17:44:43', null, null);
INSERT INTO `sys_log` VALUES ('1467', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '112.65.12.226', 'admin', '2018-11-03 17:44:43', null, null);
INSERT INTO `sys_log` VALUES ('1468', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '112.65.12.226', 'admin', '2018-11-03 17:44:44', null, null);
INSERT INTO `sys_log` VALUES ('1469', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '36', '123.118.214.92', 'admin', '2018-11-03 18:02:30', null, null);
INSERT INTO `sys_log` VALUES ('1470', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '123.118.214.92', 'admin', '2018-11-03 18:02:33', null, null);
INSERT INTO `sys_log` VALUES ('1471', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '123.118.214.92', 'admin', '2018-11-03 18:02:44', null, null);
INSERT INTO `sys_log` VALUES ('1472', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '123.118.214.92', 'admin', '2018-11-03 18:02:50', null, null);
INSERT INTO `sys_log` VALUES ('1473', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '123.118.214.92', 'admin', '2018-11-03 18:04:00', null, null);
INSERT INTO `sys_log` VALUES ('1474', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '111.197.3.193', 'admin', '2018-11-03 18:46:54', null, null);
INSERT INTO `sys_log` VALUES ('1475', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '111.197.3.193', 'admin', '2018-11-03 18:47:00', null, null);
INSERT INTO `sys_log` VALUES ('1476', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '111.197.3.193', 'admin', '2018-11-03 18:47:34', null, null);
INSERT INTO `sys_log` VALUES ('1477', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '28', '121.34.51.154', 'admin', '2018-11-03 19:30:59', null, null);
INSERT INTO `sys_log` VALUES ('1478', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '121.34.51.154', 'admin', '2018-11-03 19:32:11', null, null);
INSERT INTO `sys_log` VALUES ('1479', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '211.161.240.113', 'admin', '2018-11-03 19:32:44', null, null);
INSERT INTO `sys_log` VALUES ('1480', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '28', '211.161.240.113', 'admin', '2018-11-03 19:32:52', null, null);
INSERT INTO `sys_log` VALUES ('1481', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '211.161.240.113', 'admin', '2018-11-03 19:32:52', null, null);
INSERT INTO `sys_log` VALUES ('1482', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDeptServiceImpl.delete()', '[{\"id\":20},{\"id\":24},{\"id\":36},{\"id\":28},{\"id\":31},{\"id\":32}]', '26', '211.161.240.113', 'admin', '2018-11-03 19:33:04', null, null);
INSERT INTO `sys_log` VALUES ('1483', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '211.161.240.113', 'admin', '2018-11-03 19:33:08', null, null);
INSERT INTO `sys_log` VALUES ('1484', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '211.161.240.113', 'admin', '2018-11-03 19:33:29', null, null);
INSERT INTO `sys_log` VALUES ('1485', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '211.161.240.113', 'admin', '2018-11-03 19:33:34', null, null);
INSERT INTO `sys_log` VALUES ('1486', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '223.167.21.83', 'admin', '2018-11-03 20:22:11', null, null);
INSERT INTO `sys_log` VALUES ('1487', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '223.167.21.83', 'admin', '2018-11-03 20:22:32', null, null);
INSERT INTO `sys_log` VALUES ('1488', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '223.167.21.83', 'admin', '2018-11-03 20:22:39', null, null);
INSERT INTO `sys_log` VALUES ('1489', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '223.167.21.83', 'admin', '2018-11-03 20:22:59', null, null);
INSERT INTO `sys_log` VALUES ('1490', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '125.82.187.164', 'admin', '2018-11-03 20:50:11', null, null);
INSERT INTO `sys_log` VALUES ('1491', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '125.82.187.164', 'admin', '2018-11-03 20:50:14', null, null);
INSERT INTO `sys_log` VALUES ('1492', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '33', '223.167.32.143', 'admin', '2018-11-03 21:34:45', null, null);
INSERT INTO `sys_log` VALUES ('1493', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '223.167.32.143', 'admin', '2018-11-03 21:37:10', null, null);
INSERT INTO `sys_log` VALUES ('1494', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '121.9.233.123', 'admin', '2018-11-03 21:38:11', null, null);
INSERT INTO `sys_log` VALUES ('1495', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '121.9.233.123', 'admin', '2018-11-03 21:38:15', null, null);
INSERT INTO `sys_log` VALUES ('1496', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '121.9.233.123', 'admin', '2018-11-03 21:38:38', null, null);
INSERT INTO `sys_log` VALUES ('1497', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '121.9.233.123', 'admin', '2018-11-03 21:38:44', null, null);
INSERT INTO `sys_log` VALUES ('1498', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '182.150.138.232', 'admin', '2018-11-03 22:01:43', null, null);
INSERT INTO `sys_log` VALUES ('1499', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '182.150.138.232', 'admin', '2018-11-03 22:01:51', null, null);
INSERT INTO `sys_log` VALUES ('1500', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '182.150.138.232', 'admin', '2018-11-03 22:01:57', null, null);
INSERT INTO `sys_log` VALUES ('1501', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '182.150.138.232', 'admin', '2018-11-03 22:01:59', null, null);
INSERT INTO `sys_log` VALUES ('1502', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '183.199.184.251', 'admin', '2018-11-03 22:03:24', null, null);
INSERT INTO `sys_log` VALUES ('1503', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '183.199.184.251', 'admin', '2018-11-03 22:03:27', null, null);
INSERT INTO `sys_log` VALUES ('1504', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '14', '183.199.184.251', 'admin', '2018-11-03 22:03:28', null, null);
INSERT INTO `sys_log` VALUES ('1505', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '31', '117.100.19.13', 'admin', '2018-11-03 22:47:44', null, null);
INSERT INTO `sys_log` VALUES ('1506', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '117.100.19.13', 'admin', '2018-11-03 22:47:56', null, null);
INSERT INTO `sys_log` VALUES ('1507', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '117.100.19.13', 'admin', '2018-11-03 22:48:16', null, null);
INSERT INTO `sys_log` VALUES ('1508', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '117.100.19.13', 'admin', '2018-11-03 22:48:19', null, null);
INSERT INTO `sys_log` VALUES ('1509', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '117.100.19.13', 'admin', '2018-11-03 22:48:28', null, null);
INSERT INTO `sys_log` VALUES ('1510', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '117.100.19.13', 'admin', '2018-11-03 22:48:53', null, null);
INSERT INTO `sys_log` VALUES ('1511', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '117.100.19.13', 'admin', '2018-11-03 22:49:38', null, null);
INSERT INTO `sys_log` VALUES ('1512', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '117.100.19.13', 'admin', '2018-11-03 22:49:55', null, null);
INSERT INTO `sys_log` VALUES ('1513', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '180.173.108.88', 'admin', '2018-11-03 22:51:53', null, null);
INSERT INTO `sys_log` VALUES ('1514', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-03 22:51:56', null, null);
INSERT INTO `sys_log` VALUES ('1515', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-03 22:51:59', null, null);
INSERT INTO `sys_log` VALUES ('1516', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '180.173.108.88', 'admin', '2018-11-03 22:52:03', null, null);
INSERT INTO `sys_log` VALUES ('1517', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-03 22:52:05', null, null);
INSERT INTO `sys_log` VALUES ('1518', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '180.173.108.88', 'admin', '2018-11-03 22:52:11', null, null);
INSERT INTO `sys_log` VALUES ('1519', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-03 22:52:15', null, null);
INSERT INTO `sys_log` VALUES ('1520', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '180.173.108.88', 'admin', '2018-11-03 22:53:41', null, null);
INSERT INTO `sys_log` VALUES ('1521', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '180.173.108.88', 'admin', '2018-11-03 22:53:44', null, null);
INSERT INTO `sys_log` VALUES ('1522', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '60.210.218.97', 'admin', '2018-11-03 23:00:49', null, null);
INSERT INTO `sys_log` VALUES ('1523', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '60.210.218.97', 'admin', '2018-11-03 23:01:16', null, null);
INSERT INTO `sys_log` VALUES ('1524', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '60.210.218.97', 'admin', '2018-11-03 23:01:16', null, null);
INSERT INTO `sys_log` VALUES ('1525', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '28', '0', '60.210.218.97', 'admin', '2018-11-03 23:01:30', null, null);
INSERT INTO `sys_log` VALUES ('1526', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1537703198000,\"delFlag\":0,\"deptId\":33,\"deptName\":\"魏国\",\"email\":\"test@qq.com\",\"id\":28,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541257289937,\"mobile\":\"13889700023\",\"name\"...', '42', '60.210.218.97', 'admin', '2018-11-03 23:01:30', null, null);
INSERT INTO `sys_log` VALUES ('1527', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '60.210.218.97', 'admin', '2018-11-03 23:01:30', null, null);
INSERT INTO `sys_log` VALUES ('1528', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '60.210.218.97', 'admin', '2018-11-03 23:02:10', null, null);
INSERT INTO `sys_log` VALUES ('1529', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '60.210.218.97', 'admin', '2018-11-03 23:02:42', null, null);
INSERT INTO `sys_log` VALUES ('1530', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '27', '222.161.99.32', 'admin', '2018-11-03 23:12:56', null, null);
INSERT INTO `sys_log` VALUES ('1531', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '222.161.99.32', 'admin', '2018-11-03 23:12:59', null, null);
INSERT INTO `sys_log` VALUES ('1532', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '222.161.99.32', 'admin', '2018-11-03 23:13:01', null, null);
INSERT INTO `sys_log` VALUES ('1533', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '117.136.85.177', 'admin', '2018-11-03 23:15:10', null, null);
INSERT INTO `sys_log` VALUES ('1534', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '117.136.85.177', 'admin', '2018-11-03 23:15:27', null, null);
INSERT INTO `sys_log` VALUES ('1535', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"刘备\"}},\"pageNum\":1,\"pageSize\":8}', '6', '117.136.85.177', 'admin', '2018-11-03 23:15:33', null, null);
INSERT INTO `sys_log` VALUES ('1536', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '117.136.85.177', 'admin', '2018-11-03 23:15:46', null, null);
INSERT INTO `sys_log` VALUES ('1537', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '117.136.85.177', 'admin', '2018-11-03 23:16:47', null, null);
INSERT INTO `sys_log` VALUES ('1538', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '117.136.85.177', 'admin', '2018-11-03 23:16:54', null, null);
INSERT INTO `sys_log` VALUES ('1539', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '117.136.85.177', 'admin', '2018-11-03 23:19:12', null, null);
INSERT INTO `sys_log` VALUES ('1540', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '117.136.85.177', 'admin', '2018-11-03 23:19:45', null, null);
INSERT INTO `sys_log` VALUES ('1541', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '117.136.85.177', 'admin', '2018-11-03 23:20:48', null, null);
INSERT INTO `sys_log` VALUES ('1542', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '121.237.191.26', 'admin', '2018-11-03 23:49:08', null, null);
INSERT INTO `sys_log` VALUES ('1543', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '121.237.191.26', 'admin', '2018-11-03 23:49:34', null, null);
INSERT INTO `sys_log` VALUES ('1544', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '121.237.191.26', 'admin', '2018-11-03 23:56:51', null, null);
INSERT INTO `sys_log` VALUES ('1545', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '121.237.191.26', 'admin', '2018-11-03 23:57:03', null, null);
INSERT INTO `sys_log` VALUES ('1546', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '121.237.191.26', 'admin', '2018-11-03 23:57:06', null, null);
INSERT INTO `sys_log` VALUES ('1547', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '28', '0', '121.237.191.26', 'admin', '2018-11-03 23:57:40', null, null);
INSERT INTO `sys_log` VALUES ('1548', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1537703198000,\"delFlag\":0,\"deptId\":33,\"deptName\":\"魏国\",\"email\":\"test@qq.com\",\"id\":28,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541260659993,\"mobile\":\"13889700023\",\"name\"...', '5', '121.237.191.26', 'admin', '2018-11-03 23:57:40', null, null);
INSERT INTO `sys_log` VALUES ('1549', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '33', '121.237.191.26', 'admin', '2018-11-03 23:57:40', null, null);
INSERT INTO `sys_log` VALUES ('1550', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '42.199.57.92', 'admin', '2018-11-04 00:09:59', null, null);
INSERT INTO `sys_log` VALUES ('1551', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '42.199.57.92', 'admin', '2018-11-04 00:10:03', null, null);
INSERT INTO `sys_log` VALUES ('1552', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '27.18.40.229', 'admin', '2018-11-04 00:15:47', null, null);
INSERT INTO `sys_log` VALUES ('1553', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '27.18.40.229', 'admin', '2018-11-04 00:15:58', null, null);
INSERT INTO `sys_log` VALUES ('1554', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '27.18.40.229', 'admin', '2018-11-04 00:16:02', null, null);
INSERT INTO `sys_log` VALUES ('1555', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '27.18.40.229', 'admin', '2018-11-04 00:16:07', null, null);
INSERT INTO `sys_log` VALUES ('1556', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '15', '112.45.241.93', 'admin', '2018-11-04 01:28:28', null, null);
INSERT INTO `sys_log` VALUES ('1557', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '8', '112.45.241.93', 'admin', '2018-11-04 01:28:34', null, null);
INSERT INTO `sys_log` VALUES ('1558', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '9', '119.84.225.241', 'admin', '2018-11-04 06:57:30', null, null);
INSERT INTO `sys_log` VALUES ('1559', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '117.136.72.17', 'admin', '2018-11-04 09:24:12', null, null);
INSERT INTO `sys_log` VALUES ('1560', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '117.136.72.17', 'admin', '2018-11-04 09:27:57', null, null);
INSERT INTO `sys_log` VALUES ('1561', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '117.136.72.17', 'admin', '2018-11-04 09:29:23', null, null);
INSERT INTO `sys_log` VALUES ('1562', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findById()', '0', '0', '117.136.72.17', 'admin', '2018-11-04 09:31:05', null, null);
INSERT INTO `sys_log` VALUES ('1563', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541295064592,\"id\":0,\"name\":\"asss\",\"remark\":\"ssss\"}', '3', '117.136.72.17', 'admin', '2018-11-04 09:31:05', null, null);
INSERT INTO `sys_log` VALUES ('1564', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '12', '117.136.72.17', 'admin', '2018-11-04 09:31:05', null, null);
INSERT INTO `sys_log` VALUES ('1565', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '34', '117.136.72.17', 'admin', '2018-11-04 09:39:50', null, null);
INSERT INTO `sys_log` VALUES ('1566', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '0', '1', '117.136.72.17', 'admin', '2018-11-04 09:40:33', null, null);
INSERT INTO `sys_log` VALUES ('1567', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541295633428,\"deptId\":25,\"deptName\":\"技术部\",\"email\":\"test@qq.com\",\"id\":0,\"mobile\":\"15823078376\",\"name\":\"hao\",\"password\":\"4b179c797c0c3515ed065dd4329f570128d67bc2fc17080...', '2', '117.136.72.17', 'admin', '2018-11-04 09:40:33', null, null);
INSERT INTO `sys_log` VALUES ('1568', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '117.136.72.17', 'admin', '2018-11-04 09:40:34', null, null);
INSERT INTO `sys_log` VALUES ('1569', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '20', '117.136.72.17', 'admin', '2018-11-04 09:41:26', null, null);
INSERT INTO `sys_log` VALUES ('1570', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '5', '117.136.72.17', 'admin', '2018-11-04 09:41:30', null, null);
INSERT INTO `sys_log` VALUES ('1571', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '33', '1', '117.136.72.17', 'admin', '2018-11-04 09:42:01', null, null);
INSERT INTO `sys_log` VALUES ('1572', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541295633000,\"delFlag\":0,\"deptId\":25,\"deptName\":\"技术部\",\"email\":\"test@qq.com\",\"id\":33,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541295721132,\"mobile\":\"15823078376\",\"name...', '9', '117.136.72.17', 'admin', '2018-11-04 09:42:01', null, null);
INSERT INTO `sys_log` VALUES ('1573', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '10', '117.136.72.17', 'admin', '2018-11-04 09:42:01', null, null);
INSERT INTO `sys_log` VALUES ('1574', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '3', '117.136.72.17', 'admin', '2018-11-04 09:42:11', null, null);
INSERT INTO `sys_log` VALUES ('1575', 'hao', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '17', '117.136.72.17', 'hao', '2018-11-04 09:42:56', null, null);
INSERT INTO `sys_log` VALUES ('1576', 'hao', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '117.136.72.17', 'hao', '2018-11-04 09:43:18', null, null);
INSERT INTO `sys_log` VALUES ('1577', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '106.41.33.236', 'admin', '2018-11-04 09:46:02', null, null);
INSERT INTO `sys_log` VALUES ('1578', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '119.84.225.241', 'admin', '2018-11-04 10:12:13', null, null);
INSERT INTO `sys_log` VALUES ('1579', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '119.84.225.241', 'admin', '2018-11-04 10:12:30', null, null);
INSERT INTO `sys_log` VALUES ('1580', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '13', '119.84.225.241', 'admin', '2018-11-04 10:12:30', null, null);
INSERT INTO `sys_log` VALUES ('1581', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '22', '1', '119.84.225.241', 'admin', '2018-11-04 10:12:45', null, null);
INSERT INTO `sys_log` VALUES ('1582', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1537702980000,\"delFlag\":0,\"deptId\":34,\"deptName\":\"蜀国\",\"email\":\"test@qq.com\",\"id\":22,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541297564966,\"mobile\":\"13889700023\",\"name\"...', '4', '119.84.225.241', 'admin', '2018-11-04 10:12:45', null, null);
INSERT INTO `sys_log` VALUES ('1583', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '119.84.225.241', 'admin', '2018-11-04 10:12:45', null, null);
INSERT INTO `sys_log` VALUES ('1584', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '219.144.130.207', 'admin', '2018-11-04 11:59:03', null, null);
INSERT INTO `sys_log` VALUES ('1585', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '219.144.130.207', 'admin', '2018-11-04 11:59:28', null, null);
INSERT INTO `sys_log` VALUES ('1586', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '2', '59.109.159.78', 'admin', '2018-11-04 12:15:02', null, null);
INSERT INTO `sys_log` VALUES ('1587', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"admin\"}},\"pageNum\":1,\"pageSize\":8}', '2', '59.109.159.78', 'admin', '2018-11-04 12:15:08', null, null);
INSERT INTO `sys_log` VALUES ('1588', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"dev\"}},\"pageNum\":1,\"pageSize\":8}', '1', '59.109.159.78', 'admin', '2018-11-04 12:15:12', null, null);
INSERT INTO `sys_log` VALUES ('1589', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"dev\"}},\"pageNum\":1,\"pageSize\":8}', '3', '59.109.159.78', 'admin', '2018-11-04 12:15:13', null, null);
INSERT INTO `sys_log` VALUES ('1590', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '59.109.159.78', 'admin', '2018-11-04 12:15:16', null, null);
INSERT INTO `sys_log` VALUES ('1591', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '281', '180.173.108.88', 'admin', '2018-11-04 12:20:54', null, null);
INSERT INTO `sys_log` VALUES ('1592', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '32', '180.173.108.88', 'admin', '2018-11-04 12:20:58', null, null);
INSERT INTO `sys_log` VALUES ('1593', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '81', '180.173.108.88', 'admin', '2018-11-04 12:21:28', null, null);
INSERT INTO `sys_log` VALUES ('1594', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '80', '180.173.108.88', 'admin', '2018-11-04 12:21:30', null, null);
INSERT INTO `sys_log` VALUES ('1595', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '33', '2', '180.173.108.88', 'admin', '2018-11-04 12:21:36', null, null);
INSERT INTO `sys_log` VALUES ('1596', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.delete()', '[{\"id\":33,\"userRoles\":[]}]', '6', '180.173.108.88', 'admin', '2018-11-04 12:21:36', null, null);
INSERT INTO `sys_log` VALUES ('1597', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDeptServiceImpl.delete()', '[{\"id\":38}]', '14', '180.173.108.88', 'admin', '2018-11-04 12:21:39', null, null);
INSERT INTO `sys_log` VALUES ('1598', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '180.173.108.88', 'admin', '2018-11-04 12:21:40', null, null);
INSERT INTO `sys_log` VALUES ('1599', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.delete()', '[{\"id\":9}]', '13', '180.173.108.88', 'admin', '2018-11-04 12:21:43', null, null);
INSERT INTO `sys_log` VALUES ('1600', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '180.173.108.88', 'admin', '2018-11-04 12:21:43', null, null);
INSERT INTO `sys_log` VALUES ('1601', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.delete()', '[{\"id\":10}]', '28', '180.173.108.88', 'admin', '2018-11-04 12:21:46', null, null);
INSERT INTO `sys_log` VALUES ('1602', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '16', '180.173.108.88', 'admin', '2018-11-04 12:21:46', null, null);
INSERT INTO `sys_log` VALUES ('1603', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.delete()', '[{\"id\":11}]', '8', '180.173.108.88', 'admin', '2018-11-04 12:21:49', null, null);
INSERT INTO `sys_log` VALUES ('1604', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '180.173.108.88', 'admin', '2018-11-04 12:21:49', null, null);
INSERT INTO `sys_log` VALUES ('1605', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.delete()', '[{\"id\":12}]', '10', '180.173.108.88', 'admin', '2018-11-04 12:21:51', null, null);
INSERT INTO `sys_log` VALUES ('1606', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '180.173.108.88', 'admin', '2018-11-04 12:21:51', null, null);
INSERT INTO `sys_log` VALUES ('1607', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '26', '180.173.108.88', 'admin', '2018-11-04 12:21:54', null, null);
INSERT INTO `sys_log` VALUES ('1608', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '76', '124.14.126.207', 'admin', '2018-11-04 12:45:31', null, null);
INSERT INTO `sys_log` VALUES ('1609', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '61', '59.48.148.178', 'admin', '2018-11-04 13:42:51', null, null);
INSERT INTO `sys_log` VALUES ('1610', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '59.48.148.178', 'admin', '2018-11-04 13:42:54', null, null);
INSERT INTO `sys_log` VALUES ('1611', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '59.48.148.178', 'admin', '2018-11-04 13:42:55', null, null);
INSERT INTO `sys_log` VALUES ('1612', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '34', '171.221.103.138', 'admin', '2018-11-04 13:56:36', null, null);
INSERT INTO `sys_log` VALUES ('1613', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '171.221.103.138', 'admin', '2018-11-04 13:56:39', null, null);
INSERT INTO `sys_log` VALUES ('1614', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '171.221.103.138', 'admin', '2018-11-04 13:56:41', null, null);
INSERT INTO `sys_log` VALUES ('1615', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '171.221.103.138', 'admin', '2018-11-04 13:56:43', null, null);
INSERT INTO `sys_log` VALUES ('1616', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '293', '180.173.108.88', 'admin', '2018-11-04 15:31:51', null, null);
INSERT INTO `sys_log` VALUES ('1617', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '61', '180.173.108.88', 'admin', '2018-11-04 15:32:01', null, null);
INSERT INTO `sys_log` VALUES ('1618', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '70', '180.173.108.88', 'admin', '2018-11-04 15:32:04', null, null);
INSERT INTO `sys_log` VALUES ('1619', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '25', '180.173.108.88', 'admin', '2018-11-04 15:32:09', null, null);
INSERT INTO `sys_log` VALUES ('1620', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '76', '180.173.108.88', 'admin', '2018-11-04 15:32:10', null, null);
INSERT INTO `sys_log` VALUES ('1621', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '95', '180.173.108.88', 'admin', '2018-11-04 15:32:55', null, null);
INSERT INTO `sys_log` VALUES ('1622', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '28', '2', '180.173.108.88', 'admin', '2018-11-04 15:33:17', null, null);
INSERT INTO `sys_log` VALUES ('1623', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1537703198000,\"delFlag\":0,\"deptId\":33,\"deptName\":\"魏国\",\"email\":\"test@qq.com\",\"id\":28,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541316797152,\"mobile\":\"13889700023\",\"name\"...', '49', '180.173.108.88', 'admin', '2018-11-04 15:33:17', null, null);
INSERT INTO `sys_log` VALUES ('1624', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '39', '180.173.108.88', 'admin', '2018-11-04 15:33:17', null, null);
INSERT INTO `sys_log` VALUES ('1625', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":2,\"pageSize\":8}', '33', '180.173.108.88', 'admin', '2018-11-04 15:33:20', null, null);
INSERT INTO `sys_log` VALUES ('1626', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '7', '180.173.108.88', 'admin', '2018-11-04 15:33:23', null, null);
INSERT INTO `sys_log` VALUES ('1627', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '58', '180.173.108.88', 'admin', '2018-11-04 15:33:28', null, null);
INSERT INTO `sys_log` VALUES ('1628', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '63', '180.173.108.88', 'admin', '2018-11-04 15:33:42', null, null);
INSERT INTO `sys_log` VALUES ('1629', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '28', '180.173.108.88', 'admin', '2018-11-04 15:33:43', null, null);
INSERT INTO `sys_log` VALUES ('1630', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1541316887760,\"icon\":\"\",\"id\":0,\"name\":\"收到\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"\",\"perms\":\"\",\"type\":1,\"url\":\"\"}', '57', '180.173.108.88', 'admin', '2018-11-04 15:34:48', null, null);
INSERT INTO `sys_log` VALUES ('1631', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '59', '180.173.108.88', 'admin', '2018-11-04 15:41:52', null, null);
INSERT INTO `sys_log` VALUES ('1632', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.delete()', '[{\"id\":42}]', '7', '180.173.108.88', 'admin', '2018-11-04 15:42:01', null, null);
INSERT INTO `sys_log` VALUES ('1633', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '61', '113.65.231.48', 'admin', '2018-11-04 15:50:31', null, null);
INSERT INTO `sys_log` VALUES ('1634', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '10', '113.65.231.48', 'admin', '2018-11-04 15:50:33', null, null);
INSERT INTO `sys_log` VALUES ('1635', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '6', '113.65.231.48', 'admin', '2018-11-04 15:50:39', null, null);
INSERT INTO `sys_log` VALUES ('1636', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '52', '221.218.174.250', 'admin', '2018-11-04 15:52:08', null, null);
INSERT INTO `sys_log` VALUES ('1637', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-tickets\",\"id\":35,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541322443258,\"level\":0,\"name\":\"接口文档\",\"orderNum\":1,\"parentId\":0,\"type\":1,\"url\":\"http://139.196.87.48...', '110', '180.173.108.88', 'admin', '2018-11-04 17:07:23', null, null);
INSERT INTO `sys_log` VALUES ('1638', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-info\",\"id\":6,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1541322455566,\"level\":0,\"name\":\"SQL监控\",\"orderNum\":2,\"parentId\":0,\"type\":1,\"url\":\"http://139.196.87.48:80...', '21', '180.173.108.88', 'admin', '2018-11-04 17:07:36', null, null);
INSERT INTO `sys_log` VALUES ('1639', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '18', '218.1.24.246', 'admin', '2018-11-15 14:38:16', null, null);
INSERT INTO `sys_log` VALUES ('1640', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1542263969827,\"icon\":\"\",\"id\":0,\"name\":\"代码生成\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"\",\"perms\":\"\",\"type\":1,\"url\":\"/generator/generator\"}', '8', '218.1.24.246', 'admin', '2018-11-15 14:39:30', null, null);
INSERT INTO `sys_log` VALUES ('1641', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-edit\",\"id\":29,\"level\":1,\"name\":\"国际化\",\"orderNum\":1,\"parentId\":28,\"parentName\":\"使用案例\",\"type\":1,\"url\":\"/demo/i18n\"},{\"children\":[],\"delFlag\":0,\"ico...', '107', '218.1.24.246', 'admin', '2018-11-15 14:39:43', null, null);
INSERT INTO `sys_log` VALUES ('1642', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\"el-icon-service\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1542263990943,\"level\":0,\"name\":\"服务治理\",\"orderNum\":5,\"pa...', '18', '218.1.24.246', 'admin', '2018-11-15 14:39:51', null, null);
INSERT INTO `sys_log` VALUES ('1643', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '275', '218.1.24.246', 'admin', '2018-11-15 14:54:47', null, null);
INSERT INTO `sys_log` VALUES ('1644', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '74', '218.1.24.246', 'admin', '2018-11-15 14:55:02', null, null);
INSERT INTO `sys_log` VALUES ('1645', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '25', '218.1.24.246', 'admin', '2018-11-15 14:55:04', null, null);
INSERT INTO `sys_log` VALUES ('1646', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '66', '218.1.24.246', 'admin', '2018-11-15 14:55:07', null, null);
INSERT INTO `sys_log` VALUES ('1647', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1542263970000,\"delFlag\":0,\"icon\":\"el-icon-star-on\",\"id\":42,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1542264918504,\"level\":0,\"name\":\"代码生成\",\"orderNum\":0,\"pa...', '31', '218.1.24.246', 'admin', '2018-11-15 14:55:19', null, null);
INSERT INTO `sys_log` VALUES ('1648', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1542263970000,\"delFlag\":0,\"icon\":\"el-icon-star-on\",\"id\":42,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1542264940807,\"level\":0,\"name\":\"代码生成\",\"orderNum\":4,\"pa...', '53', '218.1.24.246', 'admin', '2018-11-15 14:55:41', null, null);
INSERT INTO `sys_log` VALUES ('1649', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '31', '218.1.24.246', 'admin', '2018-11-15 14:55:53', null, null);
INSERT INTO `sys_log` VALUES ('1650', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\"el-icon-service\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1542264972010,\"level\":0,\"name\":\"服务治理\",\"orderNum\":4,\"pa...', '9', '218.1.24.246', 'admin', '2018-11-15 14:56:12', null, null);
INSERT INTO `sys_log` VALUES ('1651', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1542263970000,\"delFlag\":0,\"icon\":\"el-icon-star-on\",\"id\":42,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1542264977768,\"level\":0,\"name\":\"代码生成\",\"orderNum\":5,\"pa...', '10', '218.1.24.246', 'admin', '2018-11-15 14:56:18', null, null);
INSERT INTO `sys_log` VALUES ('1652', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '19', '61.133.217.141', 'admin', '2018-11-15 14:56:34', null, null);
INSERT INTO `sys_log` VALUES ('1653', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 10:57:02', null, null);
INSERT INTO `sys_log` VALUES ('1654', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 10:57:02', null, null);
INSERT INTO `sys_log` VALUES ('1655', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 10:57:04', null, null);
INSERT INTO `sys_log` VALUES ('1656', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '2', '183.17.127.107', 'admin', '2018-12-27 10:57:29', null, null);
INSERT INTO `sys_log` VALUES ('1657', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1545879448943,\"icon\":\"\",\"id\":0,\"name\":\"系统监控\",\"orderNum\":3,\"parentId\":0,\"parentName\":\"\",\"perms\":\"\",\"type\":0,\"url\":\"\"}', '3', '183.17.127.107', 'admin', '2018-12-27 10:57:29', null, null);
INSERT INTO `sys_log` VALUES ('1658', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 10:57:29', null, null);
INSERT INTO `sys_log` VALUES ('1659', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '5', '218.247.157.245', 'admin', '2018-12-27 10:58:45', null, null);
INSERT INTO `sys_log` VALUES ('1660', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '12', '183.17.127.107', 'admin', '2018-12-27 10:59:01', null, null);
INSERT INTO `sys_log` VALUES ('1661', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 10:59:01', null, null);
INSERT INTO `sys_log` VALUES ('1662', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 10:59:08', null, null);
INSERT INTO `sys_log` VALUES ('1663', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 10:59:29', null, null);
INSERT INTO `sys_log` VALUES ('1664', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1545879449000,\"delFlag\":0,\"icon\":\"el-icon-setting\",\"id\":43,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879568521,\"level\":0,\"name\":\"系统监控\",\"orderNum\":3,\"pa...', '5', '183.17.127.107', 'admin', '2018-12-27 10:59:29', null, null);
INSERT INTO `sys_log` VALUES ('1665', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 10:59:29', null, null);
INSERT INTO `sys_log` VALUES ('1666', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 10:59:38', null, null);
INSERT INTO `sys_log` VALUES ('1667', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1545879449000,\"delFlag\":0,\"icon\":\"el-icon-debug\",\"id\":43,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879577891,\"level\":0,\"name\":\"系统监控\",\"orderNum\":3,\"pare...', '6', '183.17.127.107', 'admin', '2018-12-27 10:59:38', null, null);
INSERT INTO `sys_log` VALUES ('1668', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 10:59:38', null, null);
INSERT INTO `sys_log` VALUES ('1669', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:00:10', null, null);
INSERT INTO `sys_log` VALUES ('1670', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1545879449000,\"delFlag\":0,\"icon\":\"el-icon-info\",\"id\":43,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879609709,\"level\":0,\"name\":\"系统监控\",\"orderNum\":3,\"paren...', '5', '183.17.127.107', 'admin', '2018-12-27 11:00:10', null, null);
INSERT INTO `sys_log` VALUES ('1671', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 11:00:10', null, null);
INSERT INTO `sys_log` VALUES ('1672', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '11', '218.247.157.245', 'admin', '2018-12-27 11:00:44', null, null);
INSERT INTO `sys_log` VALUES ('1673', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '218.247.157.245', 'admin', '2018-12-27 11:01:08', null, null);
INSERT INTO `sys_log` VALUES ('1674', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '1', '218.247.157.245', 'admin', '2018-12-27 11:01:29', null, null);
INSERT INTO `sys_log` VALUES ('1675', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:01:36', null, null);
INSERT INTO `sys_log` VALUES ('1676', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 11:01:36', null, null);
INSERT INTO `sys_log` VALUES ('1677', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:01:38', null, null);
INSERT INTO `sys_log` VALUES ('1678', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:01:45', null, null);
INSERT INTO `sys_log` VALUES ('1679', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-info\",\"id\":6,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879705213,\"level\":0,\"name\":\"数据监控\",\"orderNum\":2,\"parentId\":0,\"type\":1,\"url\":\"http://139.196.87.48:800...', '21', '183.17.127.107', 'admin', '2018-12-27 11:01:45', null, null);
INSERT INTO `sys_log` VALUES ('1680', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:01:45', null, null);
INSERT INTO `sys_log` VALUES ('1681', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:01:56', null, null);
INSERT INTO `sys_log` VALUES ('1682', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-info\",\"id\":6,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879715557,\"level\":0,\"name\":\"数据监控\",\"orderNum\":2,\"parentId\":43,\"parentName\":\"系统监控\",\"type\":1,\"url\":\"htt...', '3', '183.17.127.107', 'admin', '2018-12-27 11:01:56', null, null);
INSERT INTO `sys_log` VALUES ('1683', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:01:56', null, null);
INSERT INTO `sys_log` VALUES ('1684', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:02:08', null, null);
INSERT INTO `sys_log` VALUES ('1685', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541160135000,\"delFlag\":0,\"icon\":\"el-icon-view\",\"id\":38,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879727920,\"level\":0,\"name\":\"服务监控\",\"orderNum\":3,\"paren...', '4', '183.17.127.107', 'admin', '2018-12-27 11:02:08', null, null);
INSERT INTO `sys_log` VALUES ('1686', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:02:08', null, null);
INSERT INTO `sys_log` VALUES ('1687', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:02:26', null, null);
INSERT INTO `sys_log` VALUES ('1688', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-info\",\"id\":6,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879716000,\"level\":1,\"name\":\"数据监控\",\"orderNum\":2,\"parentId\":43,\"parentName\":\"系统监控\",\"type\"...', '5', '183.17.127.107', 'admin', '2018-12-27 11:02:26', null, null);
INSERT INTO `sys_log` VALUES ('1689', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:02:26', null, null);
INSERT INTO `sys_log` VALUES ('1690', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:02:52', null, null);
INSERT INTO `sys_log` VALUES ('1691', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-tickets\",\"id\":35,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879772355,\"level\":0,\"name\":\"接口文档\",\"orderNum\":3,\"parentId\":0,\"type\":1,\"url\":\"http://139.196.87.48...', '2', '183.17.127.107', 'admin', '2018-12-27 11:02:52', null, null);
INSERT INTO `sys_log` VALUES ('1692', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:02:52', null, null);
INSERT INTO `sys_log` VALUES ('1693', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:02', null, null);
INSERT INTO `sys_log` VALUES ('1694', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\"el-icon-service\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879781783,\"level\":0,\"name\":\"服务治理\",\"orderNum\":2,\"pa...', '21', '183.17.127.107', 'admin', '2018-12-27 11:03:02', null, null);
INSERT INTO `sys_log` VALUES ('1695', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:02', null, null);
INSERT INTO `sys_log` VALUES ('1696', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:35', null, null);
INSERT INTO `sys_log` VALUES ('1697', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-warning\",\"id\":6,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879814893,\"level\":1,\"name\":\"数据监控\",\"orderNum\":2,\"parentId\":43,\"parentName\":\"系统监控\",\"type\":1,\"url\":\"...', '5', '183.17.127.107', 'admin', '2018-12-27 11:03:35', null, null);
INSERT INTO `sys_log` VALUES ('1698', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:35', null, null);
INSERT INTO `sys_log` VALUES ('1699', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:45', null, null);
INSERT INTO `sys_log` VALUES ('1700', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-warning\",\"id\":6,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879825388,\"level\":1,\"name\":\"数据监控\",\"orderNum\":0,\"parentId\":43,\"parentName\":\"系统监控\",\"type\":1,\"url\":\"...', '5', '183.17.127.107', 'admin', '2018-12-27 11:03:45', null, null);
INSERT INTO `sys_log` VALUES ('1701', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:45', null, null);
INSERT INTO `sys_log` VALUES ('1702', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:53', null, null);
INSERT INTO `sys_log` VALUES ('1703', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541160135000,\"delFlag\":0,\"icon\":\"el-icon-view\",\"id\":38,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879832869,\"level\":1,\"name\":\"服务监控\",\"orderNum\":1,\"paren...', '4', '183.17.127.107', 'admin', '2018-12-27 11:03:53', null, null);
INSERT INTO `sys_log` VALUES ('1704', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:03:53', null, null);
INSERT INTO `sys_log` VALUES ('1705', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:04:18', null, null);
INSERT INTO `sys_log` VALUES ('1706', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"delFlag\":0,\"icon\":\"el-icon-document\",\"id\":35,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879857695,\"level\":0,\"name\":\"接口文档\",\"orderNum\":3,\"parentId\":0,\"type\":1,\"url\":\"http://139.196.87.4...', '4', '183.17.127.107', 'admin', '2018-12-27 11:04:18', null, null);
INSERT INTO `sys_log` VALUES ('1707', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:04:18', null, null);
INSERT INTO `sys_log` VALUES ('1708', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:12', null, null);
INSERT INTO `sys_log` VALUES ('1709', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":10}', '24', '183.17.127.107', 'admin', '2018-12-27 11:05:12', null, null);
INSERT INTO `sys_log` VALUES ('1710', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '83', '183.17.127.107', 'admin', '2018-12-27 11:05:12', null, null);
INSERT INTO `sys_log` VALUES ('1711', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 11:05:13', null, null);
INSERT INTO `sys_log` VALUES ('1712', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:13', null, null);
INSERT INTO `sys_log` VALUES ('1713', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:13', null, null);
INSERT INTO `sys_log` VALUES ('1714', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 11:05:14', null, null);
INSERT INTO `sys_log` VALUES ('1715', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":10}', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:14', null, null);
INSERT INTO `sys_log` VALUES ('1716', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:14', null, null);
INSERT INTO `sys_log` VALUES ('1717', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:15', null, null);
INSERT INTO `sys_log` VALUES ('1718', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:16', null, null);
INSERT INTO `sys_log` VALUES ('1719', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":10}', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:16', null, null);
INSERT INTO `sys_log` VALUES ('1720', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:16', null, null);
INSERT INTO `sys_log` VALUES ('1721', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:17', null, null);
INSERT INTO `sys_log` VALUES ('1722', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:34', null, null);
INSERT INTO `sys_log` VALUES ('1723', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\"el-icon-service\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879933825,\"level\":0,\"name\":\"注册中心\",\"orderNum\":2,\"pa...', '9', '183.17.127.107', 'admin', '2018-12-27 11:05:34', null, null);
INSERT INTO `sys_log` VALUES ('1724', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:34', null, null);
INSERT INTO `sys_log` VALUES ('1725', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:48', null, null);
INSERT INTO `sys_log` VALUES ('1726', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"createBy\":\"admin\",\"createTime\":1545879947863,\"icon\":\"\",\"id\":0,\"name\":\"服务治理\",\"orderNum\":2,\"parentId\":0,\"parentName\":\"\",\"perms\":\"\",\"type\":0,\"url\":\"\"}', '6', '183.17.127.107', 'admin', '2018-12-27 11:05:48', null, null);
INSERT INTO `sys_log` VALUES ('1727', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:05:48', null, null);
INSERT INTO `sys_log` VALUES ('1728', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:06:07', null, null);
INSERT INTO `sys_log` VALUES ('1729', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\"el-icon-service\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879967027,\"level\":0,\"name\":\"注册中心\",\"orderNum\":2,\"pa...', '3', '183.17.127.107', 'admin', '2018-12-27 11:06:07', null, null);
INSERT INTO `sys_log` VALUES ('1730', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:06:07', null, null);
INSERT INTO `sys_log` VALUES ('1731', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '0', '183.17.127.107', 'admin', '2018-12-27 11:06:39', null, null);
INSERT INTO `sys_log` VALUES ('1732', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\"el-icon-service\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545879967000,\"level\":1,\"name\":\"注册中心\",\"or...', '5', '183.17.127.107', 'admin', '2018-12-27 11:06:39', null, null);
INSERT INTO `sys_log` VALUES ('1733', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:06:39', null, null);
INSERT INTO `sys_log` VALUES ('1734', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:07:36', null, null);
INSERT INTO `sys_log` VALUES ('1735', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\" el-icon-view\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545880056283,\"level\":1,\"name\":\"注册中心\",\"orderNum\":2,\"pare...', '11', '183.17.127.107', 'admin', '2018-12-27 11:07:36', null, null);
INSERT INTO `sys_log` VALUES ('1736', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:07:36', null, null);
INSERT INTO `sys_log` VALUES ('1737', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:11', null, null);
INSERT INTO `sys_log` VALUES ('1738', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysMenuServiceImpl.save()', '{\"children\":[],\"createBy\":\"admin\",\"createTime\":1541214408000,\"delFlag\":0,\"icon\":\" el-icon-view\",\"id\":41,\"lastUpdateBy\":\"admin\",\"lastUpdateTime\":1545880091331,\"level\":1,\"name\":\"注册中心\",\"orderNum\":0,\"pare...', '3', '183.17.127.107', 'admin', '2018-12-27 11:08:11', null, null);
INSERT INTO `sys_log` VALUES ('1739', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:11', null, null);
INSERT INTO `sys_log` VALUES ('1740', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:40', null, null);
INSERT INTO `sys_log` VALUES ('1741', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:41', null, null);
INSERT INTO `sys_log` VALUES ('1742', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:57', null, null);
INSERT INTO `sys_log` VALUES ('1743', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":10}', '8', '183.17.127.107', 'admin', '2018-12-27 11:08:57', null, null);
INSERT INTO `sys_log` VALUES ('1744', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:57', null, null);
INSERT INTO `sys_log` VALUES ('1745', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:57', null, null);
INSERT INTO `sys_log` VALUES ('1746', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:58', null, null);
INSERT INTO `sys_log` VALUES ('1747', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:59', null, null);
INSERT INTO `sys_log` VALUES ('1748', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":10}', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:59', null, null);
INSERT INTO `sys_log` VALUES ('1749', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:59', null, null);
INSERT INTO `sys_log` VALUES ('1750', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:08:59', null, null);
INSERT INTO `sys_log` VALUES ('1751', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:09:00', null, null);
INSERT INTO `sys_log` VALUES ('1752', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":10}', '8', '183.17.127.107', 'admin', '2018-12-27 11:09:00', null, null);
INSERT INTO `sys_log` VALUES ('1753', 'admin', null, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findById()', '1', '1', '183.17.127.107', 'admin', '2018-12-27 11:09:01', null, null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', null, null, '0', 'el-icon-setting', '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '/sys/user', null, '1', 'el-icon-service', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('3', '机构管理', '1', '/sys/dept', null, '1', 'el-icon-news', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '1', '/sys/role', null, '1', 'el-icon-view', '4', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('5', '菜单管理', '1', '/sys/menu', null, '1', 'el-icon-menu', '5', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('6', '数据监控', '43', 'http://139.196.87.48:8001/druid/login.html', null, '1', 'el-icon-warning', '0', null, null, 'admin', '2018-12-27 11:03:45', '0');
INSERT INTO `sys_menu` VALUES ('7', '字典管理', '1', '/sys/dict', null, '1', 'el-icon-edit-outline', '7', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('8', '系统日志', '1', '/sys/log', 'sys:log:view', '1', 'el-icon-info', '8', null, null, 'admin', '2018-09-23 19:32:28', '0');
INSERT INTO `sys_menu` VALUES ('9', '查看', '2', null, 'sys:user:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('10', '新增', '2', null, 'sys:user:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('11', '修改', '2', null, 'sys:user:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('12', '删除', '2', null, 'sys:user:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('13', '查看', '3', null, 'sys:dept:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('14', '新增', '3', null, 'sys:dept:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('15', '修改', '3', null, 'sys:dept:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('16', '删除', '3', null, 'sys:dept:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('17', '查看', '4', null, 'sys:role:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('18', '新增', '4', null, 'sys:role:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('19', '修改', '4', null, 'sys:role:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('20', '删除', '4', null, 'sys:role:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('21', '查看', '5', null, 'sys:menu:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('22', '新增', '5', null, 'sys:menu:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('23', '修改', '5', null, 'sys:menu:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('24', '删除', '5', null, 'sys:menu:delete', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('28', '使用案例', '0', null, null, '0', 'el-icon-picture-outline', '6', null, null, 'admin', '2018-11-15 14:39:43', '0');
INSERT INTO `sys_menu` VALUES ('29', '国际化', '28', '/demo/i18n', null, '1', 'el-icon-edit', '1', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('30', '换皮肤', '28', '/demo/theme', null, '1', 'el-icon-picture', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('31', '查看', '7', null, 'sys:dict:view', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('32', '新增', '7', null, 'sys:dict:add', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('33', '修改', '7', null, 'sys:dict:edit', '2', null, '0', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('34', '删除', '7', null, 'sys:dict:delete', '2', null, '0', null, null, null, null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色管理';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', 'admin', '2018-08-14 11:11:11', 'admin', '2018-09-23 19:07:18', '0');
INSERT INTO `sys_role` VALUES ('2', 'dev', '开发人员', 'admin', '2018-08-14 11:11:11', 'admin', '2018-08-14 11:11:11', '0');
INSERT INTO `sys_role` VALUES ('3', 'test', '测试人员', 'admin', '2018-08-14 11:11:11', 'admin', '2018-08-14 11:11:11', '0');
INSERT INTO `sys_role` VALUES ('8', 'mng', '部门经理', 'admin', '2018-09-23 19:09:52', null, null, '0');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色机构';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=445 DEFAULT CHARSET=utf8 COMMENT='角色菜单';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('224', '4', '1', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('225', '4', '2', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('226', '4', '9', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('227', '4', '3', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('228', '4', '13', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('229', '4', '4', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('230', '4', '17', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('231', '4', '5', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('232', '4', '21', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('233', '4', '6', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('234', '4', '7', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('235', '4', '31', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('236', '4', '8', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('237', '4', '25', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('238', '4', '26', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('239', '4', '27', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('240', '4', '28', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('241', '4', '29', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('242', '4', '30', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('243', '4', '35', 'admin', '2018-09-23 16:22:41', null, null);
INSERT INTO `sys_role_menu` VALUES ('388', '2', '1', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('389', '2', '2', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('390', '2', '9', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('391', '2', '3', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('392', '2', '13', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('393', '2', '17', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('394', '2', '5', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('395', '2', '21', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('396', '2', '7', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('397', '2', '31', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('398', '2', '8', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('399', '2', '6', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('400', '2', '35', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('401', '2', '28', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('402', '2', '29', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('403', '2', '30', 'admin', '2018-09-23 19:51:53', null, null);
INSERT INTO `sys_role_menu` VALUES ('404', '3', '1', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('405', '3', '2', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('406', '3', '9', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('407', '3', '3', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('408', '3', '13', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('409', '3', '8', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('410', '3', '6', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('411', '3', '28', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('412', '3', '29', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('413', '3', '30', 'admin', '2018-09-23 19:51:55', null, null);
INSERT INTO `sys_role_menu` VALUES ('431', '8', '1', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('432', '8', '2', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('433', '8', '9', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('434', '8', '3', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('435', '8', '13', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('436', '8', '4', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('437', '8', '17', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('438', '8', '5', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('439', '8', '21', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('440', '8', '7', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('441', '8', '31', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('442', '8', '8', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('443', '8', '6', 'admin', '2018-09-23 19:55:08', null, null);
INSERT INTO `sys_role_menu` VALUES ('444', '8', '35', 'admin', '2018-09-23 19:55:08', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(40) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='用户管理';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'bd1718f058d8a02468134432b8656a86', 'YzcmCZNvbXocrsz9dm8e', 'admin@qq.com', '13612345678', '1', '4', 'admin', '2018-08-14 11:11:11', 'admin', '2018-08-14 11:11:11', '0');
INSERT INTO `sys_user` VALUES ('22', '刘备', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '34', 'admin', '2018-09-23 19:43:00', 'admin', '2018-11-04 10:12:45', '0');
INSERT INTO `sys_user` VALUES ('23', '赵云', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '34', 'admin', '2018-09-23 19:43:44', 'admin', '2018-09-23 19:43:52', '0');
INSERT INTO `sys_user` VALUES ('24', '诸葛亮', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '34', 'admin', '2018-09-23 19:44:23', 'admin', '2018-09-23 19:44:29', '0');
INSERT INTO `sys_user` VALUES ('25', '曹操', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '33', 'admin', '2018-09-23 19:45:32', 'admin', '2018-09-23 19:45:37', '0');
INSERT INTO `sys_user` VALUES ('26', '典韦', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '33', 'admin', '2018-09-23 19:45:48', 'admin', '2018-09-23 19:45:57', '0');
INSERT INTO `sys_user` VALUES ('27', '夏侯惇', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '33', 'admin', '2018-09-23 19:46:09', 'admin', '2018-09-23 19:46:17', '0');
INSERT INTO `sys_user` VALUES ('28', '荀彧', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '33', 'admin', '2018-09-23 19:46:38', 'admin', '2018-11-04 15:33:17', '0');
INSERT INTO `sys_user` VALUES ('29', '孙权', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '35', 'admin', '2018-09-23 19:46:54', 'admin', '2018-09-23 19:47:03', '0');
INSERT INTO `sys_user` VALUES ('30', '周瑜', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '35', 'admin', '2018-09-23 19:47:28', 'admin', '2018-09-23 19:48:04', '0');
INSERT INTO `sys_user` VALUES ('31', '陆逊', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '35', 'admin', '2018-09-23 19:47:44', 'admin', '2018-09-23 19:47:58', '0');
INSERT INTO `sys_user` VALUES ('32', '黄盖', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '35', 'admin', '2018-09-23 19:48:38', 'admin', '2018-09-23 19:49:02', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('2', '2', '1', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('26', '5', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('33', '6', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('34', '4', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('35', '9', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('36', '10', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('37', '11', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('38', '12', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('39', '15', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('41', '16', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('42', '8', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('43', '7', '4', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('45', '18', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('46', '17', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('47', '3', '4', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('48', '21', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('50', '23', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('51', '24', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('52', '25', '8', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('53', '26', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('54', '27', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('56', '29', '8', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('57', '31', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('58', '30', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('59', '32', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('68', '33', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('69', '22', '8', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('70', '22', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('71', '28', '2', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', '1', 'ee02ead2c1e3a113f82accafaf878b69', '2018-12-27 23:08:41', null, null, 'admin', '2018-12-27 11:08:41');
INSERT INTO `sys_user_token` VALUES ('2', '17', '3d32077ccddb6eb2c4302feb93765cd0', '2018-09-24 05:11:17', null, null, null, '2018-09-23 17:11:17');
INSERT INTO `sys_user_token` VALUES ('3', '18', 'a939ac41fd309ca785485b4135b8baad', '2018-09-24 05:10:36', null, null, null, '2018-09-23 17:10:36');
INSERT INTO `sys_user_token` VALUES ('4', '33', '605dbcfa2277cbca3b2a124974816080', '2018-11-04 21:42:49', null, null, null, '2018-11-04 09:42:49');




-- ----------------------------
-- Table structure for loan_basis
-- ----------------------------
DROP TABLE IF EXISTS `loan_basis`;
CREATE TABLE `loan_basis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `guarantee_method` varchar(1000) DEFAULT NULL COMMENT '担保方式 逗号分隔 例如 保证,抵押,质押',
  `loan_type` bigint(20) DEFAULT NULL COMMENT '贷款类型: 0新增 1续贷',
  `application_matters` int(11) DEFAULT NULL COMMENT '申请事项：0 个人经营性贷款 1信用贷款 2 房屋按揭贷款 3个人消费类贷款',
  `borrower` varchar(50) DEFAULT NULL COMMENT '借款人',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借口人基础信息表';


-- ----------------------------
-- Table structure for related_personnel_information
-- ----------------------------
DROP TABLE IF EXISTS `related_personnel_information`;
CREATE TABLE `related_personnel_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `type` int(11) DEFAULT NULL COMMENT '类型（1、结款人）（2、抵押担保人）（3、抵押担保人） （4、保证担保人）（5、抵押担保人和保证担保人）',
  `age` int(2) DEFAULT NULL COMMENT '年龄',
  `sex` int(2) DEFAULT NULL COMMENT '性别 0男 1女',
  `identity_number` varchar(500) DEFAULT NULL COMMENT '身份证号码',
  `domicile` varchar(200) DEFAULT NULL COMMENT '户籍所在地',
  `current_home_address` varchar(200) DEFAULT NULL COMMENT '现居住地址',
  `contact_address` int(2) DEFAULT NULL COMMENT '常用通信地址 （0、现居住地址）（1、单位地址）（2、其他）',
  `local_residence_time` datetime DEFAULT NULL COMMENT '本地居住时间',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `contact_number` varchar(40) DEFAULT NULL COMMENT '联系电话',
  `qq` varchar(40) DEFAULT NULL COMMENT 'qq',
  `wechat` varchar(40) DEFAULT NULL COMMENT '微信号',
  `educational_level` int(2) DEFAULT NULL COMMENT '文化程度 （0、研究生及以上）（1、本科）（2、大专）（3、中专/高中）（4、初中）（5、其他）',
  `educational_level_value` varchar(40) DEFAULT NULL COMMENT '文化程度（5、其他）内容',
  `current_housing_source` int(2) DEFAULT NULL COMMENT '现住房来源（0、自有住房）（1、贷款自有）（2、单位宿舍）（3、与父母同住）（4、租赁）（5、其他）',
  `current_housing_source_value` varchar(30) DEFAULT NULL COMMENT '现住房来源（5、其他）值',
  `employer` varchar(30) DEFAULT NULL COMMENT '工作单位',
  `position` varchar(30) DEFAULT NULL COMMENT '职务',
  `unit_working_years` int(3) DEFAULT NULL COMMENT '单位工作年限',
  `company_name` varchar(30) DEFAULT NULL COMMENT '所投资或经营企业名称',
  `shareholding_ratio` varchar(30) DEFAULT NULL COMMENT '持股比例',
  `years_operation` int(3) DEFAULT NULL COMMENT '本行业和相近行业经营年限',
  `asset_situation` int(3) DEFAULT NULL COMMENT '资产情况（0、无）（1、有）',
  `asset_type` int(3) DEFAULT NULL COMMENT '资产类型（1、房屋）（2、土地）（3、汽车）（4、有价证券）（5、其他）',
  `marital_status` int(3) DEFAULT NULL COMMENT '婚姻状况（0、未婚）（1、已婚）（2、离异未婚）（3、丧偶未婚）（4、其他）',
  `original_spouse_name` varchar(30) DEFAULT NULL COMMENT '原配偶姓名',
  `divorce_method` int(2) DEFAULT NULL COMMENT '离婚方式 （1、协议离婚）（2、诉讼离婚）',
  `divorce_time` datetime DEFAULT NULL COMMENT '时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `couple_id` bigint(11) NOT NULL DEFAULT '0' COMMENT '配偶ID， 主加人 为0， 附加配偶 存储主加人ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='相关人员信息表';

-- ----------------------------
-- Table structure for household_income
-- ----------------------------
DROP TABLE IF EXISTS `household_income`;
CREATE TABLE `household_income` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `rpi_id` bigint(11) NOT NULL COMMENT '相关人表ID',
  `total_assets` decimal(10,2) DEFAULT NULL COMMENT '总资产',
  `total_revenue` decimal(10,2) DEFAULT NULL COMMENT '总收入',
  `applicant_annual_income` decimal(10,2) DEFAULT NULL COMMENT '申请人年薪金收入',
  `applicant_operating_income` decimal(10,2) DEFAULT NULL COMMENT '申请人年经营性收入',
  `applicant_other_income` decimal(10,2) DEFAULT NULL COMMENT '申请人其他收入',
  `spouse_annual_income` decimal(10,2) DEFAULT NULL COMMENT '申请人配偶年薪金收入',
  `spouse_operating_income` decimal(10,2) DEFAULT NULL COMMENT '申请人配偶年经营性收入',
  `spouse_other_income` decimal(10,2) DEFAULT NULL COMMENT '申请人配偶其他收入',
  `total_annual_expenditure` decimal(10,2) DEFAULT NULL COMMENT '家庭年总支出',
  `life_total_expenditure` decimal(10,2) DEFAULT NULL COMMENT '年日常生活总支出',
  `basic_life_total_expenditure` decimal(10,2) DEFAULT NULL COMMENT '年日常基本生活支出',
  `education_expenditure` decimal(10,2) DEFAULT NULL COMMENT '年子女教育支出',
  `temporary_expenditure` decimal(10,2) DEFAULT NULL COMMENT '年其他临时性支出',
  `debt_total_expenditure` decimal(10,2) DEFAULT NULL COMMENT '年债务性总支出',
  `annual_loan_expenditure` decimal(10,2) DEFAULT NULL COMMENT '申请人年还贷支出',
  `spouse_temporary_expenditure` decimal(10,2) DEFAULT NULL COMMENT '申请人配偶年还贷支出',
  `support_population` int(2) DEFAULT NULL COMMENT '家庭供养人口',
  `foreign_guarantee_lump_sum` decimal(10,2) DEFAULT NULL COMMENT '家庭对外担保总额',
  `total_liability` decimal(10,2) DEFAULT NULL COMMENT '家庭对外担保总额',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭收入信息表';


-- ----------------------------
-- Table structure asset_type_houses
-- ----------------------------
DROP TABLE IF EXISTS `asset_type_houses`;
CREATE TABLE `asset_type_houses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `property_certificate_number` varchar(50) DEFAULT NULL COMMENT '不动产权证号',
  `rpi_id` bigint(20) NOT NULL COMMENT '相关人员信息表id',
  `whether_ownership_certificates` int(2) DEFAULT NULL COMMENT '是否不动产权证（1、不动产权证）（2、非不动产权证）',
  `deed` varchar(50) DEFAULT NULL COMMENT '房产证号',
  `land_certificate` varchar(50) DEFAULT NULL COMMENT '土地证号',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `affiliation` varchar(50) DEFAULT NULL COMMENT '所属地',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `construction_area` varchar(20) DEFAULT NULL COMMENT '房屋建筑面积 单位㎡',
  `value` varchar(40) DEFAULT NULL COMMENT '价值',
  `financing_situation` int(2) DEFAULT NULL COMMENT '融资情况 （0、无抵押）（1、有抵押）',
  `whether_co_owner` int(2) DEFAULT NULL COMMENT '是否有共有人（0、否）（1、是）',
  `co_owner_name` varchar(40) DEFAULT NULL COMMENT '共有人姓名',
  `whether_lease` int(2) DEFAULT NULL COMMENT '是否有租赁（0、否）（1、是）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资产类型房屋信息表';


-- ----------------------------
-- Table structure asset_type_land
-- ----------------------------
DROP TABLE IF EXISTS `asset_type_land`;
CREATE TABLE `asset_type_land` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `land_certificate` varchar(50) DEFAULT NULL COMMENT '土地证号',
  `rpi_id` bigint(20) NOT NULL COMMENT '相关人员信息表id',
  `affiliation` varchar(50) DEFAULT NULL COMMENT '所属地',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `construction_area` varchar(20) DEFAULT NULL COMMENT '房屋建筑面积 单位㎡',
  `value` varchar(40) DEFAULT NULL COMMENT '价值',
  `financing_situation` int(2) DEFAULT NULL COMMENT '融资情况 （0、无抵押）（1、有抵押）',
  `whether_co_owner`  int(2) DEFAULT NULL COMMENT '是否有共有人（0、否）（1、是）',
  `co_owner_name` varchar(50) DEFAULT NULL COMMENT '共有人姓名',
  `whether_lease`  int(2) DEFAULT NULL COMMENT '是否有租赁（0、否）（1、是）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资产类型土地信息表';

-- ----------------------------
-- Table structure asset_type_car
-- ----------------------------
DROP TABLE IF EXISTS `asset_type_car`;
CREATE TABLE `asset_type_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `brand` varchar(50) DEFAULT NULL COMMENT '汽车品牌',
  `rpi_id` bigint(20) NOT NULL COMMENT '相关人员信息表id',
  `value` varchar(40) DEFAULT NULL COMMENT '价值',
  `number_plate` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `driving_license_number` varchar(80) DEFAULT NULL COMMENT '行驶证号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资产类型汽车信息表';


-- ----------------------------
-- Table structure asset_type_securities
-- ----------------------------
DROP TABLE IF EXISTS `asset_type_securities`;
CREATE TABLE `asset_type_securities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` int(2) DEFAULT NULL COMMENT '证券类型 （1、定期存单）（2、股权）（3、股金）',
  `rpi_id` bigint(20) NOT NULL COMMENT '相关人员信息表id',
  `value` varchar(40) DEFAULT NULL COMMENT '价值',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
   `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资产类型证券信息表';


-- ----------------------------
-- Table structure asset_type_other
-- ----------------------------
DROP TABLE IF EXISTS `asset_type_other`;
CREATE TABLE `asset_type_other` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `asset_name` varchar(40) DEFAULT NULL COMMENT '资产名称',
  `rpi_id` bigint(20) NOT NULL COMMENT '相关人员信息表id',
  `value` varchar(40) DEFAULT NULL COMMENT '价值',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
   `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资产类型其他信息表';


-- ----------------------------
-- Table structure pawn
-- ----------------------------
DROP TABLE IF EXISTS `pawn`;
CREATE TABLE `pawn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `mortgage_type` int(2) DEFAULT NULL COMMENT '抵押物类型 0房屋 1土地',
  `whether_ownership_certificates` int(2) DEFAULT NULL COMMENT '0房屋：是否不动产权证 0不动产权证 1非不动产权证',
  `property_certificate_number` varchar(50) DEFAULT NULL COMMENT '0房屋：不动产权证号',
  `building_area` varchar(20) DEFAULT NULL COMMENT '0房屋：房屋建筑面积㎡',
  `land_certificate_number` varchar(30) DEFAULT NULL COMMENT '1土地：土地证号',
  `land_occupation_area` varchar(20) DEFAULT NULL COMMENT '1土地：土地占用面积㎡',
  `land_nature` int(2) DEFAULT NULL COMMENT '土地性质 1出让 2划拨',
  `collateral_name` varchar(30) DEFAULT NULL COMMENT '抵押物名称',
  `affiliation` varchar(50) DEFAULT NULL COMMENT '抵押物所属地',
  `collateral_deposit` varchar(40) DEFAULT NULL COMMENT '抵押物存放地',
  `evaluation_corporation` varchar(30) DEFAULT NULL COMMENT '评估公司',
  `value` varchar(40) DEFAULT NULL COMMENT '价值',
  `whether_coowner` int(2) DEFAULT NULL COMMENT '是否有共有人 0否 1是',
  `coowner_name` varchar(30) DEFAULT NULL COMMENT '共有人姓名',
  `whether_lease` int(2) DEFAULT NULL COMMENT '是否有租赁 0否 1是',
  `lease_contract_name` varchar(50) DEFAULT NULL COMMENT '租赁合同名称',
  `lessee_name` varchar(50) DEFAULT NULL COMMENT '承租方姓名',
  `lease_term_start_time` datetime DEFAULT NULL COMMENT '承租期限开始时间',
  `lease_term_end_time` datetime DEFAULT NULL COMMENT '承租期限截止时间',
  `rent_payment_method` int(2) DEFAULT NULL COMMENT '租金支付方式 1按月 2按季 3按半年 4按年',
  `contract_signing_time` datetime DEFAULT NULL COMMENT '合同签署时间',
  `name_assets_id` bigint(20) NOT NULL COMMENT '所属名下id',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抵押物信息表';


-- ----------------------------
-- Table structure name_assets
-- ----------------------------
DROP TABLE IF EXISTS `name_assets`;
CREATE TABLE `name_assets` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pawn_id` bigint(20) NOT NULL COMMENT '质押物信息表id',
  `assets_id` int(2) DEFAULT NULL COMMENT '名下资产id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='所属名下资产信息表';

-- ----------------------------
-- Table structure loan_business_information
-- ----------------------------
DROP TABLE IF EXISTS `loan_business_information`;
CREATE TABLE `loan_business_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `borrower_account` varchar(50) DEFAULT NULL COMMENT '借款人账号',
  `client_number` varchar(20) DEFAULT NULL COMMENT '客户号',
  `application_amount` decimal(10,6) DEFAULT NULL COMMENT '申请金额',
  `application_period` varchar(30) DEFAULT NULL COMMENT '申请期限 单位 年',
  `cycle_quota` int(2) DEFAULT NULL COMMENT '是否申请循环额度 0否 1是',
  `interest_rate` int(2) DEFAULT NULL COMMENT '利率 1浮动利率 2固定利率',
  `adjustment_method` int(2) DEFAULT NULL COMMENT '利率调整方式 1立即生效 2次年一月一日起生效 3对月对日生效',
  `interest_rate_rise` varchar(50) DEFAULT NULL COMMENT '利率上浮幅度%',
  `application_rate` varchar(40) DEFAULT NULL COMMENT '申请利率%',
  `margin_ratio` varchar(30) DEFAULT NULL COMMENT '保证金比例%',
  `original_credit_balance` varchar(40) DEFAULT NULL COMMENT '原信贷业务余额 元',
  `use` int(2) DEFAULT NULL COMMENT '用途 1经营 2自建房 3购房 4购车 5住房装修 6购买大额耐用消费品 7旅游消费 8留学 9子女教育 10其他',
  `description` varchar(1000) DEFAULT NULL COMMENT '用途具体说明',
  `repayment` int(2) DEFAULT NULL COMMENT '还款方式 1利随本清 2按月结息，到期一次性还本 3按月结息，分期还本 4按季结息，分期还本 5等额本金 6等额本息 7其他',
  `value` varchar(50) DEFAULT NULL COMMENT '其他 值',
  `repayment_period` int(2) DEFAULT NULL COMMENT '还款期数',
  `whether_personal_home_loan` int(2) DEFAULT NULL COMMENT '是否申请个人购房贷款 0否 1是',
  `whether_provident_fund_combination_loan` int(2) DEFAULT NULL COMMENT '是否公积金组合贷款 0否 1是',
  `provident_fund_loan_amount` decimal(10,6) DEFAULT NULL COMMENT '公积金贷款金额',
  `whether_exclusive_credit_client` int(2) DEFAULT NULL COMMENT '借款人是否为我行独家信贷客户 0否 1是',
  `deposit_account` varchar(40) DEFAULT NULL COMMENT '前在我行开立一般存款账户',
   `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷款业务信息表';


-- ----------------------------
-- Table structure counterparty_information
-- ----------------------------
DROP TABLE IF EXISTS `counterparty_information`;
CREATE TABLE `counterparty_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_business_information_id` bigint(20) NOT NULL COMMENT '贷款业务信息表id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `account_number` varchar(20) DEFAULT NULL COMMENT '账号',
  `bank` varchar(20) DEFAULT NULL COMMENT '开户行',
  `amount` decimal(10,6) DEFAULT NULL COMMENT '金额',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易对手信息表';

-- ----------------------------
-- Table structure repayment_plan
-- ----------------------------
DROP TABLE IF EXISTS `repayment_plan`;
CREATE TABLE `repayment_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_business_information_id` bigint(20) NOT NULL COMMENT '贷款业务信息表id',
  `repayment_time` datetime DEFAULT NULL COMMENT '还款时间',
  `amount` decimal(10,6) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款计划信息表';

-- ----------------------------
-- Table structure group_photo
-- ----------------------------
DROP TABLE IF EXISTS `group_photo`;
CREATE TABLE `group_photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `doc_meta_id` bigint(20) NOT NULL COMMENT '文件表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合影信息表';

-- ----------------------------
-- Table structure personal_loan_survey_report
-- ----------------------------
DROP TABLE IF EXISTS `personal_loan_survey_report`;
CREATE TABLE `personal_loan_survey_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `borrower_name` varchar(40) DEFAULT NULL COMMENT '借款人姓名',
  `marital_status` int(2) DEFAULT NULL COMMENT '婚姻状况 1已婚 0未婚',
  `spouse_name` varchar(40) DEFAULT NULL COMMENT '配偶姓名',
  `whether_local_household_registration` int(2) DEFAULT NULL COMMENT '是否本地户籍 1是 0否',
  `total_property` varchar(100) DEFAULT NULL COMMENT '家庭名下房产共计',
  `total_area` varchar(40) DEFAULT NULL COMMENT '总计面积 ㎡',
  `total_value` varchar(40) DEFAULT NULL COMMENT '总价值 万元',
  `total_property_remark` varchar(1000) DEFAULT NULL COMMENT '描述',
  `family_assets` varchar(40) DEFAULT NULL COMMENT '家庭资产 万元',
  `household_debt` varchar(40) DEFAULT NULL COMMENT '家庭负债 万元',
  `annual_household_income` varchar(40) DEFAULT NULL COMMENT '年家庭收入 万元',
  `family_expense` varchar(40) DEFAULT NULL COMMENT '家庭支出 元',
  `borrower_health_status` int(2) DEFAULT NULL COMMENT '借款人健康状况 1较差 2一般 3健康',
  `other_survey_happening` varchar(40) DEFAULT NULL COMMENT '其他需调查反映的情况',
  `borrower_whether_have_civil_action` int(2) DEFAULT NULL COMMENT '借款人是否具有完全民事行为能力 1是 0否',
  `amount_loan` varchar(40) DEFAULT NULL COMMENT '申贷金额 万元',
  `self_funding` varchar(40) DEFAULT NULL COMMENT '自筹资金 万元',
  `borrowing_period` varchar(40) DEFAULT NULL COMMENT '借款期限 年',
  `loan_amount_whether_reasonable` int(2) DEFAULT NULL COMMENT '申贷金额是否合理 1是 0否',
  `loan_term_whether_reasonable` int(2) DEFAULT NULL COMMENT '申贷期限是否合理 1是 0否',
  `use_loan` varchar(50) DEFAULT NULL COMMENT '借款用途',
  `repayment_source_whether_sufficient` int(2) DEFAULT NULL COMMENT '第一还款来源是否充足 1是 0否',
  `borrower_repay_ability_estimate` varchar(1000) DEFAULT NULL COMMENT '借款人偿还能力测算（公式）',
  `whether_amount_match` int(2) DEFAULT NULL COMMENT '贷款偿还能力是否与申请贷款额度相符 1是 0否',
  `without_debt_litigation` int(2) DEFAULT NULL COMMENT '有无债务诉讼 1有 0无',
  `borrower_conduct` int(2) DEFAULT NULL COMMENT '借款人品行 1优良 2较好 3一般 4较差',
  `borrower_credit` int(2) DEFAULT NULL COMMENT '借款人资信（含信用卡）情况 0无借款 1有借款，能按期还款无不良记录 2有逾期不良情况',
  `continuous_overdue` varchar(40) DEFAULT NULL COMMENT '连续逾期 单位 期',
  `cumulative_overdue` varchar(40) DEFAULT NULL COMMENT '累计逾期 单位 期',
  `current_overdue_amount` varchar(40) DEFAULT NULL COMMENT '当前逾期金额 单位 万元',
  `financial_mechanism_loan_balance` varchar(40) DEFAULT NULL COMMENT '金融机构借款余额 单位 万元',
  `credit_card_lump_sum` varchar(40) DEFAULT NULL COMMENT '信用卡授信总额 单位 万元',
  `used_quota` varchar(40) DEFAULT NULL COMMENT '已用额度 单位 万元',
  `external_guarantee_balance` varchar(40) DEFAULT NULL COMMENT '对外担保余额 单位 万元',
  `bad_loan_balance` varchar(40) DEFAULT NULL COMMENT '其中对外担保不良贷款余额 单位 万元',
  `loan_method_guarantee` int(1) DEFAULT '0' COMMENT '贷款方式为保证担保',
  `loan_method_guarantee_remark` text DEFAULT NULL COMMENT '贷款方式为保证担保描述',
  `calculated` int(2) DEFAULT NULL COMMENT '经测算，该保证人是否具有担保能力 1是 0否',
  `loan_method_pledge_guarantee` int(1) DEFAULT NULL COMMENT '贷款方式为抵（质）押担保',
  `loan_method_pledge_guarantee_remark` text DEFAULT NULL COMMENT '贷款方式为抵（质）押担保描述',
   `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人贷款调查报告信息表';


-- ----------------------------
-- Table structure contract_information
-- ----------------------------
DROP TABLE IF EXISTS `contract_information`;
CREATE TABLE `contract_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `personal_loan_contract_no` varchar(50) DEFAULT NULL COMMENT '个人借款合同编号',
  `mortgage_guarantee_contract_no` varchar(50) DEFAULT NULL COMMENT '抵押担保 合同编号',
  `pawn_contract_no` varchar(50) DEFAULT NULL COMMENT '抵押物清单合同编号',
  `guarantee_guarantee_contract_no` varchar(50) DEFAULT NULL COMMENT '保证担保合同编号',
  `contract_signing_date` datetime DEFAULT NULL COMMENT '合同签订日',
  `borrowing_start_period` datetime DEFAULT NULL COMMENT '借款开始期限',
  `borrowing_end_period` datetime DEFAULT NULL COMMENT '借款截止期限',
  `loan_date` datetime DEFAULT NULL COMMENT '放款日期',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同信息表';


-- ----------------------------
-- Table structure post_loan_check
-- ----------------------------
DROP TABLE IF EXISTS `post_loan_check`;
CREATE TABLE `post_loan_check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `check_time` datetime DEFAULT NULL COMMENT '检查时间',
  `borrower` varchar(50) DEFAULT NULL COMMENT '借款人',
  `loan_start_and_stop_date` varchar(200) DEFAULT NULL COMMENT '贷款起止日期',
  `loan_variety` varchar(50) DEFAULT NULL COMMENT '贷款品种',
  `loan_use` varchar(50) DEFAULT NULL COMMENT '借款用途',
  `loan_amount` decimal(10,6) DEFAULT NULL COMMENT '贷款金额 万元',
  `loan_balance` decimal(10,6) DEFAULT NULL COMMENT '贷款余额 万元',
  `guarantee_method` varchar(50) DEFAULT NULL COMMENT '担保方式',
  `payment_method_withdrawal` int DEFAULT NULL COMMENT '是否按约定的采取委托支付或自主支付方式提款 0否 1是',
  `contractual_agreement` int DEFAULT NULL COMMENT '资金支付交易对手是否符合合同约定 0否 1是',
  `intended_use` int DEFAULT NULL COMMENT ' 资金使用是否符合约定用途 0否 1是',
  `is_complete` int DEFAULT NULL COMMENT '贷款资料是否完整 0否 1是',
  `complete` int DEFAULT NULL COMMENT '抵（质押）登记或担保手续是否完备 0否 1是',
  `has_implemented` int DEFAULT NULL COMMENT '对照风险评价报告及审批意见书，审批（咨询）部门提出的限制性条款以及贷后管理要求是否已落实  0否 1是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
   `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷后检查信息表';

-- ----------------------------
-- Table structure implement_information
-- ----------------------------
DROP TABLE IF EXISTS `implement_information`;
CREATE TABLE `implement_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `post_loan_check_id` bigint(20) NOT NULL COMMENT '贷后检查信息表id',
  `check_time` datetime DEFAULT NULL COMMENT '检查时间',
  `unimplemented` varchar(80) DEFAULT NULL COMMENT '未落实',
  `reason` varchar(2000) DEFAULT NULL COMMENT '原因',
  `proposed_measures` varchar(200) DEFAULT NULL COMMENT '拟采取措施',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
   `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='落实信息表';

-- ----------------------------
-- Table structure collection_notice
-- ----------------------------
DROP TABLE IF EXISTS `collection_notice`;
CREATE TABLE `collection_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `check_time` datetime DEFAULT NULL COMMENT '检查时间',
  `borrower` varchar(50) DEFAULT NULL COMMENT '借款人',
  `personal_loan_contract_number` varchar(200) DEFAULT NULL COMMENT '个人借款合同编号',
  `borrowing_period` int(3) DEFAULT NULL COMMENT '借款期限 年',
  `loan_start_and_stop_date` varchar(200) DEFAULT NULL COMMENT '贷款起止日期',
  `owe_principal` decimal(10,6) DEFAULT NULL COMMENT '所欠本金元',
  `owe_interest` decimal(10,6) DEFAULT NULL COMMENT '所欠利息元',
  `fill_date` datetime DEFAULT NULL COMMENT '填写日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
   `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷款到期（逾期）催收通知书信息表';

-- ----------------------------
-- Table structure litigation_information
-- ----------------------------
DROP TABLE IF EXISTS `litigation_information`;
CREATE TABLE `litigation_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `loan_basis_id` bigint(20) NOT NULL COMMENT '基础信息表id',
  `check_time` datetime DEFAULT NULL COMMENT '检查时间',
  `borrower` varchar(50) DEFAULT NULL COMMENT '借款人',
  `personal_loan_contract_number` varchar(200) DEFAULT NULL COMMENT '个人借款合同编号',
  `borrowing_period` int(3) DEFAULT NULL COMMENT '借款期限 年',
  `loan_start_and_stop_date` varchar(200) DEFAULT NULL COMMENT '贷款起止日期',
  `loan_balance` decimal(10,6) DEFAULT NULL COMMENT '贷款余额元',
  `owe_interest` decimal(10,6) DEFAULT NULL COMMENT '所欠利息元',
  `litigation_time` datetime DEFAULT NULL COMMENT '诉讼时间',
  `litigation_type` int(1) DEFAULT NULL COMMENT '诉讼类型 0未到期 1已到期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
   `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='诉讼信息表';



