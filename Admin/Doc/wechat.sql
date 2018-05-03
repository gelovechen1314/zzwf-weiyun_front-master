
DROP TABLE IF EXISTS wechat_menu;
CREATE TABLE wechat_menu (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(30) DEFAULT NULL,
  type varchar(20) DEFAULT NULL,
  btn_key varchar(30) DEFAULT NULL,
  url varchar(128) DEFAULT NULL,
  app_id varchar(50) DEFAULT NULL,
  pagepath varchar(128) DEFAULT NULL,
  pid bigint(20) DEFAULT '0',
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
  UNIQUE KEY btn_key (btn_key)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DROP TABLE IF EXISTS wechat_setting;
CREATE TABLE wechat_setting (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  companny varchar(128) NOT NULL,
  domain varchar(256),
  app_id varchar(50) DEFAULT NULL COMMENT '应用id',
  secret varchar(128) DEFAULT NULL COMMENT '密钥',
  token varchar(60) DEFAULT NULL,
  mch_id varchar(50) DEFAULT NULL COMMENT '商户id',
  mch_key varchar(128) DEFAULT NULL COMMENT '商户支付key',
  alipay_id varchar(50) DEFAULT NULL COMMENT '支付宝支付id',
  alipay_key varchar(128) DEFAULT NULL COMMENT '支付宝支付key',
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

