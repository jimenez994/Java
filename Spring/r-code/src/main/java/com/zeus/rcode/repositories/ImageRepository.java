package com.zeus.rcode.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.rcode.models.Image;


@Repository
public interface ImageRepository extends CrudRepository<Image , Long>{
	ArrayList<Image> findAll();
}
