package com.zeus.rcode.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.rcode.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long>{
	ArrayList<Comment> findAll();
	
}
