package ta26.spring.e1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ta26.spring.e1.dto.Piezas;

public interface PiezasDAO extends JpaRepository<Piezas, Integer>{
	
}