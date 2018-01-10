package com.zeus.dojo_survey.contollers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	  @RequestMapping(path="/login", method=RequestMethod.POST)
      public String login(@RequestParam(value="name") String name, @RequestParam(value="dojolocation") String dojolocation,@RequestParam(value="favlang") String favlang,@RequestParam(value="text_field") String text_field,HttpSession session) {
            session.setAttribute("name",name);
            session.setAttribute("dojolocation",dojolocation);
            session.setAttribute("favlang",favlang);
            session.setAttribute("text_field",text_field);
            return "redirect:/dashboard_view/";
      }
	  @Controller
	  public class DashboardController {
	      @RequestMapping("/dashboard_view")
	      public String dashboard(Model model) {
	      // ... any code to process before rendering
	        return "dashboard.jsp";
	      }
	  }
	  
	
	

}
