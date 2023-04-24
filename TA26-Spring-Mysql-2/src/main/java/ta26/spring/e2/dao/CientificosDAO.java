package ta26.spring.e2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ta26.spring.e2.dto.Cientificos;

public interface CientificosDAO extends JpaRepository<Cientificos, Integer>{
	
}