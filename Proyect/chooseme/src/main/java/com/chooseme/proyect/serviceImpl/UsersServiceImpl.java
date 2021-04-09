package com.chooseme.proyect.serviceImpl;

import java.util.List;	
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;
import com.chooseme.proyect.entities.Users;	
import com.chooseme.proyect.repository.UsersRepository;	
import com.chooseme.proyect.service.UsersService;


@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public List<Users> findAllUsers() {
		return (List<Users>) usersRepository.findAll();
	}
	
	@Override
	public Optional<Users> findUserById(int id) {
		Optional <Users> users = usersRepository.findById( id);
		return users;
	}
	

	
	@Override
	public Users saveUser(Users usersNew) {
		if (usersNew != null) {
			return usersRepository.save(usersNew);
		}
		return new Users();
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
