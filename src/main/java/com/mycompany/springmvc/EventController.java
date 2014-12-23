package com.mycompany.springmvc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvc.domain.CalendarUser;
import com.mycompany.springmvc.domain.Event;
import com.mycompany.springmvc.domain.EventAttendee;
import com.mycompany.springmvc.domain.EventLevel;
import com.mycompany.springmvc.service.CalendarService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/events")
public class EventController {
	@Autowired
	private CalendarService calendarService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView eventList(Locale locale, ModelAndView mav) {
		List<Event> events = this.calendarService.getAllEvents();	//만든 이벤트
		mav.addObject("events", events);
		mav.setViewName("events/list");
		
		return mav;
	}	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView createEvent(Locale locale, ModelAndView mav) {
		Event eventform = new Event();
		mav.addObject("eventtime");
		mav.addObject("message", "event를 생성하세요.");
		mav.addObject("eventform", eventform);
		mav.setViewName("events/createEvent");
		return mav;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String eventCreated(@ModelAttribute("eventform") Event eventform, @ModelAttribute("eventtime") String eventtime, Model model) {
        eventform.setNumLikes(0);
        eventform.setOwner(this.calendarService.getUser(0));
        eventform.setEventLevel(EventLevel.NORMAL);
        Calendar calendar = Calendar.getInstance();
        eventtime = eventtime + ":00";
        calendar.setTime(Timestamp.valueOf(eventtime));
        eventform.setWhen(calendar);
		this.calendarService.createEvent(eventform);
		System.out.println(eventtime);
		System.out.println(calendar.getTime());

       return "index";
   }

	@RequestMapping(value = "/my", method = RequestMethod.GET)
	public ModelAndView myEventList(Locale locale, ModelAndView mav) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Event> events = null;	//만든 이벤트
		List<Event> events2 = new ArrayList<Event>();	//참여하는 이벤트
		List<EventAttendee> attendees = null;
		CalendarUser user = null;
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  user = this.calendarService.getUserByEmail(username);
		  int ownerId = user.getId();
		  events = this.calendarService.getEventForOwner(ownerId);
		  attendees = this.calendarService.getEventAttendeeByAttendeeId(ownerId);
		  for(EventAttendee ea: attendees)
		  {
			  events2.add(ea.getEvent());
			  this.calendarService.getEventAttendeeByEventId(ea.getEvent().getId());
		  }
		} else {
		  String username = principal.toString();
			System.out.println(username);
		}

		mav.addObject("user", user);
		mav.addObject("events", events);
		mav.addObject("events2", events2);
		mav.addObject("attendees", attendees);
		mav.setViewName("events/myEvent");
		
		return mav;
	}
}
