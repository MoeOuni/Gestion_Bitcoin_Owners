package com.ouni.bitcoin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ouni.bitcoin.entities.Bitcoin;
import com.ouni.bitcoin.entities.Owners;
import com.ouni.bitcoin.service.BitcoinService;

@Controller
public class BitcoinController {
	@Autowired
	BitcoinService bitService;

	@RequestMapping("/showCreateBitcoin")
	public String showCreateBitcoin(ModelMap modelMap) {
		Bitcoin bit = new Bitcoin();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("bitcoin", bit);
		return "formBitcoin";
	}

	@RequestMapping("/saveBitcoin")
	public String saveProduit(@Valid Bitcoin bitcoin, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formBitcoin";
		bitService.saveBitcoin(bitcoin);
		return "redirect:/ListeBitcoins";
	}

	@RequestMapping("/ListeBitcoins")
	public String listeOwners(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Bitcoin> b = bitService.getAllBitcoinParPage(page, size);
		modelMap.addAttribute("bitcoins", b);
		modelMap.addAttribute("pages", new int[b.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeBitcoins";
	}
	

	@RequestMapping("/supprimerBitcoin")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		bitService.deleteBitcoinById(id);
		Page<Bitcoin> b = bitService.getAllBitcoinParPage(page, size);
		modelMap.addAttribute("bitcoins", b);
		modelMap.addAttribute("pages", new int[b.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeBitcoins";
	}

	@RequestMapping("/modifierBitcoin")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Bitcoin b = bitService.getBitcoinById(id);
		modelMap.addAttribute("bitcoin", b);
		modelMap.addAttribute("mode", "edit");
		return "formBitcoin";
	}

	

}
