--liquibase formatted sql
--changeset Jitender:create-permission-table

CREATE TABLE IF NOT EXISTS permission (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR (512) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY name (name)
)

--rollback DROP TABLE permission