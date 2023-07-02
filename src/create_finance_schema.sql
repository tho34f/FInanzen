Create Table years (
	year int not null,
    value_start decimal,
    value_end decimal,
    CONSTRAINT pk_years PRIMARY KEY (year)
);

CREATE TABLE financeproduct (
	id int not null AUTO_INCREMENT,
    bezeichnung mediumtext NOT NULL,
    CONSTRAINT pk_financeproduct Primary Key (id)
);

INSERT INTO financeproduct (id, bezeichnung) VALUES (6,'Aktien');
INSERT INTO YEARS (year, value_start, value_end) VALUES ();

SELECT * FROM financeproduct;
SHOW CREATE TABLE financeproduct;
SELECT * FROM YEARS;
SHOW CREATE TABLE years;