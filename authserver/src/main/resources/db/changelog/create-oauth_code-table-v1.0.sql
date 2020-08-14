--liquibase formatted sql
--changeset Jitender:create-oauth_code-table

create table if not exists oauth_code (
  code VARCHAR(256), authentication LONG VARBINARY
);

--rollback DROP TABLE oauth_code