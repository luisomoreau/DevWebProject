CREATE TABLE `genre` (
  `idgenre` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`idgenre`)
);

CREATE TABLE `film` (
  `idfilm` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) NOT NULL,
  `datedesortie` date NOT NULL,
  `idgenre` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  `realisateur` varchar(45) NOT NULL,
  `resume` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`idfilm`),
  KEY `id_genre_fk` (`idgenre`),
  CONSTRAINT `id_genre_fk` FOREIGN KEY (`idgenre`) REFERENCES `genre` (`idgenre`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

