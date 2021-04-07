package com.chooseme.proyect.repository;
import java.util.Optional;	
import org.springframework.data.jpa.repository.JpaRepository;	
import com.chooseme.proyect.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Void save(Optional<Users> usersToUpdate);

}
