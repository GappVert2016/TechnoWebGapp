package org.green.app.controllers;

import org.green.app.entities.SessionApp;
import org.green.app.metier.IRespoAppMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
