package org.green.app.controllers;

import org.green.app.entities.Utilisateur;
import org.green.app.metier.IEtudiantMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/studentApp")
public class StudentAppController {
	@Autowired
	private IEtudiantMetier metier;
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("famillecompetences", metier.listNote());

		return "home";
		
	}
}
