/*
 Navicat Premium Data Transfer

 Source Server         : 11
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : springboot3if68

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 26/04/2022 16:59:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/picture1.jpg');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/picture2.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/picture3.jpg');

-- ----------------------------
-- Table structure for huiyishi
-- ----------------------------
DROP TABLE IF EXISTS `huiyishi`;
CREATE TABLE `huiyishi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `mingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `guimo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规模',
  `leixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `tupian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `zhuangkuang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状况',
  `keyueshijian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可约时间',
  `xiangqing` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情',
  `is_delete` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '逻辑删除标志位 1有效 ，0无效',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `bianhao`(`bianhao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1648697406085 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会议室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of huiyishi
-- ----------------------------
INSERT INTO `huiyishi` VALUES (22, '2021-11-30 14:36:47', '001', '一楼会议室', '大型', '带电子屏', 'upload/huiyishi_tupian2.jpg', '可预约', '8:00-16:00', '', '1');
INSERT INTO `huiyishi` VALUES (23, '2021-11-30 14:36:47', '002', '二楼会议室', '大型', '带电子屏', 'upload/huiyishi_tupian3.jpg', '可预约', '8:00-16:00', '', '1');
INSERT INTO `huiyishi` VALUES (24, '2021-11-30 14:36:47', '003', '三楼会议室', '大型', '带电子屏，麦克风', 'upload/huiyishi_tupian4.jpg', '可预约', '8:00-16:00', '', '1');
INSERT INTO `huiyishi` VALUES (25, '2021-11-30 14:36:47', '004', '四楼会议室', '大型', '带电子屏', 'upload/huiyishi_tupian5.jpg', '可预约', '8:00-16:00', '', '1');
INSERT INTO `huiyishi` VALUES (1648696097529, '2022-03-31 11:08:16', '005', '五楼会议室', '大型', '带电子屏', 'upload/1649079994466.006ARcM3ly1gx8u1dqhpyj33342231ky.jpg', '可预约', '8:00-16:00', NULL, '0');
INSERT INTO `huiyishi` VALUES (1648697406084, '2022-03-31 11:30:05', '006', '六楼会议室', '大型', '带电子屏，麦克风', 'upload/1649080009557.5aec415aeb255.jpg', '可预约', '8:00-16:00', '', '0');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) NULL DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收藏图片',
  `type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩)',
  `is_delete` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '逻辑删除标志位 1有效，0无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storeup
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'abo', 'users', '管理员', 's93ah9szvznzok3i582aymczcp4rszjx', '2021-12-07 20:22:11', '2022-04-08 17:32:14');
INSERT INTO `token` VALUES (2, 1639313804076, '1111', 'yonghu', '用户', 'h1pwketdh1hfu3wm67yrzm3tyvsn6s9t', '2021-12-12 20:56:58', '2022-04-06 17:56:14');
INSERT INTO `token` VALUES (3, 14, 'CN111', 'yonghu', '用户', 'plpm9cwhkf6zks62srb0vcd2ux0q6dv0', '2022-04-06 22:23:47', '2022-04-08 17:53:07');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `xingming` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `gonghao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `xingbie` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `is_delete` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '逻辑删除标志位，1有效，0无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1649255615486 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '张三', 'admin', '管理员', '2021-11-30 14:36:47', 'CN001', '男', '13665569889', '1');
INSERT INTO `users` VALUES (1649255615485, '李四', '123456', '管理员', '2022-04-06 22:33:35', 'CN111', '男', '13823888884', '0');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `xingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `is_delete` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '逻辑删除标志位 1有效，0无效',
  `role` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '用户' COMMENT '用户类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `gonghao`(`gonghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1649254951166 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (14, '2021-11-30 14:36:47', 'CN111', '李四', '123456', '女', '13823888884', '1', '用户');
INSERT INTO `yonghu` VALUES (15, '2021-11-30 14:36:47', 'CN112', '王五', '123456', '男', '13823888885', '1', '用户');
INSERT INTO `yonghu` VALUES (16, '2021-11-30 14:36:47', 'CN113', '赵六', '123456', '男', '13823888886', '1', '用户');
INSERT INTO `yonghu` VALUES (1639313804076, '2021-12-12 20:56:44', 'CN114', '田七', '123456', '男', '15696345892', '1', '用户');
INSERT INTO `yonghu` VALUES (1648707791482, '2022-03-31 14:23:11', 'CN115', '付伊美', '123456', '女', '18233695876', '1', '用户');
INSERT INTO `yonghu` VALUES (1649254951165, '2022-04-06 22:22:31', 'CN133', '李一鸣', '123456', NULL, '15569864596', '1', '用户');

-- ----------------------------
-- Table structure for yuyuexinxi
-- ----------------------------
DROP TABLE IF EXISTS `yuyuexinxi`;
CREATE TABLE `yuyuexinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuyuebianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约编号',
  `bianhao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `mingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `gonghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `lianxidianhua` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `huiyizhuti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议主题',
  `canhuirenyuan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参会人员',
  `huiyishijian` datetime NULL DEFAULT NULL COMMENT '会议时间',
  `shiyongshizhang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用时长',
  `yuyuebeizhu` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '预约备注',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核回复',
  `is_delete` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '逻辑删除标志位，1未删除，0已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yuyuebianhao`(`yuyuebianhao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1649408030126 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuyuexinxi
-- ----------------------------
INSERT INTO `yuyuexinxi` VALUES (31, '2021-11-30 14:36:47', '1111111111', '编号1', '名称1', '工号1', '姓名1', '联系电话1', '会议主题1', '', '2021-11-30 14:36:47', '使用时长1', '预约备注1', '是', '', '0');
INSERT INTO `yuyuexinxi` VALUES (32, '2021-11-30 14:36:47', '2222222222', '编号2', '名称2', '工号2', '姓名2', '联系电话2', '会议主题2', '', '2021-11-30 14:36:47', '使用时长2', '预约备注2', '否', '', '0');
INSERT INTO `yuyuexinxi` VALUES (33, '2021-11-30 14:36:47', '3333333333', '编号3', '名称3', '工号3', '姓名3', '联系电话3', '会议主题3', '', '2021-11-30 14:36:47', '使用时长3', '预约备注3', '否', '', '0');
INSERT INTO `yuyuexinxi` VALUES (34, '2021-11-30 14:36:47', '4444444444', '编号4', '名称4', '工号4', '姓名4', '联系电话4', '会议主题4', '', '2021-11-30 14:36:47', '使用时长4', '预约备注4', '是', '', '0');
INSERT INTO `yuyuexinxi` VALUES (35, '2021-11-30 14:36:47', '5555555555', '编号5', '名称5', '工号5', '姓名5', '联系电话5', '会议主题5', '', '2021-11-30 14:36:47', '使用时长5', '预约备注5', '是', '', '0');
INSERT INTO `yuyuexinxi` VALUES (36, '2021-11-30 14:36:47', '6666666666', '编号6', '名称6', '工号6', '姓名6', '联系电话6', '会议主题6', 'upload/1649014080965.实习生实战项目规划方案.docx', '2021-11-30 14:36:47', '使用时长6', '预约备注6', '是', '', '0');
INSERT INTO `yuyuexinxi` VALUES (1648712516388, '2022-03-31 15:41:55', '1648712503755', '编号2', '名称2', '1111', 'abo', NULL, '但是', 'upload/1649012657874.README.txt', '2022-03-31 15:41:52', NULL, NULL, '否', NULL, '0');
INSERT INTO `yuyuexinxi` VALUES (1648712644374, '2022-03-31 15:44:04', '1648712628870', '编号3', '名称3', '1111', 'abo', NULL, '3给我', 'upload/1649012922834.家庭信息维护-需求规格说明书V1.0.docx', '2022-03-31 15:44:01', NULL, ' 发的那个人的', '否', NULL, '0');
INSERT INTO `yuyuexinxi` VALUES (1649254702341, '2022-04-06 22:18:21', '1649254558636', '001', '一楼会议室', 'CN001', '张三', '13665569889', '关于防诈骗事宜', 'upload/1649254671317.参会人员.xlsx', '2022-04-06 22:17:54', '2h', '会议紧急', '否', NULL, '1');
INSERT INTO `yuyuexinxi` VALUES (1649254795147, '2022-04-06 22:19:54', '1649254718204', '002', '二楼会议室', 'CN001', '张三', '13665569889', '关于党建活动', 'upload/1649254754554.参会人员.xlsx', '2022-04-07 08:00:00', '2h', '会议重要', '否', NULL, '1');
INSERT INTO `yuyuexinxi` VALUES (1649255149166, '2022-04-06 22:25:48', '1649255077646', '003', '三楼会议室', 'CN111', '李四', '13823888884', '五一放假注意事项', 'upload/1649408704614&参会人员.xlsx', '2022-04-29 00:00:00', '1h', '会议紧急且重要，请尽快通过', '否', NULL, '1');
INSERT INTO `yuyuexinxi` VALUES (1649407266582, '2022-04-08 16:41:06', '1649407214137', '001', '一楼会议室', 'CN001', '张三', '13665569889', '安全教育', 'upload/1649407746458&参会人员.xlsx', '2022-04-08 16:40:59', '2h', '1111', '否', NULL, '1');
INSERT INTO `yuyuexinxi` VALUES (1649408030125, '2022-04-08 16:53:49', '1649408004432', '001', '一楼会议室', 'CN111', '李四', '13823888884', '网络安全', 'upload/1649408633895&参会人员.xlsx', '2022-04-08 16:53:42', '1h', '2222', '否', NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
