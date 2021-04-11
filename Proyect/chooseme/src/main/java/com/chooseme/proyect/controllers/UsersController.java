package com.chooseme.proyect.controllers;

import java.util.List;	
import java.util.Optional;	
import com.chooseme.proyect.entities.Users;

import utils.Exceptions.ApiUnprocessableEntity;


/* declaración de las funciones usadas en el implement*/
public interface UsersController {
	
	//devuelve una lista de usuarios de tipo User
	public List<Users> getUsers();
	//busca un usuario por su id (user_id)
	public Optional<Users> getUsersById(Users user);
	//agrega un nuevo usuario a la db
	boolean addUsers(Users user, String passwordcomp) throws ApiUnprocessableEntity;
	//actualiza la informacion de usuario
	public String updateUsers(Users usersNew);
	//para testear la coneccion
	public String test();

	//borra un usuario, para realizar la operacion se requiere la contraseña del usuario
	Boolean deleteUsers(Users user);
	
	Boolean loggin(Users userNew) throws ApiUnprocessableEntity;
	



}
