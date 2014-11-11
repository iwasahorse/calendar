package com.mycompany.springmvc;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/manager/**")
public class ManagerController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, int id) {

		model.addAttribute("deletedId" ,id);	//, id + ": deleted
		
		
		return "deleteUserComplete";
	}
	
}
