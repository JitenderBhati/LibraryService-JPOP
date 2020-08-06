--liquibase formatted sql
--changeset Jitender:create-library-table

CREATE TABLE library (
id INT NOT NULL AUTO_INCREMENT,
user INT NOT NULL,
book INT NOT NULL,
issueDate DATE NOT NULL,
issuedBy INT NOT NULL ,
returnDate DATE,
PRIMARY KEY(id)
)

--rollback DROP TABLE library