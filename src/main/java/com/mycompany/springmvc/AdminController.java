package com.mycompany.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.springmvc.domain.CalendarUser;
import com.mycompany.springmvc.service.CalendarService;

@Controller
@RequestMapping(value = "/admin")

public class AdminController {
	@Autowired
	CalendarService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        CalendarUser userForm = new CalendarUser();    
        model.addAttribute("userForm", userForm);
         
        List<String> professionList = new ArrayList<String>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.addAttribute("professionList", professionList);
         
        return "register/registration";
    }
     
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") CalendarUser user, Model model) {
         
        this.userService.createUser(user);
         
        // for testing purpose:
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
         
        return "register/registrationSuccess";
    }
    
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public String allUsers(Locale locale, Model model) {
		List<CalendarUser> users = this.userService.getUsersByEmail(null);
		model.addAttribute("users", users);
		
		return "register/allUsers";
	}
}
