package com.ouni.bitcoin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.ouni.bitcoin.entities.Owners;
import com.ouni.bitcoin.repos.OwnersRepository;

@Service
public class OwnerServiceImp implements OwnerService {

	@Autowired
	OwnersRepository ownerRepos;

	@Override
	public Owners saveOwner(Owners o) {
		return ownerRepos.save(o);
	}

	@Override
	public Owners updateOwner(Owners o) {
		return ownerRepos.save(o);
	}

	@Override
	public void deleteOwner(Owners o) {
		ownerRepos.delete(o);
	}

	@Override
	public void deleteOwnerById(Long id) {
		ownerRepos.deleteById(id);
	}

	@Override
	public Owners getOwnerById(Long id) {
		return ownerRepos.findById(id).get();
	}

	@Override
	public List<Owners> getAllOwners() {
		return ownerRepos.findAll();
	}

	@Override
	public Page<Owners> getAllOwnersParPage(int page, int size) {
		return ownerRepos.findAll(PageRequest.of(page, size));
	}
}
