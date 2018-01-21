package com.zeus.Events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.Events.models.Message;
import com.zeus.Events.repositories.MessageRepository;

@Service
public class MessageServices {
	private MessageRepository messageRepository;
	public MessageServices(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public List<Message> getAll(){
		return messageRepository.findAll();
	}
	
	public Message getMassage(Long id) {
		return messageRepository.findOne(id);
	}
	public void addMessage(Message message) {
		messageRepository.save(message);
	}
	public void updateMessage(Message message) {
		messageRepository.save(message);
	}
	public void deleteMessage(Long id) {
		messageRepository.delete(id);
	}

}
