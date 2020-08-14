--liquibase formatted sql
--changeset Jitender:create-permission_role-table

CREATE TABLE IF NOT EXISTS permission_role (
  permission_id INT(11) DEFAULT NULL,
  role_id INT(11) DEFAULT NULL ,
  KEY permission_id (permission_id),
  KEY role_id (role_id),
  CONSTRAINT permission_role_ibfk_1 FOREIGN KEY (permission_id) REFERENCES permission (id),
  CONSTRAINT permission_role_ibfk_2 FOREIGN KEY (role_id) REFERENCES role (id)
)

--rollback DROP TABLE permission_role