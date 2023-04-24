package ta26.spring.e3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ta26.spring.e3.dto.Venta;

public interface VentaADAO extends JpaRepository<Venta, Integer>{
	
}