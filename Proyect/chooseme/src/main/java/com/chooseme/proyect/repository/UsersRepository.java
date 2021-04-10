package com.chooseme.proyect.repository;
import java.util.Optional;	
import org.springframework.data.repository.CrudRepository;

import com.chooseme.proyect.entities.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

	Void save(Optional<Users> usersToUpdate);
	
}
