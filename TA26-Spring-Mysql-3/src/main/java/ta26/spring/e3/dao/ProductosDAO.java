package ta26.spring.e3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ta26.spring.e3.dto.Productos;

public interface ProductosDAO extends JpaRepository<Productos, Integer>{
	
}