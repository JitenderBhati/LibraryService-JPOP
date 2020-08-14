--liquibase formatted sql
--changeset Jitender:create-user-table

CREATE TABLE IF NOT EXISTS  user (
  id INT(11) NOT NULL auto_increment,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(1024) NOT NULL,
  email VARCHAR(1024) NOT NULL,
  enabled TINYINT(4) NOT NULL,
  accountNonExpired TINYINT(4) NOT NULL,
  credentialsNonExpired TINYINT(4) NOT NULL,
  accountNonLocked TINYINT(4) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY username (username)
)