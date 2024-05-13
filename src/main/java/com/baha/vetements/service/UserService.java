package com.baha.vetements.service;

import com.baha.vetements.entities.Role;
import com.baha.vetements.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}