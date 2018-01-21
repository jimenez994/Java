package com.zeus.Events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.Events.models.Event;
import com.zeus.Events.repositories.EventRepository;

@Service
public class EventServices {
	private EventRepository eventRepository;
	
	public EventServices(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> getAll(){
		return eventRepository.findAll();
	}
	
	public Event getEvent(Long id) {
		return eventRepository.findOne(id);
	}
	
	public void addEvent(Event event) {
		eventRepository.save(event);
	}
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}
	public void deleteEvent(Long id) {
		eventRepository.delete(id);
	}
	
	

}
