--liquibase formatted sql
--changeset Jitender:create-address-table

CREATE TABLE address (
id INT NOT NULL AUTO_INCREMENT,
line1 VARCHAR(30) NOT NULL,
line2 VARCHAR(30),
city VARCHAR(20) NOT NULL,
state VARCHAR(30) NOT NULL,
country VARCHAR(30) NOT NULL,
pincode INT NOT NULL,
PRIMARY KEY(id)
)

--rollback DROP TABLE address