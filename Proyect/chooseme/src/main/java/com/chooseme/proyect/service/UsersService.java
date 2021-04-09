package com.chooseme.proyect.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;

import com.chooseme.proyect.entities.Users;

public interface UsersService {
	public List<Users> findAllUsers();
	
	public Optional<Users> findUserById(int id);
	
	public Users saveUser(Users userNew);
	
	
	public String updateUsers(Users userNew);

	Users findUserByPass(String password, int id);

	String deleteUsers(String pass, int id);
}
