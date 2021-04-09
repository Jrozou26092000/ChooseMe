package com.chooseme.proyect.controllers;

import java.util.List;	
import java.util.Optional;	
import com.chooseme.proyect.entities.Users;

import utils.Exceptions.ApiUnprocessableEntity;

public interface UsersController {

	public List<Users> getUsers();
	
	public Optional<Users> getUsersById(int id);
	
	public Users addUsers(Users users) throws ApiUnprocessableEntity;
	
	public String updateUsers(Users usersNew);
	
	public String test();
	
	public Users findPassword(String password, int id);

	String deleteUsers(String password, int id);
}
