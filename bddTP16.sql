DROP DATABASE IF EXISTS bdd_tapas;

CREATE DATABASE IF NOT EXISTS bdd_tapas
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE bdd_tapas;

CREATE TABLE IF NOT EXISTS Commande(
idCommande INT AUTO_INCREMENT,
dateCommande DATETIME,
idTable INT,
PRIMARY KEY(idCommande));

CREATE TABLE IF NOT EXISTS TableResto(
idTable INT AUTO_INCREMENT,
nbClients INT,
PRIMARY KEY(idTable));

CREATE TABLE IF NOT EXISTS Tapas(
idTapas INT AUTO_INCREMENT,
nomTapas VARCHAR(64),
PRIMARY KEY(idTapas));

CREATE TABLE IF NOT EXISTS TapasCommande(
idTapas INT,
idCommande INT,
quantite INT,
PRIMARY KEY(idTapas, idCommande));

CREATE TABLE IF NOT EXISTS Categorie(
idCategorie INT AUTO_INCREMENT,
nomCategorie VARCHAR(64),
PRIMARY KEY(idCategorie));

CREATE TABLE IF NOT EXISTS TapasCategorie(
idTapas INT,
idCategorie INT,
PRIMARY KEY(idTapas, idCategorie));

ALTER TABLE Commande
ADD CONSTRAINT Commande_idTable
FOREIGN KEY (idTable)
REFERENCES TableResto(idTable);

ALTER TABLE TapasCommande
ADD CONSTRAINT TapasCommande_idTapas
FOREIGN KEY (idTapas)
REFERENCES Tapas(idTapas);

ALTER TABLE TapasCommande
ADD CONSTRAINT TapasCommande_idCommande
FOREIGN KEY (idCommande)
REFERENCES Commande(idCommande);

ALTER TABLE TapasCategorie
ADD CONSTRAINT TapasCategorie_idTapas
FOREIGN KEY (idTapas)
REFERENCES Tapas(idTapas);

ALTER TABLE TapasCategorie
ADD CONSTRAINT TapasCategorie_idCategorie
FOREIGN KEY (idCategorie)
REFERENCES Categorie(idCategorie);