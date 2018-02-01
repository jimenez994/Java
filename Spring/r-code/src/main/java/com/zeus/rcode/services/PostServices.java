package com.zeus.rcode.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.rcode.models.Post;
import com.zeus.rcode.models.User;
import com.zeus.rcode.repositories.PostRepository;

@Service
public class PostServices {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> getAll(){
		List<Post> list = postRepository.findAll();
		Collections.reverse(list);
		return list;
	}
	public List<Post> getAllUsersPost(User user){
		List<Post> list = user.getPosts();
		Collections.reverse(list);
		return list;
	}
	public Post getPost(Long id) {
		return postRepository.findOne(id);
	}
	public void addPost(Post post) {
		postRepository.save(post);
	}
	public void deletePost(Long id) {
		postRepository.delete(id);
	}
	public ArrayList<Post> getAllFriendsPost(Long id){
		System.out.println(id+"*******id");
		return postRepository.findAllFriendsPost(id,id);
	}
	
	
	
	

}
