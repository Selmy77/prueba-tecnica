package com.asd.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asd.model.Active;

@Repository
public interface ActiveRepository extends CrudRepository<Active, Long> {
	
	Collection<Active> findAll();
	
	@Query(value="SELECT * FROM actives WHERE tipo=?1", nativeQuery = true)
	List<Active> findAllByTypeIgnoreCase(String tipo);
	
	@Query(value="SELECT * FROM actives WHERE serial=?1", nativeQuery = true)
	List<Active> findAllBySerialIgnoreCase(Long serial);
	
}
