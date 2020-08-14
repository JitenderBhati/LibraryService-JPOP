--liquibase formatted sql
--changeset Jitender:insert-into-oauth_detail-table

INSERT IGNORE INTO oauth_client_details (
                                            client_id,
                                            client_secret,
                                            web_server_redirect_uri,
                                            scope,
                                            access_token_validity,
                                            refresh_token_validity,
                                            resource_ids,
                                            authorized_grant_types,
                                            additional_information)
VALUES ('desktop',
'$2y$12$qdwXuinr.QzS48lM7msMgOz2I3kdhb74iosCSYj3dOJTIxRvz/y0.',
'http://localhost:8282/code',
'READ,WRITE',
'3600',
'10000',
'library,user,book',
'authorization_code,password,refresh_token,implicit',
'{}');

--rollback DELETE FROM oauth_client_details WHERE client_id='desktop'