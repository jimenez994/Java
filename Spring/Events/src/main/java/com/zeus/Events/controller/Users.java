package com.zeus.Events.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.Events.models.Event;
import com.zeus.Events.models.JoinUE;
import com.zeus.Events.models.Message;
import com.zeus.Events.models.Role;
import com.zeus.Events.models.User;
import com.zeus.Events.services.EventServices;
import com.zeus.Events.services.JoinUEServices;
import com.zeus.Events.services.MessageServices;
import com.zeus.Events.services.UserService;
import com.zeus.Events.validator.UserValidator;


@Controller
@RequestMapping("/")
public class Users {

    private UserService userService;

    private UserValidator userValidator;
    // NEW
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    @Autowired
    private EventServices eventServices;
    
    @Autowired
    private MessageServices messageServices;
    
    @Autowired
    private JoinUEServices joinUEServices;
    
    @PostMapping("/process")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,RedirectAttributes flasM) {
        // NEW
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "loginPage.jsp";
        }else {
//        	this flash a message and also saves the user if is successfully created
        		flasM.addFlashAttribute("success", userService.saveNoDuplicate(user));  
            return "redirect:/login";
        }
    }
    
    @RequestMapping("/login")
    public String login(HttpSession session,@Valid @ModelAttribute("user") User user,@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy");
		Date now = new Date();
		session.setAttribute("date",date.format(now));
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model,@Valid @ModelAttribute("newEvent")Event event) {
        String username = principal.getName();
        SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy");
        Date createdAt = userService.findByUsername(username).getCreatedAt();
//        Long id = userService.findByUsername(username).getId();
        model.addAttribute("createdAt", date.format(createdAt));
        List<Role> roles = userService.findByUsername(username).getRoles();
        
        if(roles.get(0).getName().equals("ROLE_ADMIN")) {
        		return "redirect:/admin";
        }
//        list of events in your state 
        List<Event> eventsArea = eventServices.yourStateEvents(userService.findByUsername(username).getState());
        model.addAttribute("eventsAtyourState", eventsArea);
        
//        list of Events not in you state
        List<Event> eventsOutOfState = eventServices.eventsNotInState(userService.findByUsername(username).getState());
        model.addAttribute("eventsOutOfState", eventsOutOfState);
        
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
    		String username = principal.getName();
    		model.addAttribute("currentUser", userService.findByUsername(username));
    		model.addAttribute("users", userService.getAllUsers());
    		return "adminPage.jsp";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
    		userService.deleteUser(id);
    		System.out.println("Delete ********");
    		return "redirect:/admin";
    }
    @RequestMapping("/upgrade/{id}")
    public String upgradeUser(@PathVariable("id") Long id) {
    		User user = userService.findUserById(id);
    		userService.upgradeUser(user);
		System.out.println("Pugrade ********"+user);
		return "redirect:/admin";
    }
    
    
//    Events
    @PostMapping("create/Event")
    public String addEvent(@Valid @ModelAttribute("newEvent") Event event,BindingResult result, RedirectAttributes modelR) {
    		if(result.hasErrors()) {
  			System.out.println(result.getAllErrors());
//  			modelR.addAttribute("bla", result.getAllErrors());
    			return "redirect:/home";
    		}else {
    			eventServices.addEvent(event);
    			return "redirect:/home";
    		}
    }
//    render the page to edit your event
    @RequestMapping("/event/edit/{id}")
    public String editEvent(@PathVariable("id") Long id, Model model) {
    		Event event = eventServices.getEvent(id);
    		if(event != null) {
    			model.addAttribute("event", event);
    			return "editEvent.jsp";
    		}else{
    			return "redirect:/home";
    		}
    }
//    join event
    @RequestMapping("/{userId}/joining/{eventId}/process")
    public String joinEvent(@PathVariable("userId") Long userId,@PathVariable("eventId") Long eventId) {
    		JoinUE newJoin = new JoinUE(userService.findUserById(userId),eventServices.getEvent(eventId));
    		joinUEServices.addJoin(newJoin);
    		return "redirect:/home";
    }
    @PostMapping("/event/edit/{id}")
    public String saveEvent(@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult result) {
    		if(result.hasErrors()) {
    			return "redirect:/event/edit/{id}";
    		}else {
    			eventServices.addEvent(event);
    			return "redirect:/home";
    		}
    }
    @RequestMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
    		eventServices.deleteEvent(id);
    		return "redirect:/home";
    	
    }
    @RequestMapping("/event/{id}")
    public String event(Principal principal,@PathVariable("id") Long id, Model model,@Valid @ModelAttribute("newMessage") Message message) {
        String username = principal.getName();
    		Long uId = userService.findByUsername(username).getId();
    		Event event = eventServices.getEvent(id);
    		List<Message> messages = event.getMessage();
    		model.addAttribute("messages",messages);
    		model.addAttribute("uId", uId);
    		model.addAttribute("event",event);
    		
    		return "event.jsp";
    }
    
    @PostMapping("/event/{id}/post/message")
    public String postMessage(@PathVariable("id") Long id,@Valid @ModelAttribute("newMessage") Message message, BindingResult result) {
    		if(result.hasErrors()) {
    			return "redirect:/event/{id}";
    		}else {
    			messageServices.addMessage(message);
    			return "redirect:/event/{id}";
    		}
    }
    @RequestMapping("/even/{id}/cancel")
    public String cancelJoinEvent(Principal principal,@PathVariable("id") Long id) {
    		String username = principal.getName();
		Long uId = userService.findByUsername(username).getId();
    		
    		return "redirect:/home";
    }
    
}
