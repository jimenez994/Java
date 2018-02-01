package com.zeus.rcode.services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.rcode.models.Comment;
import com.zeus.rcode.repositories.CommentRepository;

@Service
public class CommentServices {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public ArrayList<Comment> getAll(){
		ArrayList<Comment> list = commentRepository.findAll();
		Collections.reverse(list);
		return list;
	}
	public Comment getComment(Long id) {
		return commentRepository.findOne(id);
	}
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}
	public void deleteComment(Long id) {
		commentRepository.delete(id);
	}

}
