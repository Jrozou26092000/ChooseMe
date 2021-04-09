package com.chooseme.proyect.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chooseme.proyect.controllers.UsersController;
import com.chooseme.proyect.entities.Users;
import com.chooseme.proyect.service.UsersService;

@RestController
public class UsersControllerImpl implements UsersController {
	@Autowired
	UsersService userService;

	// http://localhost:8888/users (GET)
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Users> getUsers() {
		return userService.findAllUsers();
	}

	// http://localhost:8888/users/1 (GET)
	@Override
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Users> getUsersById(@PathVariable int id) {
		return userService.findUserById(id);
	}

	// http://localhost:8080/users/add (ADD)
	@Override
	@RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json")
	public Users addUsers(Users user) {
		return userService.saveUser(user);
	}

	// http://localhost:8080/users/delete/1 (GET)
	@Override
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteUsers(@PathVariable int id) {
		return userService.deleteUsers(id);
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
}