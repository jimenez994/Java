package com.zeus.rcode.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.rcode.models.Answer;
import com.zeus.rcode.models.Question;
import com.zeus.rcode.models.User;
import com.zeus.rcode.services.AnswerServices;
import com.zeus.rcode.services.QuestionServices;
import com.zeus.rcode.services.UserServices;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	private QuestionServices questionServices;
	public QuestionController(QuestionServices questionServices) {
		this.questionServices = questionServices;
	}

	@Autowired 
	private UserServices userServices; 
	
	@Autowired
	private AnswerServices answerServices;
	
	@RequestMapping("/{id}")
	public String showQuestion(Model model,HttpSession session,@PathVariable("id") Long id,@ModelAttribute("newAnswer") Answer answer) {
		Question question = questionServices.getQuestion(id);
		List<Answer> answerList = question.getAnswers();
		Date datec = question.getCreatedAt();
		User cUser = userServices.findById((long)session.getAttribute("id"));
		PrettyTime prettyTime = new PrettyTime();
		String time = prettyTime.format(datec);
		model.addAttribute("answers", answerList);
		model.addAttribute("question", question);
		model.addAttribute("pTime", prettyTime);
		model.addAttribute("cUser", cUser);
		return "question";
	}
	@PostMapping("/{idQ}")
	public String addAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result, @RequestParam("file") MultipartFile file, HttpSession session,Model model,@PathVariable("idQ") Long idP) {
		User user = userServices.findById((long)session.getAttribute("id"));
		Answer newAnswer = answer;
		Question question = questionServices.getQuestion(idP);
		if(result.hasErrors()) {
			return "redirect:/question/{idQ}";
		}else {
			if(!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					
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
					
					//	adding this to the detabase
					newAnswer.setUser(user);
					newAnswer.setQuestion(question);
					newAnswer.setPicture(file.getOriginalFilename());
					
					answerServices.addAnswer(newAnswer);
					
					return "redirect:/question/{idQ}";
				} catch( Exception e) {
					System.out.println("******2");
					return "redirect:/question/{idQ}";
				}
				
			}else if(file.isEmpty()) {
				newAnswer.setUser(user);
				newAnswer.setQuestion(question);
				answerServices.addAnswer(newAnswer);
				return "redirect:/question/{idQ}";
			}else {
				return "redirect:/question/{idQ}";
			}
		}
	}
	

}
