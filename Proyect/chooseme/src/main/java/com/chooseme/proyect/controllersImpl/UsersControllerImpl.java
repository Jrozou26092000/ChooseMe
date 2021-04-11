package com.chooseme.proyect.controllersImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chooseme.proyect.controllers.UsersController;
import com.chooseme.proyect.entities.Users;
import com.chooseme.proyect.service.UsersService;
import com.chooseme.proyect.validator.UserLogginValidator;
import com.chooseme.proyect.validator.UserValidatorComponent;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;
import utils.Exceptions.ApiUnprocessableEntity;

@RestController
public class UsersControllerImpl implements UsersController {
	@Autowired
	UsersService userService;
	@Autowired
	UserValidatorComponent userValidator;
	@Autowired
	UserLogginValidator logginValidator;

	/*
	 * funciones provicionales para traer datos al front
	 * @RquestMapping genera la url de la cual se obtendrán los datos
	 * en postman se llama a la dirección como get
	 */
	// http://localhost:8888/users (GET)
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Users> getUsers() {
		return userService.findAllUsers();
	}
	/*
	 * @PathVariable es provicional, y captura datos desde la url
	 * esto debe cambiar por un @RquestBody ya que permite insertar datos desde la url a cualquiera
	 * esto es una falla de seguridad que causa inyecciones sql.
	 */
	// http://localhost:8888/users/1 (GET)
	@Override
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Users> getUsersById(@PathVariable int id) {
		return userService.findUserById(id);
	}
	/*
	 * este permite capturar datos desde un body request raw json
	 * para ver la estructura, consultar la carpeta donde se encuentran los archivos de postman
	 */
	// http://localhost:8080/users/add (ADD)
	@Override
	@PostMapping(value = "/users/add",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Users addUsers(@RequestBody Users user) throws ApiUnprocessableEntity {

		this.userValidator.validator(user);
		
		return userService.saveUser(user);
		
	}
	
	// http://localhost:8080/users/delete/1 (GET)
	@Override
	@RequestMapping(value = "/users/delete/{id}/{password}", method = RequestMethod.GET, produces = "application/json")
	public String deleteUsers(@PathVariable String password, @PathVariable int id) {
		return userService.deleteUsers(password, id);
	}
	
	@Override
	@RequestMapping(value = "/users/password/{id}/{password}", method = RequestMethod.GET, produces = "application/json")
	public Users findPassword(@PathVariable String password, @PathVariable int id) {
		return userService.findUserByPass(password, id);
	}
	// http://localhost:8080/users/update (PATCH)
	@Override
	@RequestMapping(value = "/users/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateUsers(Users userNew) {
		return userService.updateUsers(userNew);
	}

	// http://localhost:8080/test (GET)
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
	
	
	@Override
	@PostMapping(value = "/users/loggin",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean loggin(@RequestBody Users userNew) throws ApiUnprocessableEntity {
		System.out.println("Test");
		this.logginValidator.validatorLoggin(userNew);
		System.out.println(userNew.getUser_name());
		if(userService.logginUser(userNew)) {
			System.out.println("password correcta");
			return true;
		}
		
		else {
			System.out.println("password incorrecta");
			return false;
		}
		
	}
	
}