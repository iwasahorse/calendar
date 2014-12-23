package com.mycompany.springmvc.service;

import java.util.List;

//import org.springframework.transaction.annotation.Transactional;


import com.mycompany.springmvc.dao.CalendarUserDao;
import com.mycompany.springmvc.dao.EventAttendeeDao;
import com.mycompany.springmvc.dao.EventDao;
import com.mycompany.springmvc.dao.UserRoleDao;
import com.mycompany.springmvc.domain.CalendarUser;
import com.mycompany.springmvc.domain.Event;
import com.mycompany.springmvc.domain.EventAttendee;

public interface CalendarService {
	/* CalendarUser */
    public CalendarUser getUser(int id);
    
    public void setUserDao(CalendarUserDao userDao);

    public CalendarUser getUserByEmail(String email);

    public List<CalendarUser> getUsersByEmail(String partialEmail);

    public int createUser(CalendarUser user);
    
    public void deleteAllUsers();
    
    /* Event */
	public void setEventDao(EventDao eventDao);
	
    public Event getEvent(int eventId);

    public List<Event> getEventForOwner(int ownerUserId);

    public List<Event> getAllEvents();

    public int createEvent(Event event);
    
    public void deleteAllEvents();
    
    /* EventAttendee */
	public void setEventAttendeeDao(EventAttendeeDao eventAttendeeDao);
	
    public List<EventAttendee> getEventAttendeeByEventId(int eventId);
    
    public List<EventAttendee> getEventAttendeeByAttendeeId(int attendeeId);

    public int createEventAttendee(EventAttendee eventAttendee);

    public void deleteEventAttendee(int id);
    
    public void deleteAllEventAttendees();
    
	/* upgradeEventLevels */
	public void upgradeEventLevels() throws Exception;

	public boolean canUpgradeEventLevel(Event event);
	
	public void upgradeEventLevel(Event event);

	public void setUserRoleDao(UserRoleDao userRoleDao);

	/* UserRole */
	public void createUserRole(String email, String role);


}