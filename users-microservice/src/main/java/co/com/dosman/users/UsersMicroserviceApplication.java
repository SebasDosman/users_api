package co.com.dosman.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({ "co.com.dosman.users" })
@EnableJpaRepositories({ "co.com.dosman.users.repositories" })
@EntityScan({ "co.com.dosman.common.entities" }) 
@SpringBootApplication
public class UsersMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
}