package com.zeus.loginRS.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.loginRS.models.Pack;

@Repository
public interface PackRepository extends CrudRepository<Pack,Long>{
	ArrayList<Pack> findAll();

}
