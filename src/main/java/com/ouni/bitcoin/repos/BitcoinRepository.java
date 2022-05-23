package com.ouni.bitcoin.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ouni.bitcoin.entities.Bitcoin;

@Repository
public interface BitcoinRepository extends JpaRepository<Bitcoin, Long> {
	
}
