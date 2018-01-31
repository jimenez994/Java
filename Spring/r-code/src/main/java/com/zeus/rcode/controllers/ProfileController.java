package com.zeus.rcode.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.rcode.models.Question;
import com.zeus.rcode.models.User;
import com.zeus.rcode.models.UserInfo;
import com.zeus.rcode.services.QuestionServices;
import com.zeus.rcode.services.UserInfoServices;
import com.zeus.rcode.services.UserServices;

@Controller
@RequestMapping("/user")
public class ProfileController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private UserInfoServices userInfoServices;
	
	@Autowired
	private QuestionServices questionServices;
	
	@RequestMapping("/{id}")
	public String profile(Model model,HttpSession session) {
		
		User cUser = userServices.findById((long)session.getAttribute("id"));
		UserInfo cUserInfo = cUser.getUserInfo();
		PrettyTime prettyTime = new PrettyTime();

		List<Question> questions = questionServices.getUsersQuestions(cUser);
		
		if(cUser.getUserInfo() != null) {
			model.addAttribute("updateUserInfo",cUserInfo);
		}else {
			model.addAttribute("updateUserInfo",new UserInfo());
		}
		model.addAttribute("pTime", prettyTime);

		model.addAttribute("questions", questions);
		model.addAttribute("cUser", cUser);
		return "profile";
	
	}
	
	@PostMapping("/update/profile")
	public String saveUpdate(@RequestParam("file") MultipartFile file,HttpSession session,@Valid @ModelAttribute("updateUserInfo") UserInfo userInfo,BindingResult result) {
		User cUser = userServices.findById((long)session.getAttribute("id"));
		System.out.println(userInfo.getId()+"*************");
		if(result.hasErrors()) {
			return "redirect:/user/"+cUser.getId();
		}else {
			userInfo.setId(null);
			if(cUser.getUserInfo() != null) {
				userInfo.setId(cUser.getUserInfo().getId());
				if(cUser.getUserInfo().getProfileImg() != null) {
					userInfo.setProfileImg(cUser.getUserInfo().getProfileImg());
				}

			}
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					
					System.out.println(file.getOriginalFilename());

					// Creating the directory to store file
					File dir = new File("src/main/resources/static/images");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + file.getOriginalFilename());
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					userInfo.setUser(cUser);
					userInfo.setProfileImg(file.getOriginalFilename());
					userInfoServices.addUserInfo(userInfo);
					return "redirect:/user/"+cUser.getId();
				}catch(Exception e) {
					return "redirect:/user/"+cUser.getId();
				}
			}else if(file.isEmpty()) {
				userInfo.setUser(cUser);
				userInfoServices.addUserInfo(userInfo);
				System.out.println("1-*****");
				return "redirect:/user/"+cUser.getId();
			}else {
				System.out.println("1-*****");
				return "redirect:/user/"+cUser.getId();
			}
			
		}
		
	}
	

}
