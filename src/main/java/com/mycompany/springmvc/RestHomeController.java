package com.mycompany.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springmvc.domain.CalendarUser;
import com.mycompany.springmvc.domain.Event;
import com.mycompany.springmvc.domain.EventAttendee;
import com.mycompany.springmvc.service.CalendarService;

@RestController
@RequestMapping("/rest")
public class RestHomeController {
	@Autowired
	CalendarService calendarService;

    @RequestMapping("/allusers")
    public List<CalendarUser> getAllUsers() {
    	List<CalendarUser> users = this.calendarService.getUsersByEmail(null);
    	return users;
    }
    
    @RequestMapping("/user/{id}")
    public CalendarUser getUser(@PathVariable String id) {
    	CalendarUser user = this.calendarService.getUser(Integer.valueOf(id));
    	return user;
    }
    
    @RequestMapping("/event/{id}")
    public List<EventAttendee> getEvent(@PathVariable String id) {
    	List<EventAttendee> attendees = this.calendarService.getEventAttendeeByEventId(Integer.valueOf(id));
    	return attendees;
    }
}
