/*
Navicat MySQL Data Transfer

Source Server         : zc
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : qaplus

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2017-05-14 00:03:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_table
-- ----------------------------
DROP TABLE IF EXISTS `base_table`;
CREATE TABLE `base_table` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_table
-- ----------------------------

-- ----------------------------
-- Table structure for qa_attachment
-- ----------------------------
DROP TABLE IF EXISTS `qa_attachment`;
CREATE TABLE `qa_attachment` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `attachment_path` varchar(4000) default NULL COMMENT '附件路径',
  `attachment_name` varchar(4000) default NULL COMMENT '附件名字（唯一名字）',
  `attachment_real_name` varchar(4000) default NULL COMMENT '附件真实名称',
  `attachment_desc` varchar(4000) default NULL COMMENT '附件描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=248 DEFAULT CHARSET=utf8 COMMENT='附件';

-- ----------------------------
-- Records of qa_attachment
-- ----------------------------
INSERT INTO `qa_attachment` VALUES ('224', 'N', '2017-01-15 11:30:59', '2017-01-15 11:30:59', 'class12_teacher', 'class12_teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\class12_teacher_20170115113059_N0@(8F73UQ5%G[NP{ZN0M6X.jpg#', 'class12_teacher_20170115113059_N0@(8F73UQ5%G[NP{ZN0M6X.jpg#', 'N0@(8F73UQ5%G[NP{ZN0M6X.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('225', 'N', '2017-01-15 17:12:32', '2017-01-15 17:12:32', 'class1_user1', 'class1_user1', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\class1_user1_20170115171232_EM`UAAF%TB)V7OLUDBBV6VT.jpg#', 'class1_user1_20170115171232_EM`UAAF%TB)V7OLUDBBV6VT.jpg#', 'EM`UAAF%TB)V7OLUDBBV6VT.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('226', 'N', '2017-01-31 09:26:51', '2017-01-31 09:26:51', 'student1', 'student1', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\student1_20170131092651_1472567014849.jpg#', 'student1_20170131092651_1472567014849.jpg#', '1472567014849.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('227', 'N', '2017-01-31 09:35:15', '2017-01-31 09:35:15', 'teacher', 'teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\teacher_20170131093515_linux虚拟机.png#', 'teacher_20170131093515_linux虚拟机.png#', 'linux虚拟机.png#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('228', 'N', '2017-01-31 12:46:27', '2017-01-31 12:46:27', 'add_test', 'add_test', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\add_test_20170131124627_base_table.sql#', 'add_test_20170131124627_base_table.sql#', 'base_table.sql#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('229', 'N', '2017-01-31 12:49:20', '2017-01-31 12:49:20', 'add_test', 'add_test', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\add_test_20170131124920_base_table.sql#', 'add_test_20170131124920_base_table.sql#', 'base_table.sql#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('230', 'N', '2017-01-31 12:56:21', '2017-01-31 12:56:21', 'teacher', 'teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\teacher_20170131125621_a.jpg#', 'teacher_20170131125621_a.jpg#', 'a.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('231', 'N', '2017-01-31 12:56:25', '2017-01-31 12:56:25', 'teacher', 'teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\teacher_20170131125625_f.jpg#', 'teacher_20170131125625_f.jpg#', 'f.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('232', 'N', '2017-01-31 12:57:00', '2017-01-31 12:57:00', 'teacher', 'teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\teacher_20170131125700_毕业证.jpg#', 'teacher_20170131125700_毕业证.jpg#', '毕业证.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('233', 'N', '2017-01-31 12:57:02', '2017-01-31 12:57:02', 'teacher', 'teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\teacher_20170131125702_git.png#', 'teacher_20170131125702_git.png#', 'git.png#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('234', 'N', '2017-01-31 13:00:12', '2017-01-31 13:00:12', 'add_test', 'add_test', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\add_test_20170131130012_1472567014849.jpg#', 'add_test_20170131130012_1472567014849.jpg#', '1472567014849.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('235', 'N', '2017-02-03 19:51:12', '2017-02-03 19:51:12', 'teacher', 'teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\teacher_20170203195112_毕业证.jpg#', 'teacher_20170203195112_毕业证.jpg#', '毕业证.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('236', 'N', '2017-02-06 22:39:47', '2017-02-06 22:39:47', 'student1', 'student1', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\student1_20170206223947_20170204 (29).xlsx#', 'student1_20170206223947_20170204 (29).xlsx#', '20170204 (29).xlsx#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('237', 'N', '2017-02-06 22:41:31', '2017-02-06 22:41:31', 'student1', 'student1', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp6/wtpwebapps/qaplus/WEB-INF/classes/upload\\student1_20170206224131_年会现场.jpg#', 'student1_20170206224131_年会现场.jpg#', '年会现场.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('238', 'N', '2017-02-17 22:15:12', '2017-02-17 22:15:12', 'teacher', 'teacher', '/C:/zc/workspace/my/qaplus/target/classes/upload\\teacher_20170217221512_a.jpg#', 'teacher_20170217221512_a.jpg#', 'a.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('239', 'N', '2017-02-17 22:46:28', '2017-02-17 22:46:28', 'student1', 'student1', '/C:/zc/workspace/my/qaplus/target/classes/upload\\student1_20170217224628_1472567014849.jpg#', 'student1_20170217224628_1472567014849.jpg#', '1472567014849.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('240', 'N', '2017-02-18 15:46:32', '2017-02-18 15:46:32', 'student1', 'student1', '/C:/zc/workspace/my/qaplus/target/classes/upload\\student1_20170218154631_base_table.sql#', 'student1_20170218154631_base_table.sql#', 'base_table.sql#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('241', 'N', '2017-02-18 15:53:16', '2017-02-18 15:53:16', 'student1', 'student1', '/C:/zc/workspace/my/qaplus/target/classes/upload\\student1_20170218155316_年会现场.jpg#', 'student1_20170218155316_年会现场.jpg#', '年会现场.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('242', 'N', '2017-03-04 12:28:35', '2017-03-04 12:28:35', 'student1', 'student1', '/C:/zc/workspace/my/qaplus/target/classes/upload\\student1_20170304122835_N0@(8F73UQ5%G[NP{ZN0M6X.jpg#', 'student1_20170304122835_N0@(8F73UQ5%G[NP{ZN0M6X.jpg#', 'N0@(8F73UQ5%G[NP{ZN0M6X.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('243', 'N', '2017-03-04 12:39:35', '2017-03-04 12:39:35', 'student1', 'student1', '/C:/zc/workspace/my/qaplus/target/classes/upload\\student1_20170304123935_linux虚拟机.png#', 'student1_20170304123935_linux虚拟机.png#', 'linux虚拟机.png#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('244', 'N', '2017-03-05 14:53:32', '2017-03-05 14:53:32', 'student1', 'student1', '/C:/zc/workspace/my/qaplus/target/classes/upload\\student1_20170305145332_linux虚拟机.png#', 'student1_20170305145332_linux虚拟机.png#', 'linux虚拟机.png#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('245', 'N', '2017-03-05 14:58:30', '2017-03-05 14:58:30', 'student1', 'student1', '/C:/zc/workspace/my/qaplus/target/classes/upload\\student1_20170305145830_QQ图片20161216231515.jpg#', 'student1_20170305145830_QQ图片20161216231515.jpg#', 'QQ图片20161216231515.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('246', 'N', '2017-03-05 15:44:14', '2017-03-05 15:44:14', 'teacher', 'teacher', '/C:/zc/workspace/my/qaplus/target/classes/upload\\teacher_20170305154414_a.jpg#', 'teacher_20170305154414_a.jpg#', 'a.jpg#', 'STU_QUESTION_ATTACH');
INSERT INTO `qa_attachment` VALUES ('247', 'N', '2017-05-13 23:56:39', '2017-05-13 23:56:39', 'teacher', 'teacher', '/C:/zc/workspace/my/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/qaplus/WEB-INF/classes/upload\\teacher_20170513235639_EM`UAAF%TB)V7OLUDBBV6VT.jpg#', 'teacher_20170513235639_EM`UAAF%TB)V7OLUDBBV6VT.jpg#', 'EM`UAAF%TB)V7OLUDBBV6VT.jpg#', 'STU_QUESTION_ATTACH');

-- ----------------------------
-- Table structure for qa_board
-- ----------------------------
DROP TABLE IF EXISTS `qa_board`;
CREATE TABLE `qa_board` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `content` varchar(4000) default NULL COMMENT '公告内容',
  `important_flag` char(1) default NULL COMMENT '重要标识',
  `start_time` datetime default NULL COMMENT '开始时间',
  `end_time` datetime default NULL COMMENT '结束时间',
  `keep_top` int(4) unsigned zerofill default '0000' COMMENT '是否置顶',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='公告表';

-- ----------------------------
-- Records of qa_board
-- ----------------------------
INSERT INTO `qa_board` VALUES ('86', 'N', '2017-02-22 22:37:37', '2017-02-22 22:37:37', 'system', 'system', '热烈祝贺：  在【SystemOperatorLog】考试中，获得前三名的成绩，试卷总分：20，此次考试平均分：0', 'Y', '2017-02-22 22:37:37', '2017-02-25 22:37:37', '0008');

-- ----------------------------
-- Table structure for qa_board_user
-- ----------------------------
DROP TABLE IF EXISTS `qa_board_user`;
CREATE TABLE `qa_board_user` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `board_id` bigint(11) default NULL COMMENT '公告',
  `user_id` bigint(11) default NULL COMMENT '用户Id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8 COMMENT='公告-用户关系';

-- ----------------------------
-- Records of qa_board_user
-- ----------------------------
INSERT INTO `qa_board_user` VALUES ('7', 'N', '2017-01-15 21:44:21', '2017-01-15 21:44:21', 'class12_teacher', 'class12_teacher', '4', '4');
INSERT INTO `qa_board_user` VALUES ('8', 'N', '2017-01-15 21:44:21', '2017-01-15 21:44:21', 'class12_teacher', 'class12_teacher', '4', '1');
INSERT INTO `qa_board_user` VALUES ('9', 'N', '2017-01-15 21:51:13', '2017-01-15 21:51:13', 'class12_teacher', 'class12_teacher', '5', '4');
INSERT INTO `qa_board_user` VALUES ('10', 'N', '2017-01-15 21:51:13', '2017-01-15 21:51:13', 'class12_teacher', 'class12_teacher', '5', '1');
INSERT INTO `qa_board_user` VALUES ('11', 'N', '2017-01-15 22:25:27', '2017-01-15 22:25:27', 'system', 'system', '6', '1');
INSERT INTO `qa_board_user` VALUES ('12', 'N', '2017-01-20 22:13:26', '2017-01-20 22:13:26', 'system', 'system', '7', '1');
INSERT INTO `qa_board_user` VALUES ('13', 'N', '2017-01-21 16:10:40', '2017-01-21 16:10:40', 'system', 'system', '8', '1');
INSERT INTO `qa_board_user` VALUES ('14', 'N', '2017-01-21 16:11:30', '2017-01-21 16:11:30', 'system', 'system', '9', '1');
INSERT INTO `qa_board_user` VALUES ('15', 'N', '2017-01-21 16:48:36', '2017-01-21 16:48:36', 'system', 'system', '10', '1');
INSERT INTO `qa_board_user` VALUES ('16', 'N', '2017-01-31 14:11:01', '2017-01-31 14:11:01', 'teacher', 'teacher', '11', '1');
INSERT INTO `qa_board_user` VALUES ('17', 'N', '2017-01-31 14:11:01', '2017-01-31 14:11:01', 'teacher', 'teacher', '11', '6');
INSERT INTO `qa_board_user` VALUES ('18', 'N', '2017-01-31 14:11:01', '2017-01-31 14:11:01', 'teacher', 'teacher', '11', '7');
INSERT INTO `qa_board_user` VALUES ('19', 'N', '2017-01-31 14:20:13', '2017-01-31 14:20:13', 'teacher', 'teacher', '12', '1');
INSERT INTO `qa_board_user` VALUES ('20', 'N', '2017-01-31 14:22:53', '2017-01-31 14:22:53', 'teacher', 'teacher', '13', '1');
INSERT INTO `qa_board_user` VALUES ('21', 'N', '2017-01-31 14:22:53', '2017-01-31 14:22:53', 'teacher', 'teacher', '13', '6');
INSERT INTO `qa_board_user` VALUES ('22', 'N', '2017-01-31 14:33:22', '2017-01-31 14:33:22', 'teacher', 'teacher', '17', '7');
INSERT INTO `qa_board_user` VALUES ('23', 'N', '2017-01-31 16:00:56', '2017-01-31 16:00:56', 'teacher', 'teacher', '18', '7');
INSERT INTO `qa_board_user` VALUES ('24', 'N', '2017-01-31 16:00:56', '2017-01-31 16:00:56', 'teacher', 'teacher', '18', '1');
INSERT INTO `qa_board_user` VALUES ('25', 'N', '2017-01-31 16:00:56', '2017-01-31 16:00:56', 'teacher', 'teacher', '18', '6');
INSERT INTO `qa_board_user` VALUES ('26', 'N', '2017-01-31 19:56:23', '2017-01-31 19:56:23', 'system', 'system', '19', '7');
INSERT INTO `qa_board_user` VALUES ('27', 'N', '2017-01-31 19:56:23', '2017-01-31 19:56:23', 'system', 'system', '19', '1');
INSERT INTO `qa_board_user` VALUES ('28', 'N', '2017-01-31 19:56:23', '2017-01-31 19:56:23', 'system', 'system', '19', '6');
INSERT INTO `qa_board_user` VALUES ('29', 'N', '2017-02-01 18:41:45', '2017-02-01 18:41:45', 'system', 'system', '20', '7');
INSERT INTO `qa_board_user` VALUES ('30', 'N', '2017-02-01 19:09:38', '2017-02-01 19:09:38', 'teacher', 'teacher', '21', '1');
INSERT INTO `qa_board_user` VALUES ('31', 'N', '2017-02-01 19:09:38', '2017-02-01 19:09:38', 'teacher', 'teacher', '21', '6');
INSERT INTO `qa_board_user` VALUES ('32', 'N', '2017-02-01 19:35:01', '2017-02-01 19:35:01', 'system', 'system', '22', '1');
INSERT INTO `qa_board_user` VALUES ('33', 'N', '2017-02-01 19:35:01', '2017-02-01 19:35:01', 'system', 'system', '22', '6');
INSERT INTO `qa_board_user` VALUES ('34', 'N', '2017-02-01 19:45:34', '2017-02-01 19:45:34', 'teacher', 'teacher', '23', '1');
INSERT INTO `qa_board_user` VALUES ('35', 'N', '2017-02-01 19:45:34', '2017-02-01 19:45:34', 'teacher', 'teacher', '23', '6');
INSERT INTO `qa_board_user` VALUES ('36', 'N', '2017-02-01 20:20:46', '2017-02-01 20:20:46', 'system', 'system', '24', '1');
INSERT INTO `qa_board_user` VALUES ('37', 'N', '2017-02-01 20:20:46', '2017-02-01 20:20:46', 'system', 'system', '24', '6');
INSERT INTO `qa_board_user` VALUES ('38', 'N', '2017-02-02 08:56:40', '2017-02-02 08:56:40', 'teacher', 'teacher', '25', '1');
INSERT INTO `qa_board_user` VALUES ('39', 'N', '2017-02-02 08:56:58', '2017-02-02 08:56:58', 'teacher', 'teacher', '25', '6');
INSERT INTO `qa_board_user` VALUES ('40', 'N', '2017-02-02 09:25:30', '2017-02-02 09:25:30', 'system', 'system', '26', '1');
INSERT INTO `qa_board_user` VALUES ('41', 'N', '2017-02-02 09:25:30', '2017-02-02 09:25:30', 'system', 'system', '26', '6');
INSERT INTO `qa_board_user` VALUES ('42', 'N', '2017-02-03 09:00:42', '2017-02-03 09:00:42', 'teacher', 'teacher', '27', '1');
INSERT INTO `qa_board_user` VALUES ('43', 'N', '2017-02-03 09:00:42', '2017-02-03 09:00:42', 'teacher', 'teacher', '27', '6');
INSERT INTO `qa_board_user` VALUES ('44', 'N', '2017-02-03 09:15:02', '2017-02-03 09:15:02', 'system', 'system', '28', '1');
INSERT INTO `qa_board_user` VALUES ('45', 'N', '2017-02-03 09:15:02', '2017-02-03 09:15:02', 'system', 'system', '28', '6');
INSERT INTO `qa_board_user` VALUES ('46', 'N', '2017-02-03 09:29:12', '2017-02-03 09:29:12', 'teacher', 'teacher', '29', '1');
INSERT INTO `qa_board_user` VALUES ('47', 'N', '2017-02-03 09:29:12', '2017-02-03 09:29:12', 'teacher', 'teacher', '29', '6');
INSERT INTO `qa_board_user` VALUES ('48', 'N', '2017-02-03 09:52:01', '2017-02-03 09:52:01', 'teacher', 'teacher', '30', '1');
INSERT INTO `qa_board_user` VALUES ('49', 'N', '2017-02-03 09:52:01', '2017-02-03 09:52:01', 'teacher', 'teacher', '30', '6');
INSERT INTO `qa_board_user` VALUES ('50', 'N', '2017-02-03 10:00:46', '2017-02-03 10:00:46', 'system', 'system', '31', '1');
INSERT INTO `qa_board_user` VALUES ('51', 'N', '2017-02-03 10:00:46', '2017-02-03 10:00:46', 'system', 'system', '31', '6');
INSERT INTO `qa_board_user` VALUES ('52', 'N', '2017-02-03 19:33:30', '2017-02-03 19:33:30', 'teacher', 'teacher', '32', '1');
INSERT INTO `qa_board_user` VALUES ('53', 'N', '2017-02-03 19:33:30', '2017-02-03 19:33:30', 'teacher', 'teacher', '32', '6');
INSERT INTO `qa_board_user` VALUES ('54', 'N', '2017-02-03 19:36:25', '2017-02-03 19:36:25', 'teacher', 'teacher', '33', '1');
INSERT INTO `qa_board_user` VALUES ('55', 'N', '2017-02-03 19:36:25', '2017-02-03 19:36:25', 'teacher', 'teacher', '33', '6');
INSERT INTO `qa_board_user` VALUES ('56', 'N', '2017-02-03 19:37:00', '2017-02-03 19:37:00', 'teacher', 'teacher', '34', '1');
INSERT INTO `qa_board_user` VALUES ('57', 'N', '2017-02-03 19:37:00', '2017-02-03 19:37:00', 'teacher', 'teacher', '34', '6');
INSERT INTO `qa_board_user` VALUES ('58', 'N', '2017-02-03 19:38:47', '2017-02-03 19:38:47', 'teacher', 'teacher', '35', '1');
INSERT INTO `qa_board_user` VALUES ('59', 'N', '2017-02-03 19:38:51', '2017-02-03 19:38:51', 'teacher', 'teacher', '35', '6');
INSERT INTO `qa_board_user` VALUES ('60', 'N', '2017-02-03 19:40:24', '2017-02-03 19:40:24', 'teacher', 'teacher', '36', '1');
INSERT INTO `qa_board_user` VALUES ('61', 'N', '2017-02-03 19:40:24', '2017-02-03 19:40:24', 'teacher', 'teacher', '36', '6');
INSERT INTO `qa_board_user` VALUES ('62', 'N', '2017-02-03 19:49:24', '2017-02-03 19:49:24', 'teacher', 'teacher', '37', '1');
INSERT INTO `qa_board_user` VALUES ('63', 'N', '2017-02-03 19:49:24', '2017-02-03 19:49:24', 'teacher', 'teacher', '37', '6');
INSERT INTO `qa_board_user` VALUES ('64', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '38', '1');
INSERT INTO `qa_board_user` VALUES ('65', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '38', '6');
INSERT INTO `qa_board_user` VALUES ('66', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '39', '1');
INSERT INTO `qa_board_user` VALUES ('67', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '39', '6');
INSERT INTO `qa_board_user` VALUES ('68', 'N', '2017-02-04 08:38:12', '2017-02-04 08:38:12', 'system', 'system', '40', '1');
INSERT INTO `qa_board_user` VALUES ('69', 'N', '2017-02-04 08:38:12', '2017-02-04 08:38:12', 'system', 'system', '40', '6');
INSERT INTO `qa_board_user` VALUES ('70', 'N', '2017-02-04 08:38:12', '2017-02-04 08:38:12', 'system', 'system', '41', '1');
INSERT INTO `qa_board_user` VALUES ('71', 'N', '2017-02-04 08:38:12', '2017-02-04 08:38:12', 'system', 'system', '41', '6');
INSERT INTO `qa_board_user` VALUES ('72', 'N', '2017-02-04 14:15:40', '2017-02-04 14:15:40', 'system', 'system', '42', '1');
INSERT INTO `qa_board_user` VALUES ('73', 'N', '2017-02-04 14:15:40', '2017-02-04 14:15:40', 'system', 'system', '42', '6');
INSERT INTO `qa_board_user` VALUES ('74', 'N', '2017-02-04 14:17:16', '2017-02-04 14:17:16', 'teacher', 'teacher', '43', '1');
INSERT INTO `qa_board_user` VALUES ('75', 'N', '2017-02-04 14:17:16', '2017-02-04 14:17:16', 'teacher', 'teacher', '43', '6');
INSERT INTO `qa_board_user` VALUES ('76', 'N', '2017-02-06 22:02:29', '2017-02-06 22:02:29', 'system', 'system', '44', '1');
INSERT INTO `qa_board_user` VALUES ('77', 'N', '2017-02-06 22:02:29', '2017-02-06 22:02:29', 'system', 'system', '44', '6');
INSERT INTO `qa_board_user` VALUES ('78', 'N', '2017-02-19 18:41:50', '2017-02-19 18:41:50', 'teacher', 'teacher', '45', '1');
INSERT INTO `qa_board_user` VALUES ('79', 'N', '2017-02-19 18:41:50', '2017-02-19 18:41:50', 'teacher', 'teacher', '45', '6');
INSERT INTO `qa_board_user` VALUES ('80', 'N', '2017-02-19 18:41:50', '2017-02-19 18:41:50', 'teacher', 'teacher', '45', '8');
INSERT INTO `qa_board_user` VALUES ('81', 'N', '2017-02-19 19:10:36', '2017-02-19 19:10:36', 'system', 'system', '46', '1');
INSERT INTO `qa_board_user` VALUES ('82', 'N', '2017-02-19 19:10:36', '2017-02-19 19:10:36', 'system', 'system', '46', '6');
INSERT INTO `qa_board_user` VALUES ('83', 'N', '2017-02-19 19:10:36', '2017-02-19 19:10:36', 'system', 'system', '46', '8');
INSERT INTO `qa_board_user` VALUES ('84', 'N', '2017-02-19 21:07:35', '2017-02-19 21:07:35', 'teacher', 'teacher', '47', '1');
INSERT INTO `qa_board_user` VALUES ('85', 'N', '2017-02-19 21:07:35', '2017-02-19 21:07:35', 'teacher', 'teacher', '47', '6');
INSERT INTO `qa_board_user` VALUES ('86', 'N', '2017-02-19 21:07:35', '2017-02-19 21:07:35', 'teacher', 'teacher', '47', '8');
INSERT INTO `qa_board_user` VALUES ('87', 'N', '2017-02-19 21:35:08', '2017-02-19 21:35:08', 'system', 'system', '48', '1');
INSERT INTO `qa_board_user` VALUES ('88', 'N', '2017-02-19 21:35:08', '2017-02-19 21:35:08', 'system', 'system', '48', '6');
INSERT INTO `qa_board_user` VALUES ('89', 'N', '2017-02-19 21:35:08', '2017-02-19 21:35:08', 'system', 'system', '48', '8');
INSERT INTO `qa_board_user` VALUES ('96', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '51', '1');
INSERT INTO `qa_board_user` VALUES ('97', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '51', '6');
INSERT INTO `qa_board_user` VALUES ('98', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '51', '8');
INSERT INTO `qa_board_user` VALUES ('99', 'N', '2017-02-22 22:30:05', '2017-02-22 22:30:05', 'system', 'system', '52', '1');
INSERT INTO `qa_board_user` VALUES ('100', 'N', '2017-02-22 22:30:05', '2017-02-22 22:30:05', 'system', 'system', '52', '6');
INSERT INTO `qa_board_user` VALUES ('101', 'N', '2017-02-22 22:30:05', '2017-02-22 22:30:05', 'system', 'system', '52', '8');
INSERT INTO `qa_board_user` VALUES ('201', 'N', '2017-02-22 22:37:37', '2017-02-22 22:37:37', 'system', 'system', '86', '1');
INSERT INTO `qa_board_user` VALUES ('202', 'N', '2017-02-22 22:37:37', '2017-02-22 22:37:37', 'system', 'system', '86', '6');
INSERT INTO `qa_board_user` VALUES ('203', 'N', '2017-02-22 22:37:37', '2017-02-22 22:37:37', 'system', 'system', '86', '8');

-- ----------------------------
-- Table structure for qa_class
-- ----------------------------
DROP TABLE IF EXISTS `qa_class`;
CREATE TABLE `qa_class` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `name` varchar(40) default NULL COMMENT '班级名称',
  `person` int(3) default NULL COMMENT '班级人数',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='班级表';

-- ----------------------------
-- Records of qa_class
-- ----------------------------
INSERT INTO `qa_class` VALUES ('1', 'N', '2016-09-16 13:46:07', '2017-02-20 22:38:59', 'teacher', 'system', '三班11', '30');
INSERT INTO `qa_class` VALUES ('2', 'N', '2016-09-16 11:09:34', '2017-01-31 13:30:15', 'teacher', 'system', '三班22', '30');
INSERT INTO `qa_class` VALUES ('3', 'N', '2016-09-09 17:49:23', '2017-01-31 13:30:20', 'teacher', 'system', '三班33', '30');
INSERT INTO `qa_class` VALUES ('4', 'Y', '2017-02-22 21:30:10', '2017-02-22 21:36:31', 'teacher', 'teacher', '三班44', '30');

-- ----------------------------
-- Table structure for qa_exam_error_questions
-- ----------------------------
DROP TABLE IF EXISTS `qa_exam_error_questions`;
CREATE TABLE `qa_exam_error_questions` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `error_count` int(2) default NULL COMMENT '做错次数',
  `question_id` bigint(255) default NULL COMMENT '问题ID',
  `error_range` int(2) default NULL COMMENT '容错范围，错了几次',
  `stu_id` bigint(255) default NULL COMMENT '学生ID',
  `description` varchar(255) NOT NULL default '' COMMENT '描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qa_exam_error_questions
-- ----------------------------
INSERT INTO `qa_exam_error_questions` VALUES ('11', 'N', '2017-02-19 21:11:33', '2017-02-19 21:11:33', 'student1', 'student1', '0', '23', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('12', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '24', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('13', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '25', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('14', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '26', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('15', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '27', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('16', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '28', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('17', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '29', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('18', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '30', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('19', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '31', '1', '1', '');
INSERT INTO `qa_exam_error_questions` VALUES ('20', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '1', '32', '1', '1', '');

-- ----------------------------
-- Table structure for qa_exam_question
-- ----------------------------
DROP TABLE IF EXISTS `qa_exam_question`;
CREATE TABLE `qa_exam_question` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `title` varchar(4000) default NULL COMMENT '试题标题',
  `content` varchar(4000) default NULL COMMENT '试题内容',
  `type` varchar(255) default '' COMMENT '试题类型（单选、多选）',
  `score` int(2) default NULL COMMENT '分值（2分一个）',
  `diff_stage` varchar(20) default NULL COMMENT '难易程度（动态改变，根据错误率）',
  `question_person` varchar(50) default NULL COMMENT '出题人',
  `wrong_flag` char(1) default NULL COMMENT '学生可以标记这道题有问题',
  `wrong_flag_desc` varchar(4000) default NULL COMMENT '题目有误描述',
  `wrong_flag_person` varchar(255) default NULL COMMENT '谁说这道题有问题',
  `category` varchar(32) default NULL COMMENT '问题分类',
  `note` varchar(500) default NULL COMMENT '对正确答案的解释',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='考试试题库表';

-- ----------------------------
-- Records of qa_exam_question
-- ----------------------------
INSERT INTO `qa_exam_question` VALUES ('23', 'N', '2017-01-15 11:43:08', '2017-02-01 18:48:10', 'teacher', 'class12_teacher', '关于sleep()和wait()，以下描述错误的一项是（ ）', '关于sleep()和wait()，以下描述错误的一项是（ ）', 'RADIO', '2', 'MIDDLE', 'class12_teacher', null, null, '', 'J2SE', 'sleep是线程类（Thread）的方法，导致此线程暂停执行指定时间，给执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用sleep不会释放对象锁。  wait是Object类的方法，对此对象调用wait方法导致本线程放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象发出notify方法（或notifyAll）后本线程才进入对象锁定池准备获得对象锁进入运行状态。');
INSERT INTO `qa_exam_question` VALUES ('24', 'N', '2017-01-15 11:44:53', '2017-01-15 19:49:40', 'class12_teacher', 'class12_teacher', '<p>下面能让线程停止执行的有（多选）( )</p>', '<p>下面能让线程停止执行的有（多选）( )</p>', 'CHECKBOX', '2', 'MIDDLE', 'class12_teacher', null, null, null, 'J2SE', 'sleep：导致此线程暂停执行指定时间  stop: 这个方法将终止所有未结束的方法，包括run方法。  synchronized():对象锁  yield：当前正在被服务的线程可能觉得cpu的服务质量不够好，于是提前退出，这就是yield。  wait：当前正在被服务的线程需要睡一会，醒来后继续被服务');
INSERT INTO `qa_exam_question` VALUES ('25', 'N', '2017-01-15 11:46:37', '2017-01-15 11:46:37', 'class12_teacher', 'class12_teacher', '<p>下面哪个可以改变容器的布局？( )</p>', '<p>下面哪个可以改变容器的布局？( )</p>', 'RADIO', '2', 'MIDDLE', 'class12_teacher', null, null, null, 'J2SE', 'Java设置布局管理器setLayout()');
INSERT INTO `qa_exam_question` VALUES ('26', 'N', '2017-01-15 11:47:10', '2017-01-15 11:47:10', 'class12_teacher', 'class12_teacher', '<p>下面哪个是applet传递参数的正确方式？（ ）</p>', '<p>下面哪个是applet传递参数的正确方式？（ ）</p>', 'RADIO', '2', 'MIDDLE', 'class12_teacher', null, null, null, 'J2SE', '');
INSERT INTO `qa_exam_question` VALUES ('27', 'N', '2017-01-15 11:47:52', '2017-01-15 11:47:52', 'class12_teacher', 'class12_teacher', '<p>提供Java存取数据库能力的包是（）</p>', '<p>提供Java存取数据库能力的包是（）</p>', 'RADIO', '2', 'EASY', 'class12_teacher', null, null, null, 'J2SE', 'java.sql是JDBC的编程接口  java.awt和java.swing是做图像界面的类库  java.lang: Java 编程语言进行程序设计的基础类');
INSERT INTO `qa_exam_question` VALUES ('28', 'N', '2017-01-15 11:48:27', '2017-01-15 11:48:27', 'class12_teacher', 'class12_teacher', '<p>不能用来修饰interface的有（）</p>', '<p>不能用来修饰interface的有（）</p>', 'CHECKBOX', '2', 'EASY', 'class12_teacher', null, null, null, 'J2SE', '修饰接口可以是public和默认');
INSERT INTO `qa_exam_question` VALUES ('29', 'N', '2017-01-15 11:50:08', '2017-01-15 11:50:08', 'class12_teacher', 'class12_teacher', '<p>下列说法错误的有（）</p>', '<p>下列说法错误的有（）</p>', 'CHECKBOX', '2', 'EASY', 'class12_teacher', null, null, null, 'J2SE', '在类方法中不能使用this关键字   在类方法中可以调用其它类中的类方法  在类方法中可以通过实例化对象调用实例方法');
INSERT INTO `qa_exam_question` VALUES ('30', 'N', '2017-01-15 11:51:31', '2017-01-15 11:51:31', 'class12_teacher', 'class12_teacher', '<p>从下面四段（A，B，C，D）代码中选择出正确的代码段（）</p>', '<p>从下面四段（A，B，C，D）代码中选择出正确的代码段（）</p>', 'RADIO', '2', 'EASY', 'class12_teacher', null, null, null, 'J2SE', '抽象方法不能有方法体   方法中定义的是局部变量，不能用类成员变量修饰符private  final修饰为常量，常量的值不能被改变');
INSERT INTO `qa_exam_question` VALUES ('31', 'N', '2017-01-15 11:54:06', '2017-01-15 11:55:59', 'class12_teacher', 'class12_teacher', '<p>选择下面代码的运行结果：（）。</p><pre>public class Test{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>   public void method(){<br>    for(int i = 0; i &lt; 3; i++){<br>       System.out.print(i);<br>     }<br>    System.out.print(i);<br>   }<br>}</pre><p>\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n</p>', '<p>选择下面代码的运行结果：（）.</p><blockquote>public class Test{<br>public void method()<br>{<br>for(int i = 0; i</blockquote>', 'RADIO', '2', 'DIFFICULT', 'class12_teacher', null, null, null, 'J2SE', 'i变量的作用范围是整个for循环');
INSERT INTO `qa_exam_question` VALUES ('32', 'N', '2017-01-15 11:57:28', '2017-01-15 11:57:28', 'class12_teacher', 'class12_teacher', '<p>请看如下代码 class Person { private int a; public int change(int m){return \r\nm;} } public class Teacher extends Person{ public int b; public static \r\nvoid main(String arg[]){ Person p = new Person(); Teacher t = new \r\nTeacher(); int i; // point x } }</p><p>\r\n</p><p>下面哪些放在// point x?行是正确的？ A， i = m; B, i = b; C, i = p.a; D, i = p.change(30); E, i = t.b;</p>', '<p>请看如下代码 class Person { private int a; public int change(int m){return \r\nm;} } public class Teacher extends Person{ public int b; public static \r\nvoid main(String arg[]){ Person p = new Person(); Teacher t = new \r\nTeacher(); int i; // point x } }</p><p>\r\n</p><p>下面哪些放在// point x?行是正确的？ A， i = m; B, i = b; C, i = p.a; D, i = p.change(30); E, i = t.b;</p>', 'RADIO', '2', 'DIFFICULT', 'class12_teacher', null, null, null, 'J2SE', '重载：方法名相同，参数列表不同');
INSERT INTO `qa_exam_question` VALUES ('39', 'N', '2017-02-04 14:08:10', '2017-02-04 14:08:10', 'teacher', 'teacher', 'Excel导入问题内容', 'Excel导入问题内容', 'RADIO', '2', 'MIDDLE', 'teacher', null, null, null, 'JAVASCRIPT', '这是Note');
INSERT INTO `qa_exam_question` VALUES ('40', 'N', '2017-02-04 14:10:57', '2017-02-04 14:10:57', 'teacher', 'teacher', 'Excel导入问题内容', 'Excel导入问题内容', 'RADIO', '2', 'MIDDLE', 'teacher', null, null, null, 'JAVASCRIPT', '这是Note');

-- ----------------------------
-- Table structure for qa_exam_question_item
-- ----------------------------
DROP TABLE IF EXISTS `qa_exam_question_item`;
CREATE TABLE `qa_exam_question_item` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `exam_question_id` bigint(255) default NULL COMMENT '考试问题ID',
  `item_content` varchar(4000) default NULL COMMENT '选项内容(A\\B\\C.....）',
  `is_right_item` char(1) default NULL COMMENT '是否为正确选项',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8 COMMENT='考试问题选项';

-- ----------------------------
-- Records of qa_exam_question_item
-- ----------------------------
INSERT INTO `qa_exam_question_item` VALUES ('51', 'N', '2017-01-15 11:43:08', '2017-01-15 19:55:29', 'class12_teacher', 'class12_teacher', '23', 'sleep是线程类（Thread）的方法，wait是Object类的方法；', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('52', 'N', '2017-01-15 11:43:08', '2017-01-15 19:55:18', 'class12_teacher', 'class12_teacher', '23', 'sleep不释放对象锁，wait放弃对象锁；', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('53', 'N', '2017-01-15 11:43:08', '2017-01-15 11:43:08', 'class12_teacher', 'class12_teacher', '23', 'sleep暂停线程、但监控状态仍然保持，结束后会自动恢复；', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('54', 'N', '2017-01-15 11:43:08', '2017-01-15 11:43:08', 'class12_teacher', 'class12_teacher', '23', 'wait后进入等待锁定池，只有针对此对象发出notify方法后获得对象锁进入运行状态。', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('55', 'N', '2017-01-15 11:44:53', '2017-01-15 11:44:53', 'class12_teacher', 'class12_teacher', '24', 'sleep();', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('56', 'N', '2017-01-15 11:44:53', '2017-01-15 11:44:53', 'class12_teacher', 'class12_teacher', '24', 'stop();', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('57', 'N', '2017-01-15 11:44:53', '2017-01-15 11:44:53', 'class12_teacher', 'class12_teacher', '24', 'notify();', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('58', 'N', '2017-01-15 11:44:53', '2017-01-15 11:44:53', 'class12_teacher', 'class12_teacher', '24', 'synchronized();', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('59', 'N', '2017-01-15 11:44:53', '2017-01-15 11:44:53', 'class12_teacher', 'class12_teacher', '24', 'yield();', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('60', 'N', '2017-01-15 11:44:53', '2017-01-15 11:44:53', 'class12_teacher', 'class12_teacher', '24', 'wait();', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('61', 'N', '2017-01-15 11:44:53', '2017-01-15 11:44:53', 'class12_teacher', 'class12_teacher', '24', 'notifyAll();', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('62', 'N', '2017-01-15 11:46:37', '2017-01-15 11:46:37', 'class12_teacher', 'class12_teacher', '25', 'setLayout(aLayoutManager);', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('63', 'N', '2017-01-15 11:46:37', '2017-01-15 11:46:37', 'class12_teacher', 'class12_teacher', '25', 'addLayout(aLayoutManager);', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('64', 'N', '2017-01-15 11:46:37', '2017-01-15 11:46:37', 'class12_teacher', 'class12_teacher', '25', 'layout(aLayoutManager);', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('65', 'N', '2017-01-15 11:46:37', '2017-01-15 11:46:37', 'class12_teacher', 'class12_teacher', '25', 'setLayoutManager(aLayoutManager);', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('66', 'N', '2017-01-15 11:47:10', '2017-01-15 11:47:10', 'class12_teacher', 'class12_teacher', '26', '<applet code=Test.class age=33 width=100 height=100>', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('67', 'N', '2017-01-15 11:47:10', '2017-01-15 11:47:10', 'class12_teacher', 'class12_teacher', '26', '<param name=age value=33>', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('68', 'N', '2017-01-15 11:47:10', '2017-01-15 11:47:10', 'class12_teacher', 'class12_teacher', '26', '<applet code=Test.class name=age value=33 width=100 height=100>', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('69', 'N', '2017-01-15 11:47:10', '2017-01-15 11:47:10', 'class12_teacher', 'class12_teacher', '26', '<applet Test 33>', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('70', 'N', '2017-01-15 11:47:52', '2017-01-15 11:47:52', 'class12_teacher', 'class12_teacher', '27', 'java.sql', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('71', 'N', '2017-01-15 11:47:52', '2017-01-15 11:47:52', 'class12_teacher', 'class12_teacher', '27', 'java.awt', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('72', 'N', '2017-01-15 11:47:52', '2017-01-15 11:47:52', 'class12_teacher', 'class12_teacher', '27', 'java.lang', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('73', 'N', '2017-01-15 11:47:52', '2017-01-15 11:47:52', 'class12_teacher', 'class12_teacher', '27', 'java.swing', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('74', 'N', '2017-01-15 11:48:27', '2017-01-15 11:48:27', 'class12_teacher', 'class12_teacher', '28', 'private', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('75', 'N', '2017-01-15 11:48:27', '2017-01-15 11:48:27', 'class12_teacher', 'class12_teacher', '28', 'public', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('76', 'N', '2017-01-15 11:48:27', '2017-01-15 11:48:27', 'class12_teacher', 'class12_teacher', '28', 'protected', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('77', 'N', '2017-01-15 11:48:27', '2017-01-15 11:48:27', 'class12_teacher', 'class12_teacher', '28', 'static', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('78', 'N', '2017-01-15 11:50:08', '2017-01-15 11:50:08', 'class12_teacher', 'class12_teacher', '29', '在类方法中可用this来调用本类的类方法', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('79', 'N', '2017-01-15 11:50:08', '2017-01-15 11:50:08', 'class12_teacher', 'class12_teacher', '29', '在类方法中调用本类的类方法时可直接调用', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('80', 'N', '2017-01-15 11:50:08', '2017-01-15 11:50:08', 'class12_teacher', 'class12_teacher', '29', '在类方法中只能调用本类中的类方法', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('81', 'N', '2017-01-15 11:50:08', '2017-01-15 11:50:08', 'class12_teacher', 'class12_teacher', '29', '在类方法中绝对不能调用实例方法', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('82', 'N', '2017-01-15 11:51:31', '2017-01-15 11:52:02', 'class12_teacher', 'class12_teacher', '30', 'abstractclassName{privateStringname;publicabstractbooleanisStupidName(Stringname){}}', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('83', 'N', '2017-01-15 11:51:31', '2017-01-15 11:51:31', 'class12_teacher', 'class12_teacher', '30', 'public class Something {  void doSomething () {  private String s = “”;  int l = s.length();  }  }', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('84', 'N', '2017-01-15 11:51:31', '2017-01-15 11:51:55', 'class12_teacher', 'class12_teacher', '30', 'publicclassSomething{publicstaticvoidmain(String[]args){Othero=newOther();newSomething().addOne(o);}publicvoidaddOne(finalOthero){o.i  ;}}classOther{publicinti;}', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('85', 'N', '2017-01-15 11:51:31', '2017-01-15 11:52:00', 'class12_teacher', 'class12_teacher', '30', 'publicclassSomething{publicintaddOne(finalintx){return  x;}}', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('86', 'N', '2017-01-15 11:54:06', '2017-01-15 11:54:06', 'class12_teacher', 'class12_teacher', '31', '0122', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('87', 'N', '2017-01-15 11:54:06', '2017-01-15 11:54:06', 'class12_teacher', 'class12_teacher', '31', '0123', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('88', 'N', '2017-01-15 11:54:06', '2017-01-15 11:54:06', 'class12_teacher', 'class12_teacher', '31', '编译错误', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('89', 'N', '2017-01-15 11:54:06', '2017-01-15 11:54:06', 'class12_teacher', 'class12_teacher', '31', '没有任何输出', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('90', 'N', '2017-01-15 11:57:28', '2017-01-15 11:57:28', 'class12_teacher', 'class12_teacher', '32', 'public void method( int m){…}', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('91', 'N', '2017-01-15 11:57:28', '2017-01-15 11:57:28', 'class12_teacher', 'class12_teacher', '32', 'public int method(){…}', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('92', 'N', '2017-01-15 11:57:28', '2017-01-15 11:57:28', 'class12_teacher', 'class12_teacher', '32', 'public void method2(){…}', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('93', 'N', '2017-01-15 11:57:28', '2017-01-15 11:57:28', 'class12_teacher', 'class12_teacher', '32', 'public int method(int m，float f ){…}', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('225', 'N', '2017-02-04 14:08:10', '2017-02-04 14:11:17', 'teacher', null, '39', '这个选项是正确答案（这是第一个选项）', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('226', 'N', '2017-02-04 14:08:10', '2017-02-04 14:08:10', 'system', null, '39', '每个选项用竖线隔开（这是第二个选项）', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('227', 'N', '2017-02-04 14:08:10', '2017-02-04 14:08:10', 'system', null, '39', '这是第三个答案', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('228', 'N', '2017-02-04 14:08:10', '2017-02-04 14:08:10', 'system', null, '39', '这是第四个答案', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('229', 'N', '2017-02-04 14:10:57', '2017-02-04 14:10:57', 'teacher', 'teacher', '40', '这个选项是正确答案（这是第一个选项）', 'Y');
INSERT INTO `qa_exam_question_item` VALUES ('230', 'N', '2017-02-04 14:10:57', '2017-02-04 14:10:57', 'teacher', 'teacher', '40', '每个选项用竖线隔开（这是第二个选项）', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('231', 'N', '2017-02-04 14:10:57', '2017-02-04 14:10:57', 'teacher', 'teacher', '40', '这是第三个答案', 'N');
INSERT INTO `qa_exam_question_item` VALUES ('232', 'N', '2017-02-04 14:10:57', '2017-02-04 14:10:57', 'teacher', 'teacher', '40', '这是第四个答案', 'N');

-- ----------------------------
-- Table structure for qa_excel_config
-- ----------------------------
DROP TABLE IF EXISTS `qa_excel_config`;
CREATE TABLE `qa_excel_config` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `primary_key` varchar(255) default NULL COMMENT 'Excel数据组的唯一标识',
  `property` varchar(50) default NULL COMMENT '属性值',
  `header_name` varchar(255) default NULL COMMENT 'Excel头部显示名称',
  `column_key` varchar(255) default NULL COMMENT '需要特殊处理的Key值',
  `serial` int(2) default NULL COMMENT '排序',
  `format_style` varchar(255) default NULL COMMENT '格式化',
  `common_key` varchar(255) default NULL COMMENT '公共处理的Key',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qa_excel_config
-- ----------------------------
INSERT INTO `qa_excel_config` VALUES ('1', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_EXAM_QUESTION_TEMPLATE', 'content', '问题内容', null, '1', null, null);
INSERT INTO `qa_excel_config` VALUES ('2', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_EXAM_QUESTION_TEMPLATE', 'type', '问题类型', '', '2', '', 'questionTypeAdapter');
INSERT INTO `qa_excel_config` VALUES ('3', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_EXAM_QUESTION_TEMPLATE', 'score', '问题分数', '', '3', '0.00', '');
INSERT INTO `qa_excel_config` VALUES ('4', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_EXAM_QUESTION_TEMPLATE', 'diffStage', '难易程度', '', '4', '', 'diffStageAdapter');
INSERT INTO `qa_excel_config` VALUES ('5', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_EXAM_QUESTION_TEMPLATE', 'category', '问题分类', '', '5', '', 'categoryAdapter');
INSERT INTO `qa_excel_config` VALUES ('6', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_EXAM_QUESTION_TEMPLATE', 'note', 'NOTE', '', '6', '', '');
INSERT INTO `qa_excel_config` VALUES ('7', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_EXAM_QUESTION_TEMPLATE', 'items', '选项', '', '7', '', 'ITEMS');
INSERT INTO `qa_excel_config` VALUES ('8', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_T_QUESTION_TEMPLATE', 'title', '问题标题', '', '1', '', '');
INSERT INTO `qa_excel_config` VALUES ('9', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_T_QUESTION_TEMPLATE', 'content', '问题内容', '', '2', '', '');
INSERT INTO `qa_excel_config` VALUES ('10', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_T_QUESTION_TEMPLATE', 'answer', '问题答案', '', '3', '', '');
INSERT INTO `qa_excel_config` VALUES ('12', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'DOWNLOAD_T_QUESTION_TEMPLATE', 'category', '问题分类', '', '4', '', 'categoryAdapter');
INSERT INTO `qa_excel_config` VALUES ('13', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'content', '问题内容', '', '1', '', '');
INSERT INTO `qa_excel_config` VALUES ('14', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'type', '问题类型', '', '2', '', 'questionTypeAdapter');
INSERT INTO `qa_excel_config` VALUES ('15', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'score', '问题分数', '', '3', '0.00', '');
INSERT INTO `qa_excel_config` VALUES ('16', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'diffStage', '难易程度', '', '4', '', 'diffStageAdapter');
INSERT INTO `qa_excel_config` VALUES ('17', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'category', '问题分类', '', '5', '', 'categoryAdapter');
INSERT INTO `qa_excel_config` VALUES ('18', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'note', 'NOTE', '', '6', '', '');
INSERT INTO `qa_excel_config` VALUES ('19', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'items', '选项', 'items', '7', '', '');
INSERT INTO `qa_excel_config` VALUES ('20', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_EXAM_QUESTION', 'questionPerson', '出题人', '', '7', '', '');
INSERT INTO `qa_excel_config` VALUES ('21', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_T_QUESTION_TEMPLATE', 'title', '问题标题', '', '1', '', '');
INSERT INTO `qa_excel_config` VALUES ('22', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_T_QUESTION_TEMPLATE', 'content', '问题内容', '', '2', '', '');
INSERT INTO `qa_excel_config` VALUES ('23', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_T_QUESTION_TEMPLATE', 'answer', '问题答案', '', '3', '', '');
INSERT INTO `qa_excel_config` VALUES ('24', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_T_QUESTION_TEMPLATE', 'category', '问题分类', '', '4', '', 'categoryAdapter');
INSERT INTO `qa_excel_config` VALUES ('25', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'EXPORT_T_QUESTION_TEMPLATE', 'recCreateDate', '创建时间', '', '5', 'yyyy/m/d h:mm:ss', '');
INSERT INTO `qa_excel_config` VALUES ('26', 'n', '2017-02-17 23:34:16', '2017-02-17 23:34:17', 'system', 'system', 'TEST_GET_CRON_FROM_DB', '0/1 * * * * ?', '', '', null, '', '');

-- ----------------------------
-- Table structure for qa_log
-- ----------------------------
DROP TABLE IF EXISTS `qa_log`;
CREATE TABLE `qa_log` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '修改日期',
  `rec_update_user` varchar(32) default '' COMMENT '修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `method_name` varchar(200) default NULL COMMENT '执行的方法名',
  `params` varchar(4000) default NULL COMMENT '执行方法的参数',
  `is_success` char(1) default NULL COMMENT '是否成功',
  `ip` varchar(50) default '127.0.0.1' COMMENT '用户IP',
  `method_desc` varchar(100) default NULL COMMENT '方法描述信息',
  `error_tip` varchar(500) default NULL COMMENT '错误提示：“用户名不存在”',
  `error_msg` varchar(500) default NULL COMMENT '记录exception详细信息',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=595 DEFAULT CHARSET=utf8 COMMENT='系统操作日志表';

-- ----------------------------
-- Records of qa_log
-- ----------------------------
INSERT INTO `qa_log` VALUES ('571', 'N', '2017-01-15 17:34:56', '2017-01-15 17:34:56', 'class1_user1', 'class1_user1', 'com.qaplus.service.impl.QuestionServiceImpl.addStuQuestion()', '{\"category\":\"J2SE\",\"id\":13,\"needFaceComm\":\"N\",\"questionContent\":\"A．String toString()\\r\\n\\r\\nB．void notify()\\r\\n\\r\\nC．void notifyAll()\\r\\n\\r\\nD．void wait()\",\"questionPerson\":1,\"recCreateDate\":1484472893675,\"recCreateUser\":\"class1_user1\",\"recUpdateDate\":1484472893675,\"recUpdateUser\":\"class1_user1\",\"solvePerson\":4,\"title\":\"下列Object类中的方法，哪一项不是完全跟线程有关：\"}', 'N', '127.0.0.1', '添加问题', null, null);
INSERT INTO `qa_log` VALUES ('572', 'N', '2017-01-15 17:35:25', '2017-01-15 17:35:25', 'class1_user1', 'class1_user1', 'com.qaplus.service.impl.QuestionServiceImpl.addStuQuestion()', '{\"category\":\"J2SE\",\"id\":14,\"needFaceComm\":\"N\",\"questionContent\":\"A．程序员必须创建一个线程来释放内存；\\r\\n\\r\\nB．内存回收程序负责释放无用内存\\r\\n\\r\\nC．内存回收程序允许程序员直接释放内存\\r\\n\\r\\nD．内存回收程序可以在指定的时间释放内存对象\",\"questionPerson\":1,\"recCreateDate\":1484472924899,\"recCreateUser\":\"class1_user1\",\"recUpdateDate\":1484472924899,\"recUpdateUser\":\"class1_user1\",\"solvePerson\":4,\"title\":\"在Java语言中，下列哪些语句关于内存回收的说明是正确的?\"}', 'Y', '127.0.0.1', '添加问题', null, null);
INSERT INTO `qa_log` VALUES ('582', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', 'com.qaplus.service.impl.PaperServiceImpl.makePaper()', '{\"avgScore\":0,\"classId\":1,\"diffStage\":\"EASY\",\"difficult\":2,\"easy\":4,\"examDate\":1487690101000,\"examLong\":30,\"examTime\":\"2017-02-21 23:15:01\",\"id\":42,\"invigilatePerson\":2,\"isEffect\":\"Y\",\"middle\":4,\"paperCategory\":\"MIX\",\"paperPerson\":2,\"paperStatus\":\"STARTING\",\"paperTitle\":\"SystemOperatorLog\",\"questionAmount\":10,\"questionIds\":\"28,30,27,29,25,24,40,23,32,31,\",\"recCreateDate\":1487690119313,\"recCreateUser\":\"teacher\",\"recUpdateDate\":1487690119314,\"recUpdateUser\":\"teacher\",\"stuIds\":\"1,6,8,\",\"totalScore\":20,\"upsetItem\":\"N\",\"upsetQuestion\":\"N\"}', 'Y', '127.0.0.1', '制作试卷', null, null);
INSERT INTO `qa_log` VALUES ('588', 'N', '2017-02-22 21:30:10', '2017-02-22 21:30:10', 'teacher', 'teacher', 'com.qaplus.service.impl.ClassServiceImpl.addClass()', '{\"id\":4,\"name\":\"三班44\",\"person\":30,\"recCreateDate\":1487770210477,\"recCreateUser\":\"teacher\",\"recUpdateDate\":1487770210477,\"recUpdateUser\":\"teacher\"}', 'Y', '127.0.0.1', '添加班级', null, null);
INSERT INTO `qa_log` VALUES ('590', 'N', '2017-03-04 12:28:46', '2017-03-04 12:28:46', 'student1', 'student1', 'com.qaplus.service.impl.QuestionServiceImpl.addStuQuestion()', '{\"category\":\"4\",\"id\":19,\"needFaceComm\":\"N\",\"questionAttachmentId\":242,\"questionContent\":\"动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试\",\"questionHasAttachment\":\"Y\",\"questionPerson\":1,\"recCreateDate\":1488601723499,\"recCreateUser\":\"student1\",\"recUpdateDate\":1488601723499,\"recUpdateUser\":\"student1\",\"solvePerson\":2,\"title\":\"动态分类测试\"}', 'Y', '127.0.0.1', '学生添加问题', null, null);
INSERT INTO `qa_log` VALUES ('591', 'N', '2017-03-04 12:39:40', '2017-03-04 12:39:40', 'student1', 'student1', 'com.qaplus.service.impl.QuestionServiceImpl.addStuQuestion()', '{\"category\":\"JQUERY\",\"id\":20,\"needFaceComm\":\"N\",\"questionAttachmentId\":243,\"questionContent\":\"这是描述\",\"questionHasAttachment\":\"Y\",\"questionPerson\":1,\"recCreateDate\":1488602378414,\"recCreateUser\":\"student1\",\"recUpdateDate\":1488602378414,\"recUpdateUser\":\"student1\",\"solvePerson\":2,\"title\":\"这次选择了JQUERY\"}', 'Y', '127.0.0.1', '学生添加问题', null, null);
INSERT INTO `qa_log` VALUES ('592', 'N', '2017-03-05 14:53:52', '2017-03-05 14:53:52', 'student1', 'student1', 'com.qaplus.service.impl.QuestionServiceImpl.addStuQuestion()', '{\"category\":\"OTHER\",\"id\":21,\"needFaceComm\":\"N\",\"questionAttachmentId\":244,\"questionContent\":\"学生一  添加问题 测试 问题描述（Other）\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\\r\\n学生一  添加问题 测试 问题描述\",\"questionHasAttachment\":\"Y\",\"questionPerson\":1,\"recCreateDate\":1488696830088,\"recCreateUser\":\"student1\",\"recUpdateDate\":1488696830088,\"recUpdateUser\":\"student1\",\"solvePerson\":2,\"title\":\"学生一  添加问题 测试 标题（附件是:Linux虚拟机图片）\"}', 'Y', '127.0.0.1', '学生添加问题', null, null);
INSERT INTO `qa_log` VALUES ('593', 'N', '2017-03-05 14:57:06', '2017-03-05 14:57:06', 'student1', 'student1', 'com.qaplus.service.impl.QuestionServiceImpl.addStuQuestion()', '{\"category\":\"J2SE\",\"id\":22,\"needFaceComm\":\"N\",\"questionContent\":\"5.测试发邮件\",\"questionPerson\":1,\"recCreateDate\":1488696996180,\"recCreateUser\":\"student1\",\"recUpdateDate\":1488696996180,\"recUpdateUser\":\"student1\",\"solvePerson\":2,\"title\":\"5.测试发邮件\"}', 'Y', '127.0.0.1', '学生添加问题', null, null);
INSERT INTO `qa_log` VALUES ('594', 'N', '2017-03-05 15:00:16', '2017-03-05 15:00:16', 'student1', 'student1', 'com.qaplus.service.impl.QuestionServiceImpl.addStuQuestion()', '{\"category\":\"J2SE\",\"id\":23,\"needFaceComm\":\"N\",\"questionAttachmentId\":245,\"questionContent\":\"学生一 添加问题 测试 问题描述（Other） 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述\",\"questionHasAttachment\":\"Y\",\"questionPerson\":1,\"recCreateDate\":1488697113698,\"recCreateUser\":\"student1\",\"recUpdateDate\":1488697113698,\"recUpdateUser\":\"student1\",\"solvePerson\":2,\"title\":\"学生一 添加问题 测试 标题（附件是:Linux虚拟机图片）\"}', 'Y', '127.0.0.1', '学生添加问题', null, null);

-- ----------------------------
-- Table structure for qa_paper
-- ----------------------------
DROP TABLE IF EXISTS `qa_paper`;
CREATE TABLE `qa_paper` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `total_score` int(3) default '100' COMMENT '总分',
  `question_amount` int(3) default '50' COMMENT '试题数目',
  `question_ids` varchar(255) default '' COMMENT '试题编号（逗号分隔）',
  `diff_stage` varchar(20) default NULL COMMENT '试卷难易程度（难、中、易），根据试卷的考试结果判断',
  `invigilate_person` bigint(255) default NULL COMMENT '监考老师',
  `paper_person` bigint(255) default NULL COMMENT '出卷人',
  `paper_title` varchar(255) default '' COMMENT '试卷标题',
  `paper_category` varchar(255) default '' COMMENT '试卷分类（Mix-综合试卷）',
  `exam_date` datetime default NULL COMMENT '考试时间',
  `exam_long` int(11) default '90' COMMENT '考试时长（单位：分钟）',
  `upset_question` char(1) default NULL COMMENT '打乱试题顺序',
  `is_effect` char(1) default NULL COMMENT '是否生效（时间判断）',
  `upset_item` char(1) default NULL COMMENT '打乱选项顺序',
  `paper_status` varchar(40) default NULL COMMENT '试卷状态',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='试卷表';

-- ----------------------------
-- Records of qa_paper
-- ----------------------------
INSERT INTO `qa_paper` VALUES ('38', 'N', '2017-02-19 18:41:50', '2017-02-19 19:10:36', 'system', 'teacher', '20', '10', '27,28,29,30,26,23,25,24,31,32,', 'EASY', '2', '2', '测试-试卷名称1', 'OTHER', '2017-02-19 18:40:35', '30', 'N', 'N', 'N', 'STARTED');
INSERT INTO `qa_paper` VALUES ('39', 'N', '2017-02-19 21:07:35', '2017-02-19 21:35:08', 'system', 'teacher', '20', '10', '27,28,29,30,26,23,25,24,31,32,', 'EASY', '2', '2', '测试-试卷名称1', 'OTHER', '2017-02-19 21:05:08', '30', 'N', 'N', 'N', 'STARTED');
INSERT INTO `qa_paper` VALUES ('42', 'N', '2017-02-21 23:15:19', '2017-02-22 22:37:37', 'system', 'teacher', '20', '10', '28,30,27,29,25,24,40,23,32,31,', 'EASY', '2', '2', 'SystemOperatorLog', 'MIX', '2017-02-21 23:15:01', '30', 'N', 'N', 'N', 'STARTED');

-- ----------------------------
-- Table structure for qa_paper_stu
-- ----------------------------
DROP TABLE IF EXISTS `qa_paper_stu`;
CREATE TABLE `qa_paper_stu` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `is_submit` char(1) default NULL COMMENT '是否提交试卷',
  `exam_status` varchar(20) default NULL COMMENT '学生考试状态（考试中、已提交）',
  `stu_id` bigint(255) default NULL COMMENT '学生Id',
  `paper_id` bigint(255) default NULL COMMENT '试卷ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qa_paper_stu
-- ----------------------------
INSERT INTO `qa_paper_stu` VALUES ('61', 'N', '2017-02-19 21:07:35', '2017-02-19 21:11:33', 'student1', 'teacher', 'Y', 'EXAMED', '1', '39');
INSERT INTO `qa_paper_stu` VALUES ('62', 'N', '2017-02-19 21:07:36', '2017-02-19 21:35:08', 'system', 'teacher', 'Y', 'EXAMED', '6', '39');
INSERT INTO `qa_paper_stu` VALUES ('63', 'N', '2017-02-19 21:07:36', '2017-02-19 21:35:08', 'system', 'teacher', 'Y', 'EXAMED', '8', '39');
INSERT INTO `qa_paper_stu` VALUES ('70', 'N', '2017-02-21 23:15:19', '2017-02-22 22:30:04', 'system', 'teacher', 'Y', 'EXAMED', '1', '42');
INSERT INTO `qa_paper_stu` VALUES ('71', 'N', '2017-02-21 23:15:19', '2017-02-22 22:30:05', 'system', 'teacher', 'Y', 'EXAMED', '6', '42');
INSERT INTO `qa_paper_stu` VALUES ('72', 'N', '2017-02-21 23:15:19', '2017-02-22 22:30:05', 'system', 'teacher', 'Y', 'EXAMED', '8', '42');

-- ----------------------------
-- Table structure for qa_paper_stu_detail
-- ----------------------------
DROP TABLE IF EXISTS `qa_paper_stu_detail`;
CREATE TABLE `qa_paper_stu_detail` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `paper_id` bigint(255) default NULL COMMENT '试卷',
  `exam_question_id` bigint(255) default NULL COMMENT '试卷题目ID',
  `stu_id` bigint(255) default NULL COMMENT '学生',
  `choice_item` varchar(10) default NULL COMMENT '学生选择的选项（有可能是多选）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=742 DEFAULT CHARSET=utf8 COMMENT='学生-试卷（学生答案）';

-- ----------------------------
-- Records of qa_paper_stu_detail
-- ----------------------------
INSERT INTO `qa_paper_stu_detail` VALUES ('622', 'N', '2017-02-19 21:07:35', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '27', '1', '70,');
INSERT INTO `qa_paper_stu_detail` VALUES ('623', 'N', '2017-02-19 21:07:35', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '28', '1', '74,');
INSERT INTO `qa_paper_stu_detail` VALUES ('624', 'N', '2017-02-19 21:07:35', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '29', '1', '78,');
INSERT INTO `qa_paper_stu_detail` VALUES ('625', 'N', '2017-02-19 21:07:35', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '30', '1', '82,');
INSERT INTO `qa_paper_stu_detail` VALUES ('626', 'N', '2017-02-19 21:07:36', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '26', '1', '66,');
INSERT INTO `qa_paper_stu_detail` VALUES ('627', 'N', '2017-02-19 21:07:36', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '23', '1', '51,');
INSERT INTO `qa_paper_stu_detail` VALUES ('628', 'N', '2017-02-19 21:07:36', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '25', '1', '62,');
INSERT INTO `qa_paper_stu_detail` VALUES ('629', 'N', '2017-02-19 21:07:36', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '24', '1', '55,');
INSERT INTO `qa_paper_stu_detail` VALUES ('630', 'N', '2017-02-19 21:07:36', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '31', '1', '86,');
INSERT INTO `qa_paper_stu_detail` VALUES ('631', 'N', '2017-02-19 21:07:36', '2017-02-19 21:11:34', 'student1', 'teacher', '39', '32', '1', '90,');
INSERT INTO `qa_paper_stu_detail` VALUES ('632', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '27', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('633', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '28', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('634', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '29', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('635', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '30', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('636', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '26', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('637', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '23', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('638', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '25', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('639', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '24', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('640', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '31', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('641', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '32', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('642', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '27', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('643', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '28', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('644', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '29', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('645', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '30', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('646', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '26', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('647', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '23', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('648', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '25', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('649', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '24', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('650', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '31', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('651', 'N', '2017-02-19 21:07:36', '2017-02-19 21:07:36', 'teacher', 'teacher', '39', '32', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('712', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '28', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('713', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '30', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('714', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '27', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('715', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '29', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('716', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '25', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('717', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '24', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('718', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '40', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('719', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '23', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('720', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '32', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('721', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '31', '1', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('722', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '28', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('723', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '30', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('724', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '27', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('725', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '29', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('726', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '25', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('727', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '24', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('728', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '40', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('729', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '23', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('730', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '32', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('731', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '31', '6', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('732', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '28', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('733', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '30', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('734', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '27', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('735', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '29', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('736', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '25', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('737', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '24', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('738', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '40', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('739', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '23', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('740', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '32', '8', null);
INSERT INTO `qa_paper_stu_detail` VALUES ('741', 'N', '2017-02-21 23:15:19', '2017-02-21 23:15:19', 'teacher', 'teacher', '42', '31', '8', null);

-- ----------------------------
-- Table structure for qa_recommend_file
-- ----------------------------
DROP TABLE IF EXISTS `qa_recommend_file`;
CREATE TABLE `qa_recommend_file` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `title` varchar(255) default NULL,
  `content` varchar(8000) default NULL,
  `has_attachment` char(1) default NULL COMMENT '是否有附件',
  `attachment_id` bigint(255) default NULL COMMENT '附件路径',
  `recommend_person` bigint(255) default NULL COMMENT '推荐者（可以是毕业的学生，可以是老师）',
  `category` varchar(50) default NULL COMMENT '资料类别',
  `all_read` char(1) default NULL COMMENT '所有人可见',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='推荐资料表';

-- ----------------------------
-- Records of qa_recommend_file
-- ----------------------------
INSERT INTO `qa_recommend_file` VALUES ('1', 'N', '2017-01-14 21:18:50', '2017-02-08 21:50:55', 'teacher', 'class12_teacher', 'java构建树结构常用方法（一）', '<pre>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@Override\r\n&nbsp;&nbsp;&nbsp;&nbsp;	public List&lt;DimensionValueDto&gt; commonBuildTree(List&lt;DimensionValueDto&gt; dimensionValues) {\r\n		Map&lt;String, List&lt;DimensionValueDto&gt;&gt; groupChildNodes = groupChildNodes(dimensionValues,false,null);\r\n		return commonBuildDimValTree(dimensionValues, groupChildNodes);\r\n	}\r\n\r\n\r\n\r\n\r\n\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/**\r\n	 * 按照维值dimensionCode+parentCode进行分组\r\n	 * @param dimensionValues 维值列表\r\n	 * @param isTemplateDefined 是否维模板定义 是：需要 checkIsEffectedForTemplateDefined 处理\r\n	 * @param dimensionValueCodes 上一次选择的维值Code列表 不是模板定义传 null\r\n	 * @return 分组后的维值\r\n	 */\r\n	private Map&lt;String, List&lt;DimensionValueDto&gt;&gt; groupChildNodes(List&lt;DimensionValueDto&gt; dimensionValues,boolean isTemplateDefined,List&lt;String&gt; dimensionValueCodes) {\r\n		Map&lt;String, List&lt;DimensionValueDto&gt;&gt; groupChildNodes=new HashMap&lt;String, List&lt;DimensionValueDto&gt;&gt;();\r\n		if(!isTemplateDefined){\r\n			assemberI18n(dimensionValues);\r\n		}\r\n		for (DimensionValueDto childNode : dimensionValues) {\r\n			List&lt;DimensionValueDto&gt; childNodes=groupChildNodes.get(childNode.getParentCode()+childNode.getDimensionCode());\r\n			if(childNodes==null){\r\n				childNodes=new ArrayList&lt;DimensionValueDto&gt;();\r\n				groupChildNodes.put(childNode.getParentCode()+childNode.getDimensionCode(), childNodes);\r\n			}\r\n			if(isTemplateDefined &amp;&amp; checkIsEffectedForTemplateDefined(childNode, dimensionValueCodes)){\r\n				childNodes.add(childNode);\r\n			}else{\r\n				childNodes.add(childNode);\r\n			}\r\n		}\r\n		return groupChildNodes;\r\n	}\r\n\r\n\r\n\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;private List&lt;DimensionValueDto&gt; commonBuildDimValTree(List&lt;DimensionValueDto&gt; dimensionValues,Map&lt;String, List&lt;DimensionValueDto&gt;&gt; groupChildNodes){\r\n		List&lt;DimensionValueDto&gt; nodeList = new ArrayList&lt;DimensionValueDto&gt;();\r\n		List&lt;String&gt; alreadyGenTree = new ArrayList&lt;String&gt;();\r\n		for (DimensionValueDto parentDimensionValue : dimensionValues) {\r\n			List&lt;DimensionValueDto&gt; childNodes=groupChildNodes.get(parentDimensionValue.getCode()+parentDimensionValue.getDimensionCode());\r\n			if(childNodes!=null){\r\n				if (parentDimensionValue.getChildNodes() == null) {\r\n					parentDimensionValue.setChildNodes(new ArrayList&lt;DimensionValueDto&gt;());\r\n				}\r\n				parentDimensionValue.getChildNodes().addAll(childNodes);\r\n				//去除重复\r\n				parentDimensionValue.setChildNodes(new ArrayList&lt;DimensionValueDto&gt;(new HashSet&lt;DimensionValueDto&gt;(parentDimensionValue.getChildNodes())));\r\n				orderBySerial(parentDimensionValue.getChildNodes());\r\n				for (DimensionValueDto dimensionValueDto : parentDimensionValue.getChildNodes()) {\r\n					alreadyGenTree.add(dimensionValueDto.getCode() + dimensionValueDto.getParentCode() + dimensionValueDto.getDimensionCode());\r\n				}\r\n			}\r\n		}\r\n		for (DimensionValueDto parentDimensionValue : dimensionValues) {\r\n			// 解决 bug 如果数组进来的第一个元素是二级节点，则会重复添加\r\n			if (!alreadyGenTree.contains(parentDimensionValue.getCode() + parentDimensionValue.getParentCode() + parentDimensionValue.getDimensionCode())) {\r\n				nodeList.add(parentDimensionValue);\r\n			}\r\n		}\r\n		return nodeList;\r\n	}\r\n</pre><pre>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@Override\r\n	public List&lt;DimensionValueDto&gt; buildTree(List&lt;DimensionValueDto&gt; dimensionValues) {\r\n		List&lt;DimensionValueDto&gt; rootDimensionValues = Lists.newArrayListWithCapacity(dimensionValues.size());\r\n		for (DimensionValueDto dimensionValue : dimensionValues) {\r\n			if (StringUtils.isEmpty(dimensionValue.getParentCode())) {\r\n				rootDimensionValues.add(dimensionValue);\r\n			}\r\n		}\r\n		// 为根节点维值添加国际化信息，维值修改需要\r\n		orderBySerial(rootDimensionValues);\r\n		assemberI18n(rootDimensionValues);\r\n		dimensionValues.removeAll(rootDimensionValues);\r\n		\r\n		Map&lt;String, List&lt;DimensionValueDto&gt;&gt; groupChildNodes = groupChildNodes(dimensionValues,false,null);\r\n		buildDimensionValueTree(rootDimensionValues, groupChildNodes);\r\n		return rootDimensionValues;\r\n	}\r\n\r\n\r\n\r\n\r\n\r\n\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/**\r\n	 * 按照serial 排序，前端上下移功能必须要\r\n	 * \r\n	 * @param dimensionValues\r\n	 *            维值\r\n	 */\r\n	private void orderBySerial(List&lt;DimensionValueDto&gt; dimensionValues) {\r\n		Collections.sort(dimensionValues, new Comparator&lt;DimensionValueDto&gt;() {\r\n			@Override\r\n			public int compare(DimensionValueDto o1, DimensionValueDto o2) {\r\n				if (o1.getSerial() != null &amp;&amp; o2.getSerial() != null) {\r\n					return o1.getSerial() - o2.getSerial();\r\n				} else {\r\n					return 1;\r\n				}\r\n			}\r\n		});\r\n	}\r\n\r\n\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/**\r\n	 * 构建树结构\r\n	 * @param parentDimensionValues 根节点\r\n	 * @param groupChildNodes 按照code+dimensionCode分组的map\r\n	 */\r\n	private void buildDimensionValueTree(List&lt;DimensionValueDto&gt; parentDimensionValues, Map&lt;String, List&lt;DimensionValueDto&gt;&gt; groupChildNodes) {\r\n		for (DimensionValueDto parentDimensionValue : parentDimensionValues) {\r\n			getChildNodesFromMap(groupChildNodes, parentDimensionValue);\r\n		}\r\n		for (DimensionValueDto dimensionValue : parentDimensionValues) {\r\n			if (CollectionUtils.isNotEmpty(dimensionValue.getChildNodes())) {\r\n				// 为维值添加国际化信息，维值修改需要\r\n				orderBySerial(dimensionValue.getChildNodes());\r\n				buildDimensionValueTree(dimensionValue.getChildNodes(), groupChildNodes);\r\n			}\r\n		}\r\n	}\r\n\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/**\r\n&nbsp;&nbsp;&nbsp;&nbsp;	 * 得到维值的直接子节点\r\n	 * @param groupChildNodes 按照code+dimensionCode分组的map\r\n	 * @param parentDimensionValue 父维值\r\n	 */\r\n	private void getChildNodesFromMap(Map&lt;String, List&lt;DimensionValueDto&gt;&gt; groupChildNodes, DimensionValueDto parentDimensionValue) {\r\n		List&lt;DimensionValueDto&gt; childNodes=groupChildNodes.get(parentDimensionValue.getCode()+parentDimensionValue.getDimensionCode());\r\n		if(childNodes!=null){\r\n			if (parentDimensionValue.getChildNodes() == null) {\r\n				parentDimensionValue.setChildNodes(new ArrayList&lt;DimensionValueDto&gt;());\r\n			}\r\n			parentDimensionValue.getChildNodes().addAll(childNodes);\r\n			//去除重复\r\n			parentDimensionValue.setChildNodes(new ArrayList&lt;DimensionValueDto&gt;(new HashSet&lt;DimensionValueDto&gt;(parentDimensionValue.getChildNodes())));\r\n		}\r\n	}</pre><div><br></div>', null, null, '2', 'J2SE', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('2', 'N', '2017-01-14 21:25:09', '2017-01-14 21:25:09', 'class12_teacher', 'class12_teacher', '常用配置项', '<p>1.maven中配置字符编码：</p><pre><li class=\"alt\">&lt;properties&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;project.build.sourceEncoding&gt;UTF-8&lt;/project.build.sourceEncoding&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&lt;/properties&gt;&nbsp;</li></pre><li class=\"alt\">2.web.xml中配置session超时：</li><pre><li class=\"alt\"></li><li class=\"alt\">&lt;!--&nbsp;sesson超时时间&nbsp;--&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"\">&lt;session-config&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&lt;session-timeout&gt;180&lt;/session-timeout&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"\">&lt;/session-config&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"alt\">&lt;!--&nbsp;4040页面返回&nbsp;--&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"\">&lt;error-page&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&lt;error-code&gt;404&lt;/error-code&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"\">&nbsp;&nbsp;&nbsp;&lt;location&gt;/WEB-INF/error.jsp&lt;/location&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\"></li><li class=\"alt\">&lt;/error-page&gt;</li></pre><li class=\"alt\"></li><li class=\"alt\">3.连接MySQL数据库：</li><pre><li class=\"alt\">&lt;property&nbsp;name=\"jdbcUrl\"&nbsp;value=\"jdbc:mysql://localhost:3306/db_activiti?useUnicode=true&amp;characterEncoding=utf-8\"/&gt;&nbsp;&nbsp;</li></pre><div class=\"save_code tracking-ad\" data-mod=\"popu_249\"><a target=\"_blank\"><span id=\"transmark\"></span></a></div>4.避免IE执行AJAX时，返回JSON出现下载文件：<li class=\"alt\"></li><pre><li class=\"alt\">&lt;!--避免IE执行AJAX时，返回JSON出现下载文件&nbsp;--&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&lt;bean&nbsp;id=\"mappingJacksonHttpMessageConverter\"&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;class=\"org.springframework.http.converter.json.MappingJacksonHttpMessageConverter\"&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;property&nbsp;name=\"supportedMediaTypes\"&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;list&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;value&gt;text/html;charset=UTF-8&lt;/value&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/list&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/property&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&lt;/bean&gt; &nbsp;</li></pre><li class=\"alt\">5.在web.xml中配置 &nbsp;防止Spring内存溢出监听器：</li><li class=\"alt\"></li><pre><li class=\"alt\">&lt;!--&nbsp;防止Spring内存溢出监听器&nbsp;--&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&lt;listener&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;listener-class&gt;org.springframework.web.util.IntrospectorCleanupListener&lt;/listener-class&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&lt;/listener&gt; &nbsp;</li></pre>&nbsp;<p><br></p><p><br></p>', null, null, '2', 'OTHER', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('3', 'N', '2017-01-14 21:29:21', '2017-01-14 21:29:21', 'class12_teacher', 'class12_teacher', '网站', '<p><p>Oracle:<br></p><pre>&nbsp;&nbsp; &nbsp;1.ORA-01790: 表达式必须具有与对应表达式相同的数据类型\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.sina.com.cn/s/blog_4ccb7fed0101f7u3.html\r\n&nbsp;&nbsp; &nbsp;2.Oracle查询被锁的表及进程的方法\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://database.51cto.com/art/201010/231542.htm\r\n&nbsp;&nbsp; &nbsp;3.oracle正则表达式regexp_like的用法详解\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.jb51.net/article/38426.htm\r\n&nbsp;&nbsp; &nbsp;4.ORA-00907: 缺少右括号 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/hadstj/article/details/7962470\r\n&nbsp;&nbsp; &nbsp;5.oracle之优化一中用group by优化distinct \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/fengfengfeifei/article/details/6778996\r\n&nbsp;&nbsp; &nbsp;6.ORACLE数据库表快速回滚到某一时间点 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://my.oschina.net/fajar/blog/542774</pre>\r\nMySql:<br><pre>&nbsp;&nbsp; &nbsp;1.mysql语句优化总结（一） \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/kevinlifeng/article/details/43233227</pre>\r\nMybatis:<br><pre>&nbsp;&nbsp; &nbsp;1.Mybatis &lt;collection&gt; 标签使用\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/mamba10/article/details/20927225</pre>\r\nBat:<br><pre>&nbsp;&nbsp; &nbsp;1.Bat命令学习\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/SunShineYPH/archive/2011/12/13/2285570.html</pre>\r\n&nbsp;&nbsp; &nbsp;<br>\r\nHibernate:<br><pre>&nbsp;&nbsp; &nbsp;1.注意Hibernate4在开发当中的一些改变 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/houpengfei111/article/details/9468389\r\n&nbsp;&nbsp; &nbsp;2.Hibernate注解详解(超全面不解释)\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; \r\n&nbsp;http://wenku.baidu.com/link?url=f2EUBpaVbuVQv03IFuuw6LJCcgs9tYiToEce3OA-XTen5jgbPtjsbpJUQyDGqkjZ-feEE1IO5gGlvghIwzUXW0ClDlFEnOr7TcMymgIRbxe\r\n&nbsp;&nbsp; &nbsp;3.Hibernate+EhCache配置二级缓存\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://jyao.iteye.com/blog/1315726</pre>\r\nSpringMvc:<br><pre>&nbsp;&nbsp; &nbsp;1.ApplicationHttpRequest cannot be cast to MultipartHttpServletRequest springMVC 文件上传转换出错解决\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/cuyt/archive/2012/11/09/2763207.html\r\n&nbsp;&nbsp; &nbsp;2.SpringMVC利用AOP实现自定义注解记录日志\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.xdemo.org/springmvc-aop-annotation/\r\n&nbsp;&nbsp; &nbsp;3.springmvc ztree 实现权限菜单的展示 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/zwx19921215/article/details/44339919\r\n&nbsp;&nbsp; &nbsp;4.Spring MVC常用的注解\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://justice-jl.iteye.com/blog/1814980</pre>\r\n&nbsp;&nbsp; &nbsp;<br>\r\nEclipse：<br><pre>&nbsp;&nbsp; &nbsp;1.Eclipse 4.4(luna) 安装Veloeclipse 2.0.8时报错的问题\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/yuanermen/p/4178458.html</pre>\r\n&nbsp;&nbsp; &nbsp;<br>\r\nJdbc:<br><pre>&nbsp;&nbsp; &nbsp;1.java PreparedStatement sql批量更新 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/tower888/article/details/10782781</pre>\r\nSpring:<br><pre>&nbsp;&nbsp; &nbsp;1.使用Spring+Junit4.4进行测试(使用注解)\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.blogjava.net/titanaly/archive/2011/11/30/365230.html\r\n&nbsp;&nbsp; &nbsp;2.SpringMVC框架使用注解执行定时任务\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;https://wuzhuti.cn/850.html</pre>\r\nJavaEE:<br><pre>&nbsp;&nbsp; &nbsp;1.java使double保留两位小数的多方法 java保留两位小数\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.jb51.net/article/46010.htm\r\n&nbsp;&nbsp; &nbsp;2.Java Base64加密解码实例 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/vicken520/article/details/9066563\r\n&nbsp;&nbsp; &nbsp;3.Java NIO使用及原理分析 (一) \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/wuxianglong/article/details/6604817\r\n&nbsp;&nbsp; &nbsp;4.JavaMail API详解\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.360doc.com/content/14/0306/17/16088576_358273704.shtml\r\n&nbsp;&nbsp; &nbsp;5.java比较两个日期大小\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/QQParadise/articles/1501420.html\r\n&nbsp;&nbsp; &nbsp;6.使用java的wsimport.exe工具生成wsdl的客户端代码 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/tianma630/article/details/8231224\r\n&nbsp;&nbsp; &nbsp;7. Map.putAll方法\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://book.2cto.com/201309/31811.html\r\n&nbsp;&nbsp; &nbsp;8. org.apache.commons.lang.StringUtils（StringUtils工具类的常用方法） \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/baple/article/details/16356157\r\n&nbsp;&nbsp; &nbsp;9.遍历Map的四种方法\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/kristain/articles/2033566.html\r\n&nbsp;&nbsp; &nbsp;10.FileUtils方法大全 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/gao36951/article/details/38302553\r\n&nbsp;&nbsp; &nbsp;11.Java四种线程池的使用\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://cuisuqiang.iteye.com/blog/2019372\r\n&nbsp;&nbsp; &nbsp;12.java并发编程中CountDownLatch和CyclicBarrier的使用 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/hbzyaxiu520/article/details/6183714\r\n&nbsp;&nbsp; &nbsp;13.26个提升java性能需要注意的地方\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.admin10000.com/document/1070.html\r\n&nbsp;&nbsp; &nbsp;14.ThreadLocal的正确用法 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/vking_wang/article/details/14225379\r\n&nbsp;&nbsp; &nbsp;15.常见WEB开发安全漏洞 原因分析及解决\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://leeqoo.iteye.com/blog/1584867</pre>\r\nStruts2:<br><pre>&nbsp;&nbsp; &nbsp;1.struts2标签详解\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/langtianya/archive/2013/03/18/2965878.html</pre>\r\nWebLogic<br><pre>&nbsp;&nbsp; &nbsp;1.weblogic内存溢出解决方法\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; \r\n&nbsp;http://wenku.baidu.com/link?url=Cz5R6FOox5UyMxpWqs8M89l-ADGxrDEyk4RESl709HbKkCGKvW9uO0SZKyoyB_SnD4EABEGU2sgE5wQ7pYXKavj4XOrnUqI_SIfBBUXahVK\r\n&nbsp;&nbsp; &nbsp;2.weblogic忘记用户名或者密码的解决方法\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://itindex.net/detail/49563-weblogic-%E5%BF%98%E8%AE%B0-%E5%AF%86%E7%A0%81</pre>\r\n框架整合：<br><pre>&nbsp;&nbsp; &nbsp;1.Spring4.0+Hibernate4.0+Struts2.3整合包括增删改查案例，解决整合中出现的异常\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://xp9802.iteye.com/blog/2121993</pre>\r\n正则表达式：<br><pre>&nbsp;&nbsp; &nbsp;1.正则表达式基本语法\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/light169/archive/2006/10/18/532347.html</pre>\r\nGson:<br><pre>&nbsp;&nbsp; &nbsp;1.Gson简要使用笔记\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/chenlhuaf/archive/2011/05/01/gson_test.html</pre>\r\nXPath:<br><pre>&nbsp;&nbsp; &nbsp;1.XPath 教程\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.runoob.com/xpath/xpath-tutorial.html</pre>\r\njQuery:<br><pre>&nbsp;&nbsp; &nbsp;1.jquery.pagination.js分页\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/knowledgesea/archive/2013/01/03/2841554.html\r\n&nbsp;&nbsp; &nbsp;2. jQuery 序列化表单数据 serialize() serializeArray() \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/tjcyjd/article/details/27058073\r\n&nbsp;&nbsp; &nbsp;3.jQuery选择器总结\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.cnblogs.com/onlys/articles/jQuery.html\r\n&nbsp;&nbsp; &nbsp;4.jquery eval解析JSON中的注意点介绍\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.jb51.net/article/40842.htm\r\n&nbsp;&nbsp; &nbsp;5. jQuery中return false,e.preventDefault(),e.stopPropagation()的区别 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/woshixuye/article/details/7422985</pre>在线帮助文档：<br><pre>&nbsp;&nbsp; &nbsp;1.开源中国在线工具\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;https://wenzhang.baidu.com/\r\n&nbsp;&nbsp; &nbsp;2.在线工具\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://tool.lu/\r\n&nbsp;&nbsp; &nbsp;3.jar包下载\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://cn.jarfire.org/\r\n&nbsp;&nbsp; &nbsp;4.在线生成MyEclipse注册码\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://www.98key.com/index.jsp</pre>\r\nActiviti:<br><pre>&nbsp;&nbsp; &nbsp;1.Activiti工作流简单入门\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://my.oschina.net/Barudisshu/blog/309721\r\n&nbsp;&nbsp; &nbsp;2.Activiti初学者教程 \r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;http://blog.csdn.net/bluejoe2000/article/details/39521405</pre></p>', null, null, '2', 'OTHER', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('4', 'N', '2017-01-14 21:31:53', '2017-01-14 21:31:53', 'class12_teacher', 'class12_teacher', 'oracle小知识总结', '<p>一：锁表、线程：<br>\r\n</p><p>\r\n</p><p>&nbsp;&nbsp;&nbsp;&nbsp; 1.查看被锁的表：</p><pre><li class=\"alt\"><span class=\"keyword\">select</span>&nbsp;p.spid,&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.sid,&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.serial#,&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c.object_name,&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.session_id,&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.oracle_username,&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.os_user_name&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;<span class=\"keyword\">from</span>&nbsp;v$process&nbsp;p,&nbsp;v$session&nbsp;a,&nbsp;v$locked_object&nbsp;b,&nbsp;all_objects&nbsp;c&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;<span class=\"keyword\">where</span>&nbsp;p.addr&nbsp;=&nbsp;a.paddr&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;<span class=\"op\">and</span>&nbsp;a.process&nbsp;=&nbsp;b.process&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;<span class=\"op\">and</span>&nbsp;c.object_id&nbsp;=&nbsp;b.object_id; &nbsp;</li></pre><li class=\"alt\">2.查看线程：</li><pre><li class=\"alt\"><span class=\"keyword\">SELECT</span>&nbsp;sid,&nbsp;serial#,&nbsp;username,&nbsp;osuser&nbsp;<span class=\"keyword\">FROM</span>&nbsp;v$session; &nbsp;</li></pre><li class=\"alt\"> 3.杀掉线程：</li><li class=\"alt\"></li><pre><li class=\"alt\"><span class=\"comment\">--</span>&nbsp;&nbsp;</li><li class=\"\"><span class=\"keyword\">alter</span>&nbsp;system&nbsp;kill&nbsp;session&nbsp;<span class=\"string\">\'sid,serial#\'</span>;&nbsp;&nbsp;</li><li class=\"alt\"><span class=\"comment\">--eg:</span>&nbsp;&nbsp;</li><li class=\"\"><span class=\"keyword\">alter</span>&nbsp;system&nbsp;kill&nbsp;session&nbsp;<span class=\"string\">\'2277,10675\'</span>;&nbsp;</li></pre><li class=\"\">4.按月分组：</li><li class=\"\"></li><pre><li class=\"alt\">SELECT&nbsp;to_char(日期字段,\'yyyymm\'),sum(*)&nbsp;&nbsp;</li><li class=\"\">FROM&nbsp;[TableName]&nbsp;&nbsp;</li><li class=\"alt\">group&nbsp;by&nbsp;to_char(日期字段,\'yyyymm\');&nbsp;</li></pre>&nbsp;', null, null, '2', 'OTHER', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('5', 'N', '2017-01-14 21:33:42', '2017-01-14 21:36:22', 'class12_teacher', 'class12_teacher', 'Java小知识总结 （一）', '<p>1.ObjectOutputStream</p><p>&nbsp;&nbsp;&nbsp; 必须先输出才能使用ObjectInputStream读取，并且输出的时候是乱码。如果出现“拒绝访问”，将生成的文件不要放大盘符的根目录就行。</p><p>\r\n\r\n</p><p>&nbsp;&nbsp; 下面是一个简单案例：</p><pre><li class=\"alt\"><span class=\"keyword\">package</span>&nbsp;com.my.objectinputstream;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;</li><li class=\"alt\"><span class=\"keyword\">import</span>&nbsp;java.io.File;&nbsp;&nbsp;</li><li class=\"\"><span class=\"keyword\">import</span>&nbsp;java.io.FileInputStream;&nbsp;&nbsp;</li><li class=\"alt\"><span class=\"keyword\">import</span>&nbsp;java.io.FileOutputStream;&nbsp;&nbsp;</li><li class=\"\"><span class=\"keyword\">import</span>&nbsp;java.io.ObjectInputStream;&nbsp;&nbsp;</li><li class=\"alt\"><span class=\"keyword\">import</span>&nbsp;java.io.ObjectOutputStream;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;</li><li class=\"alt\"><span class=\"keyword\">public</span>&nbsp;<span class=\"keyword\">class</span>&nbsp;TestObjectStream&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">public</span>&nbsp;<span class=\"keyword\">static</span>&nbsp;<span class=\"keyword\">void</span>&nbsp;main(String[]&nbsp;args)&nbsp;{&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">try</span>&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ObjectOutputStream&nbsp;oos&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;ObjectOutputStream(<span class=\"keyword\">new</span>&nbsp;FileOutputStream(<span class=\"keyword\">new</span>&nbsp;File(<span class=\"string\">\"c:/zc/objectstream.dat\"</span>)));&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Animal&nbsp;a1&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;Animal(<span class=\"string\">\"tiger\"</span>,&nbsp;<span class=\"number\">120</span>,&nbsp;<span class=\"string\">\"red\"</span>,&nbsp;<span class=\"string\">\"cat\"</span>,&nbsp;<span class=\"number\">12</span>,&nbsp;<span class=\"number\">20</span>);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Animal&nbsp;a2&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;Animal(<span class=\"string\">\"eagle\"</span>,&nbsp;<span class=\"number\">10</span>,&nbsp;<span class=\"string\">\"gold\"</span>,&nbsp;<span class=\"string\">\"bird\"</span>,&nbsp;<span class=\"number\">6</span>,&nbsp;<span class=\"number\">10</span>);&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;oos.writeObject(a1);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;oos.writeObject(a2);&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;oos.flush();&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;oos.close();&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ObjectInputStream&nbsp;ois&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;ObjectInputStream(<span class=\"keyword\">new</span>&nbsp;FileInputStream(<span class=\"string\">\"c:/zc/objectstream.dat\"</span>));&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Animal&nbsp;ra1&nbsp;=&nbsp;(Animal)&nbsp;ois.readObject();&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(ra1.toString());&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Animal&nbsp;ra2&nbsp;=&nbsp;(Animal)&nbsp;ois.readObject();&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(ra2.toString());&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<span class=\"keyword\">catch</span>&nbsp;(Exception&nbsp;e)&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e.printStackTrace();&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"alt\">} &nbsp;</li></pre><li class=\"alt\">2.Java运行本地系统命令:</li><li class=\"alt\">&nbsp;下面是一个打开notepad++的简单案例：</li><li class=\"alt\"></li><pre><li class=\"alt\"><span class=\"keyword\">public</span>&nbsp;<span class=\"keyword\">static</span>&nbsp;<span class=\"keyword\">void</span>&nbsp;main(String[]&nbsp;args)<span class=\"keyword\">throws</span>&nbsp;Exception&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;Runtime.getRuntime().exec(<span class=\"string\">\"C:\\\\Program&nbsp;Files&nbsp;(x86)\\\\Notepad++\\\\notepad++\"</span>);&nbsp;&nbsp;</li><li class=\"alt\">} &nbsp;</li></pre><li class=\"alt\">&nbsp;<span style=\"line-height: 1.42857;\">3.唯一索引的好处：</span>\r\n<pre>&nbsp; 比如一个数据列，不能作为主键，而且允许为空，但是业务上要求唯一特性。这时候使用唯一性索引就是最好的选择</pre></li>', null, null, '2', 'J2SE', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('6', 'N', '2017-01-14 21:34:48', '2017-01-14 21:36:57', 'class12_teacher', 'class12_teacher', 'Java小知识总结 （二）', '<p>6.spring装载SimpleDateFormate实现统一格式：</p><pre><li class=\"alt\">&lt;!--&nbsp;配置时间格式化器&nbsp;--&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&lt;bean&nbsp;id=<span class=\"string\">\"dateFormatter\"</span>&nbsp;<span class=\"keyword\">class</span>=<span class=\"string\">\"java.text.SimpleDateFormat\"</span>&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&lt;constructor-arg&nbsp;value=<span class=\"string\">\"yyyy-MM-dd&nbsp;HH:mm:ss\"</span>/&gt;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&lt;/bean&gt;&nbsp;</li></pre><li class=\"\">7.java查找同税率同OU的发票：</li><li class=\"\"></li><pre><li class=\"alt\"><span class=\"comment\">/**</span>&nbsp;</li><li class=\"\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;按照税率和OU对发票分组</span>&nbsp;</li><li class=\"alt\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;@param&nbsp;invoices&nbsp;发票数组</span>&nbsp;</li><li class=\"\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;@return&nbsp;map对象</span>&nbsp;</li><li class=\"alt\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*/</span>&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">private</span>&nbsp;HashMap&lt;String,&nbsp;List&lt;GwsInvoice&gt;&gt;&nbsp;groupByOrgIdAndRate(List&lt;GwsInvoice&gt;&nbsp;invoices){&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"comment\">//&nbsp;根据税率和部门将发票拆分为不同的数组</span>&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HashMap&lt;String,&nbsp;List&lt;GwsInvoice&gt;&gt;&nbsp;invoicesWithOrgAndRate&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;HashMap&lt;String,&nbsp;List&lt;GwsInvoice&gt;&gt;();&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">for</span>&nbsp;(GwsInvoice&nbsp;invoice&nbsp;:&nbsp;invoices)&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List&lt;GwsInvoice&gt;&nbsp;list&nbsp;=&nbsp;invoicesWithOrgAndRate.get(invoice.getTaxRate()&nbsp;+&nbsp;DELIMITER&nbsp;+&nbsp;invoice.getOrgId());&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">if</span>&nbsp;(list&nbsp;==&nbsp;<span class=\"keyword\">null</span>)&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;list&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;ArrayList&lt;GwsInvoice&gt;();&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;invoicesWithOrgAndRate.put(invoice.getTaxRate()&nbsp;+&nbsp;DELIMITER&nbsp;+&nbsp;invoice.getOrgId(),&nbsp;list);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;list.add(invoice);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">return</span>&nbsp;invoicesWithOrgAndRate;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;</li></pre><li class=\"\">8.java遇到字符乱码时截取字符串：</li><li class=\"\"></li><pre><li class=\"alt\"><span class=\"keyword\">public</span>&nbsp;<span class=\"keyword\">static</span>&nbsp;String&nbsp;substring(String&nbsp;str,&nbsp;<span class=\"keyword\">int</span>&nbsp;size)&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">try</span>&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">if</span>&nbsp;(str.getBytes(<span class=\"string\">\"UTF-8\"</span>).length&gt;&nbsp;size)&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;str&nbsp;=&nbsp;str.substring(<span class=\"number\">0</span>,&nbsp;str.length()&nbsp;-&nbsp;<span class=\"number\">1</span>);&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;str&nbsp;=&nbsp;substring(str,&nbsp;size);&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<span class=\"keyword\">catch</span>&nbsp;(UnsupportedEncodingException&nbsp;e)&nbsp;{&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"comment\">//&nbsp;TODO&nbsp;Auto-generated&nbsp;catch&nbsp;block&nbsp;&nbsp;</span>&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e.printStackTrace();&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">return</span>&nbsp;str;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;</li></pre><li class=\"\"><br></li>', null, null, '2', 'J2SE', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('7', 'N', '2017-01-14 21:35:57', '2017-01-14 21:35:57', 'class12_teacher', 'class12_teacher', '使用Oracle数据库in(xx,xx,xx) 大于1000时的解决方法', '<pre><li class=\"alt\"><span class=\"keyword\">public</span>&nbsp;<span class=\"keyword\">class</span>&nbsp;OracleSQLInUtil&nbsp;{&nbsp;&nbsp;</li><li class=\"\"><span style=\"line-height: 1.42857;\">&nbsp; &nbsp;&nbsp;</span><span class=\"keyword\" style=\"line-height: 1.42857;\">public</span><span style=\"line-height: 1.42857;\">&nbsp;</span><span class=\"keyword\" style=\"line-height: 1.42857;\">static</span><span style=\"line-height: 1.42857;\">&nbsp;&nbsp;String&nbsp;getOracleSQLIn(List&nbsp;ids,&nbsp;</span><span class=\"keyword\" style=\"line-height: 1.42857;\">int</span><span style=\"line-height: 1.42857;\">&nbsp;count,&nbsp;String&nbsp;field)&nbsp;{ &nbsp;</span></li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;count&nbsp;=&nbsp;Math.min(count,&nbsp;<span class=\"number\">1000</span>);&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">int</span>&nbsp;len&nbsp;=&nbsp;ids.size();&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">int</span>&nbsp;size&nbsp;=&nbsp;len&nbsp;%&nbsp;count;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">if</span>&nbsp;(size&nbsp;==&nbsp;<span class=\"number\">0</span>)&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;size&nbsp;=&nbsp;len&nbsp;/&nbsp;count;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<span class=\"keyword\">else</span>&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;size&nbsp;=&nbsp;(len&nbsp;/&nbsp;count)&nbsp;+&nbsp;<span class=\"number\">1</span>;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;StringBuilder&nbsp;builder&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;StringBuilder();&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">for</span>&nbsp;(<span class=\"keyword\">int</span>&nbsp;i&nbsp;=&nbsp;<span class=\"number\">0</span>;&nbsp;i&nbsp;&lt;&nbsp;size;&nbsp;i++)&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">int</span>&nbsp;fromIndex&nbsp;=&nbsp;i&nbsp;*&nbsp;count;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">int</span>&nbsp;toIndex&nbsp;=&nbsp;Math.min(fromIndex&nbsp;+&nbsp;count,&nbsp;len);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List&nbsp;subList=<span class=\"keyword\">new</span>&nbsp;ArrayList();&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;subList=ids.subList(fromIndex,&nbsp;toIndex);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String&nbsp;result=<span class=\"string\">\"\"</span>;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">for</span>&nbsp;(<span class=\"keyword\">int</span>&nbsp;j&nbsp;=&nbsp;<span class=\"number\">0</span>;&nbsp;j&nbsp;&lt;&nbsp;subList.size();&nbsp;j++)&nbsp;{&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Object&nbsp;obj=subList.get(j);&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;result+=<span class=\"string\">\"\'\"</span>+obj.toString()+<span class=\"string\">\"\',\"</span>;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;result=result.substring(<span class=\"number\">1</span>,&nbsp;result.length()-<span class=\"number\">2</span>);&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String&nbsp;productId&nbsp;=&nbsp;StringUtils.defaultIfEmpty(result,&nbsp;<span class=\"string\">\"\"</span>);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">if</span>&nbsp;(i&nbsp;!=&nbsp;<span class=\"number\">0</span>)&nbsp;{&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;builder.append(<span class=\"string\">\"&nbsp;or&nbsp;\"</span>);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;builder.append(field).append(<span class=\"string\">\"&nbsp;in&nbsp;(\'\"</span>).append(productId).append(<span class=\"string\">\"\')\"</span>);&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">return</span>&nbsp;StringUtils.defaultIfEmpty(builder.toString(),&nbsp;field&nbsp;+&nbsp;<span class=\"string\">\"&nbsp;in&nbsp;(\'\')\"</span>);&nbsp;&nbsp;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"comment\">/*public&nbsp;static&nbsp;void&nbsp;main(String[]&nbsp;args)&nbsp;{</span>&nbsp;</li><li class=\"alt\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String&nbsp;uuid=\"(\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\',\'10\',\'11\',\'12\',\'13\',\'14\',\'15\',\'16\',\'17\',\'18\',\'19\')\";</span>&nbsp;</li><li class=\"\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;</li><li class=\"alt\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;</li><li class=\"\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String[]&nbsp;arr&nbsp;=&nbsp;uuid.substring(1,&nbsp;uuid.length()-1).replace(\"\'\",&nbsp;\"\").split(\",\");</span>&nbsp;</li><li class=\"alt\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String&nbsp;inHql=OracleSQLInUtil.getOracleSQLIn2(Arrays.asList(arr),3,\"a.mini_Trans_Basic_Cntr_Uuid\");</span>&nbsp;</li><li class=\"\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(inHql);</span>&nbsp;</li><li class=\"alt\"><span class=\"comment\">&nbsp;&nbsp;&nbsp;&nbsp;}*/</span>&nbsp;&nbsp;</li><li class=\"\">} &nbsp;</li></pre>', null, null, '2', 'OTHER', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('8', 'N', '2017-02-07 21:00:17', '2017-02-07 21:00:17', 'teacher', 'teacher', '指南针项目需求', '<p>项目背景：</p><p>集团财务预测编制流程涉及财务同学人数多时间短，每月需要消耗大量时间调整底稿及上传数据；</p><p>结合今年财务四大战役，专注提升财务预测流程效率，充分解放财务同学的生产力，不做数据的搬运工，让财务同学更多的完成深入的分析；</p><p>系统化的定制财务数据分析，挖掘分析价值，高效的支持决策；</p><p>项目目标：</p><p>总体目标：</p><p>实现实际、预算、预测全面数仓建设，为预测、预算提供基础数据保障；</p><p>提炼、沉淀预测逻辑，实现预测流程管理、自动化预测（包括业务预测）及多维度财务报表，提高预测准确度及分析决策数据（完成集团多数业务的自动化预测链路后，预计节省3FTE）；</p><p>创新型的建立数据提取、分析的自动化模型，同时能支持其他业务类分析；</p><p>分阶段目标：</p><p>项目一期（本期）：</p><p>完成集团预测工作流自动化，优化预测链路，将预测流程线上化；</p><p>简化手工环节，如报表分拆，传递，审批，合并等，合并结果实时可见，同时做到单点分险可配置可预警；</p><p>沉淀所有指标和各个操作节点上的历史数据，做到历史数据可追溯；</p><p>有效缩短每个汇报周期25%（收入预测及Full P&amp;L两轮编制更节省1天）；</p><p>项目二期（待定）-业务数据直连：消除业务数据来源的多样性，实现数据的集中展示。抽取，清洗和导入预测所需业务数据；标准化数据字典，自动校验数据；形成预测数据仓库，支持决策分析</p><p>项目三期（待定）-预测逻辑内建：提炼和沉淀预测逻辑，把预测“艺术”变为“科学”。简化和标准化预测方法；消除因不同操作人和方法而导致的预测差异；利用数据模型提高预测准确度</p><p>项目涉众（Stakeholder）</p><p>用户方：BU财务、X线财务、集团FP&amp;A</p><p>业务方接口人：集团SSC-大任</p><p>技术团队：核心业务、信息平台前端/交互</p>', null, null, '2', 'OTHER', 'Y');
INSERT INTO `qa_recommend_file` VALUES ('9', 'N', '2017-02-08 21:50:30', '2017-02-08 21:50:30', 'teacher', 'teacher', 'java构建树结构常用方法（二）', '<pre>/**\r\n	 * 获取某个父节点下面的所有子节点\r\n	 */\r\n	private void getAllChildNodesRecursion(List&lt;DimensionValueDto&gt; dimensionValues, CnsDimensionValue parentDimensionValue,\r\n			List&lt;DimensionValueDto&gt; allChildDimensionValues) {\r\n		for (DimensionValueDto dimensionValue : dimensionValues) {\r\n			if (StringUtils.isNotEmpty(dimensionValue.getParentCode()) &amp;&amp; dimensionValue.getParentCode().equals(parentDimensionValue.getCode())\r\n					&amp;&amp; dimensionValue.getDimensionCode().equals(parentDimensionValue.getDimensionCode())) {\r\n				getAllChildNodesRecursion(dimensionValues, dimensionValue, allChildDimensionValues);\r\n				allChildDimensionValues.add(dimensionValue);\r\n			}\r\n		}\r\n	}\r\n\r\n	@Override\r\n	public List&lt;DimensionValueDto&gt; getAllChildNodes(List&lt;DimensionValueDto&gt; dimensionValues, CnsDimensionValue childDimensionValue) {\r\n		List&lt;DimensionValueDto&gt; allChildDimensionValues = new ArrayList&lt;DimensionValueDto&gt;();\r\n		getAllChildNodesRecursion(dimensionValues, childDimensionValue, allChildDimensionValues);\r\n		return allChildDimensionValues;\r\n	}</pre><pre>/**\r\n	 * 找到某个子节点的所有父节点\r\n	 * \r\n	 * @param dimensionValues\r\n	 * @param dimensionValue\r\n	 * @return\r\n	 */\r\n	private void getAllParentNodesRecursion(List&lt;DimensionValueDto&gt; dimensionValues, DimensionValueDto dimensionValue,\r\n			List&lt;DimensionValueDto&gt; allParentDimensionValues) {\r\n		for (DimensionValueDto dimensionValueDto : dimensionValues) {\r\n			if (StringUtils.isEmpty(dimensionValue.getParentCode())) {\r\n				break;\r\n			}\r\n			if (dimensionValueDto.getCode().equals(dimensionValue.getParentCode())\r\n					&amp;&amp; dimensionValueDto.getDimensionCode().equals(dimensionValue.getDimensionCode())) {\r\n				allParentDimensionValues.add(dimensionValueDto);\r\n				getAllParentNodesRecursion(dimensionValues, dimensionValueDto, allParentDimensionValues);\r\n			}\r\n		}\r\n	}\r\n\r\n	@Override\r\n	public List&lt;DimensionValueDto&gt; getAllParentNodes(List&lt;DimensionValueDto&gt; dimensionValues, DimensionValueDto dimVals) {\r\n		List&lt;DimensionValueDto&gt; allParentDimensionValues = new ArrayList&lt;DimensionValueDto&gt;();\r\n		getAllParentNodesRecursion(dimensionValues, dimVals, allParentDimensionValues);\r\n		return allParentDimensionValues;\r\n	}</pre>', null, null, '2', 'OTHER', 'Y');

-- ----------------------------
-- Table structure for qa_resources
-- ----------------------------
DROP TABLE IF EXISTS `qa_resources`;
CREATE TABLE `qa_resources` (
  `id` bigint(255) NOT NULL auto_increment,
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `name` varchar(255) default NULL COMMENT '资源名称',
  `parent_id` bigint(255) default NULL COMMENT '父类Id',
  `res_key` varchar(50) default NULL COMMENT '资源Key',
  `type` varchar(10) default NULL COMMENT '权限类型，0．表示目录　1，表示菜单．2，表示按扭 3 , 首页的显示',
  `res_url` varchar(200) default NULL COMMENT '资源链接',
  `level` int(11) default NULL COMMENT '级别',
  `description` varchar(200) default NULL COMMENT '描述',
  `status` varchar(40) default NULL COMMENT '权限状态（可以回收权限）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='权限-资源表';

-- ----------------------------
-- Records of qa_resources
-- ----------------------------
INSERT INTO `qa_resources` VALUES ('1', 'N', '2016-09-10 15:03:28', '2016-09-10 15:30:20', 'system', 'system', '问题管理', '1', 'RES_MENU_QUESTION_MANAGE_TEA', '0', '', '1', '问题管理', null);
INSERT INTO `qa_resources` VALUES ('2', 'N', '2016-09-10 15:03:28', '2016-09-10 15:30:20', 'system', 'system', '学长情况', '2', 'RES_MENU_GRAD_SITUATION', '0', '', '2', '学长情况', null);
INSERT INTO `qa_resources` VALUES ('3', 'N', '2016-09-10 15:03:28', '2016-09-10 15:30:20', 'system', 'system', '资料管理', '3', 'RES_MENU_RECOMMEND_FILE', '0', '', '3', '资料管理', null);
INSERT INTO `qa_resources` VALUES ('4', 'N', '2016-09-10 15:03:28', '2016-09-10 15:30:20', 'system', 'system', '系统管理', '4', 'RES_MENU_SYSTEM', '0', '', '4', '系统管理', null);
INSERT INTO `qa_resources` VALUES ('5', 'N', '2016-09-10 15:03:28', '2016-09-10 15:30:20', 'system', 'system', '考试管理', '5', 'RES_MENU_EXAM', '0', '', '5', '考试管理', null);
INSERT INTO `qa_resources` VALUES ('6', 'N', '2016-09-10 15:08:53', '2016-09-10 15:30:20', 'system', 'system', '数据管理', '6', 'RES_MENU_SYSTEM_DATA', '0', '', '6', '数据管理', null);
INSERT INTO `qa_resources` VALUES ('7', 'N', '2016-09-10 15:29:33', '2016-09-10 15:30:20', 'system', 'system', '问题列表', '1', 'RES_MENU_QUESTION_TEA_LIST', '1', '/qaplus/teacher/teaQuestionList/teaQuestionList.jsp', '7', '教师问题列表', null);
INSERT INTO `qa_resources` VALUES ('8', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '问题列表', '1', 'RES_MENU_QUESTION_STU_LIST', '1', '/qaplus/student/stuQuestionList/stuQuestionList.jsp', '2', '学生问题列表', null);
INSERT INTO `qa_resources` VALUES ('9', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '我要提问', '1', 'RES_MENU_STU_ADD_QUESTION', '1', '/qaplus/student/stuAddQuestion/stuAddQuestion.jsp', '2', '学生提问', null);
INSERT INTO `qa_resources` VALUES ('10', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '我要回答', '1', 'RES_MENU_TEA_ANSWER_QUESTION', '1', '/qaplus/teacher/teaAnswerQuestion/teaAnswerQuestion.jsp', '2', '教师回答', null);
INSERT INTO `qa_resources` VALUES ('11', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '问题图表', '1', 'RES_MENU_QUEATION_CHART', '1', '/qaplus/teacher/questionChart/questionChart.jsp', '2', '问题图表', null);
INSERT INTO `qa_resources` VALUES ('12', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '学长就业情况', '2', 'RES_MENU_GRAD_SITUATION', '1', '', '2', '我的资料', null);
INSERT INTO `qa_resources` VALUES ('13', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '就业心得', '2', 'RES_MENU_GRAD_GET', '1', '', '2', '就业心得', null);
INSERT INTO `qa_resources` VALUES ('14', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '谈谈就业心得', '2', 'RES_MENU_GRAD_ADD', '1', '', '2', '谈谈就业心得', null);
INSERT INTO `qa_resources` VALUES ('15', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '资料列表', '3', 'RES_MENU_FILE_LIST', '1', '/qaplus/user/recommendFile/recommendFile.jsp', '2', '资料列表', null);
INSERT INTO `qa_resources` VALUES ('16', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '添加资料', '3', 'RES_MENU_ADD_FILE', '1', '/qaplus/user/addRecommend/addRecommend.jsp', '2', '添加资料', null);
INSERT INTO `qa_resources` VALUES ('18', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '操作日志', '4', 'RES_MENU_OPERATE_LOG', '1', '/qaplus/teacher/rightLog/rightLog.jsp', '2', '操作日志', null);
INSERT INTO `qa_resources` VALUES ('19', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '错误日志', '4', 'RES_MENU_ERROR_LOG', '1', '/qaplus/teacher/errorLog/errorLog.jsp', '2', '错误日志', null);
INSERT INTO `qa_resources` VALUES ('20', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '我的成绩', '5', 'RES_MENU_MY_SCORE', '1', '/qaplus/student/stuScore/stuScore.jsp', '2', '我的成绩', null);
INSERT INTO `qa_resources` VALUES ('22', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '习题练习', '5', 'RES_MENU_MY_EXERCISE', '1', '', '2', '习题练习', null);
INSERT INTO `qa_resources` VALUES ('24', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '我的试卷', '5', 'RES_MENU_MY_PAPER', '1', '/qaplus/student/stuPaperList/stuPaperList.jsp', '2', '我的试卷', null);
INSERT INTO `qa_resources` VALUES ('26', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '制作试卷', '5', 'RES_MENU_MAKE_PAPER', '1', '/qaplus/teacher/teaMakePaper/teaMakePaper.jsp', '2', '制作试卷', null);
INSERT INTO `qa_resources` VALUES ('27', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '查看试卷', '5', 'RES_MENU_VIEW_PAPER', '1', '/qaplus/teacher/paperManage/paperManage.jsp', '2', '查看试卷', null);
INSERT INTO `qa_resources` VALUES ('31', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '班级维护', '6', 'RES_MENU_CLASS_UPDATE', '1', '/qaplus/teacher/classList/classList.jsp', '2', '班级维护', null);
INSERT INTO `qa_resources` VALUES ('32', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '用户维护', '6', 'RES_MENU_USER_UPDATE', '1', '/qaplus/teacher/userList/userList.jsp', '2', '用户维护', null);
INSERT INTO `qa_resources` VALUES ('33', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '未解决问题', '33', 'RES_HOME_MY_PROBLEM_STU', '3', '/qaplus/student/stuQuestionList/stuQuestionList.jsp', '2', 'glyphicon glyphicon-question-sign', null);
INSERT INTO `qa_resources` VALUES ('34', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '学生提问', '34', 'RES_HOME_MY_PROBLEM_TEA', '3', '/qaplus/teacher/teaQuestionList/teaQuestionList.jsp', '2', 'glyphicon glyphicon-question-sign', null);
INSERT INTO `qa_resources` VALUES ('35', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '就业信息', '35', 'RES_HOME_GRAD_SITUATION', '3', '就业信息', '2', 'glyphicon glyphicon-info-sign', null);
INSERT INTO `qa_resources` VALUES ('36', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '待办事项', '36', 'RES_HOME_UNDO_TASK', '3', '/qaplus/user/undoTask/undoTask.jsp', '2', 'glyphicon glyphicon-tasks', null);
INSERT INTO `qa_resources` VALUES ('37', 'Y', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '待办事项', '37', 'RES_HOME_UNDO_TASK_TEA', '3', '', '2', '待办事项公用就可以了', null);
INSERT INTO `qa_resources` VALUES ('38', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '就业心得', '38', 'RES_HOME_GRAD_GET', '3', '', '2', 'glyphicon glyphicon-thumbs-up', null);
INSERT INTO `qa_resources` VALUES ('39', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '资料管理', '38', 'RES_HOME_RESOURCE', '3', '/qaplus/user/recommendFile/recommendFile.jsp', '2', 'glyphicon glyphicon-file', null);
INSERT INTO `qa_resources` VALUES ('40', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '未处理学生作业', '38', 'RES_HOME_RESOURCE_STU', '3', '/qaplus/student/stuHomeworkList/stuHomeworkList.jsp', '2', 'glyphicon glyphicon-book', null);
INSERT INTO `qa_resources` VALUES ('41', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '布置作业', '38', 'RES_HOME_RESOURCE_TEA', '3', '/qaplus/teacher/homeworkManage/homeworkManage.jsp', '2', 'glyphicon glyphicon-book', null);
INSERT INTO `qa_resources` VALUES ('42', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '我的题库', '1', 'RES_MENU_TEA_QUESTION_LIST', '1', '/qaplus/teacher/teaQuestionBank/teaQuestionBank.jsp', '2', '我的题库', null);
INSERT INTO `qa_resources` VALUES ('43', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '作业管理', '1', 'RES_MENU_TEA_HOMEWORK_MANAGE', '1', '/qaplus/teacher/homeworkManage/homeworkManage.jsp', '2', '老师管理家庭作业', null);
INSERT INTO `qa_resources` VALUES ('44', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '考试题库', '5', 'RES_MENU_EXAM_QUESTION', '1', '/qaplus/teacher/examQuestion/examQuestion.jsp', '2', '考试题库', null);
INSERT INTO `qa_resources` VALUES ('45', 'N', '2016-09-10 15:29:37', '2016-09-10 15:30:23', 'system', 'system', '我的错题', '5', 'RES_MENU_MY_ERROR_QUESTIONS', '1', '/qaplus/student/errorQuestions/errorQuestions.jsp', '2', '我的错题', '');

-- ----------------------------
-- Table structure for qa_resources_role
-- ----------------------------
DROP TABLE IF EXISTS `qa_resources_role`;
CREATE TABLE `qa_resources_role` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `resc_id` bigint(255) NOT NULL COMMENT '资源ID',
  `role_id` bigint(255) NOT NULL COMMENT '角色ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='角色资源对应表';

-- ----------------------------
-- Records of qa_resources_role
-- ----------------------------
INSERT INTO `qa_resources_role` VALUES ('2', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '8', '1');
INSERT INTO `qa_resources_role` VALUES ('3', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '9', '1');
INSERT INTO `qa_resources_role` VALUES ('5', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '15', '1');
INSERT INTO `qa_resources_role` VALUES ('6', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '16', '1');
INSERT INTO `qa_resources_role` VALUES ('7', 'N', '2016-09-10 16:52:14', '2016-09-10 16:52:19', 'system', 'system', '12', '1');
INSERT INTO `qa_resources_role` VALUES ('8', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:21', 'system', 'system', '13', '1');
INSERT INTO `qa_resources_role` VALUES ('9', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '20', '1');
INSERT INTO `qa_resources_role` VALUES ('11', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '22', '1');
INSERT INTO `qa_resources_role` VALUES ('13', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '24', '1');
INSERT INTO `qa_resources_role` VALUES ('14', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '30', '1');
INSERT INTO `qa_resources_role` VALUES ('25', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '17', '1');
INSERT INTO `qa_resources_role` VALUES ('26', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '2', '1');
INSERT INTO `qa_resources_role` VALUES ('27', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '3', '1');
INSERT INTO `qa_resources_role` VALUES ('28', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '5', '1');
INSERT INTO `qa_resources_role` VALUES ('29', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '6', '1');
INSERT INTO `qa_resources_role` VALUES ('30', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '1', '1');
INSERT INTO `qa_resources_role` VALUES ('37', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '1', '2');
INSERT INTO `qa_resources_role` VALUES ('38', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '2', '2');
INSERT INTO `qa_resources_role` VALUES ('39', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '3', '2');
INSERT INTO `qa_resources_role` VALUES ('40', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '4', '2');
INSERT INTO `qa_resources_role` VALUES ('41', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '5', '2');
INSERT INTO `qa_resources_role` VALUES ('42', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '6', '2');
INSERT INTO `qa_resources_role` VALUES ('43', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '7', '2');
INSERT INTO `qa_resources_role` VALUES ('44', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '10', '2');
INSERT INTO `qa_resources_role` VALUES ('45', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '11', '2');
INSERT INTO `qa_resources_role` VALUES ('46', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '15', '2');
INSERT INTO `qa_resources_role` VALUES ('47', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '16', '2');
INSERT INTO `qa_resources_role` VALUES ('48', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '17', '2');
INSERT INTO `qa_resources_role` VALUES ('49', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '12', '2');
INSERT INTO `qa_resources_role` VALUES ('50', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '13', '2');
INSERT INTO `qa_resources_role` VALUES ('51', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '18', '2');
INSERT INTO `qa_resources_role` VALUES ('52', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '19', '2');
INSERT INTO `qa_resources_role` VALUES ('53', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '25', '2');
INSERT INTO `qa_resources_role` VALUES ('54', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '26', '2');
INSERT INTO `qa_resources_role` VALUES ('55', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '27', '2');
INSERT INTO `qa_resources_role` VALUES ('58', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '31', '2');
INSERT INTO `qa_resources_role` VALUES ('59', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '32', '2');
INSERT INTO `qa_resources_role` VALUES ('66', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '13', '2');
INSERT INTO `qa_resources_role` VALUES ('67', 'N', '2016-09-10 17:14:10', '2016-09-10 17:14:10', 'system', 'system', '18', '2');
INSERT INTO `qa_resources_role` VALUES ('68', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '19', '2');
INSERT INTO `qa_resources_role` VALUES ('120', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '33', '1');
INSERT INTO `qa_resources_role` VALUES ('121', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '35', '1');
INSERT INTO `qa_resources_role` VALUES ('122', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '36', '1');
INSERT INTO `qa_resources_role` VALUES ('123', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '38', '1');
INSERT INTO `qa_resources_role` VALUES ('124', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '39', '1');
INSERT INTO `qa_resources_role` VALUES ('125', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '40', '1');
INSERT INTO `qa_resources_role` VALUES ('132', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '34', '2');
INSERT INTO `qa_resources_role` VALUES ('133', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '35', '2');
INSERT INTO `qa_resources_role` VALUES ('134', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '36', '2');
INSERT INTO `qa_resources_role` VALUES ('135', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '38', '2');
INSERT INTO `qa_resources_role` VALUES ('136', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '39', '2');
INSERT INTO `qa_resources_role` VALUES ('137', 'N', '2016-09-10 16:52:24', '2016-09-10 16:52:24', 'system', 'system', '41', '2');
INSERT INTO `qa_resources_role` VALUES ('138', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '42', '2');
INSERT INTO `qa_resources_role` VALUES ('139', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '43', '2');
INSERT INTO `qa_resources_role` VALUES ('140', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '44', '2');
INSERT INTO `qa_resources_role` VALUES ('141', 'N', '2016-09-10 17:14:08', '2016-09-10 17:14:10', 'system', 'system', '45', '1');

-- ----------------------------
-- Table structure for qa_role
-- ----------------------------
DROP TABLE IF EXISTS `qa_role`;
CREATE TABLE `qa_role` (
  `id` bigint(255) NOT NULL auto_increment,
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `name` varchar(255) default NULL COMMENT '角色名称',
  `role_key` varchar(50) default NULL COMMENT '角色Key',
  `description` varchar(500) default NULL COMMENT '角色描述',
  `enable` char(1) default NULL COMMENT '是否可用（Y-可用 N-不可用）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of qa_role
-- ----------------------------
INSERT INTO `qa_role` VALUES ('1', 'N', '2016-09-10 15:03:28', '2016-09-10 15:03:28', 'system', 'system', '在校学生', 'ROLE_STU', '在校学生', 'Y');
INSERT INTO `qa_role` VALUES ('2', 'N', '2016-09-10 15:03:28', '2016-09-10 15:03:28', 'system', 'system', '老师', 'ROLE_TEA', '老师', 'Y');

-- ----------------------------
-- Table structure for qa_s_question
-- ----------------------------
DROP TABLE IF EXISTS `qa_s_question`;
CREATE TABLE `qa_s_question` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `title` varchar(255) default NULL COMMENT '问题标题',
  `question_content` varchar(4000) default NULL COMMENT '问题内容',
  `answer_content` varchar(4000) default NULL COMMENT '答案内容',
  `is_solve` char(1) default 'N' COMMENT '是否解决',
  `question_has_attachment` char(1) default NULL COMMENT '问题是否有附件',
  `answer_has_attachment` char(1) default NULL COMMENT '回答是否要附件',
  `answer_attachment_id` bigint(255) default NULL COMMENT '回答附件路劲',
  `question_attachment_id` bigint(255) default NULL COMMENT '问题附件名称',
  `category` varchar(50) default NULL COMMENT '分类',
  `need_face_comm` char(1) default NULL COMMENT '是否需要当面交流',
  `solve_time` datetime default NULL COMMENT '解决时间',
  `question_person` bigint(255) default NULL COMMENT '提问者',
  `solve_person` bigint(255) default NULL COMMENT '解决者',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='学生问题表';

-- ----------------------------
-- Records of qa_s_question
-- ----------------------------
INSERT INTO `qa_s_question` VALUES ('13', 'N', '2017-01-15 17:34:53', '2017-01-15 17:58:07', 'class12_teacher', 'class1_user1', '下列Object类中的方法，哪一项不是完全跟线程有关：', '下列Object类中的方法，哪一项不是完全跟线程有关：\r\nA．String toString()\r\n\r\nB．void notify()\r\n\r\nC．void notifyAll()\r\n\r\nD．void wait()', '<p>答案选：A</p>', 'Y', null, null, null, null, 'J2SE', 'N', '2017-01-15 17:58:07', '1', '2');
INSERT INTO `qa_s_question` VALUES ('14', 'N', '2017-01-15 17:35:24', '2017-02-04 14:14:25', 'teacher', 'class1_user1', '在Java语言中，下列哪些语句关于内存回收的说明是正确的?', '在Java语言中，下列哪些语句关于内存回收的说明是正确的?\r\nA．程序员必须创建一个线程来释放内存；\r\n\r\nB．内存回收程序负责释放无用内存\r\n\r\nC．内存回收程序允许程序员直接释放内存\r\n\r\nD．内存回收程序可以在指定的时间释放内存对象', '', 'Y', null, null, null, null, 'J2SE', 'N', '2017-02-04 14:14:25', '1', '2');
INSERT INTO `qa_s_question` VALUES ('15', 'N', '2017-01-31 09:26:57', '2017-01-31 09:35:17', 'teacher', 'student1', '这是一个问题', '这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题这是一个问题', '<p>这是老师的回答<span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span><span style=\"line-height: 1.42857;\">这是老师的回答</span></p>', 'Y', 'Y', 'Y', '227', '226', 'DEV_TOOL', 'N', '2017-01-31 09:35:17', '1', '2');
INSERT INTO `qa_s_question` VALUES ('16', 'N', '2017-01-31 12:50:22', '2017-01-31 12:54:05', 'teacher', 'add_test', 'add_test用户提问', 'add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问add_test用户提问', '<p>这是老师给你的add_test的答案<span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span><span style=\"line-height: 1.42857;\">这是老师给你的add_test的答案</span></p>', 'Y', 'Y', null, null, '229', 'FRONT', 'Y', '2017-01-31 12:54:05', '7', '2');
INSERT INTO `qa_s_question` VALUES ('17', 'N', '2017-02-18 15:46:37', '2017-02-18 15:46:37', 'student1', 'student1', '测试发邮件', '测试发邮件', null, 'N', 'Y', null, null, '240', 'DEV_TOOL', 'N', null, '1', '2');
INSERT INTO `qa_s_question` VALUES ('18', 'N', '2017-02-18 15:53:23', '2017-02-18 15:53:23', 'student1', 'student1', '测试发邮件2', '测试发邮件2', null, 'N', 'Y', null, null, '241', 'JQUERY', 'Y', null, '1', '2');
INSERT INTO `qa_s_question` VALUES ('19', 'N', '2017-03-04 12:28:43', '2017-03-04 12:28:43', 'student1', 'student1', '动态分类测试', '动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试', null, 'N', 'Y', null, null, '242', 'JQUERY', 'N', null, '1', '2');
INSERT INTO `qa_s_question` VALUES ('20', 'N', '2017-03-04 12:39:38', '2017-03-04 12:39:38', 'student1', 'student1', '这次选择了JQUERY', '这是描述', null, 'N', 'Y', null, null, '243', 'JQUERY', 'N', null, '1', '2');
INSERT INTO `qa_s_question` VALUES ('21', 'N', '2017-03-05 14:53:50', '2017-03-05 14:53:50', 'student1', 'student1', '学生一  添加问题 测试 标题（附件是:Linux虚拟机图片）', '学生一  添加问题 测试 问题描述（Other）\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述', null, 'N', 'Y', null, null, '244', 'OTHER', 'N', null, '1', '2');
INSERT INTO `qa_s_question` VALUES ('22', 'N', '2017-03-05 14:56:36', '2017-03-05 14:56:36', 'student1', 'student1', '5.测试发邮件', '5.测试发邮件', null, 'N', null, null, null, null, 'J2SE', 'N', null, '1', '2');
INSERT INTO `qa_s_question` VALUES ('23', 'N', '2017-03-05 14:58:33', '2017-03-05 15:44:15', 'teacher', 'student1', '学生一 添加问题 测试 标题（附件是:Linux虚拟机图片）', '学生一 添加问题 测试 问题描述（Other） 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述', '<p><font color=\"#c80000\" face=\"Consolas, Lucida Console, Courier New, monospace\"><span style=\"font-size: 12px;\">这个就是答案 &nbsp;怎么这个颜色，有附件 a.jpg</span></font></p>', 'Y', 'Y', 'Y', '246', '245', 'J2SE', 'N', '2017-03-05 15:44:15', '1', '2');

-- ----------------------------
-- Table structure for qa_score
-- ----------------------------
DROP TABLE IF EXISTS `qa_score`;
CREATE TABLE `qa_score` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `score` int(3) default NULL COMMENT '分数',
  `paper_id` bigint(255) default NULL COMMENT '试卷ID（记得计算：班级和试卷的最高分、最低分、平均分）',
  `stu_id` bigint(255) default NULL COMMENT '学生ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='学生分数表';

-- ----------------------------
-- Records of qa_score
-- ----------------------------
INSERT INTO `qa_score` VALUES ('22', 'N', '2017-01-15 14:01:33', '2017-01-15 14:01:33', 'class1_user1', 'class1_user1', '4', '14', '1');
INSERT INTO `qa_score` VALUES ('23', 'N', '2017-01-15 21:12:25', '2017-01-15 21:12:25', 'system', 'system', '0', '14', '4');
INSERT INTO `qa_score` VALUES ('24', 'N', '2017-01-15 22:25:27', '2017-01-15 22:25:27', 'system', 'system', '0', '18', '1');
INSERT INTO `qa_score` VALUES ('25', 'N', '2017-01-15 22:25:27', '2017-01-15 22:25:27', 'system', 'system', '0', '18', '1');
INSERT INTO `qa_score` VALUES ('26', 'N', '2017-01-21 16:10:40', '2017-01-21 16:10:40', 'system', 'system', '0', '18', '1');
INSERT INTO `qa_score` VALUES ('27', 'N', '2017-01-21 16:10:40', '2017-01-21 16:10:40', 'system', 'system', '0', '18', '1');
INSERT INTO `qa_score` VALUES ('28', 'N', '2017-01-21 16:11:30', '2017-01-21 16:11:30', 'system', 'system', '0', '18', '1');
INSERT INTO `qa_score` VALUES ('29', 'N', '2017-01-21 16:11:30', '2017-01-21 16:11:30', 'system', 'system', '0', '18', '1');
INSERT INTO `qa_score` VALUES ('30', 'N', '2017-01-21 16:15:29', '2017-01-21 16:15:29', 'class1_user1', 'class1_user1', '8', '17', '1');
INSERT INTO `qa_score` VALUES ('31', 'N', '2017-01-21 16:48:36', '2017-01-21 16:48:36', 'system', 'system', '0', '17', '1');
INSERT INTO `qa_score` VALUES ('32', 'N', '2017-01-31 16:13:08', '2017-01-31 16:13:08', 'add_test', 'add_test', '8', '25', '7');
INSERT INTO `qa_score` VALUES ('33', 'N', '2017-01-31 19:56:22', '2017-01-31 19:56:22', 'system', 'system', '0', '25', '7');
INSERT INTO `qa_score` VALUES ('34', 'N', '2017-01-31 19:56:23', '2017-01-31 19:56:23', 'system', 'system', '0', '25', '1');
INSERT INTO `qa_score` VALUES ('35', 'N', '2017-01-31 19:56:23', '2017-01-31 19:56:23', 'system', 'system', '0', '25', '6');
INSERT INTO `qa_score` VALUES ('36', 'N', '2017-02-01 19:20:28', '2017-02-01 19:20:28', 'student1', 'student1', '6', '26', '1');
INSERT INTO `qa_score` VALUES ('37', 'N', '2017-02-01 19:35:01', '2017-02-01 19:35:01', 'system', 'system', '0', '26', '6');
INSERT INTO `qa_score` VALUES ('38', 'N', '2017-02-01 20:11:54', '2017-02-01 20:11:54', 'student2', 'student2', '6', '27', '6');
INSERT INTO `qa_score` VALUES ('39', 'N', '2017-02-01 20:20:46', '2017-02-01 20:20:46', 'student1', 'student1', '0', '27', '1');
INSERT INTO `qa_score` VALUES ('40', 'N', '2017-02-02 09:25:30', '2017-02-02 09:25:30', 'system', 'system', '0', '28', '1');
INSERT INTO `qa_score` VALUES ('41', 'N', '2017-02-02 09:25:30', '2017-02-02 09:25:30', 'system', 'system', '0', '28', '6');
INSERT INTO `qa_score` VALUES ('42', 'N', '2017-02-03 09:06:32', '2017-02-03 09:06:32', 'student1', 'student1', '0', '29', '1');
INSERT INTO `qa_score` VALUES ('43', 'N', '2017-02-03 09:07:59', '2017-02-03 09:07:59', 'student2', 'student2', '2', '29', '6');
INSERT INTO `qa_score` VALUES ('44', 'N', '2017-02-03 09:37:05', '2017-02-03 09:37:05', 'student1', 'student1', '0', '30', '1');
INSERT INTO `qa_score` VALUES ('45', 'N', '2017-02-03 09:44:26', '2017-02-03 09:44:26', 'student2', 'student2', '2', '30', '6');
INSERT INTO `qa_score` VALUES ('46', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '1');
INSERT INTO `qa_score` VALUES ('47', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '6');
INSERT INTO `qa_score` VALUES ('48', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '1');
INSERT INTO `qa_score` VALUES ('49', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '6');
INSERT INTO `qa_score` VALUES ('50', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '1');
INSERT INTO `qa_score` VALUES ('51', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '6');
INSERT INTO `qa_score` VALUES ('52', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '1');
INSERT INTO `qa_score` VALUES ('53', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '6');
INSERT INTO `qa_score` VALUES ('54', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '1');
INSERT INTO `qa_score` VALUES ('55', 'N', '2017-02-04 08:38:11', '2017-02-04 08:38:11', 'system', 'system', '0', '33', '6');
INSERT INTO `qa_score` VALUES ('56', 'N', '2017-02-04 14:22:27', '2017-02-04 14:22:27', 'student1', 'student1', '8', '37', '1');
INSERT INTO `qa_score` VALUES ('57', 'N', '2017-02-06 22:02:28', '2017-02-06 22:02:28', 'system', 'system', '0', '37', '6');
INSERT INTO `qa_score` VALUES ('58', 'N', '2017-02-19 18:46:35', '2017-02-19 18:46:35', 'student2', 'student2', '6', '38', '6');
INSERT INTO `qa_score` VALUES ('59', 'N', '2017-02-19 19:10:36', '2017-02-19 19:10:36', 'system', 'system', '0', '38', '8');
INSERT INTO `qa_score` VALUES ('60', 'N', '2017-02-19 21:11:34', '2017-02-19 21:11:34', 'student1', 'student1', '6', '39', '1');
INSERT INTO `qa_score` VALUES ('61', 'N', '2017-02-19 21:35:08', '2017-02-19 21:35:08', 'system', 'system', '0', '39', '6');
INSERT INTO `qa_score` VALUES ('62', 'N', '2017-02-19 21:35:08', '2017-02-19 21:35:08', 'system', 'system', '0', '39', '8');

-- ----------------------------
-- Table structure for qa_send_mail_info
-- ----------------------------
DROP TABLE IF EXISTS `qa_send_mail_info`;
CREATE TABLE `qa_send_mail_info` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `sender` varchar(255) default NULL COMMENT '发送者',
  `receivers` varchar(255) default NULL COMMENT '接收者',
  `status` varchar(255) default NULL COMMENT '状态',
  `mail_content` varchar(4000) default NULL COMMENT '邮件内容',
  `subject` varchar(255) default NULL COMMENT '邮件主题',
  `template_name` varchar(255) default NULL COMMENT '邮件模板名称',
  `source_id` bigint(255) default NULL COMMENT '来源ID',
  `description` varchar(500) default NULL COMMENT '描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qa_send_mail_info
-- ----------------------------
INSERT INTO `qa_send_mail_info` VALUES ('1', 'N', '2017-02-18 15:47:03', '2017-02-18 15:47:03', 'system', null, null, '486289410@qq.com', 'SUCCESS', '<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n	<title>电子邮箱 - QAPLUS</title>\r\n	<style type=\"text/css\">\r\n		*{margin:0;padding:0}\r\n	</style>\r\n</head>\r\n<body>\r\n	学生：学生1(486289410@qq.com) 毫不客气的给你提了一个问题，请登录系统（http://localhost:8080/qaplus/teaQuestionList/teaQuestionList.jsp?title=%E6%B5%8B%E8%AF%95%E5%8F%91%E9%82%AE%E4%BB%B6）进入问题列表，回答学生提的问题。\r\n	<br/>\r\n	问题内容如下：\r\n	<br/>\r\n	问题标题：测试发邮件\r\n	<br/>\r\n	问题内容：测试发邮件\r\n	<br/>\r\n	<span style=\"color:red\">请注意：看看有没有附件哦！</span>\r\n</div>\r\n</body>\r\n</html>', '学生学生1提问（含附件）', 'templates/stuAddQuestionTemplate.vm', null, null);
INSERT INTO `qa_send_mail_info` VALUES ('2', 'N', '2017-02-18 15:53:29', '2017-02-18 15:53:29', 'system', null, null, '486289410@qq.com', 'SUCCESS', '<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n	<title>电子邮箱 - QAPLUS</title>\r\n	<style type=\"text/css\">\r\n		*{margin:0;padding:0}\r\n	</style>\r\n</head>\r\n<body>\r\n	学生：学生1(486289410@qq.com) 毫不客气的给你提了一个问题，请登录系统（http://localhost:8080/qaplus/teacher/teaQuestionList/teaQuestionList.jsp?title=%E6%B5%8B%E8%AF%95%E5%8F%91%E9%82%AE%E4%BB%B62）进入问题列表，回答学生提的问题。\r\n	<br/>\r\n	问题内容如下：\r\n	<br/>\r\n	问题标题：测试发邮件2\r\n	<br/>\r\n	问题内容：测试发邮件2\r\n	<br/>\r\n	<span style=\"color:red\">请注意：看看有没有附件哦！</span>\r\n</div>\r\n</body>\r\n</html>', '学生学生1提问（含附件）', 'templates/stuAddQuestionTemplate.vm', '18', '学生向老师提问，发邮件给老师提醒');
INSERT INTO `qa_send_mail_info` VALUES ('3', 'N', '2017-03-04 12:28:45', '2017-03-04 12:28:45', 'system', null, null, '486289410@qq.com', 'FAILURE', '<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n	<title>电子邮箱 - QAPLUS</title>\r\n	<style type=\"text/css\">\r\n		*{margin:0;padding:0}\r\n	</style>\r\n</head>\r\n<body>\r\n	学生：学生1(486289410@qq.com) 毫不客气的给你提了一个问题，请登录系统（http://localhost:8080/qaplus/teacher/teaQuestionList/teaQuestionList.jsp?title=%E5%8A%A8%E6%80%81%E5%88%86%E7%B1%BB%E6%B5%8B%E8%AF%95）进入问题列表，回答学生提的问题。\r\n	<br/>\r\n	问题内容如下：\r\n	<br/>\r\n	问题标题：动态分类测试\r\n	<br/>\r\n	问题内容：动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试动态分类测试\r\n	<br/>\r\n	<span style=\"color:red\">请注意：看看有没有附件哦！</span>\r\n</div>\r\n</body>\r\n</html>', '学生学生1提问（含附件）', 'templates/stuAddQuestionTemplate.vm', '19', '学生向老师提问，发邮件给老师提醒');
INSERT INTO `qa_send_mail_info` VALUES ('4', 'N', '2017-03-04 12:39:40', '2017-03-04 12:39:40', 'system', null, null, '486289410@qq.com', 'FAILURE', '<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n	<title>电子邮箱 - QAPLUS</title>\r\n	<style type=\"text/css\">\r\n		*{margin:0;padding:0}\r\n	</style>\r\n</head>\r\n<body>\r\n	学生：学生1(486289410@qq.com) 毫不客气的给你提了一个问题，请登录系统（http://localhost:8080/qaplus/teacher/teaQuestionList/teaQuestionList.jsp?title=%E8%BF%99%E6%AC%A1%E9%80%89%E6%8B%A9%E4%BA%86JQUERY）进入问题列表，回答学生提的问题。\r\n	<br/>\r\n	问题内容如下：\r\n	<br/>\r\n	问题标题：这次选择了JQUERY\r\n	<br/>\r\n	问题内容：这是描述\r\n	<br/>\r\n	<span style=\"color:red\">请注意：看看有没有附件哦！</span>\r\n</div>\r\n</body>\r\n</html>', '学生学生1提问（含附件）', 'templates/stuAddQuestionTemplate.vm', '20', '学生向老师提问，发邮件给老师提醒');
INSERT INTO `qa_send_mail_info` VALUES ('5', 'N', '2017-03-05 14:53:52', '2017-03-05 14:53:52', 'system', null, null, '486289410@qq.com', 'FAILURE', '<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n	<title>电子邮箱 - QAPLUS</title>\r\n	<style type=\"text/css\">\r\n		*{margin:0;padding:0}\r\n	</style>\r\n</head>\r\n<body>\r\n	学生：学生1(486289410@qq.com) 毫不客气的给你提了一个问题，请登录系统（http://localhost:8080/qaplus/teacher/teaQuestionList/teaQuestionList.jsp?title=%E5%AD%A6%E7%94%9F%E4%B8%80++%E6%B7%BB%E5%8A%A0%E9%97%AE%E9%A2%98+%E6%B5%8B%E8%AF%95+%E6%A0%87%E9%A2%98%EF%BC%88%E9%99%84%E4%BB%B6%E6%98%AF%3ALinux%E8%99%9A%E6%8B%9F%E6%9C%BA%E5%9B%BE%E7%89%87%EF%BC%89）进入问题列表，回答学生提的问题。\r\n	<br/>\r\n	问题内容如下：\r\n	<br/>\r\n	问题标题：学生一  添加问题 测试 标题（附件是:Linux虚拟机图片）\r\n	<br/>\r\n	问题内容：学生一  添加问题 测试 问题描述（Other）\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n学生一  添加问题 测试 问题描述\r\n	<br/>\r\n	<span style=\"color:red\">请注意：看看有没有附件哦！</span>\r\n</div>\r\n</body>\r\n</html>', '学生学生1提问（含附件）', 'templates/stuAddQuestionTemplate.vm', '21', '学生向老师提问，发邮件给老师提醒');
INSERT INTO `qa_send_mail_info` VALUES ('6', 'N', '2017-03-05 14:57:02', '2017-03-05 14:57:02', 'system', null, null, '486289410@qq.com', 'SUCCESS', '<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n	<title>电子邮箱 - QAPLUS</title>\r\n	<style type=\"text/css\">\r\n		*{margin:0;padding:0}\r\n	</style>\r\n</head>\r\n<body>\r\n	学生：学生1(486289410@qq.com) 毫不客气的给你提了一个问题，请登录系统（http://localhost:8080/qaplus/teacher/teaQuestionList/teaQuestionList.jsp?title=5.%E6%B5%8B%E8%AF%95%E5%8F%91%E9%82%AE%E4%BB%B6）进入问题列表，回答学生提的问题。\r\n	<br/>\r\n	问题内容如下：\r\n	<br/>\r\n	问题标题：5.测试发邮件\r\n	<br/>\r\n	问题内容：5.测试发邮件\r\n	<br/>\r\n	<span style=\"color:red\">请注意：看看有没有附件哦！</span>\r\n</div>\r\n</body>\r\n</html>', '学生学生1提问', 'templates/stuAddQuestionTemplate.vm', '22', '学生向老师提问，发邮件给老师提醒');
INSERT INTO `qa_send_mail_info` VALUES ('7', 'N', '2017-03-05 15:00:16', '2017-03-05 15:00:16', 'system', null, null, '486289410@qq.com', 'FAILURE', '<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n	<title>电子邮箱 - QAPLUS</title>\r\n	<style type=\"text/css\">\r\n		*{margin:0;padding:0}\r\n	</style>\r\n</head>\r\n<body>\r\n	学生：学生1(486289410@qq.com) 毫不客气的给你提了一个问题，请登录系统（http://localhost:8080/qaplus/teacher/teaQuestionList/teaQuestionList.jsp?title=%E5%AD%A6%E7%94%9F%E4%B8%80+%E6%B7%BB%E5%8A%A0%E9%97%AE%E9%A2%98+%E6%B5%8B%E8%AF%95+%E6%A0%87%E9%A2%98%EF%BC%88%E9%99%84%E4%BB%B6%E6%98%AF%3ALinux%E8%99%9A%E6%8B%9F%E6%9C%BA%E5%9B%BE%E7%89%87%EF%BC%89）进入问题列表，回答学生提的问题。\r\n	<br/>\r\n	问题内容如下：\r\n	<br/>\r\n	问题标题：学生一 添加问题 测试 标题（附件是:Linux虚拟机图片）\r\n	<br/>\r\n	问题内容：学生一 添加问题 测试 问题描述（Other） 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述 学生一 添加问题 测试 问题描述\r\n	<br/>\r\n	<span style=\"color:red\">请注意：看看有没有附件哦！</span>\r\n</div>\r\n</body>\r\n</html>', '学生学生1提问（含附件）', 'templates/stuAddQuestionTemplate.vm', '23', '学生向老师提问，发邮件给老师提醒');

-- ----------------------------
-- Table structure for qa_stu_comment
-- ----------------------------
DROP TABLE IF EXISTS `qa_stu_comment`;
CREATE TABLE `qa_stu_comment` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `title` varchar(255) default NULL COMMENT '标题',
  `content` varchar(4000) default NULL COMMENT '内容',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='毕业生就业心得表';

-- ----------------------------
-- Records of qa_stu_comment
-- ----------------------------

-- ----------------------------
-- Table structure for qa_stu_graduation
-- ----------------------------
DROP TABLE IF EXISTS `qa_stu_graduation`;
CREATE TABLE `qa_stu_graduation` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `user_id` bigint(255) default NULL COMMENT '用户ID',
  `company_name` varchar(255) default NULL COMMENT '公司名称',
  `baise_salary` decimal(10,2) default NULL COMMENT '基本工资',
  `work_address` varchar(255) default NULL COMMENT '工作地点',
  `work_desc` varchar(255) default NULL COMMENT '工作描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='毕业生待遇表';

-- ----------------------------
-- Records of qa_stu_graduation
-- ----------------------------

-- ----------------------------
-- Table structure for qa_stu_homework
-- ----------------------------
DROP TABLE IF EXISTS `qa_stu_homework`;
CREATE TABLE `qa_stu_homework` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `title` varchar(255) default NULL COMMENT '作业标题',
  `create_person` varchar(32) default NULL COMMENT '谁布置的作业',
  `commit_date` datetime default NULL COMMENT '到点交作业',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='家庭作业';

-- ----------------------------
-- Records of qa_stu_homework
-- ----------------------------
INSERT INTO `qa_stu_homework` VALUES ('47', 'N', '2017-01-15 18:06:30', '2017-01-15 18:06:30', 'class12_teacher', 'class12_teacher', 'J2SE家庭作业1', 'class12_teacher', '2017-01-15 18:05:21');
INSERT INTO `qa_stu_homework` VALUES ('48', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', 'J2SE家庭作业2', 'class12_teacher', '2017-01-16 18:05:02');
INSERT INTO `qa_stu_homework` VALUES ('49', 'N', '2017-01-15 18:18:00', '2017-01-15 18:18:00', 'class12_teacher', 'class12_teacher', 'J2SE家庭作业3', 'class12_teacher', '2017-01-14 18:17:42');
INSERT INTO `qa_stu_homework` VALUES ('50', 'N', '2017-01-31 12:57:59', '2017-01-31 12:57:59', 'teacher', 'teacher', 'add_test布置作业', 'teacher', '2017-01-31 12:55:22');
INSERT INTO `qa_stu_homework` VALUES ('51', 'N', '2017-01-31 13:03:37', '2017-01-31 13:03:37', 'teacher', 'teacher', 'tets', 'teacher', '2017-01-30 14:00:18');

-- ----------------------------
-- Table structure for qa_stu_hw_answer
-- ----------------------------
DROP TABLE IF EXISTS `qa_stu_hw_answer`;
CREATE TABLE `qa_stu_hw_answer` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `homework_id` bigint(255) default NULL,
  `question_id` bigint(255) default NULL,
  `stu_id` bigint(255) default NULL,
  `commit_content` varchar(4000) default NULL,
  `teacher_remark` varchar(255) default NULL COMMENT '老师批注',
  `has_attachment` char(1) default NULL,
  `attachment_id` bigint(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=742 DEFAULT CHARSET=utf8 COMMENT='学生答案';

-- ----------------------------
-- Records of qa_stu_hw_answer
-- ----------------------------
INSERT INTO `qa_stu_hw_answer` VALUES ('728', 'N', '2017-01-15 18:06:30', '2017-01-15 18:16:22', 'class12_teacher', 'class12_teacher', '47', '77', '1', 'A<span id=\"transmark\"></span><br>', '做错了，题目解析自己看答案', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('729', 'N', '2017-01-15 18:06:30', '2017-01-15 18:17:05', 'class12_teacher', 'class12_teacher', '47', '78', '1', '<span id=\"transmark\"></span>', '做错了，题目解析自己看答案', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('730', 'N', '2017-01-15 18:06:30', '2017-01-15 18:17:04', 'class12_teacher', 'class12_teacher', '47', '79', '1', '<span id=\"transmark\"></span>', '做错了，题目解析自己看答案', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('731', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', '48', '77', '2', null, null, null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('732', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', '48', '78', '2', null, null, null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('733', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', '48', '79', '2', null, null, null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('734', 'N', '2017-01-15 18:18:00', '2017-01-15 18:22:00', 'class12_teacher', 'class12_teacher', '49', '77', '1', '<p>我选A<span id=\"transmark\"></span><br></p>', '错了，自己看答案', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('735', 'N', '2017-01-15 18:18:00', '2017-01-15 18:21:59', 'class12_teacher', 'class12_teacher', '49', '78', '1', '<p>我选A）<span id=\"transmark\"></span><br></p>', '对了', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('736', 'N', '2017-01-15 18:18:00', '2017-01-15 18:21:58', 'class12_teacher', 'class12_teacher', '49', '79', '1', '<p>我选A）<span id=\"transmark\"></span><br></p>', '对了', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('737', 'N', '2017-01-31 12:57:59', '2017-01-31 13:01:47', 'teacher', 'teacher', '50', '80', '7', '学生做题目，回答问题1，答案<br><span id=\"transmark\"></span>', '老师批注问题1', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('738', 'N', '2017-01-31 12:57:59', '2017-01-31 13:01:46', 'teacher', 'teacher', '50', '81', '7', '学生做题目，回答问题1，答案<br><span id=\"transmark\"></span>', '老师批注问题2', 'Y', '234');
INSERT INTO `qa_stu_hw_answer` VALUES ('739', 'N', '2017-01-31 13:03:37', '2017-01-31 13:26:14', 'teacher', 'teacher', '51', '77', '7', 'a', '做错了，自己看答案', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('740', 'N', '2017-01-31 13:03:37', '2017-01-31 13:26:17', 'teacher', 'teacher', '51', '78', '7', 'b', '做错了，自己看答案', null, null);
INSERT INTO `qa_stu_hw_answer` VALUES ('741', 'N', '2017-01-31 13:03:37', '2017-01-31 13:26:21', 'teacher', 'teacher', '51', '79', '7', 'c', '做错了，自己看答案', null, null);

-- ----------------------------
-- Table structure for qa_stu_hw_detail
-- ----------------------------
DROP TABLE IF EXISTS `qa_stu_hw_detail`;
CREATE TABLE `qa_stu_hw_detail` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `homework_id` bigint(255) default NULL,
  `stu_id` bigint(255) default NULL,
  `is_commit` char(1) default 'N' COMMENT '作业是否上交',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8 COMMENT='家庭作业-学生';

-- ----------------------------
-- Records of qa_stu_hw_detail
-- ----------------------------
INSERT INTO `qa_stu_hw_detail` VALUES ('164', 'N', '2017-01-15 18:06:30', '2017-01-15 18:12:41', 'class1_user1', 'class12_teacher', '47', '1', 'Y');
INSERT INTO `qa_stu_hw_detail` VALUES ('165', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', '48', '2', 'N');
INSERT INTO `qa_stu_hw_detail` VALUES ('166', 'N', '2017-01-15 18:18:00', '2017-01-15 18:21:09', 'class1_user1', 'class12_teacher', '49', '1', 'Y');
INSERT INTO `qa_stu_hw_detail` VALUES ('167', 'N', '2017-01-31 12:57:59', '2017-01-31 13:00:14', 'add_test', 'teacher', '50', '7', 'Y');
INSERT INTO `qa_stu_hw_detail` VALUES ('168', 'N', '2017-01-31 13:03:37', '2017-01-31 13:23:50', 'add_test', 'teacher', '51', '7', 'Y');

-- ----------------------------
-- Table structure for qa_stu_hw_question
-- ----------------------------
DROP TABLE IF EXISTS `qa_stu_hw_question`;
CREATE TABLE `qa_stu_hw_question` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `homework_id` bigint(255) default NULL,
  `question_id` bigint(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8 COMMENT='家庭作业-问题';

-- ----------------------------
-- Records of qa_stu_hw_question
-- ----------------------------
INSERT INTO `qa_stu_hw_question` VALUES ('181', 'N', '2017-01-15 18:06:30', '2017-01-15 18:06:30', 'class12_teacher', 'class12_teacher', '47', '77');
INSERT INTO `qa_stu_hw_question` VALUES ('182', 'N', '2017-01-15 18:06:30', '2017-01-15 18:06:30', 'class12_teacher', 'class12_teacher', '47', '78');
INSERT INTO `qa_stu_hw_question` VALUES ('183', 'N', '2017-01-15 18:06:30', '2017-01-15 18:06:30', 'class12_teacher', 'class12_teacher', '47', '79');
INSERT INTO `qa_stu_hw_question` VALUES ('184', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', '48', '77');
INSERT INTO `qa_stu_hw_question` VALUES ('185', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', '48', '78');
INSERT INTO `qa_stu_hw_question` VALUES ('186', 'N', '2017-01-15 18:07:14', '2017-01-15 18:07:14', 'class12_teacher', 'class12_teacher', '48', '79');
INSERT INTO `qa_stu_hw_question` VALUES ('187', 'N', '2017-01-15 18:18:00', '2017-01-15 18:18:00', 'class12_teacher', 'class12_teacher', '49', '77');
INSERT INTO `qa_stu_hw_question` VALUES ('188', 'N', '2017-01-15 18:18:00', '2017-01-15 18:18:00', 'class12_teacher', 'class12_teacher', '49', '78');
INSERT INTO `qa_stu_hw_question` VALUES ('189', 'N', '2017-01-15 18:18:00', '2017-01-15 18:18:00', 'class12_teacher', 'class12_teacher', '49', '79');
INSERT INTO `qa_stu_hw_question` VALUES ('190', 'N', '2017-01-31 12:57:59', '2017-01-31 12:57:59', 'teacher', 'teacher', '50', '80');
INSERT INTO `qa_stu_hw_question` VALUES ('191', 'N', '2017-01-31 12:57:59', '2017-01-31 12:57:59', 'teacher', 'teacher', '50', '81');
INSERT INTO `qa_stu_hw_question` VALUES ('192', 'N', '2017-01-31 13:03:37', '2017-01-31 13:03:37', 'teacher', 'teacher', '51', '77');
INSERT INTO `qa_stu_hw_question` VALUES ('193', 'N', '2017-01-31 13:03:37', '2017-01-31 13:03:37', 'teacher', 'teacher', '51', '78');
INSERT INTO `qa_stu_hw_question` VALUES ('194', 'N', '2017-01-31 13:03:37', '2017-01-31 13:03:37', 'teacher', 'teacher', '51', '79');

-- ----------------------------
-- Table structure for qa_system_constant
-- ----------------------------
DROP TABLE IF EXISTS `qa_system_constant`;
CREATE TABLE `qa_system_constant` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `category` varchar(50) default NULL COMMENT '常量分类',
  `code` varchar(50) default '' COMMENT '常量Code（后台需要的值）',
  `name` varchar(50) default NULL COMMENT '后台接收的属性名称',
  `text` varchar(255) default NULL COMMENT '常量展示值',
  `serial` int(3) default NULL COMMENT '排序',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='系统常量维护表';

-- ----------------------------
-- Records of qa_system_constant
-- ----------------------------
INSERT INTO `qa_system_constant` VALUES ('1', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'J2SE', 'categorys', 'J2SE', '2');
INSERT INTO `qa_system_constant` VALUES ('2', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'J2EE', 'categorys', 'J2EE', '3');
INSERT INTO `qa_system_constant` VALUES ('3', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'JAVASCRIPT', 'categorys', 'JAVASCRIPT', '4');
INSERT INTO `qa_system_constant` VALUES ('4', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'JQUERY', 'categorys', 'JQUERY', '5');
INSERT INTO `qa_system_constant` VALUES ('5', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'FRONT', 'categorys', '前端', '6');
INSERT INTO `qa_system_constant` VALUES ('6', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'DEV_TOOL', 'categorys', '开发工具', '7');
INSERT INTO `qa_system_constant` VALUES ('7', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'JAVASCRIPT', 'categorys', 'JAVASCRIPT', '8');
INSERT INTO `qa_system_constant` VALUES ('8', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'QUESTION_CATEGORY', 'OTHER', 'categorys', '其他', '9');
INSERT INTO `qa_system_constant` VALUES ('9', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'MY_CATEGORY', 'my', 'my', '我的问题', '1');
INSERT INTO `qa_system_constant` VALUES ('10', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'SOLVE_CATEGORY', 'N', 'solveType', '未解决', '10');
INSERT INTO `qa_system_constant` VALUES ('11', 'N', '2017-03-03 21:20:10', '2017-03-03 21:20:11', 'system', 'system', 'SOLVE_CATEGORY', 'Y', 'solveType', '已解决', '11');

-- ----------------------------
-- Table structure for qa_t_question
-- ----------------------------
DROP TABLE IF EXISTS `qa_t_question`;
CREATE TABLE `qa_t_question` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `title` varchar(255) default NULL COMMENT '标题',
  `content` varchar(4000) default NULL COMMENT '内容',
  `answer` varchar(4000) default NULL COMMENT '答案',
  `category` varchar(50) default NULL COMMENT '分类',
  `user_id` bigint(255) default NULL COMMENT '用户ID',
  `question_has_attachment` char(1) default NULL COMMENT '问题是否有附件',
  `answer_has_attachment` char(1) default NULL COMMENT '回答是否要附件',
  `answer_attachment_id` bigint(255) default NULL COMMENT '回答附件路劲',
  `question_attachment_id` bigint(255) default NULL COMMENT '问题附件名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COMMENT='教师问题库';

-- ----------------------------
-- Records of qa_t_question
-- ----------------------------
INSERT INTO `qa_t_question` VALUES ('77', 'N', '2017-01-15 18:03:23', '2017-01-15 18:03:23', 'class12_teacher', 'class12_teacher', 'Java接口的修饰符可以为（）', 'Java接口的修饰符可以为（）:\r\nA private     B protected     C final       D abstract', '答案：CD\r\n\r\n解析：接口很重要，为了说明情况，这里稍微啰嗦点：\r\n\r\n（1）接口用于描述系统对外提供的所有服务,因此接口中的成员常量和方法都必须是公开(public)类型的,确保外部使用者能访问它们；\r\n\r\n（2）接口仅仅描述系统能做什么,但不指明如何去做,所以接口中的方法都是抽象(abstract)方法；\r\n\r\n（3）接口不涉及和任何具体实例相关的细节,因此接口没有构造方法,不能被实例化,没有实例变量，只有静态（static）变量；\r\n\r\n（4）接口的中的变量是所有实现类共有的，既然共有，肯定是不变的东西，因为变化的东西也不能够算共有。所以变量是不可变(final)类型，也就是常量了。\r\n\r\n（5） 接口中不可以定义变量？如果接口可以定义变量，但是接口中的方法又都是抽象的，在接口中无法通过行为来修改属性。有的人会说了，没有关系，可以通过 实现接口的对象的行为来修改接口中的属性。这当然没有问题，但是考虑这样的情况。如果接口 A 中有一个public 访问权限的静态变量 a。按照 Java 的语义，我们可以不通过实现接口的对象来访问变量 a，通过 A.a = xxx; 就可以改变接口中的变量 a 的值了。正如抽象类中是可以这样做的，那么实现接口 A 的所有对象也都会自动拥有这一改变后的 a 的值了，也就是说一个地方改变了 a，所有这些对象中 a 的值也都跟着变了。这和抽象类有什么区别呢，怎么体现接口更高的抽象级别呢，怎么体现接口提供的统一的协议呢，那还要接口这种抽象来做什么呢？所以接口中 不能出现变量，如果有变量，就和接口提供的统一的抽象这种思想是抵触的。所以接口中的属性必然是常量，只能读不能改，这样才能为实现接口的对象提供一个统 一的属性。\r\n\r\n通俗的讲，你认为是要变化的东西，就放在你自己的实现中，不能放在接口中去，接口只是对一类事物的属性和行为更高层次的抽象。对修改关闭，对扩展（不同的实现 implements）开放，接口是对开闭原则的一种体现。\r\n\r\n所以：\r\n\r\n接口的方法默认是public abstract；\r\n\r\n接口中不可以定义变量即只能定义常量(加上final修饰就会变成常量)。所以接口的属性默认是public static final 常量，且必须赋初值。\r\n\r\n注意：final和abstract不能同时出现。', 'J2SE', '2', null, null, null, null);
INSERT INTO `qa_t_question` VALUES ('78', 'N', '2017-01-15 18:04:28', '2017-01-15 18:04:28', 'class12_teacher', 'class12_teacher', '不通过构造函数也能创建对象吗（）', '不通过构造函数也能创建对象吗（）\r\nA 是     B 否', '答案：A\r\n\r\n解析：Java创建对象的几种方式（重要）：\r\n\r\n(1) 用new语句创建对象，这是最常见的创建对象的方法。\r\n(2) 运用反射手段,调用java.lang.Class或者java.lang.reflect.Constructor类的newInstance()实例方法。\r\n(3) 调用对象的clone()方法。\r\n(4) 运用反序列化手段，调用java.io.ObjectInputStream对象的 readObject()方法。\r\n\r\n(1)和(2)都会明确的显式的调用构造函数 ；(3)是在内存上对已有对象的影印，所以不会调用构造函数 ；(4)是从文件中还原类的对象，也不会调用构造函数。', 'J2SE', '2', null, null, null, null);
INSERT INTO `qa_t_question` VALUES ('79', 'N', '2017-01-15 18:05:47', '2017-01-15 18:05:47', 'class12_teacher', 'class12_teacher', 'ArrayList list = new ArrayList(20);中的list扩充几次（）', 'ArrayList list = new ArrayList(20);中的list扩充几次（）\r\nA 0     B 1     C 2      D 3', '答案：A\r\n\r\n解析：这里有点迷惑人，大家都知道默认ArrayList的长度是10个，所以如果你要往list里添加20个元素肯定要扩充一次（扩充为原来的1.5倍），但是这里显示指明了需要多少空间，所以就一次性为你分配这么多空间，也就是不需要扩充了。', 'J2SE', '2', null, null, null, null);
INSERT INTO `qa_t_question` VALUES ('80', 'N', '2017-01-31 12:56:26', '2017-01-31 12:56:26', 'teacher', 'teacher', '问题标题1', '问题内容1', '问题答案1', 'OTHER', '2', 'Y', 'Y', '231', '230');
INSERT INTO `qa_t_question` VALUES ('81', 'N', '2017-01-31 12:57:17', '2017-01-31 12:57:17', 'teacher', 'teacher', '问题标题2', '问题内容2', '问题答案2', 'J2SE', '2', 'Y', 'Y', '232', '233');

-- ----------------------------
-- Table structure for qa_task
-- ----------------------------
DROP TABLE IF EXISTS `qa_task`;
CREATE TABLE `qa_task` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `oper_key` varchar(255) default NULL COMMENT '任务key',
  `content` varchar(500) default NULL COMMENT '任务内容',
  `trigger_person` varchar(32) default '' COMMENT '触发任务者',
  `is_solve` char(1) default 'N' COMMENT '是否处理',
  `is_agree` char(1) default '' COMMENT '处理结果 N-不同意  Y-同意  ''''-未处理',
  `audit_msg` varchar(255) default NULL COMMENT '审批意见',
  `keyword` varchar(255) default NULL COMMENT '任务信息（问题标题、注册的人...）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='任务表（教师注册，学生上传文件）';

-- ----------------------------
-- Records of qa_task
-- ----------------------------
INSERT INTO `qa_task` VALUES ('9', 'N', '2017-01-31 10:43:37', '2017-01-31 10:43:37', 'system', 'system', 'USER_REGISTER', '[用户注册]  用户：student2，在2017-01-31 10:43:37 申请成为：三班11的学生', 'student2', 'Y', 'Y', 'OK', 'student2');
INSERT INTO `qa_task` VALUES ('10', 'Y', '2017-01-31 12:40:37', '2017-01-31 12:41:04', 'teacher', 'system', 'USER_REGISTER', '[用户注册]  用户：add_test，在2017-01-31 12:40:37 申请成为：三班22的学生', 'add_test', 'Y', 'Y', 'AGREE', 'add_test');
INSERT INTO `qa_task` VALUES ('11', 'Y', '2017-01-31 12:54:05', '2017-01-31 12:58:51', 'add_test', 'teacher', 'TEA_SOLVE_QUESTION', '问题：add_test用户提问 在：2017-01-31 12:54:05被老师老师解决', '老师', 'Y', 'Y', 'AGREE', 'add_test用户提问');
INSERT INTO `qa_task` VALUES ('12', 'Y', '2017-02-04 14:14:25', '2017-02-20 22:26:16', 'student1', 'teacher', 'TEA_SOLVE_QUESTION', '问题：在Java语言中，下列哪些语句关于内存回收的说明是正确的? 在：2017-02-04 14:14:25被老师老师解决', '老师', 'Y', 'Y', 'AGREE', '在Java语言中，下列哪些语句关于内存回收的说明是正确的?');
INSERT INTO `qa_task` VALUES ('13', 'Y', '2017-02-19 17:51:47', '2017-02-19 17:51:59', 'teacher', 'system', 'USER_REGISTER', '[用户注册]  用户：test，在2017-02-19 17:51:47 申请成为：三班11的学生', 'test', 'Y', 'Y', 'AGREE', 'test');
INSERT INTO `qa_task` VALUES ('14', 'Y', '2017-03-05 15:44:15', '2017-03-05 15:45:02', 'student1', 'teacher', 'TEA_SOLVE_QUESTION', '问题：学生一 添加问题 测试 标题（附件是:Linux虚拟机图片） 在：2017-03-05 15:44:15被老师老师解决', '老师', 'Y', 'Y', 'AGREE', '学生一 添加问题 测试 标题（附件是:Linux虚拟机图片）');

-- ----------------------------
-- Table structure for qa_user
-- ----------------------------
DROP TABLE IF EXISTS `qa_user`;
CREATE TABLE `qa_user` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `job` int(1) default NULL COMMENT '职位（1-学生，2-毕业学生，3-老师，4-校长）',
  `phone` varchar(20) default NULL COMMENT '手机号',
  `email` varchar(40) default NULL COMMENT '邮件',
  `username` varchar(40) default NULL COMMENT '用户名',
  `password` varchar(200) default NULL COMMENT '密码',
  `name` varchar(10) default NULL COMMENT '姓名',
  `sex` char(1) default NULL COMMENT '性别',
  `age` int(3) default NULL COMMENT '年龄',
  `has_icon` char(1) default 'N' COMMENT '是否有头像',
  `attachment_id` bigint(255) default NULL COMMENT '头像图片附件ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of qa_user
-- ----------------------------
INSERT INTO `qa_user` VALUES ('1', 'N', '2017-01-21 17:12:10', '2017-02-17 22:46:29', 'student1', 'system', '1', '15821285717', '486289410@qq.com', 'student1', 'IBLjN2ZA9K6qnKZCUm2WuYkIDXGXrgFOHryyKsZGQn8=', '学生1', 'M', '12', 'Y', '239');
INSERT INTO `qa_user` VALUES ('2', 'N', '2016-09-24 14:13:31', '2017-05-13 23:56:40', 'teacher', 'system', '2', '15821285717', '486289410@qq.com', 'teacher', '+Da+DvirxPDef+pzaNZVuzx3BZGf8JdL', '老师', 'M', '20', 'Y', '247');
INSERT INTO `qa_user` VALUES ('6', 'N', '2017-01-31 10:43:37', '2017-01-31 10:43:37', 'system', 'system', '1', '13629172174', '486289410@qq.com', 'student2', 'DeIxfZ/GLN4QXuBD847H75JQhxZmuxwSCheNmxgWblc=', '学生2', null, null, 'N', null);
INSERT INTO `qa_user` VALUES ('7', 'N', '2017-01-31 12:40:37', '2017-01-31 12:40:37', 'system', 'system', '1', '15821285717', '486289410@qq.com', 'add_test', 'xi6o742MgD88rOtq/12FVkAfXCNPoXbvJmDmr0XQR4o=', 'add_test', null, null, 'N', null);
INSERT INTO `qa_user` VALUES ('8', 'N', '2017-02-19 17:51:47', '2017-02-19 17:51:47', 'system', 'system', '1', '15821285717', 'test@test.com', 'test', 'cYa7vL/JMIsP81MDYAoi+az1RX1xWgf7', 'test', null, null, 'N', null);

-- ----------------------------
-- Table structure for qa_user_class
-- ----------------------------
DROP TABLE IF EXISTS `qa_user_class`;
CREATE TABLE `qa_user_class` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `user_id` bigint(255) default NULL COMMENT '用户ID',
  `class_id` bigint(255) default NULL COMMENT '班级ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qa_user_class
-- ----------------------------
INSERT INTO `qa_user_class` VALUES ('1', 'N', '2017-01-21 16:52:33', '2017-01-21 16:52:34', 'system', 'system', '1', '1');
INSERT INTO `qa_user_class` VALUES ('2', 'N', '2017-01-21 16:52:33', '2017-01-21 16:52:34', 'system', 'system', '2', '1');
INSERT INTO `qa_user_class` VALUES ('3', 'N', '2017-01-21 16:52:33', '2017-01-21 16:52:34', 'system', 'system', '2', '2');
INSERT INTO `qa_user_class` VALUES ('6', 'N', '2017-01-31 10:43:37', '2017-01-31 10:43:37', 'system', 'system', '6', '1');
INSERT INTO `qa_user_class` VALUES ('7', 'N', '2017-01-31 12:40:37', '2017-01-31 12:40:37', 'system', 'system', '7', '2');
INSERT INTO `qa_user_class` VALUES ('8', 'N', '2017-02-19 17:51:47', '2017-02-19 17:51:47', 'system', 'system', '8', '1');

-- ----------------------------
-- Table structure for qa_user_role
-- ----------------------------
DROP TABLE IF EXISTS `qa_user_role`;
CREATE TABLE `qa_user_role` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default '' COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `user_id` bigint(255) default '0' COMMENT '用户ID',
  `role_id` bigint(255) default '0' COMMENT '角色ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='权限-用户角色对应表';

-- ----------------------------
-- Records of qa_user_role
-- ----------------------------
INSERT INTO `qa_user_role` VALUES ('1', 'N', '2016-09-10 15:03:21', '2016-09-10 15:03:32', 'system', 'system', '1', '1');
INSERT INTO `qa_user_role` VALUES ('2', 'N', '2017-01-21 17:14:31', '2017-01-21 17:14:31', 'teacher', 'teacher', '2', '2');
INSERT INTO `qa_user_role` VALUES ('39', 'N', '2017-01-31 10:06:23', '2017-01-31 10:06:23', 'student1', 'student1', '3', '1');
INSERT INTO `qa_user_role` VALUES ('40', 'N', '2017-01-31 10:44:13', '2017-01-31 10:44:13', 'teacher', 'teacher', '6', '1');
INSERT INTO `qa_user_role` VALUES ('41', 'N', '2017-01-31 12:41:04', '2017-01-31 12:41:04', 'teacher', 'teacher', '7', '1');
INSERT INTO `qa_user_role` VALUES ('42', 'N', '2017-02-19 17:51:59', '2017-02-19 17:51:59', 'teacher', 'teacher', '8', '1');

-- ----------------------------
-- Table structure for qa_user_task
-- ----------------------------
DROP TABLE IF EXISTS `qa_user_task`;
CREATE TABLE `qa_user_task` (
  `id` bigint(255) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` char(1) default '' COMMENT '是否已经删除',
  `rec_create_date` datetime default NULL COMMENT '记录创建时间',
  `rec_update_date` datetime default NULL COMMENT '最近修改时间',
  `rec_update_user` varchar(32) default NULL COMMENT '最近修改人',
  `rec_create_user` varchar(32) default NULL COMMENT '创建人',
  `user_id` bigint(255) default NULL COMMENT '用户ID',
  `task_id` bigint(255) default NULL COMMENT '任务ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户任务对应表';

-- ----------------------------
-- Records of qa_user_task
-- ----------------------------
INSERT INTO `qa_user_task` VALUES ('3', 'N', '2017-01-31 10:43:37', '2017-01-31 10:43:37', 'system', 'system', '1', '9');
INSERT INTO `qa_user_task` VALUES ('4', 'N', '2017-01-31 10:43:37', '2017-01-31 10:43:37', 'system', 'system', '2', '9');
INSERT INTO `qa_user_task` VALUES ('5', 'Y', '2017-01-31 12:40:37', '2017-01-31 12:40:37', 'system', 'system', '2', '10');
INSERT INTO `qa_user_task` VALUES ('6', 'Y', '2017-01-31 12:54:05', '2017-01-31 12:54:05', 'teacher', 'teacher', '7', '11');
INSERT INTO `qa_user_task` VALUES ('7', 'Y', '2017-02-04 14:14:25', '2017-02-04 14:14:25', 'teacher', 'teacher', '1', '12');
INSERT INTO `qa_user_task` VALUES ('8', 'Y', '2017-02-19 17:51:47', '2017-02-19 17:51:47', 'system', 'system', '1', '13');
INSERT INTO `qa_user_task` VALUES ('9', 'Y', '2017-02-19 17:51:47', '2017-02-19 17:51:47', 'system', 'system', '2', '13');
INSERT INTO `qa_user_task` VALUES ('10', 'Y', '2017-02-19 17:51:47', '2017-02-19 17:51:47', 'system', 'system', '6', '13');
INSERT INTO `qa_user_task` VALUES ('11', 'Y', '2017-03-05 15:44:15', '2017-03-05 15:44:15', 'teacher', 'teacher', '1', '14');
