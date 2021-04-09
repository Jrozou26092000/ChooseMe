package com.chooseme.proyect.entities;

import javax.persistence.Column;	
import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;	
import javax.persistence.GenerationType;	
import javax.persistence.Id;	
import javax.persistence.Table;

@Entity	
@Table(name = "reviewers")
public class Reviewer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reviewer_id")
	int id;
	@Column(name="user_name")
	String user_name;
	@Column(name="user_id")
	int user_id;
	@Column(name="reviewer")
	int reviewer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getReviewer() {
		return reviewer;
	}
	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}
	
}
