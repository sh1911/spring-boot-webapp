package com.alien.bloodhelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alien.bloodhelper.models.UserCredentials;
import com.alien.bloodhelper.models.UserDetailsPrinciple;
import com.alien.bloodhelper.repositry.UserJpaRepositry;

@Service
public class UserDetailerServices implements UserDetailsService {

	@Autowired
	UserJpaRepositry reposirty;
	
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
			
			UserCredentials user = reposirty.findByEmail(email);
					
			if(user==null)
				throw new UsernameNotFoundException("user not found");
					
		return new UserDetailsPrinciple(user);
		
	}

	public boolean isUserExists(String email) {
		UserCredentials user = reposirty.findByEmail(email);
		if(user==null)
				return true;
		else
			return false;
	}
	public UserCredentials ifExists(String email)
	{
		UserCredentials user=reposirty.findByEmail(email);
		if(user!=null)
			return user ;
		else
			return null;
	}
	
	
	

}
