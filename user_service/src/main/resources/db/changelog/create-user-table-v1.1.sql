--liquibase formatted sql
--changeset jitender:create-User-table

CREATE TABLE user(
    id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    address_id int NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_user_address FOREIGN KEY (address_id)
    REFERENCES address(id)
)

--rollback DROP TABLE user