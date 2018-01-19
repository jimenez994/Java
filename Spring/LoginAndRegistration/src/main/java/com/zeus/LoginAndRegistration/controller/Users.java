package com.zeus.LoginAndRegistration.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.LoginAndRegistration.models.User;
import com.zeus.LoginAndRegistration.services.UserService;
import com.zeus.LoginAndRegistration.validator.UserValidator;

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
    
//    @RequestMapping("/registration")
//    public String registerForm(@Valid @ModelAttribute("user") User user) {
//        return "registrationPage.jsp";
//    }
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
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy");
        Date createdAt = userService.findByUsername(username).getCreatedAt();
        model.addAttribute("createdAt", date.format(createdAt));
        model.addAttribute("currentUser", userService.findByUsername(username));
        
        
        
        return "homePage.jsp";
    }
}