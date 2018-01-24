package com.zeus.lookify.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.lookify.models.LookifyModel;

@Repository
public interface LookifyRepository extends CrudRepository<LookifyModel, Long>{
	ArrayList<LookifyModel> findByArtist(String search);
		Long countByTitleContaining(String search);
	    Long deleteByTitleStartingWith(String search);
		ArrayList<LookifyModel> OrderByRatingDesc();
}
