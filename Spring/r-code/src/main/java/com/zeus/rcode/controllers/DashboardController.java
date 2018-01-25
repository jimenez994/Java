package com.zeus.rcode.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.rcode.models.Image;
import com.zeus.rcode.models.Question;
import com.zeus.rcode.models.User;
import com.zeus.rcode.services.ImageServices;
import com.zeus.rcode.services.QuestionServices;
import com.zeus.rcode.services.UserServices;

@Controller
public class DashboardController {
	@Autowired
	private QuestionServices questionServices;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private ImageServices imageServices; 
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session,Model model,@ModelAttribute("newImage")Image image,@ModelAttribute("newQuestion")Question question,@ModelAttribute("request")User request){
		List<Question> questions = questionServices.getAll();
		List<Image> images = imageServices.getAll();
		byte[] imaged = images.get(0).getPic();
		System.out.println(imaged);
		List<User> users = userServices.notFriendsList((long)session.getAttribute("id"));
		if( session.getAttribute("id") != null ){
			model.addAttribute("images", images);
			model.addAttribute("users", users);
			model.addAttribute("questions", questions);
			model.addAttribute("cUser", userServices.findById((long)session.getAttribute("id")));
			return "dashboard";
		}else{
			return "redirect:/";
		}
	}
	
//	adding a question 
	@PostMapping("/create/quetion")
	public String postQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result, RedirectAttributes modelR){
		if(result.hasErrors()) {
			modelR.addAttribute("errors", result.getAllErrors());
			return "redirect:/dashboard";
		}else {
			questionServices.addQuestion(question);
			return "redirect:/dashboard";
		}
	}
// send friend Request
	@PostMapping("/request/{id}")
	public String request(@PathVariable("id") Long id,HttpSession session) {
		User user = userServices.findById((long)session.getAttribute("id"));
		User resiver = userServices.findById(id);
		List<User> requests = resiver.getRecieveRequests();
		requests.add(user);
		resiver.setRecieveRequests(requests);
		userServices.update(resiver);
		return "redirect:/dashboard";
	}
//	cancel friend Request
	@PostMapping("/cancel/{id}")
	public String cancelRequest(@PathVariable("id") int id,HttpSession session) {
		User user = userServices.findById((long)session.getAttribute("id"));
		User resiver = userServices.findById(id);
		List<User> requests = resiver.getRecieveRequests();
		System.out.println(requests.size());
		System.out.println(requests.toString());
		System.out.println(user.getSendRequests().toString());
		for(int i = 0; i < requests.size();i++) {
			if(user.getId() == requests.get(i).getId()) {
				requests.remove(i);
				resiver.setRecieveRequests(requests);

				userServices.update(resiver);
			}
		}
		return"redirect:/dashboard";
	}
//	accept friend request
	@PostMapping("/accept/{id}")
	public String acceptFriendRequest(@PathVariable("id") Long id,HttpSession session) {
		User user = userServices.findById((long)session.getAttribute("id"));
		User userAccepeted = userServices.findById(id);
		List<User> friends = userAccepeted.getUserFriends();
		friends.add(user);
		userAccepeted.setUserFriends(friends);
		userServices.update(userAccepeted);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException{
		if (!file.isEmpty()) {
			 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			 System.out.println(src.getType());
//			 File destination = new File("File directory with file name"); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
//			 ImageIO.write(src, "png", destination);
			 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
		 
	}  
		return "redirect:/dashboard";
	}
	
	
	
//	@PostMapping("/add/image")
//	public String addImage(@Valid @ModelAttribute("newImage") Image image,BindingResult result) {
//		// get the provided image from the form
//		MultipartFile Image = image;
//		if(result.hasErrors()) {
//			System.out.println("error");
//			return "redirect:/dashboard";
//		}else {
//			System.out.println("1************");
//			byte[] bytes = image.getPic();
//	        System.out.println("2************");
//
//			byte[] encodeBase64 = Base64.encodeBase64(bytes);
//			Base64 base64 = new Base64();
//	        System.out.println("3************"); 
////	        String base64Encoded = encodeBase64;
//	        String decodedString = new String(base64.decode(encodeBase64));
//			
//	        System.out.println(decodedString);
//	        image.setPic(encodeBase64);
//			imageServices.addImage(image);
//			return "redirect:/dashboard";
//		}
//	}

}
