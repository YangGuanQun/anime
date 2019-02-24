/*
Navicat MySQL Data Transfer

Source Server         : clover@121.196.192.183
Source Server Version : 50725
Source Host           : 121.196.192.183:3306
Source Database       : clover

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-02-24 19:57:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_ani
-- ----------------------------
DROP TABLE IF EXISTS `t_ani`;
CREATE TABLE `t_ani` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `episode_num` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `period` varchar(255) DEFAULT NULL,
  `fin_state` int(2) DEFAULT NULL,
  `watch_state` int(2) DEFAULT NULL,
  `day` int(2) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `flag` int(2) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
