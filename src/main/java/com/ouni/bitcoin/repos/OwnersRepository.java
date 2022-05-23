package com.ouni.bitcoin.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouni.bitcoin.entities.Owners;


public interface OwnersRepository extends JpaRepository<Owners, Long> {

	List<Owners> findByNomOwner(String nom);
	List<Owners> findByNomOwnerContains(String nom);
}
