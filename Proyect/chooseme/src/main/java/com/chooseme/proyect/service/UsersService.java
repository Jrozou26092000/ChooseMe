package com.chooseme.proyect.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;

import com.chooseme.proyect.entities.Users;
/*
 * interface para la implementación de la clase service
 */
public interface UsersService {
	// Trae todos los usuarios desde la DB
	public List<Users> findAllUsers();
	// Busca un usuario por su id
	public Optional<Users> findUserById(int id);
	// Crea un nuevo usuario de tipo usuario
	public Users saveUser(Users userNew);
	// Actrualiza el usuario existente
	public String updateUsers(Users userNew);
	//verifica que la contraseña ingresada sea la correcta, para ello busca por id y la contraseña encriptada referida a ese id
	Users findUserByPass(String password, int id);
	//borra un usuario ingresando su contraseña y su id
	String deleteUsers(String pass, int id);
	

	public Boolean logginUser(Users userNew);

}
