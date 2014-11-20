package com.mycompany.springmvc.dao;

import com.mycompany.springmvc.domain.UserRole;

public interface UserRoleDao {
	void add(UserRole userRole);
	UserRole get(String userId);
	void update(UserRole userRole);
}