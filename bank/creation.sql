CREATE TABLE COMPTES(
	IDCOMPTE INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,
	NOM VARCHAR(50) NOT NULL,
	BALANCE INTEGER NOT NULL
);

INSERT INTO COMPTES(NOM, BALANCE) VALUES('Jean', 15);
INSERT INTO COMPTES(NOM, BALANCE) VALUES('Jacques', 25);
INSERT INTO COMPTES(NOM, BALANCE) VALUES('Jeanne', 75);
INSERT INTO COMPTES(NOM, BALANCE) VALUES('Robert', 150);