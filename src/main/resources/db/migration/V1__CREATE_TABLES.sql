DROP TABLE IF EXISTS BOOKS CASCADE;

CREATE TABLE BOOKS
(
    ID         BIGINT NOT NULL,
    TITLE      VARCHAR2(50),
    AUTHOR     VARCHAR2(50),
    PUBLISHER  VARCHAR2(50),
    STILL_HAVE BOOLEAN,
    LOCATION   VARCHAR2(50),
    PRIMARY KEY (ID)
);

INSERT INTO BOOKS(ID, TITLE, AUTHOR, PUBLISHER, STILL_HAVE, LOCATION)
VALUES (1, 'The Godfather', 'Mario Puzo', 'Penguin', TRUE, 'Home');
INSERT INTO BOOKS(ID, TITLE, AUTHOR, PUBLISHER, STILL_HAVE, LOCATION)
VALUES (2, 'Twelve Mighty Orphans', 'Jim Dent', 'Random House', FALSE, 'Sold');
INSERT INTO BOOKS(ID, TITLE, AUTHOR, PUBLISHER, STILL_HAVE, LOCATION)
VALUES (3, 'Daisy Jones and the Six', 'Taylor Jenkins Reid', 'Simon & Schuster', FALSE, 'Lent to Phil');
