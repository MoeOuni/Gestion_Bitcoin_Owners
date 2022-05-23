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
import com.ouni.bitcoin.service.OwnerService;

@Controller
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	@Autowired
	BitcoinService bitService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Bitcoin> bits = bitService.findAll();
		Owners own = new Owners();
		Bitcoin bit = new Bitcoin();
		bit = bits.get(0); //
		own.setBitcoin(bit);
		modelMap.addAttribute("owner", own);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("bitcoins", bits);
		return "formOwners";
	}

	@RequestMapping("/saveOwner")
	public String saveProduit(@Valid Owners owner, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formOwners";
		ownerService.saveOwner(owner);
		return "redirect:/ListeOwners";
	}

	@RequestMapping("/ListeOwners")
	public String listeOwners(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Owners> o = ownerService.getAllOwnersParPage(page, size);
		modelMap.addAttribute("owners", o);
		modelMap.addAttribute("pages", new int[o.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeOwners";
	}

	@RequestMapping("/supprimerOwner")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		ownerService.deleteOwnerById(id);
		Page<Owners> o = ownerService.getAllOwnersParPage(page, size);
		modelMap.addAttribute("owners", o);
		modelMap.addAttribute("pages", new int[o.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeOwners";
	}

	@RequestMapping("/modifierOwner")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Owners o = ownerService.getOwnerById(id);
		List<Bitcoin> bits = bitService.findAll();
		modelMap.addAttribute("owner", o);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("bitcoins", bits);
		return "formOwners";
	}

	@RequestMapping("/updateOwner")
	public String updateProduit(@ModelAttribute("owner") Owners owner, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		owner.setPurchaseDate(dateCreation);
		ownerService.updateOwner(owner);
		List<Owners> o = ownerService.getAllOwners();
		modelMap.addAttribute("owners", o);
		return "ListeOwners";
	}
}
