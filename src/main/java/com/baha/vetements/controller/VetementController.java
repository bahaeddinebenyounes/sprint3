package com.baha.vetements.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baha.vetements.entities.Type;
import com.baha.vetements.entities.Vetement;
import com.baha.vetements.service.VetementService;

import jakarta.validation.Valid;



@Controller
public class VetementController {
	@Autowired
	VetementService vetementService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}

	@RequestMapping("/listeVetements")
	public String listeVetements(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Page<Vetement> prods = vetementService.getAllVetementsParPage(page, size);
		modelMap.addAttribute("vetements", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVetements";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	List<Type> typs = vetementService.getAllTypes();
	modelMap.addAttribute("vetement", new Vetement());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("type", typs);
	return "formVetement";
	}

	@RequestMapping("/saveVetement")
	public String saveVetement(@Valid Vetement vetement,
			BindingResult bindingResult,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors()) return "formVetement";
		
		if (vetement.getIdVetement()==null) //ajout
			isNew=true;
		
		
		vetementService.saveVetement(vetement);
		if (isNew) //ajout
		{
		Page<Vetement> vets = vetementService.getAllVetementsParPage(page, size);
		currentPage = vets.getTotalPages()-1;
		}
		else //modif
		currentPage=page;
	return ("redirect:/listeVetements");	}

	@RequestMapping("/supprimerVetement")
	public String supprimerVetement(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		vetementService.deleteVetementById(id);
		Page<Vetement> prods = vetementService.getAllVetementsParPage(page, size);
		modelMap.addAttribute("vetements", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeVetements";
		}
	

	@RequestMapping("/modifierVetement")
	public String editerVetement(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		List<Type> typs = vetementService.getAllTypes();
		Vetement p = vetementService.getVetement(id);
		modelMap.addAttribute("vetement", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("type", typs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);


		return "formVetement";
	}

	@RequestMapping("/updateVetement")
	public String updateVetement(@ModelAttribute("vetement") Vetement vetement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
// conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		vetement.setDateCreation(dateCreation);
		vetementService.updateVetement(vetement);
		List<Vetement> prods = vetementService.getAllVetements();
		modelMap.addAttribute("vetements", prods);
		return "listeVetements";
	}
}