package com.libertymutual.goforcode.invoice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.libertymutual.goforcode.invoice.models.User;
import com.libertymutual.goforcode.invoice.repositories.UserRepository;



@Configuration
@Profile("development")
public class SeedData {
	
	public SeedData(UserRepository usersRepository, PasswordEncoder encoder) {
		usersRepository.save(new User("alex", encoder.encode("alex"), "ADMIN"));	
		usersRepository.save(new User("admin", encoder.encode("admin"), "ADMIN"));
		usersRepository.save(new User("clerk", encoder.encode("clerk"), "CLERK"));
		usersRepository.save(new User("accountant", encoder.encode("accountant"),"ACCOUNTANT"));
	}	
}
