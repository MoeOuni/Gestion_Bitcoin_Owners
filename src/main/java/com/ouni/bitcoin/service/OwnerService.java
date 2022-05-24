package com.ouni.bitcoin.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.ouni.bitcoin.entities.Owners;

public interface OwnerService {
	Owners saveOwner(Owners o);
	Owners updateOwner(Owners o);
	void deleteOwner(Owners o);
	void deleteOwnerById(Long id);
	Owners getOwnerById(Long id);
	List<Owners> getAllOwners();
	Page<Owners> getAllOwnersParPage(int page, int size);
	List<Owners> findByBitcoin(String bitcoin);
}
