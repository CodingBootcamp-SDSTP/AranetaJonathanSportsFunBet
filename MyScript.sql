DROP DATABASE myprojectdb;
CREATE DATABASE myprojectdb;
CREATE USER myproject@localhost IDENTIFIED BY '1216';
GRANT ALL PRIVILEDGES ON assetdb.* TO myproject@localhost;
USE myprojectdb;

DROP TABLE IF EXISTS users;
CREATE TABLE users (id INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY, firstname VARCHAR(55) NOT NULL, middlename VARCHAR(55) NULL, lastname VARCHAR(55) NOT NULL, birthdate DATE NOT NULL, gender CHAR(1) CHECK (gender = "M" OR gender = "F") NOT NULL, address VARCHAR(255) NOT NULL);

INSERT INTO users(firstname, middlename, lastname, birthdate, gender, address) VALUES ("Jonathan", "Flores", "Araneta", 07-21-1984, 'M', "Gen.Trias, Cavite");
INSERT INTO users(firstname, middlename, lastname, birthdate, gender, address) VALUES ("Emilio", "Aguinaldo", "Sebastian", 04-11-1994, 'M', "Apparri, Isabela");
INSERT INTO users(firstname, middlename, lastname, birthdate, gender, address) VALUES ("Katrina", "Lagdameo", "Araneta", 11-24-1984,'F', "Gen.Trias, Cavite");

DROP TABLE IF EXISTS teams;
CREATE TABLE teams (name VARCHAR(55) PRIMARY KEY NOT NULL, location VARCHAR(55) NOT NULL);

INSERT INTO teams(name, location) VALUES ("STI Storm", "Laguna");
INSERT INTO teams(name, location) VALUES ("AMA Thunder", "Cavite");
INSERT INTO teams(name, location) VALUES ("CEU Carabaws", "Batangas");
INSERT INTO teams(name, location) VALUES ("TUP Apaches", "Manila");
INSERT INTO teams(name, location) VALUES ("UST Tomcats", "Rizal");
INSERT INTO teams(name, location) VALUES ("BSU Servlets", "Quezon");


DROP TABLE IF EXISTS players;
CREATE TABLE players (id INT(11) NOT NULL PRIMARY KEY, name VARCHAR(55) NOT NULL, height INT(11) NOT NULL, weight INT(11) NOT NULL, position VARCHAR(55) CHECK(position = "PG" OR position = "SG" OR position = "PF" OR position = "SF" OR position = "C") NOT NULL, location INT(11), REFERENCES teams(name));

INSERT INTO TableAssets( name, price, location, assignedto, assettype) VALUES ( "MS Office", 1000, NULL, "2018-01-001", "softwarelicense");
INSERT INTO TableAssets( name, price, location, assignedto, assettype) VALUES ("Windows 10", 1500, NULL, NULL, "softwarelicense");
INSERT INTO TableAssets( name, price, location, assignedto,assettype) VALUES ( "Table 1", 500, 4017, "2018-01-002", "table");
INSERT INTO TableAssets( name, price, location, assignedto, assettype) VALUES ( "Table 2", 700, 4016, "2018-01-003", "table");
INSERT INTO TableAssets( name, price, location, assignedto,assettype) VALUES ( "STI Building", 1000000, 4019, NULL, "building");
INSERT INTO TableAssets( name, price, location, assignedto, assettype) VALUES ( "Building 2", 4000000, 4019 , NULL, "building");

SELECT * FROM TablePersons;
SELECT * FROM TableLocations;
SELECT * FROM TableAssets;