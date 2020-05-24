package com.alien.bloodhelper.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alien.bloodhelper.models.UserCredentials;

public interface UserJpaRepositry extends JpaRepository<UserCredentials,Integer> {
	
	UserCredentials findByEmail(String email);

}
