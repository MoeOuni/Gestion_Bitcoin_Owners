package com.ouni.bitcoin.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ouni.bitcoin.entities.Bitcoin;

public interface BitcoinService {
	Bitcoin saveBitcoin(Bitcoin b);
	Bitcoin getBitcoinById(long id);
	void deleteBitcoinById(long id);
	Bitcoin updateBitcoin(Bitcoin b);
	Page<Bitcoin> getAllBitcoinParPage(int page, int size);
	List <Bitcoin> findAll();
}
