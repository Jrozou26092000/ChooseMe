package com.chooseme.proyect.validator;


import org.springframework.stereotype.Component;

import com.chooseme.proyect.entities.Users;
import com.chooseme.proyect.repository.UsersRepository;

import utils.Exceptions.ApiUnprocessableEntity;

@Component
public class UserLogginValidatorComponent implements UserLogginValidator {
	
	UsersRepository usersRepository;
	Users user_check;
	@Override
	public void validatorLoggin(Users user) throws ApiUnprocessableEntity {
		System.out.println("pre get name validation");
		user_check = usersRepository.getUserByUsername(user.getUser_name());
		System.out.println("post get name validation");
		if(user.getName() == null || user.getName().isEmpty()) {
			message("El nombre de usuario es obligatorio");
		}else if(user_check.getName().isEmpty()) {
			message("No se encontro al usuario");
		}
		
		
	}

	private void message(String message) throws ApiUnprocessableEntity {
		throw new ApiUnprocessableEntity(message);
		
	}

}
