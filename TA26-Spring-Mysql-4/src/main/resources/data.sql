DROP TABLE IF EXISTS reserva;
DROP TABLE IF EXISTS investigadores;
DROP TABLE IF EXISTS equipos;
DROP TABLE IF EXISTS facultades;

--
-- Table structure for table facultades
--

SET character_set_client = utf8mb4;

CREATE TABLE facultades (
  id int NOT NULL AUTO_INCREMENT, 
  nombre varchar(100),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table facultades
--

LOCK TABLES facultades WRITE;
INSERT INTO facultades (nombre) VALUES ('Facultad de ciencias'), ('Facultad de quimica'), ('Facultad de medicina');
UNLOCK TABLES;

--
-- Table structure for table investigadores
--

SET character_set_client = utf8mb4;

CREATE TABLE investigadores (
  dni varchar(9) NOT NULL,
  nomapels varchar(100),
  id_facultad int,
  PRIMARY KEY (dni),
  FOREIGN KEY (id_facultad) REFERENCES facultades (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table investigadores
--

LOCK TABLES investigadores WRITE;
INSERT INTO investigadores (dni, nomapels, id_facultad) VALUES
('12345678A' ,'Investigador 1', 1),
('87654321B' ,'Investigador 2', 2),
('43218765C','Investigador 3', 3);
UNLOCK TABLES;

--
-- Table structure for table equipos
--

SET character_set_client = utf8mb4;

CREATE TABLE equipos (
  id int NOT NULL AUTO_INCREMENT, 
  nombre varchar(100),
  id_facultad int,
  PRIMARY KEY (id),
  FOREIGN KEY (id_facultad) REFERENCES facultades (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table equipos
--

LOCK TABLES equipos WRITE;
INSERT INTO equipos (nombre, id_facultad) VALUES ('Equipo 1', 1), ('Equipo 2', 2), ('Equipo 3', 3);
UNLOCK TABLES;

--
-- Table structure for table reserva
--

SET character_set_client = utf8mb4 ;
 
CREATE TABLE reserva (
  id int NOT NULL AUTO_INCREMENT,
  comienzo DATETIME,
  fin DATETIME,
  dni_investigador varchar(9),
  id_equipo int,
  PRIMARY KEY (id),
  FOREIGN KEY (dni_investigador) REFERENCES investigadores (dni) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_equipo) REFERENCES equipos (id) ON DELETE CASCADE ON UPDATE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES reserva WRITE;
INSERT INTO reserva (comienzo, fin, dni_investigador, id_equipo) VALUE
('2023-01-01 12:00:00', '2024-01-01 12:00:00', '12345678A', 1),
('2023-02-02 12:00:00', '2024-02-02 12:00:00', '87654321B', 2),
('2023-03-03 12:00:00', '2024-01-02 12:00:00', '43218765C', 3);
UNLOCK TABLES;
