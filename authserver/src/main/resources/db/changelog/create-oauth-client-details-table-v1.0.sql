--liquibase formatted sql
--changeset Jitender:create-oauth_client_details-table

CREATE TABLE IF NOT EXISTS  oauth_client_details (
  client_id VARCHAR(255) NOT NULL,
  client_secret VARCHAR(255) NOT NULL,
  web_server_redirect_uri VARCHAR(2048) DEFAULT NULL,
  scope VARCHAR(255) DEFAULT NULL,
  access_token_validity INT(11) DEFAULT NULL,
  refresh_token_validity INT(11) DEFAULT NULL,
  resource_ids VARCHAR(1024) DEFAULT NULL,
  authorized_grant_types VARCHAR(1024) DEFAULT NULL,
  authorities VARCHAR(1024) DEFAULT NULL,
  additional_information VARCHAR(4096) DEFAULT NULL,
  autoapprove VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (client_id)
)

--rollback DROP TABLE oauth_client_details