package com.ouni.bitcoin.service;

import java.util.List;

import com.ouni.bitcoin.entities.Role;


public interface RoleService {
	 List <Role> findAll();
	    
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	 Role getRole (Long idRole);
}
