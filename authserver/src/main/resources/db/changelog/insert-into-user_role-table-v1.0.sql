--liquibase formatted sql
--changeset Jitender:insert-into-role_user-table

    INSERT INTO role_user (ROLE_ID, USER_ID)
    VALUES
    (1, 2) /* jitender-user */,
    (2, 1) /* admin-admin */ ;

--rollback DELETE FROM role_user