package com.chooseme.proyect.controllers;

import java.util.List;	
import java.util.Optional;	
import com.chooseme.proyect.entities.Users;

public interface UsersController {

	public List<Users> getUsers();
	
	public Optional<Users> getUsersById(int id);
	
	public Users addUsers(Users users);
	
	public String deleteUsers(int id);
	
	public String updateUsers(Users usersNew);
	
	public String test();
	
}
