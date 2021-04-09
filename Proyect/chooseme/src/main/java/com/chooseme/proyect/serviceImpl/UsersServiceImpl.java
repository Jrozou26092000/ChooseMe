package com.chooseme.proyect.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;
import com.chooseme.proyect.entities.Users;	
import com.chooseme.proyect.repository.UsersRepository;	
import com.chooseme.proyect.service.UsersService;

import utils.BCrypt;


@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository usersRepository;
	Users user;
	
	
	@Override
	public List<Users> findAllUsers() {
		return (List<Users>) usersRepository.findAll();
	}
	
	@Override
	public Optional<Users> findUserById(int id) {
		Optional<Users> users = usersRepository.findById( id);
		return users;
	}
	


	@Override
	public Users findUserByPass(String password, int id) {
		user = null;
		try {
			user = usersRepository.findById(id).get();
		}
		
		catch(NoSuchElementException ne) {
		}
		if(BCrypt.checkpw(password, user.getPassword()))
		{
			return user;
		}
		return null;
		
		
		//return "La contrase;a coincide";
		
	}
	
	

	
	@Override
	public Users saveUser(Users usersNew) {
		
		usersNew.setPassword(BCrypt.hashpw(usersNew.getPassword(), BCrypt.gensalt()));
		
		return usersRepository.save(usersNew);
	}
	

	@Override
	public String deleteUsers(String pass, int id) {
		user = findUserByPass(pass, id);
		
		if(user != null) {
			user.setActive(0);
			usersRepository.save(user);
			return "Usuario ahora inactivo";
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
			
			usersRepository.save(usersToUpdate);
		}
		
		
		
		return "Error al modificar el usuario";
	}	
	
}
