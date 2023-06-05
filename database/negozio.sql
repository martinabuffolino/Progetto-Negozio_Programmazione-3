-- Creazione
----------------------------------
CREATE TABLE `prenotazione` (
  `CODICE` varchar(45) DEFAULT NULL,
  `NOMECLIENTE` varchar(45) DEFAULT NULL,
  `COGNOMECLIENTE` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `CELLULARE` varchar(45) DEFAULT NULL,
  `SERIALE` varchar(45) DEFAULT NULL,
  `MODELLO` varchar(45) DEFAULT NULL,
  `TIPO` varchar(45) DEFAULT NULL,
  `COSTO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODICE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
--------------------------------
-- Popolamento
INSERT INTO negozio.prenotazione (codice, nomecliente, cognomecliente, email, password, cellulare, seriale, modello, tipo, costo) VALUES
('01', 'mario', 'verde', 'marioverde@gmail.com', 'ciao', '332636225', 'bbb0012vf', 'iPhone 12', 'Sostituzione Display', '100');
('02', 'sara', 'rossi', 'sararossi@gmail.com', 'ciao', '3362514852', 'vvv0021vs', 'Samsung A20', 'Sostituzione Batteria', '80');
('03', 'laura', 'bove', 'laurabove@gmail.com', 'ciao', '3345698520', 'ggg7458wr', 'iPhone 14', 'Sostituzione Display', '100');
('04', 'marco', 'bove', 'marcobove@gmail.com', 'ciao', '3321547852', 'gns1655fe', 'iPhone 11', 'Sostituzione Batteria', '80');
('05', 'luca', 'esposito', 'lucaesposito@gmail.com', 'ciao', '3352625229', 'vsv1589vs', 'Samsung Flip', 'Sostituzione Batteria', '80');
('06', 'giacomo', 'russo', 'giacomorusso@gmail.com', 'ciao', '3335698741', 'vsv1616vs', 'Samsung S22', 'Sostituzione Display', '100');
('07', 'paolo', 'poppi', 'paolopoppi@gmail.com', 'ciao', '3326655474', 'vss1516vs', 'Samsung S22', 'Sostituzione Batteria', '80');


