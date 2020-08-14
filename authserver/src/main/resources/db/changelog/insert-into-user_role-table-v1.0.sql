--liquibase formatted sql
--changeset Jitender:insert-into-role_user-table

    INSERT INTO role_user (ROLE_ID, USER_ID)
    VALUES
    (1, 1) /* jitender-admin */,
    (2, 2) /* admin-operatorr */ ;

--rollback DELETE FROM role_user