--liquibase formatted sql
--changeset Jitender:create-role-table

CREATE TABLE IF NOT EXISTS role (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(id),
  UNIQUE KEY name (name)
)

--rollback DROP TABLE role