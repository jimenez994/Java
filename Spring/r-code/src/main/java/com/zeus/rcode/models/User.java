package com.zeus.rcode.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=8)
	private String username;
	
	@Email(message="Invalid Email Format! Ex: example@example.com")
	private String email;
	
	@Size(min=8,max=255,message="Password must be between 8-255 characters.")
	private String password;

	private int level = 0;

	@Transient
	@Size(min=8,max=255,message="Password Confirmation must be between 8-255 characters.")	
	private String confirm;

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Question> quetion;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "friend_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userFriends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "requests", 
    joinColumns = @JoinColumn(name = "sender_id"), 
    inverseJoinColumns = @JoinColumn(name = "reciver_id")
    )
    private List<User> sendRequests;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "requests", 
    joinColumns = @JoinColumn(name = "reciver_id"), 
    inverseJoinColumns = @JoinColumn(name = "sender_id")
    )
    private List<User> recieveRequests;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Answer> Answers;
    
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Image> image;
    
    @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private UserInfo userInfo;
	
	public User() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	public List<Question> getQuetion() {
		return quetion;
	}
	public void setQuetion(List<Question> quetion) {
		this.quetion = quetion;
	}
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	public List<User> getUserFriends() {
		return userFriends;
	}
	public void setUserFriends(List<User> userFriends) {
		this.userFriends = userFriends;
	}
	public List<User> getSendRequests() {
		return sendRequests;
	}
	public void setSendRequests(List<User> sendRequests) {
		this.sendRequests = sendRequests;
	}
	public List<User> getRecieveRequests() {
		return recieveRequests;
	}
	public void setRecieveRequests(List<User> recieveRequests) {
		this.recieveRequests = recieveRequests;
	}
	public List<Image> getImage() {
		return image;
	}
	public void setImage(List<Image> image) {
		this.image = image;
	}
	public List<Answer> getAnswers() {
		return Answers;
	}
	public void setAnswers(List<Answer> answers) {
		Answers = answers;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
	
	
	

}
