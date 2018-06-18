
DROP TABLE IF EXISTS users;
CREATE TABLE users (userID INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY, firstname VARCHAR(55) NOT NULL, middlename VARCHAR(55) NOT NULL, lastname VARCHAR(55) NOT NULL, age INT(11) NOT NULL, gender VARCHAR(11)NOT NULL, address VARCHAR(255) NOT NULL);

INSERT INTO users(firstname, middlename, lastname, age, gender, address) VALUES ("Jonathan", "Flores", "Araneta", 21, "Male", "Gen.Trias, Cavite");
INSERT INTO users(firstname, middlename, lastname, age, gender, address) VALUES ("Emilio", "Aguinaldo", "Sebastian", 23, "Male", "Apparri, Cagayan Valley");
INSERT INTO users(firstname, middlename, lastname, age, gender, address) VALUES ("Katrina", "Lagdameo", "Araneta", 24, "Female", "Gen.Trias, Cavite");

DROP TABLE IF EXISTS teams;
CREATE TABLE teams (name VARCHAR(55) PRIMARY KEY NOT NULL, location VARCHAR(55) NOT NULL);

INSERT INTO teams(name, location) VALUES ("STI Storm", "Laguna");
INSERT INTO teams(name, location) VALUES ("AMA Thunder", "Cavite");
INSERT INTO teams(name, location) VALUES ("CEU Carabaws", "Batangas");
INSERT INTO teams(name, location) VALUES ("TUP Apaches", "Manila");
INSERT INTO teams(name, location) VALUES ("UST Tomcats", "Rizal");
INSERT INTO teams(name, location) VALUES ("BSU Servlets", "Quezon");

DROP TABLE IF EXISTS players;
CREATE TABLE players (playerID INT(11) PRIMARY KEY NOT NULL, name VARCHAR(55) NOT NULL, age INT(11) NOT NULL, height INT(11) NOT NULL, weight INT(11) NOT NULL, position VARCHAR(55) NOT NULL, team VARCHAR(55), FOREIGN KEY(team) REFERENCES teams(name));

INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (3, "Daniel Manalo", 19, 77, 150, "C","STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (21, "Goudy Espina", 23, 74, 148, "PF", "STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (24, "Ronald Raz", 29, 70, 155, "SF", "STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (33, "Jhon Renan Nuevo", 22, 72, 140, "PG", "STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (36, "Pagz Consuelo", 18, 69, 130, "SG", "STI Storm");

DROP TABLE IF EXISTS games;
CREATE TABLE games (gameID INT(11) PRIMARY KEY NOT NULL, hometeam VARCHAR(50), FOREIGN KEY(hometeam) REFERENCES teams(name) NOT NULL, awayteam VARCHAR(50), FOREIGN KEY(awayteam) REFERENCES teams(name) NOT NULL, homescore INT(11) NOT NULL, awayscore INT(11) NOT NULL);

INSERT INTO games (gameID, hometeam, awayteam, homescore, awayscore) VALUES (1, "STI Storm", "AMA Thunder", 87, 79);

