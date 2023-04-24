DROP TABLE IF EXISTS suministra;
DROP TABLE IF EXISTS piezas;
DROP TABLE IF EXISTS proveedores;
SET character_set_client = utf8mb4;

CREATE TABLE piezas (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(100),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table piezas
--

LOCK TABLES piezas WRITE;
INSERT INTO piezas (nombre) VALUES ('tornillo'),('tuerca'),('clavo');
UNLOCK TABLES;

--
-- Table structure for table proveedores
--

SET character_set_client = utf8mb4;

CREATE TABLE proveedores (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(100),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table proveedores
--

LOCK TABLES proveedores WRITE;
INSERT INTO proveedores (nombre) VALUES ('Proveedor 1'), ('Proveedor 2'), ('Proveedor 3');
UNLOCK TABLES;

--
-- Table structure for table suministra
--

SET character_set_client = utf8mb4 ;
 
CREATE TABLE suministra (
  id int NOT NULL AUTO_INCREMENT,
  precio int,
  id_pieza int NOT NULL,
  id_proveedor int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_pieza) REFERENCES piezas (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_proveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table suministra
--

LOCK TABLES suministra WRITE;
INSERT INTO suministra (precio, id_pieza, id_proveedor) VALUES (1,1,'1'),(2,2,'2'),(3,3,'3');
UNLOCK TABLES;
