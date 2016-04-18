package org.green.app.controllers;

import javax.validation.Valid;

import org.green.app.entities.SessionApp;
import org.green.app.metier.IRespoAppMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/respoApp")
public class RespoAppController {
	@Autowired
	private IRespoAppMetier metier;
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("sessionApp", new SessionApp());
		model.addAttribute("sessionApps", metier.listSassionApp());
		return "gestions";
		
	}
	@RequestMapping(value="/saveSessionApp")
	public String saveSessionApp(@Valid SessionApp sa, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("sessionApps", metier.listSassionApp());
			return("gestions");
		}
		metier.ajouterSessionApp(sa);
		model.addAttribute("sessionApp", new SessionApp());
		model.addAttribute("sessionApps", metier.listSassionApp());
		return "gestions";
		
	}
}
