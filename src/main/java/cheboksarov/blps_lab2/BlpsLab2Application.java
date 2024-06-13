package cheboksarov.blps_lab2;

import cheboksarov.blps_lab2.dto.RegisterRequestDto;
import cheboksarov.blps_lab2.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootApplication
public class BlpsLab2Application {

	public static void main(String[] args) {
		SpringApplication.run(BlpsLab2Application.class, args);

	}
	//todo Auto-generate admin, betmaster, statisticsmaster
	/*@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService authenticationService
	){
		return args -> {
			authenticationService.register(
					RegisterRequestDto.builder()
							.username("admin")
							.password("123qwe")
							.firstName("Yaroslav")
							.lastName("Cheboksarov")
							.build()
			)
		};

	}*/

}
