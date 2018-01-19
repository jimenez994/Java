package com.zeus.EmployeeAndManagers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.EmployeeAndManagers.models.EmployeeAndManagers;

@Repository
public interface ManagerEmployeeRepo extends CrudRepository<EmployeeAndManagers, Long>{
	
	List<EmployeeAndManagers> findAll(); // find all employees
	
	List<EmployeeAndManagers> findByManager(EmployeeAndManagers manager);

	List<EmployeeAndManagers> findByPromoted(boolean promoted);
	// retrieve list of only managers
	
	boolean existsById(Long id); // check if Employee exists by id
}
