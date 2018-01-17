package com.zeus.DojoOverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.DojoOverflow.models.Answer;
import com.zeus.DojoOverflow.models.Question;
import com.zeus.DojoOverflow.models.Tag;
import com.zeus.DojoOverflow.services.AnswerServices;
import com.zeus.DojoOverflow.services.QuestionServices;
import com.zeus.DojoOverflow.services.TagServices;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private QuestionServices questionServices;
	
	@Autowired
	private AnswerServices answerServices;
	
	@Autowired
	private TagServices tagServices;
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = questionServices.getAll();
		model.addAttribute("questions", questions);
		System.out.println("------->"+questions.get(0).getTags().get(0).getSubject());
		return "dashboard.jsp";
	}
	@RequestMapping("/questions/new")
	public String createQuestion(Model modelQ,Model modelT) {
		modelQ.addAttribute("newQuestion",new Question());
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String addQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult resultQ, @RequestParam(value="hags") String tags) {
		question.setTags(new ArrayList<Tag>());
		String str = tags;
		boolean check = false;
		List<String> items = Arrays.asList(str.toLowerCase().trim().split("\\s*,\\s*"));
		if(items.size() <= 3) {
			for(int i = 0; i<items.size();i++) {
				if(items.get(i).trim().equals("")) {
					return "newQuestion.jsp";
				}else {
					check = true;
				}
			}
		}else {
			return "newQuestion.jsp";
		}
		if(resultQ.hasErrors()) {
			check = false;
			return "newQuestion.jsp";
		}else {
			Tag newTag = new Tag(tags);
			
			tagServices.addTag(newTag);
			questionServices.addQuestion(question);
			question.getTags().add(newTag);
			questionServices.addQuestion(question);
			return "redirect:/questions";
		}
	}
	@RequestMapping("/questions/{id}")
	public String selectedQuestion(@PathVariable("id") Long id,Model model) {
		Question quest = questionServices.findQuestion(id);
		String str = quest.getTags().get(0).getSubject();
		List<String> items = Arrays.asList(str.toLowerCase().trim().split("\\s*,\\s*"));
		System.out.println(items);
		model.addAttribute("quest", quest);
		model.addAttribute("tags", items);
		model.addAttribute("newAnswer", new Answer());
		model.addAttribute("answers", quest.getAnswers());
		return "question.jsp";
	}
	@PostMapping("/questions/{id}")
	public String addAnswer(RedirectAttributes redirectAttributes,@PathVariable("id") Long id,@Valid @ModelAttribute("newAnswer") Answer answer,BindingResult result) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "Must be a least 5 Characters");
			return "redirect:/questions/{id}";
		}else {
			Answer ans = new Answer(questionServices.findQuestion(id),answer.getAnswer());
			answerServices.addAnswer(ans);
			return "redirect:/questions/{id}";
		}
	}
}
