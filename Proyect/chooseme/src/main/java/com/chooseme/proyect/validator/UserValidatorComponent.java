package com.chooseme.proyect.validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chooseme.proyect.entities.Users;

import utils.Exceptions.ApiUnprocessableEntity;

@Component
public class UserValidatorComponent implements UserValidator {

	@Override
	public void validator(Users user) throws ApiUnprocessableEntity {
		System.out.println("usuario: ");
		System.out.println(user);
		System.out.println(user.getUser_id());
		if(user.getUser_name() == null || user.getUser_name().isEmpty()) {
			message("El nombre de usuario es obligatorio");
		}else if(user.getUser_name().length() <3) {
			message("El nombre de usuario debe tener al menos 3 caracteres");
		}
		if(user.getEmail() == null || user.getEmail().isEmpty()) {
			message("El correo es obligatorio");
		}else if(user.getEmail().length() <7) {
			message("El correo de usuario debe tener al menos 7 caracteres");
		}
		if(user.getName() == null || user.getName().isEmpty()) {
			message("El nombre es obligatorio");
		}else if(user.getName().length() <3) {
			message("El nombre debe tener al menos 3 caracteres");
		}
		if(user.getLastname() == null || user.getLastname().isEmpty()) {
			message("El apellido es obligatorio");
		}else if(user.getLastname().length() <3) {
			message("El apellido debe tener al menos 3 caracteres");
		}
		
		
	}
	
	private void message(String message) throws ApiUnprocessableEntity {
		throw new ApiUnprocessableEntity(message);
	}

}
