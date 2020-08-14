--liquibase formatted sql
--changeset Jitender:insert-into-user-table

insert into user (
                    id,
                    username,
                    password,
                    email,
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked)
    VALUES ('1',
    'jitender',
    '$2y$12$4dTQCY2tEJRrNgLffGK8lem9njDz65ou4GnDxNDIbxz1SR8fnmvha',
    'jitender@epam.com',
    '1',
    '1',
    '1',
    '1');

 insert into user (
                    id,
                    username,
                    password,
                    email,
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked)
    VALUES ('2',
    'admin',
    '$2y$12$0HpfD7Qw3C8kqrY2/TvfBOBuZbmYhyA0rhRe09Y0Pm.VyixEpxqNy',
    'admin@epam.com',
    '1',
    '1',
    '1',
    '1');

--     INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
--     VALUES
--     (1, 1) /* jitender-admin */,
--     (2, 2) /* admin-operatorr */ ;

--rollback DELETE TABLE user