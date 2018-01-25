/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50521
 Source Host           : localhost:3306
 Source Schema         : demo_unit

 Target Server Type    : MySQL
 Target Server Version : 50521
 File Encoding         : 65001

 Date: 25/01/2018 16:15:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for distributed_lock
-- ----------------------------
DROP TABLE IF EXISTS `distributed_lock`;
CREATE TABLE `distributed_lock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` bigint(255) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of distributed_lock
-- ----------------------------
INSERT INTO `distributed_lock` VALUES (1, 0, 0);
INSERT INTO `distributed_lock` VALUES (2, 1, 0);
INSERT INTO `distributed_lock` VALUES (3, 2, 0);
INSERT INTO `distributed_lock` VALUES (4, 3, 0);
INSERT INTO `distributed_lock` VALUES (5, 4, 0);
INSERT INTO `distributed_lock` VALUES (6, 5, 0);
INSERT INTO `distributed_lock` VALUES (7, 6, 0);
INSERT INTO `distributed_lock` VALUES (8, 7, 0);
INSERT INTO `distributed_lock` VALUES (9, 8, 0);
INSERT INTO `distributed_lock` VALUES (10, 9, 0);
INSERT INTO `distributed_lock` VALUES (11, 10, 0);
INSERT INTO `distributed_lock` VALUES (12, 11, 0);
INSERT INTO `distributed_lock` VALUES (13, 12, 0);
INSERT INTO `distributed_lock` VALUES (14, 13, 0);
INSERT INTO `distributed_lock` VALUES (15, 14, 0);
INSERT INTO `distributed_lock` VALUES (16, 15, 0);
INSERT INTO `distributed_lock` VALUES (17, 16, 0);
INSERT INTO `distributed_lock` VALUES (18, 17, 0);
INSERT INTO `distributed_lock` VALUES (19, 18, 0);
INSERT INTO `distributed_lock` VALUES (20, 19, 0);
INSERT INTO `distributed_lock` VALUES (21, 20, 0);
INSERT INTO `distributed_lock` VALUES (22, 21, 0);
INSERT INTO `distributed_lock` VALUES (23, 22, 0);
INSERT INTO `distributed_lock` VALUES (24, 23, 0);
INSERT INTO `distributed_lock` VALUES (25, 24, 0);
INSERT INTO `distributed_lock` VALUES (26, 25, 0);
INSERT INTO `distributed_lock` VALUES (27, 26, 0);
INSERT INTO `distributed_lock` VALUES (28, 27, 0);
INSERT INTO `distributed_lock` VALUES (29, 28, 0);
INSERT INTO `distributed_lock` VALUES (30, 29, 0);
INSERT INTO `distributed_lock` VALUES (31, 30, 0);
INSERT INTO `distributed_lock` VALUES (32, 31, 0);
INSERT INTO `distributed_lock` VALUES (33, 32, 0);
INSERT INTO `distributed_lock` VALUES (34, 33, 0);
INSERT INTO `distributed_lock` VALUES (35, 34, 0);
INSERT INTO `distributed_lock` VALUES (36, 35, 0);
INSERT INTO `distributed_lock` VALUES (37, 36, 0);
INSERT INTO `distributed_lock` VALUES (38, 37, 0);
INSERT INTO `distributed_lock` VALUES (39, 38, 0);
INSERT INTO `distributed_lock` VALUES (40, 39, 0);
INSERT INTO `distributed_lock` VALUES (41, 40, 0);
INSERT INTO `distributed_lock` VALUES (42, 41, 0);
INSERT INTO `distributed_lock` VALUES (43, 42, 0);
INSERT INTO `distributed_lock` VALUES (44, 43, 0);
INSERT INTO `distributed_lock` VALUES (45, 44, 0);
INSERT INTO `distributed_lock` VALUES (46, 45, 0);
INSERT INTO `distributed_lock` VALUES (47, 46, 0);
INSERT INTO `distributed_lock` VALUES (48, 47, 0);
INSERT INTO `distributed_lock` VALUES (49, 48, 0);
INSERT INTO `distributed_lock` VALUES (50, 49, 0);
INSERT INTO `distributed_lock` VALUES (51, 50, 0);
INSERT INTO `distributed_lock` VALUES (52, 51, 0);
INSERT INTO `distributed_lock` VALUES (53, 52, 0);
INSERT INTO `distributed_lock` VALUES (54, 53, 0);
INSERT INTO `distributed_lock` VALUES (55, 54, 0);
INSERT INTO `distributed_lock` VALUES (56, 55, 0);
INSERT INTO `distributed_lock` VALUES (57, 56, 0);
INSERT INTO `distributed_lock` VALUES (58, 57, 0);
INSERT INTO `distributed_lock` VALUES (59, 58, 0);
INSERT INTO `distributed_lock` VALUES (60, 59, 0);
INSERT INTO `distributed_lock` VALUES (61, 60, 0);
INSERT INTO `distributed_lock` VALUES (62, 61, 0);
INSERT INTO `distributed_lock` VALUES (63, 62, 0);
INSERT INTO `distributed_lock` VALUES (64, 63, 0);
INSERT INTO `distributed_lock` VALUES (65, 64, 0);
INSERT INTO `distributed_lock` VALUES (66, 65, 0);
INSERT INTO `distributed_lock` VALUES (67, 66, 0);
INSERT INTO `distributed_lock` VALUES (68, 67, 0);
INSERT INTO `distributed_lock` VALUES (69, 68, 0);
INSERT INTO `distributed_lock` VALUES (70, 69, 0);
INSERT INTO `distributed_lock` VALUES (71, 70, 0);
INSERT INTO `distributed_lock` VALUES (72, 71, 0);
INSERT INTO `distributed_lock` VALUES (73, 72, 0);
INSERT INTO `distributed_lock` VALUES (74, 73, 0);
INSERT INTO `distributed_lock` VALUES (75, 74, 0);
INSERT INTO `distributed_lock` VALUES (76, 75, 0);
INSERT INTO `distributed_lock` VALUES (77, 76, 0);
INSERT INTO `distributed_lock` VALUES (78, 77, 0);
INSERT INTO `distributed_lock` VALUES (79, 78, 0);
INSERT INTO `distributed_lock` VALUES (80, 79, 0);
INSERT INTO `distributed_lock` VALUES (81, 80, 0);
INSERT INTO `distributed_lock` VALUES (82, 81, 0);
INSERT INTO `distributed_lock` VALUES (83, 82, 0);
INSERT INTO `distributed_lock` VALUES (84, 83, 0);
INSERT INTO `distributed_lock` VALUES (85, 84, 0);
INSERT INTO `distributed_lock` VALUES (86, 85, 0);
INSERT INTO `distributed_lock` VALUES (87, 86, 0);
INSERT INTO `distributed_lock` VALUES (88, 87, 0);
INSERT INTO `distributed_lock` VALUES (89, 88, 0);
INSERT INTO `distributed_lock` VALUES (90, 89, 0);
INSERT INTO `distributed_lock` VALUES (91, 90, 0);
INSERT INTO `distributed_lock` VALUES (92, 91, 0);
INSERT INTO `distributed_lock` VALUES (93, 92, 0);
INSERT INTO `distributed_lock` VALUES (94, 93, 0);
INSERT INTO `distributed_lock` VALUES (95, 94, 0);
INSERT INTO `distributed_lock` VALUES (96, 95, 0);
INSERT INTO `distributed_lock` VALUES (97, 96, 0);
INSERT INTO `distributed_lock` VALUES (98, 97, 0);
INSERT INTO `distributed_lock` VALUES (99, 98, 0);
INSERT INTO `distributed_lock` VALUES (100, 99, 0);

SET FOREIGN_KEY_CHECKS = 1;
