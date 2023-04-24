DROP TABLE IF EXISTS asignado_a;
DROP TABLE IF EXISTS cientificos;
DROP TABLE IF EXISTS proyectos;
SET character_set_client = utf8mb4;

CREATE TABLE cientificos (
  dni varchar(9) NOT NULL,
  nomapels varchar(100),
  PRIMARY KEY (dni)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table cientificos
--

LOCK TABLES cientificos WRITE;
INSERT INTO cientificos (dni, nomapels) VALUES ('12345678A', 'Cientifico 1'),('87654321B', 'Cientifico 2'),('43218765C', 'Cientifico 3');
UNLOCK TABLES;

--
-- Table structure for table cientificos
--

SET character_set_client = utf8mb4;

CREATE TABLE proyectos (
  id INT NOT NULL AUTO_INCREMENT,
  nombre varchar(100),
  horas int,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table proyectos
--

LOCK TABLES proyectos WRITE;
INSERT INTO proyectos (nombre, horas) VALUES ('Proyecto 1', 100), ('Proyecto 2', 200), ('Proyecto 3', 300);
UNLOCK TABLES;

--
-- Table structure for table proyectos
--

SET character_set_client = utf8mb4 ;
 
CREATE TABLE asignado_a (
  id int NOT NULL AUTO_INCREMENT,
  id_cientifico varchar(9) NOT NULL,
  id_proyecto int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_cientifico) REFERENCES cientificos (dni) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_proyecto) REFERENCES proyectos (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table suministra
--

LOCK TABLES asignado_a WRITE;
INSERT INTO asignado_a (id_cientifico, id_proyecto) VALUES ('12345678A',1),('87654321B',2),('43218765C',3);
UNLOCK TABLES;
