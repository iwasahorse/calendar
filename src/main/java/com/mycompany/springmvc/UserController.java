package com.mycompany.springmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvc.dao.UserRoleDao;
import com.mycompany.springmvc.domain.CalendarUser;
import com.mycompany.springmvc.service.CalendarService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/users/**")
public class UserController {
	@Autowired
	CalendarService calendarService;
	@Autowired
	UserRoleDao userRoleDao;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		  ModelAndView model = new ModelAndView();
		  if (error != null) {
			model.addObject("error", "Invalid username and password!");
		  }
	 
		  if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		  }
		  model.setViewName("users/signin");
	 
		  return model;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		  ModelAndView model = new ModelAndView();
		  CalendarUser userForm = new CalendarUser();    
	        model.addObject("userForm", userForm);
		  model.setViewName("users/signup");
	 
		  return model;
	}
	
     
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") CalendarUser user, Model model) {
         
        this.calendarService.createUser(user);
        this.calendarService.createUserRole(user.getEmail(), "ROLE_USER");
         
        // for testing purpose:
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
         
        return "users/signupSuccess";
    }
	
}
