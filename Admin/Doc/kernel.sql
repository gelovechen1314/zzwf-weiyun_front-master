-- item 数据字典表
DROP TABLE IF EXISTS windy_item;
CREATE TABLE windy_item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  type varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  value varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  remark varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  add_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  add_user bigint(20) DEFAULT NULL,
  update_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  update_user bigint(20) DEFAULT NULL,
  attr0 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr1 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr2 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr3 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr4 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr5 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr6 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr7 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr8 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr9 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 用户表(商户信息也要写在这里面)
DROP TABLE IF EXISTS windy_user;
CREATE TABLE windy_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  account VARCHAR(50) not null COLLATE utf8mb4_bin,
  code varchar(50) not null COLLATE utf8mb4_bin,
  name VARCHAR(50) COLLATE utf8mb4_bin,
  nick VARCHAR(50) COLLATE utf8mb4_bin,
  password VARCHAR(50) not null COLLATE utf8mb4_bin,
  pwd_encrypt varchar(10) not null COLLATE utf8mb4_bin default '0' COMMENT '0不加密，1加密',
  sex VARCHAR(10) COLLATE utf8mb4_bin DEFAULT '1',
  phone VARCHAR(30) COLLATE utf8mb4_bin,
  email varchar(128) COLLATE utf8mb4_bin,
  card_type VARCHAR(10) COLLATE utf8mb4_bin DEFAULT '1' COMMENT '1身份证',
  card_no   VARCHAR(20) COLLATE utf8mb4_bin,
  qq VARCHAR(20) COLLATE utf8mb4_bin,
  we_chat VARCHAR(50) COLLATE utf8mb4_bin COMMENT '微信openid',
  head_image varchar(256),
  flag VARCHAR(10) not null COLLATE utf8mb4_bin DEFAULT '1',
  type VARCHAR(10) not NULL COLLATE utf8mb4_bin DEFAULT '1',
  user_from VARCHAR(10) COLLATE utf8mb4_bin,
  shared_revenue_rate int comment '收入分成比例',
  add_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  add_user bigint(20) DEFAULT NULL,
  update_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  update_user bigint(20) DEFAULT NULL,
  attr0 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr1 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr2 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr3 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr4 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr5 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr6 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr7 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr8 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr9 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY `account` (`account`),
  UNIQUE KEY `phoen` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- role 角色表
DROP TABLE IF EXISTS windy_role;
CREATE TABLE windy_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL COLLATE utf8mb4_bin,
  code VARCHAR(50) COLLATE utf8mb4_bin,
  remark VARCHAR(128) COLLATE utf8mb4_bin,
  flag VARCHAR(10) COLLATE utf8mb4_bin,
  add_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  add_user bigint(20) DEFAULT NULL,
  update_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  update_user bigint(20) DEFAULT NULL,
  attr0 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr1 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr2 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr3 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr4 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr5 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr6 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr7 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr8 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr9 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- menu 菜单
DROP TABLE IF EXISTS windy_menu ;
CREATE TABLE windy_menu (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) COLLATE utf8mb4_bin,
  code VARCHAR(50) COLLATE utf8mb4_bin,
  pid BIGINT DEFAULT 0,
  url VARCHAR(128) COLLATE utf8mb4_bin,
  icon_ VARCHAR(128) COLLATE utf8mb4_bin,
  has_children varchar(10) COLLATE utf8mb4_bin,
  is_extern VARCHAR(10) COLLATE utf8mb4_bin DEFAULT '0',
  flag VARCHAR(10) COLLATE utf8mb4_bin,
  remark VARCHAR(128) COLLATE utf8mb4_bin,
  add_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  add_user bigint(20) DEFAULT NULL,
  update_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  update_user bigint(20) DEFAULT NULL,
  attr0 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr1 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr2 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr3 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr4 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr5 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr6 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr7 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr8 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr9 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- org 组织表
DROP TABLE IF EXISTS windy_org;
CREATE TABLE windy_org (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) COLLATE utf8mb4_bin,
  remark varchar(128) COLLATE utf8mb4_bin,
  flag varchar(10) COLLATE utf8mb4_bin,
  add_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  add_user bigint(20) DEFAULT NULL,
  update_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  update_user bigint(20) DEFAULT NULL,
  attr0 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr1 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr2 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr3 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr4 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr5 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr6 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr7 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr8 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr9 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- user_role 用户角色表
DROP TABLE IF EXISTS windy_user_role;
CREATE TABLE windy_user_role (
  user_id bigint,
  role_id BIGINT,
  PRIMARY KEY (user_id,role_id)
);

-- user_org 用户组织表
DROP TABLE IF EXISTS windy_user_org;
CREATE TABLE windy_user_org (
  user_id bigint,
  org_id BIGINT,
  PRIMARY KEY (user_id,org_id)
);

-- role_menu 角色菜单表
DROP TABLE IF EXISTS windy_role_menu;
CREATE TABLE windy_role_menu (
  role_id bigint,
  menu_id BIGINT,
  PRIMARY KEY (role_id,menu_id)
);

-- setting 系统设置表
DROP TABLE IF EXISTS windy_setting;
CREATE TABLE windy_setting (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) COLLATE utf8mb4_bin,
  domain VARCHAR(128) COLLATE utf8mb4_bin,
  short_name VARCHAR(40) COLLATE utf8mb4_bin,
  org_enable VARCHAR(10) COLLATE utf8mb4_bin,
  add_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  add_user bigint(20) DEFAULT NULL,
  update_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  update_user bigint(20) DEFAULT NULL,
  attr0 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr1 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr2 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr3 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr4 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr5 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr6 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr7 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr8 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr9 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 公告
DROP TABLE IF EXISTS windy_notice;
CREATE TABLE windy_notice (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT ' id',
  title varchar(50) DEFAULT NULL COMMENT '公告标题',
  type int(4) DEFAULT NULL COMMENT '公告分类(系统消息/资讯/推广/商户)',
  content varchar(1024) DEFAULT NULL COMMENT '公告内容',
  notice_personnel varchar(50) DEFAULT NULL COMMENT '发布人',
  add_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  add_user bigint(20) DEFAULT NULL,
  update_time varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  update_user bigint(20) DEFAULT NULL,
  attr0 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr1 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr2 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr3 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr4 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr5 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr6 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr7 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr8 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  attr9 varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


