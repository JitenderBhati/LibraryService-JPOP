--liquibase formatted sql
--changeset Jitender:create-oauth_access_token-table

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(256),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);

--rollback DROP TABLE oauth_refresh_token