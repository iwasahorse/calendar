package com.mycompany.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springmvc.domain.User;
import com.mycompany.springmvc.service.UserService;
import com.mycompany.springmvc.service.UserServiceImpl;

@RestController
@RequestMapping("/rest")
public class RestHomeController {
	@Autowired
	UserService userService;

    @RequestMapping("/allusers")
    public List<User> getAllUsers() {
    	List<User> users = this.userService.getAll();
    	return users;
    }
    
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
    	User user = this.userService.get(id);
    	return user;
    }
}
