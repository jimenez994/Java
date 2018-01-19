package com.zeus.EmployeeAndManagers.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.EmployeeAndManagers.models.EmployeeAndManagers;
import com.zeus.EmployeeAndManagers.repository.ManagerEmployeeRepo;

@Service
public class EmployeeAndManagerServices {
	
	private ManagerEmployeeRepo managerEmployeeRepo;
	public EmployeeAndManagerServices(ManagerEmployeeRepo managerEmployeeRepo) {
		this.managerEmployeeRepo = managerEmployeeRepo;
	}
		
	public EmployeeAndManagers create(EmployeeAndManagers employee) {
		return managerEmployeeRepo.save(employee);
		}
	
	public EmployeeAndManagers get(Long id) {
		return managerEmployeeRepo.findOne(id);
		}
	
	public EmployeeAndManagers update(EmployeeAndManagers employee) {
		return managerEmployeeRepo.save(employee);
		}
	public void delete(EmployeeAndManagers employee) {
		managerEmployeeRepo.delete(employee);
		}
	
	public List<EmployeeAndManagers> all() {
		return managerEmployeeRepo.findAll();
		} // all workers
	public List<EmployeeAndManagers> managers() {
		return managerEmployeeRepo.findByPromoted(true);
		} // managers only
	public List<EmployeeAndManagers> employees() {
		return managerEmployeeRepo.findByPromoted(false);
		} // managers only
	
	public List<EmployeeAndManagers> team(EmployeeAndManagers manager) {
		return managerEmployeeRepo.findByManager(manager);
		}
	
	public boolean exists(Long id) {
		return managerEmployeeRepo.existsById(id);
		}
	
	public void promote(EmployeeAndManagers manager) {
		manager.setPromoted(true);
		managerEmployeeRepo.save(manager);
	}
	
	public void assign(EmployeeAndManagers employee, EmployeeAndManagers manager) {
		employee.setManager(manager);
		managerEmployeeRepo.save(employee);
	}

}
