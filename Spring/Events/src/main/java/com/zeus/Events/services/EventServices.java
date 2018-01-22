package com.zeus.Events.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.Events.models.Event;
import com.zeus.Events.models.JoinUE;
import com.zeus.Events.models.Message;
import com.zeus.Events.repositories.EventRepository;

@Service
public class EventServices {
	private EventRepository eventRepository;
	
	public EventServices(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	 @Autowired
	    private EventServices eventServices;
	 
	 @Autowired
	    private MessageServices messageServices;
	    
	 @Autowired
	    private JoinUEServices joinUEServices;
	 
	public List<Event> getAll(){
		return eventRepository.findAll();
	}
	
	public Event getEvent(Long id) {
		return eventRepository.findOne(id);
	}
	
	public List<Event> yourStateEvents(String state){
		ArrayList<Event> events = eventRepository.findAll();	
		ArrayList<Event> eventsList = new ArrayList<Event>();		

		for(int i= 0; i < events.size() ;i++) {
			if(events.get(i).getState().equals(state)) {
				System.out.println(events.get(i).getState());
				eventsList.add(events.get(i));
			}
		}
		System.out.println(eventsList);
		return eventsList;
	}
	public List<Event> eventsNotInState(String state){
		ArrayList<Event> events = eventRepository.findAll();	
		ArrayList<Event> eventsList = new ArrayList<Event>();		

		for(int i= 0; i < events.size() ;i++) {
			if(!events.get(i).getState().equals(state)) {
				System.out.println(events.get(i).getState());
				eventsList.add(events.get(i));
			}
		}
		System.out.println(eventsList);
		return eventsList;
	}
	
	public void addEvent(Event event) {
		System.out.println(event.getDate());
		SimpleDateFormat format = new SimpleDateFormat("MMMM d , yyyy");
		String sDate = format.format(event.getDate());
		event.setdDate(sDate);
		eventRepository.save(event);
	}
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}
	public void deleteEvent(Long id) {
		List<Message> messages = eventServices.getEvent(id).getMessage();
		for(int i = 0; i < messages.size(); i++){
			Message message = messages.get(i);
			messageServices.deleteMessage(message.getId());
		}
		List<JoinUE> joins = eventServices.getEvent(id).getJoinUE();
		for(int i = 0; i < joins.size(); i++){
			JoinUE join = joins.get(i);
			joinUEServices.deleteJoin(join.getId());
		}
		
		System.out.println(eventServices.getEvent(id).getMessage());
		
		eventServices.getEvent(id).getJoinUE();
		eventRepository.delete(id);
	}
	
	

}
