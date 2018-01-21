package com.zeus.Events.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.Events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event , Long>{
	ArrayList<Event> findAll();

}
