package co.com.dosman.roles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.dosman.roles.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {	
	boolean existsByName(String name);
}
