--liquibase formatted sql
--changeset Jitender:insert-into-permission_and_role-table

INSERT INTO permission (NAME) VALUES
 ('create_profile'),
 ('read_profile'),
 ('update_profile'),
 ('delete_profile');

INSERT INTO role (NAME) VALUES
		('ROLE_admin'),('ROLE_operator');

 --rollback DELETE FROM permission
 --rollback DELETE FROM role