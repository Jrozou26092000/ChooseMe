package com.chooseme.proyect.serviceImpl;

import java.util.List;	
import java.util.Optional;

import org.hibernate.internal.util.MathHelper;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.chooseme.proyect.dto.UsersRequest;
import com.chooseme.proyect.entities.Users;	
import com.chooseme.proyect.repository.UsersRepository;	
import com.chooseme.proyect.service.UsersService;

import utils.MHelpers;


@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public List<Users> findAllUsers() {
		return (List<Users>) usersRepository.findAll();
	}
	
	@Override
	public Optional<Users> findUsersById(int id) {
		Optional <Users> users = usersRepository.findById( id);
		return users;
	}
	
	@Override
	public void saveUsers(UsersRequest usersNew) {
		
		Users users = MHelpers.modelmapper().map(usersNew, Users.class);
		this.usersRepository.save(users);
	}
	
	@Override
	public String deleteUsers(int id) {
		if(usersRepository.findById( id).isPresent()) {
			usersRepository.deleteById( id);
			return "Usuario eliminado";
		}
		return "El usuario no existe";
	}
	
	@Override
	public String updateUsers(Users usersUpdated) {
		int num = usersUpdated.getUser_id();
		if(usersRepository.findById( num).isPresent()) {
			Users usersToUpdate = new Users();
			usersToUpdate.setUser_id(usersUpdated.getUser_id());
			usersToUpdate.setUser_name(usersUpdated.getUser_name());
			usersToUpdate.setEmail(usersUpdated.getEmail());
			usersToUpdate.setPassword(usersUpdated.getPassword());
			usersToUpdate.setActive(usersUpdated.getActive());
			usersToUpdate.setName(usersUpdated.getName());
			usersToUpdate.setLastname(usersUpdated.getLastname());
			usersToUpdate.setPhone(usersUpdated.getPhone());
			usersToUpdate.setPoints(usersUpdated.getPoints());
			usersToUpdate.setGoogle_account(usersUpdated.getGoogle_account());
		}
		
		return "Error al modificar el usuario";
	}
	
	
	
	
}
