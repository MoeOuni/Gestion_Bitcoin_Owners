package com.ouni.bitcoin;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ouni.bitcoin.entities.Owners;
import com.ouni.bitcoin.repos.OwnersRepository;
import com.ouni.bitcoin.service.OwnerService;

@SpringBootTest
class BitcoinApplicationTests {

	@Autowired
	private OwnersRepository OwnerRepos;
	@Autowired
	private OwnerService OwnerServ;

	@Test
	public void testFindByNomProduit() {
		List<Owners> prods = OwnerRepos.findByNomOwner("Bill");

		for (Owners p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testFindByNomOwnerContains() {
		List<Owners> prods = OwnerRepos.findByNomOwnerContains("Bill");

		for (Owners p : prods) {
			System.out.println(p);
		}
	}

}
