SET GLOBAL time_zone = '+3:00';

CREATE TABLE `glavniprojektant` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ImePrezime` varchar(100) NOT NULL,
  `BrojLicence` bigint NOT NULL,
  `Zvanje` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `idejnoresenje` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `DatumIzrade` date NOT NULL,
  `GlavniProjektantId` int NOT NULL,
  `ObjekatId` int NOT NULL,
  `LokacijskaDozvolaId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `idejnoresenje_glavniprojektant_idx` (`GlavniProjektantId`),
  KEY `idejnoresenje_objekat_idx` (`ObjekatId`),
  KEY `idejnoresenje_lokacijskadozvola_idx` (`LokacijskaDozvolaId`),
  CONSTRAINT `idejnoresenje_glavniprojektant` FOREIGN KEY (`GlavniProjektantId`) REFERENCES `glavniprojektant` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idejnoresenje_lokacijskadozvola` FOREIGN KEY (`LokacijskaDozvolaId`) REFERENCES `lokacijskadozvola` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idejnoresenje_objekat` FOREIGN KEY (`ObjekatId`) REFERENCES `objekat` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `informacijeolokaciji` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `DatumIzdavanja` date NOT NULL,
  `NamenaZemljista` varchar(255) NOT NULL,
  `Zona` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `istorijapromenevalute` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `DatumPromene` date NOT NULL,
  `Kurs` decimal(10,2) NOT NULL,
  `ValutaId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `istorijapromenevalute_valuta_idx` (`ValutaId`),
  CONSTRAINT `istorijapromenevalute_valuta` FOREIGN KEY (`ValutaId`) REFERENCES `valuta` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `izvestajoizvrsenjuradova` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  `Datum` date NOT NULL,
  `StatusDokumenta` int NOT NULL,
  `KontrolorId` int NOT NULL,
  `NazivKontrolora` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `izvestajoizvrsenjuradova_kontrolor_idx` (`KontrolorId`),
  CONSTRAINT `izvestajoizvrsenjuradova_kontrolor` FOREIGN KEY (`KontrolorId`) REFERENCES `kontrolor` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `kontrolor` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  `Jmbg` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `lokacijskadozvola` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `OpstiPodaci` varchar(255) NOT NULL,
  `LokacijskiUslovi` varchar(255) NOT NULL,
  `BrojParcele` bigint NOT NULL,
  `PovrsinaParcele` bigint NOT NULL,
  `DatumIzdavanja` date DEFAULT NULL,
  `InformacijeOLokacijiId` int NOT NULL,
  `NazivIdejnogResenja` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `lokacijskadozvola_iol_idx` (`InformacijeOLokacijiId`),
  CONSTRAINT `lokacijskadozvola_iol` FOREIGN KEY (`InformacijeOLokacijiId`) REFERENCES `informacijeolokaciji` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `nalogzauplatu` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  `SifraPlacanja` int NOT NULL,
  `PozivNaBroj` varchar(45) NOT NULL,
  `Model` int NOT NULL,
  `SvrhaUplate` varchar(45) NOT NULL,
  `Iznos` decimal(10,2) NOT NULL,
  `DatumUplate` date NOT NULL,
  `Uplatilac` varchar(45) NOT NULL,
  `ValutaId` int NOT NULL,
  `BrojRacunaId` int NOT NULL,
  `NazivValute` varchar(45) DEFAULT NULL,
  `NazivPrimaoca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `nalogzauplatu_tekuciracun_idx` (`BrojRacunaId`),
  KEY `nalogzauplatu_valuta_idx` (`ValutaId`),
  CONSTRAINT `nalogzauplatu_tekuciracun` FOREIGN KEY (`BrojRacunaId`) REFERENCES `tekuciracun` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nalogzauplatu_valuta` FOREIGN KEY (`ValutaId`) REFERENCES `valuta` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `objekat` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `Dimenzije` decimal(10,2) NOT NULL,
  `Karakteristike` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `povrsina` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Oznaka` int NOT NULL,
  `Naziv` varchar(50) NOT NULL,
  `VrstaPoda` varchar(20) NOT NULL,
  `ProjekatZaGradjevinskuDozvoluId` int NOT NULL,
  `VrstaPovrsineId` int NOT NULL,
  `ProstorijaNaziv` varchar(50) DEFAULT NULL,
  `Status` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `povrsina_pgd_idx` (`ProjekatZaGradjevinskuDozvoluId`),
  KEY `povrsina_vrstapovrsine_idx` (`VrstaPovrsineId`),
  CONSTRAINT `povrsina_pgd` FOREIGN KEY (`ProjekatZaGradjevinskuDozvoluId`) REFERENCES `projekatzagradjevinskudozvolu` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `povrsina_vrstapovrsine` FOREIGN KEY (`VrstaPovrsineId`) REFERENCES `vrstapovrsine` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4964 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `projekatzagradjevinskudozvolu` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `DatumIzrade` date DEFAULT NULL,
  `NazivIdejnogResenja` varchar(50) DEFAULT NULL,
  `IdejnoResenjeId` int NOT NULL,
  `StatusDokumenta` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `pgd_idejnoresenje_idx` (`IdejnoResenjeId`),
  CONSTRAINT `pgd_idejnoresenje` FOREIGN KEY (`IdejnoResenjeId`) REFERENCES `idejnoresenje` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `prostorija` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `VrstaPovrsineId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `prostorija_vrstapovrsine_idx` (`VrstaPovrsineId`),
  CONSTRAINT `prostorija_vrstapovrsine` FOREIGN KEY (`VrstaPovrsineId`) REFERENCES `vrstapovrsine` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `stavkeizvestaja` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  `Opis` varchar(100) NOT NULL,
  `Rezultat` varchar(45) NOT NULL,
  `Status` int NOT NULL,
  `IzvestajId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `stavkeizvestaja_izvestajoizvrsenjuradova_idx` (`IzvestajId`),
  CONSTRAINT `stavkeizvestaja_izvestajoizvrsenjuradova` FOREIGN KEY (`IzvestajId`) REFERENCES `izvestajoizvrsenjuradova` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tekuciracun` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `BrojRacuna` varchar(45) NOT NULL,
  `NazivPrimaoca` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `valuta` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vrstapovrsine` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
