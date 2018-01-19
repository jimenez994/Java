package com.zeus.EmployeeAndManagers.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EmployeeAndManagers {
	@Id 
	@GeneratedValue
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date createdAt;
	@Column
	private Date updatedAt;
	
	@OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
	private List<EmployeeAndManagers> employees;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private EmployeeAndManagers manager;
	
    private boolean promoted;

	public EmployeeAndManagers() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPromoted() {
		return promoted;
	}

	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<EmployeeAndManagers> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeAndManagers> employees) {
		this.employees = employees;
	}

	public EmployeeAndManagers getManager() {
		return manager;
	}

	public void setManager(EmployeeAndManagers manager) {
		this.manager = manager;
	}
	
	
	

}
