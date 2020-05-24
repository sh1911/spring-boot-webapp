package com.alien.bloodhelper.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.alien.bloodhelper.models.UserCredentials;

@Component
public interface UserRepositry extends CrudRepository<UserCredentials,Integer> {

}
