package com.ouni.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ouni.bitcoin.entities.Bitcoin;
import com.ouni.bitcoin.repos.BitcoinRepository;


@Service
public class BitcoinServiceImp implements BitcoinService{
	
	@Autowired
	private BitcoinRepository bitRepository;
	
	@Override
	public List<Bitcoin> findAll() {
		// TODO Auto-generated method stub
		return bitRepository.findAll();
	}

	@Override
	public Bitcoin saveBitcoin(Bitcoin b) {
		// TODO Auto-generated method stub
		return bitRepository.save(b);
	}

	@Override
	public Bitcoin getBitcoinById(long id) {
		// TODO Auto-generated method stub
		return bitRepository.getById(id);
	}

	@Override
	public void deleteBitcoinById(long id) {
		bitRepository.deleteById(id);
	}

	@Override
	public Bitcoin updateBitcoin(Bitcoin b) {
		return bitRepository.save(b);
	}

	@Override
	public Page<Bitcoin> getAllBitcoinParPage(int page, int size) {
		// TODO Auto-generated method stub
		return bitRepository.findAll(PageRequest.of(page, size));
	}

}
