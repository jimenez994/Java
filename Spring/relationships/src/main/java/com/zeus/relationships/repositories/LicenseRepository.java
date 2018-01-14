package com.zeus.relationships.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.zeus.relationships.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	ArrayList<License> findAll();

}
