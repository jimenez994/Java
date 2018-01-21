package com.zeus.Events.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	public List<Event> yourStateEvents(String state){
		System.out.println("*****************");
		ArrayList<Event> events = eventRepository.findAll();
		System.out.println(events.size());
		
		for(int i= 0; i <= events.size() -1;i++) {
			if(!events.get(i).getState().equals(state)) {
				events.remove(i);
				System.out.println("************");
			}
		}
		return events;
	}
	public void addEvent(Event event) {
//		SimpleDateFormat date = new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy");
//		String eDate = event.getDate();
//		event.setDate(date.format(eDate));
		eventRepository.save(event);
	}
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}
	public void deleteEvent(Long id) {
		eventRepository.delete(id);
	}
	
	

}
