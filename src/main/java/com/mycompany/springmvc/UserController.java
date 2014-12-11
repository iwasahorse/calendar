package com.mycompany.springmvc;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/users/**")
public class UserController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
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
	
}
