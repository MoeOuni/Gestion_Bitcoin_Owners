package com.ouni.bitcoin.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouni.bitcoin.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
