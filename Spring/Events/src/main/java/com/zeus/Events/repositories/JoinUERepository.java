package com.zeus.Events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.Events.models.JoinUE;

@Repository
public interface JoinUERepository extends CrudRepository<JoinUE, Long>{
	List<JoinUE> findAll();

}
