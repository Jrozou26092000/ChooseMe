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
	public Optional<Users> getUsersById(int id);
	//agrega un nuevo usuario a la db
	public Users addUsers(Users users) throws ApiUnprocessableEntity;
	//actualiza la informacion de usuario
	public String updateUsers(Users usersNew);
	//para testear la coneccion
	public String test();
	//verifica si el password encriptado y el ingresado son los mismos
	public Users findPassword(String password, int id);
	//borra un usuario, para realizar la operacion se requiere la contraseña del usuario
	String deleteUsers(String password, int id);
	
	Boolean loggin(Users userNew) throws ApiUnprocessableEntity;
}
