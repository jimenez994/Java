package com.zeus.DojosAndNinjas.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.zeus.DojosAndNinjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	ArrayList<Dojo> findAll();

}
