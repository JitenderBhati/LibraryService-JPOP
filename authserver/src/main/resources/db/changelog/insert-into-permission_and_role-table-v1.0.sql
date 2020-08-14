--liquibase formatted sql
--changeset Jitender:insert-into-permission_and_role-table

INSERT INTO permission (NAME) VALUES
 ('create'),
 ('read'),
 ('update'),
 ('delete');

INSERT INTO role (NAME) VALUES
		('ROLE_admin'),('ROLE_user');

 --rollback DELETE FROM permission
 --rollback DELETE FROM role