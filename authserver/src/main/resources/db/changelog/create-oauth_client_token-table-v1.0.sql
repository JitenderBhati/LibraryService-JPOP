--liquibase formatted sql
--changeset Jitender:create-oauth_client_token-table

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(256),
  token LONG VARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

--rollback DROP TABLE oauth_client_token