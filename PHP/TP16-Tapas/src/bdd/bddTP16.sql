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

INSERT INTO Categorie(nomCategorie) VALUES
("Végétarien"),
("Viande et charcuterie"),
("Poisson"),
("Froid"),
("Chaud");

INSERT INTO Tapas(nomTapas) VALUES
("Patatas ketchup maison spicy et aïoli"),
("Mousse de pois chiches, fruits secs épicés"),
("Piquillos de chèvre menthe"),
("Caviar d'aubergines et crispy oignons"),
("Croquette de jambon serrano, creamcheese"),
("Brochette de poulet miel"),
("Fois gras, porto, crumble de figue, jambon"),
("Samoussa de boeuf, yaourt menthe"),
("Anchois marinés, feta, concombre"),
("Calamar tempura, paprika, citron"),
("Tartare de saumon, soja, yuzu"),
("Cabillaud confit, crumble de chorizo, yakitori");

INSERT INTO TapasCategorie(idTapas, idCategorie) VALUES
(1, 1), (1, 4),
(2, 1), (2, 4),
(3, 1), (3, 4),
(4, 1), (4, 5),
(5, 2), (5, 4),
(6, 2), (6, 5),
(7, 2), (7, 4),
(8, 2), (8, 5),
(9, 3), (9, 4),
(10, 3), (10, 5),
(11, 3), (11, 4),
(12, 3), (12, 5);

INSERT INTO TableResto(nbClients) VALUES
(3),(4),(2);

INSERT INTO Commande(dateCommande, idTable) VALUES
("2020-03-20 11:57:08", 1), 
("2020-03-20 12:14:45", 2),
("2020-03-20 12:35:49", 1),
("2020-03-20 12:48:23", 2),
("2020-03-20 13:04:41", 3);

INSERT INTO TapasCommande(idTapas, idCommande, quantite) VALUES
(1, 1, 3), (6, 1, 2), (4, 1, 1),
(5, 2, 2), (8, 2, 3), (12, 2, 2),
(7, 3, 5), (9, 2, 5),
(6, 4, 3), (3, 4, 4), (7, 4, 6),
(4, 5, 3), (2, 5, 4), (11, 5, 3);



