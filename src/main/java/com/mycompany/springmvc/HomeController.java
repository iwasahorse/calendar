package com.mycompany.springmvc;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvc.domain.CalendarUser;
import com.mycompany.springmvc.service.CalendarService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	CalendarService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, ModelAndView mav) {
		mav.addObject("message", "myCalendar 서비스에 오신 것을 환영합니다.");
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(
			Locale locale,
			Model model,
			@RequestParam(value = "a", required = false, defaultValue = "0") int a,
			int b) {
		model.addAttribute("result", a + b);

		return "result";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Locale locale, Model model,
			@RequestParam(value = "id") String id) {
		this.userService.deleteAllUsers();
		

		CalendarUser user = this.userService.getUserByEmail(id);

		model.addAttribute("user", user);

		return "userInfo";
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll(Locale locale, Model model) {
		this.userService.deleteAllUsers();
	

		List<CalendarUser> users = this.userService.getUsersByEmail(null);

		model.addAttribute("users", users);

		return "usersInfo";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			ModelAndView model) {

		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(ModelAndView model) {
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;
	}

	@RequestMapping(value = "/myinfo", method = RequestMethod.GET)
	public ModelAndView myinfo(ModelAndView model) {
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			CalendarUser user = this.userService.getUserByEmail(userDetail.getUsername());
			model.addObject("user", user);
		}

		model.setViewName("myinfo");
		return model;
	}

}
