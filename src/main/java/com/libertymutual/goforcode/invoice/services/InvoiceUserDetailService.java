package com.libertymutual.goforcode.invoice.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.invoice.repositories.UserRepository;



@Service
public class InvoiceUserDetailService implements UserDetailsService {

	private UserRepository usersRepository;
	
	public InvoiceUserDetailService(UserRepository usersRepository) {
		this.usersRepository = usersRepository;		
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		return usersRepository.findByUsername(username);
	}	
}
