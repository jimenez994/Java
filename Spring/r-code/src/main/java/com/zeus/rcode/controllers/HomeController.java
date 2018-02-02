package com.zeus.rcode.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.rcode.models.Comment;
import com.zeus.rcode.models.Post;
import com.zeus.rcode.models.User;
import com.zeus.rcode.services.CommentServices;
import com.zeus.rcode.services.PostServices;
import com.zeus.rcode.services.UserServices;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired 
	private UserServices userServices; 
	
	@Autowired
	private PostServices postServices;
	
	@Autowired
	private CommentServices commentServices;
	
	@RequestMapping("")
	public String home(@ModelAttribute("newPost") Post post,Model model,HttpSession session,@ModelAttribute("newComment") Comment comment) {
		User user = userServices.findById((long)session.getAttribute("id"));
		PrettyTime prettyTime = new PrettyTime();
		ArrayList<Post> posts = postServices.getAllFriendsPost(user.getId());
		List<Post> postsND = new ArrayList<>(new LinkedHashSet<>(posts));  
		if(postsND.isEmpty()) {
			postsND = user.getPosts();
		}
		System.out.println(postsND);
		model.addAttribute("posts", postsND);
		model.addAttribute("cUser", user);
		model.addAttribute("pTime", prettyTime);
		return "home";
	}
	@PostMapping("/post")
	public String createPost(@Valid @ModelAttribute("newPost") Post post,@RequestParam("file") MultipartFile file,HttpSession session) {
		User cUser = userServices.findById((long)session.getAttribute("id"));
		
		if(file.isEmpty() && post.getMessage().equals("")) {
			return "redirect:/home";
		}else if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
//				creating the directory to store file
				File dir = new File("src/main/resources/static/images");
				if(!dir.exists())
					dir.mkdir();
//				create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
//				adding it to my datebase
				post.setUser(cUser);
				post.setPicture(file.getOriginalFilename());
				cUser.getPosts().add(post);
				postServices.addPost(post);
				return "redirect:/home";
			}catch (Exception e) {
				return "redirect:/home";
			}
		}else if(file.isEmpty() && !post.getMessage().equals("")) {
			post.setUser(cUser);
			cUser.getPosts().add(post);
			postServices.addPost(post);
			return "redirect:/home";
		}
		return "redirect:/home";
	}
	@PostMapping("/addComment/{id}")
	public String addComment(@Valid @ModelAttribute("newComment") Comment comment,@PathVariable("id") Long id,HttpSession session,@RequestParam("file2") MultipartFile file) {
		User cUser = userServices.findById((long)session.getAttribute("id"));
		Post cPost = postServices.getPost(id);
		System.out.println("******1");
		if(file.isEmpty() && comment.getComment().equals("")) {
			return "redirect:/home";
		}else if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
//				creating the directory to store file
				File dir = new File("src/main/resources/static/images");
				if(!dir.exists())
					dir.mkdir();
//				create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
//				adding it to my datebase
				comment.setUser(cUser);
				comment.setPost(cPost);
				comment.setPicture(file.getOriginalFilename());
				Comment newComment = comment;
				cUser.getComments().add(newComment);
				commentServices.addComment(newComment);
				
				
				
				return "redirect:/home";
			}catch (Exception e) {
				return "redirect:/home";
			}
		}else if(file.isEmpty() && !comment.getComment().equals("")) {
			comment.setUser(cUser);
			comment.setPost(cPost);
			System.out.println(cPost.getId() +"****** this is the current post");	
			Comment newComment = comment;
			cUser.getComments().add(newComment);
			commentServices.addComment(newComment);
			return "redirect:/home";
		}
		return "redirect:/home";
	}
	
	
	
	
	
	
	
	
	
	

}
