DROP TABLE IF EXISTS user;
CREATE TABLE user (userID INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY, username VARCHAR(50) NOT NULL, password VARCHAR(50) NOT NULL,usertype INT(11) NOT NULL, firstname VARCHAR(55) NOT NULL, lastname VARCHAR(55) NOT NULL, age INT(11) NOT NULL, gender VARCHAR(11)NOT NULL, address VARCHAR(255) NOT NULL);

INSERT INTO (username, password, usertype,firstname, lastname, age, gender, address) VALUES ("admin", "admin123", 1, "Jonathan", "Araneta", 21, "Male", "Gen.Trias, Cavite");
INSERT INTO user(username, password, usertype, firstname, lastname, age, gender, address) VALUES ("pakboy", "pass123", 2, "Emilio", "Sebastian", 23, "Male", "Apparri, Cagayan Valley");
INSERT INTO user(username, password, usertype, firstname, lastname, age, gender, address) VALUES ("megz", "kat123", 2, "Katrina", "Damaso", 24, "Female", "Gen.Trias, Cavite");

DROP TABLE IF EXISTS team;
CREATE TABLE team (name VARCHAR(55) PRIMARY KEY NOT NULL, location VARCHAR(55) NOT NULL);

INSERT INTO team(name, location) VALUES ("STI Storm", "Laguna");
INSERT INTO team(name, location) VALUES ("AMA Thunder", "Cavite");
INSERT INTO team(name, location) VALUES ("CEU Carabaws", "Batangas");
INSERT INTO team(name, location) VALUES ("TUP Apaches", "Manila");
INSERT INTO team(name, location) VALUES ("UST Tomcats", "Rizal");
INSERT INTO team(name, location) VALUES ("BSU Servlets", "Quezon");

DROP TABLE IF EXISTS players;
CREATE TABLE players (playerID INT(11) PRIMARY KEY NOT NULL, name VARCHAR(55) NOT NULL, age INT(11) NOT NULL, height INT(11) NOT NULL, weight INT(11) NOT NULL, position VARCHAR(55) NOT NULL, team VARCHAR(55), FOREIGN KEY(team) REFERENCES teams(name));

INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (3, "Daniel Manalo", 19, 77, 150, "C","STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (21, "Goudy Espina", 23, 74, 148, "PF", "STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (24, "Ronald Raz", 29, 70, 155, "SF", "STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (33, "Jhon Renan Nuevo", 22, 72, 140, "PG", "STI Storm");
INSERT INTO players(playerID, name, age, height, weight, position, team) VALUES (36, "Pagz Consuelo", 18, 69, 130, "SG", "STI Storm");
