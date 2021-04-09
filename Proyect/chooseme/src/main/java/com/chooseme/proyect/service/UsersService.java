package com.chooseme.proyect.service;

import java.util.List;
import java.util.Optional;
import com.chooseme.proyect.entities.Users;

public interface UsersService {
	public List<Users> findAllUsers();
	
	public Optional<Users> findUserById(int id);
	
	public Users saveUser(Users userNew);
	
	public String deleteUsers(int id);
	
	public String updateUsers(Users userNew);
}
