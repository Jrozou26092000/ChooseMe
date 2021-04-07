package com.chooseme.proyect.controllersImpl;


import java.util.List;	
import java.util.Optional;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;	
import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;	
import com.chooseme.proyect.controllers.UsersController;	
import com.chooseme.proyect.entities.Users;	
import com.chooseme.proyect.service.UsersService;

@Controller // This means that this class is a Controller*/
@RequestMapping(path="/testing") // This means URL's start with /demo (after Application path)
public class UsersControllerImpl implements UsersController {
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Users> getUsers(){
		return usersService.findAllUsers();
	}
	
	@Override
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Users> getUsersById(@PathVariable int id){
		return usersService.findUsersById(id);
	}
	@Override
	@RequestMapping(value = "/Users/add", method = RequestMethod.POST, produces = "application/json")		
	public Users addUsers(Users users) {
		return usersService.saveUsers(users);
	}
	@Override		
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET, produces = "application/json")		
	public String deleteUsers(@PathVariable int id) {			
		return usersService.deleteUsers(id);
	}
	@Override		
	@RequestMapping(value = "/usres/update", method = RequestMethod.PATCH, produces = "application/json")		
	public String updateUsers(Users usersNew) {			
		return usersService.updateUsers(usersNew);		
	}
	/*@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")		
	@Override		
	public String test() {			
		return "Test done";		
	}*/
	@GetMapping(path="/test")
	  public @ResponseBody String test() {
	    return "Test done";
	}
	@GetMapping(path="/all")
	  public @ResponseBody String getAllUsers() {
	    return "Hola Mundo";
	}
	

}
