package com.zeus.Events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.Events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event , Long>{
	List<Event> findAll();

}
