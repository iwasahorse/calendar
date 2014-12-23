package com.mycompany.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvc.dao.CalendarUserDao;
import com.mycompany.springmvc.dao.EventAttendeeDao;
import com.mycompany.springmvc.dao.EventDao;
import com.mycompany.springmvc.dao.UserRoleDao;
import com.mycompany.springmvc.domain.CalendarUser;
import com.mycompany.springmvc.domain.Event;
import com.mycompany.springmvc.domain.EventAttendee;
import com.mycompany.springmvc.domain.EventLevel;
import com.mycompany.springmvc.domain.UserRole;


@Service("calendarService")
@Transactional
public class DefaultCalendarService implements CalendarService {
	public static final int MIN_NUMLIKES_FOR_HOT = 10;

	@Autowired
	private CalendarUserDao userDao;
	
	@Autowired
	private EventDao eventDao;

	@Autowired
	private EventAttendeeDao eventAttendeeDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	/* CalendarUser */
	@Override
	public void setUserDao(CalendarUserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public CalendarUser getUser(int id) {
		return this.userDao.findUser(id);
	}

	@Override
	public CalendarUser getUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	@Override
	public List<CalendarUser> getUsersByEmail(String partialEmail) {
		return userDao.findUsersByEmail(partialEmail);
	}

	@Override
	public int createUser(CalendarUser user) {
		return userDao.createUser(user);
	}

	@Override
	public void deleteAllUsers() {
		userDao.deleteAll();
	}



	/* Event */
	@Override
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	@Override
	public Event getEvent(int eventId) {
		return eventDao.findEvent(eventId);
	}

	@Override
	public List<Event> getEventForOwner(int ownerUserId) {
		return eventDao.findForOwner(ownerUserId);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventDao.findAllEvents();
	}

	@Override
	public int createEvent(Event event) {
		if (event.getEventLevel() == null) {
			event.setEventLevel(EventLevel.NORMAL);
		}

		return eventDao.createEvent(event);
	}

	@Override
	public void deleteAllEvents() {
		eventDao.deleteAll();
	}

	/* EventAttendee */

	@Override
	public void setEventAttendeeDao(EventAttendeeDao eventAttendeeDao) {
		this.eventAttendeeDao = eventAttendeeDao;
	}	
	
	@Override
	public List<EventAttendee> getEventAttendeeByEventId(int eventId) {
		return eventAttendeeDao.findEventAttendeeByEventId(eventId);	//수정한 부분
	}

	@Override
	public List<EventAttendee> getEventAttendeeByAttendeeId(int attendeeId) {
		return eventAttendeeDao.findEventAttendeeByAttendeeId(attendeeId);
	}

	@Override
	public int createEventAttendee(EventAttendee eventAttendee) {
		return eventAttendeeDao.createEventAttendee(eventAttendee);
	}

	@Override
	public void deleteEventAttendee(int id) {
		eventAttendeeDao.deleteEventAttendee(id);
	}

	@Override
	public void deleteAllEventAttendees() {
		eventAttendeeDao.deleteAll();
	}



	/* upgradeEventLevels */
	@Override
	public void upgradeEventLevels() throws Exception{
		List<Event> events = eventDao.findAllEvents();
		for(Event event : events) {
			if( canUpgradeEventLevel(event)) {
				upgradeEventLevel(event);
			}
		}
	}

	@Override
	public boolean canUpgradeEventLevel(Event event) {
		EventLevel currentLevel = event.getEventLevel();
		switch( currentLevel ) {
		case NORMAL: return ( event.getNumLikes() >= MIN_NUMLIKES_FOR_HOT);
		case HOT: return false;
		default: throw new IllegalArgumentException("Unknown Level: " + currentLevel);
		}
	}

	@Override
	public void upgradeEventLevel(Event event) {
		event.upgradeLevel();
		eventDao.udpateEvent(event);
	}
	
	/* UserRole */
	@Override
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	@Override
	public void createUserRole(String email, String role) {
		this.userRoleDao.add(new UserRole(email, role));
	}
}