--liquibase formatted sql
--changeset Jitender:create-user_role-table

CREATE TABLE IF NOT EXISTS role_user (
  role_id INT(11) DEFAULT NULL,
  user_id INT(11) DEFAULT NULL,
  KEY role_id (role_id),
  KEY user_id (user_id),
  CONSTRAINT role_user_ibfk_1 FOREIGN KEY (role_id) REFERENCES role (id),
  CONSTRAINT role_user_ibfk_2 FOREIGN KEY (user_id) REFERENCES user (id)
)

--rollback DROP TABLE user_role