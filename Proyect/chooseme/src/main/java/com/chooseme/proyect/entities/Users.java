package com.chooseme.proyect.entities;

import javax.persistence.Column;	
import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;	
import javax.persistence.GenerationType;	
import javax.persistence.Id;	
import javax.persistence.Table;

@Entity	
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	int id;
	@Column(name= "user_photo_google")
	String photo_url;
	@Column(name="user_name")
	String user_name;
	@Column(name="email")
	String email;
	@Column(name="password")
	String password;
	@Column(name="active")
	int active;
	@Column(name="name")
	String real_name;
	@Column(name="lastname")
	String lastname;
	@Column(name="phone")
	String phone;
	@Column(name="points")
	int points;
	@Column(name="google_account")
	String google_account;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser_photo_url() {
		return photo_url;
	}
	public void setUser_photo_url(String photo_url) {
		this.photo_url = photo_url;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getName() {
		return real_name;
	}
	public void setName(String real_name) {
		this.real_name = real_name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getGoogle_account() {
		return google_account;
	}
	public void setGoogle_account(String google_account) {
		this.google_account = google_account;
	}
	
	
	
}
