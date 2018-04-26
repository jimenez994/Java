package com.zeus.flashCards.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.flashCards.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	ArrayList<User> findAll();
	User findByEmail(String email);
	User findByUsername(String username);
}
