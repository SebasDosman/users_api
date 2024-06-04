package co.com.dosman.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({ "co.com.dosman.users"})
@EnableDiscoveryClient
@EnableJpaRepositories({ "co.com.dosman.users.repositories", "co.com.dosman.roles.repositories" })
@EntityScan({ "co.com.dosman.common.entities" }) 
@SpringBootApplication
public class UsersMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
}
