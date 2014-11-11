package com.mycompany.springmvc;

import static com.mycompany.springmvc.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.mycompany.springmvc.service.UserServiceImpl.MIN_RECCOMEND_FOR_GOLD;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.springmvc.domain.Level;

import com.mycompany.springmvc.domain.User;
import com.mycompany.springmvc.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	UserService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
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
		this.userService.deleteAll();
		this.add();

		User user = this.userService.get(id);

		model.addAttribute("user", user);

		return "userInfo";
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll(Locale locale, Model model) {
		this.userService.deleteAll();
		this.add();

		List<User> users = this.userService.getAll();

		model.addAttribute("users", users);

		return "usersInfo";
	}

	public void add() {
		List<User> users = Arrays.asList(new User("bumjin", "�ڹ���", "p1",
				"user1@ksug.org", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0), // 49,
																				// 0
				new User("joytouch", "����", "p2", "user2@ksug.org",
						Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0), // 50, 0
				new User("erwins", "�Ž���", "p3", "user3@ksug.org", Level.SILVER,
						60, MIN_RECCOMEND_FOR_GOLD - 1), // 60, 29
				new User("madnite1", "�̻�ȣ", "p4", "user4@ksug.org",
						Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD), // 60, 30
				new User("green", "���α�", "p5", "user5@ksug.org", Level.GOLD,
						100, Integer.MAX_VALUE));

		this.userService.add(users.get(0));
		this.userService.add(users.get(1));
		this.userService.add(users.get(2));
		this.userService.add(users.get(3));
		this.userService.add(users.get(4));
	}

}
