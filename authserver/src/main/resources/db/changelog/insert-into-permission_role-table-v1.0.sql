--liquibase formatted sql
--changeset Jitender:insert-into-permission_role-table

INSERT INTO permission_role (PERMISSION_ID, ROLE_ID) VALUES
     (1,1), /*create-> admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read user */
     (3,2);  /* update user */

--rollback DELETE FROM permission_role