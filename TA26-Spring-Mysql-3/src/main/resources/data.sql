DROP TABLE IF EXISTS venta;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS cajeros;
DROP TABLE IF EXISTS maquinas_registradoras;

--
-- Table structure for table productos
--

SET character_set_client = utf8mb4;

CREATE TABLE productos (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(100),
  precio int,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table productos
--

LOCK TABLES productos WRITE;
INSERT INTO productos (nombre, precio) VALUES ('Arroz', 2),('Macarrones', 1),('Tomate', 3);
UNLOCK TABLES;

--
-- Table structure for table cajeros
--

SET character_set_client = utf8mb4;

CREATE TABLE cajeros (
  id int NOT NULL AUTO_INCREMENT,
  nomapels varchar(100),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table cajeros
--

LOCK TABLES cajeros WRITE;
INSERT INTO cajeros (nomapels) VALUES ('Cajero 1'), ('Cajero 2'), ('Cajero 3');
UNLOCK TABLES;


--
-- Table structure for table maquinas_registradoras
--

SET character_set_client = utf8mb4;

CREATE TABLE maquinas_registradoras (
  id int NOT NULL AUTO_INCREMENT,
  piso int DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table maquinas_registradoras
--

LOCK TABLES maquinas_registradoras WRITE;
INSERT INTO maquinas_registradoras (piso) VALUES (1), (2), (3);
UNLOCK TABLES;

--
-- Table structure for table venta
--

SET character_set_client = utf8mb4 ;
 
CREATE TABLE venta (
  id int NOT NULL AUTO_INCREMENT,
  id_producto int NOT NULL,
  id_cajero int NOT NULL,
  id_maquina int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_producto) REFERENCES productos (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_cajero) REFERENCES cajeros (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_maquina) REFERENCES maquinas_registradoras (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table venta
--

LOCK TABLES venta WRITE;
INSERT INTO venta (id_producto, id_cajero, id_maquina) VALUES (1,1,1),(2,2,2),(3,3,3);
UNLOCK TABLES;
