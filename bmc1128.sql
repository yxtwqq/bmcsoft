/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : bmc1128

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-11-30 14:16:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bmc_goods`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_goods`;
CREATE TABLE `bmc_goods` (
  `g_id` int(10) NOT NULL COMMENT '商品id',
  `g_price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `s_id` int(10) NOT NULL COMMENT '店铺id',
  `uptime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_goods
-- ----------------------------
INSERT INTO `bmc_goods` VALUES ('20', '20.00', '3', '2018-11-30 13:46:25');
INSERT INTO `bmc_goods` VALUES ('21', '259.00', '2', '2018-11-30 13:46:25');

-- ----------------------------
-- Table structure for `bmc_result`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_result`;
CREATE TABLE `bmc_result` (
  `g_id` int(11) NOT NULL COMMENT '商品id',
  `g_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `s_id` int(11) DEFAULT NULL COMMENT '店铺id',
  `s_name` varchar(255) DEFAULT NULL COMMENT '店铺名称',
  `res_upprice` decimal(10,2) NOT NULL COMMENT '上传价格',
  `res_plaprice` decimal(10,2) DEFAULT NULL COMMENT '平台价格',
  `result` int(2) DEFAULT NULL COMMENT '1,高，2等，3低',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_result
-- ----------------------------

-- ----------------------------
-- Table structure for `bmc_rgoods`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_rgoods`;
CREATE TABLE `bmc_rgoods` (
  `r_id` int(10) NOT NULL COMMENT '在线商品id',
  `r_name` varchar(255) DEFAULT NULL COMMENT '在线商品id',
  `r_price` decimal(10,2) NOT NULL COMMENT '在线商品价格',
  `s_id` int(10) NOT NULL COMMENT '在线店铺',
  `s_name` varchar(50) DEFAULT NULL COMMENT '在线店铺名称',
  `uptime` datetime NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_rgoods
-- ----------------------------

-- ----------------------------
-- Table structure for `bmc_uploads`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_uploads`;
CREATE TABLE `bmc_uploads` (
  `up_id` int(11) NOT NULL AUTO_INCREMENT,
  `up_path` varchar(255) DEFAULT NULL,
  `up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`up_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_uploads
-- ----------------------------
INSERT INTO `bmc_uploads` VALUES ('34', 'D:/workspace/20181130132959新建 Microsoft Excel 97-2003 工作表.xls', '2018-11-30 13:29:59');
INSERT INTO `bmc_uploads` VALUES ('35', 'D:/workspace/20181130133154新建 Microsoft Excel 97-2003 工作表.xls', '2018-11-30 13:31:54');
INSERT INTO `bmc_uploads` VALUES ('36', 'D:/workspace/20181130134624新建 Microsoft Excel 97-2003 工作表.xls', '2018-11-30 13:46:24');
