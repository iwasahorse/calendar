package com.mycompany.springmvc.dao;

import java.util.List;

import com.mycompany.springmvc.domain.CalendarUser;

public interface CalendarUserDao {
    public CalendarUser findUser(int id);

    public CalendarUser findUserByEmail(String email);

    public List<CalendarUser> findUsersByEmail(String partialEmail);

    public int createUser(CalendarUser user);
    
    public List<CalendarUser> findAllusers();
    
    public void deleteAll();
}
