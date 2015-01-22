DELETE FROM film;
DELETE FROM genre;

INSERT INTO `genre`(`idgenre`,`nom`) VALUES (1,'Drame');
INSERT INTO `genre`(`idgenre`,`nom`) VALUES (2,'Action');
INSERT INTO `genre`(`idgenre`,`nom`) VALUES (3,'Comédie');

INSERT INTO `film`(`idfilm`,`titre`, datedesortie, idgenre, duree, realisateur, resume) VALUES (1, 'Interstellar', '2014-11-5', 1, 169, 'Christopher Nolan','Un groupe d\'explorateurs exploite une faille dans l\'espace-temps afin de parcourir des distances incroyables dans le but de sauver l\'humanité.');
INSERT INTO `film`(`idfilm`,`titre`, datedesortie, idgenre, duree, realisateur, resume) VALUES (2, 'Quand vient la nuit', '2014-11-12', 1, 107, 'Michael R. Roskam', 'Le gérant d\'un bar new-yorkais, impliqué dans les affaires de la mafia locale, est poursuivi par l\'ancien propriétaire d'un chien qu\'il a sauvé de la mort.');
INSERT INTO `film`(`idfilm`,`titre`, datedesortie, idgenre, duree, realisateur, resume) VALUES (3, 'Hunger Games : La Révolte, partie 1', '2014-11-19', 2, 125, 'Francis Lawrence', 'Katniss est devenue le symbole d\'une rébellion contre le pouvoir totalitaire. Son destin, celui de ses proches, et celui de Panem sont en jeu.');
INSERT INTO `film`(`idfilm`,`titre`, datedesortie, idgenre, duree, realisateur, resume) VALUES (4, 'Vie sauvage', '2014-10-29', 1, 106, 'Cédric Kahn', 'Après sa séparation avec sa femme, qui a eu la garde des enfants, Paco est venu les chercher pour partir en cavale dans le sud pendant des années.');
