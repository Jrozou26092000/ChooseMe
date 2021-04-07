package com.chooseme.proyect.controllersImpl;


import java.util.List;	
import java.util.Optional;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;	
import com.chooseme.proyect.controllers.UsersController;	
import com.chooseme.proyect.entities.Users;
import com.chooseme.proyect.repository.UsersRepository;
import com.chooseme.proyect.service.UsersService;

/*@Controller // This means that this class is a Controller
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
	}
	@GetMapping(path="/test")
	  public @ResponseBody String test() {
	    return "Test done";
	}
	@GetMapping(path="/all")
	  public @ResponseBody String getAllUsers() {
	    return "Hola Mundo";
	}*/
@RestController
@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UsersControllerImpl {
	@Autowired
	private UsersRepository userRepository;
	UsersService usersService;
	
	@PostMapping(path="/setusers")
	public @ResponseBody String addNewUsers (@RequestParam String user_name,
			@RequestParam String email) {
		Users u = new Users();
		u.setName(user_name);
	    u.setEmail(email);
	    userRepository.save(u);
	    return "Saved";
	}
	@PostMapping(path="/users")
	public @ResponseBody String getNewUser () {
		Users u = new Users();
		return u.getUser_name();
		
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Users> getUsersById(@PathVariable int id){
		return usersService.findUsersById(id);
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	
	@GetMapping(value = "/test")		
	public @ResponseBody String test() {			
		return "Test";
	}
	
	@PostMapping("/createUser")
    public Users createUser(@RequestBody Users users) {
        return userRepository.save(users);
    }
}
