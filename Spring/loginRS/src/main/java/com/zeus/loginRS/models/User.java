package com.zeus.loginRS.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User{
	@Id
	@GeneratedValue
	private long id;

	@Email(message="Invalid Email Format! Ex: example@example.com")
	private String email;
	
	@Size(min=1,max=255,message="First Name must be between 1-255 characters.")
	private String firstName;

	@Size(min=1,max=255,message="Last Name must be between 1-255 characters.")
	private String lastName;

	@Size(min=8,max=255,message="Password must be between 8-255 characters.")
	private String password;

	private int level;

	@Transient
	@Size(min=8,max=255,message="Password Confirmation must be between 8-255 characters.")	
	private String confirm;

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Pack> packs;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pack_id")
    private Pack pack;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private DueDate dueDate;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public void setEmail(String email){
		this.email=email;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setConfirm(String confirm){
		this.confirm=confirm;
	}	
	public String getEmail(){return email;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public String getPassword(){return password;}
	public String getConfirm(){return confirm;}

	
	public List<Pack> getPacks() {
		return packs;
	}
	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	public DueDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(DueDate dueDate) {
		this.dueDate = dueDate;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public User(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}