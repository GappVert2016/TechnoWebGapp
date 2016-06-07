package org.green.app.controllers;

import org.green.app.entities.Utilisateur;
import org.green.app.metier.ITuteurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/tutorApp")
public class TutorAppController {
		@Autowired
		private ITuteurMetier metier;
		@RequestMapping(value="/index")
		public String index(Model model){
			model.addAttribute("familleForm", new Utilisateur());
			model.addAttribute("listUtilisateurs", metier.listUtilisateur());

			return "famillecompetences";
			
		}
		
}
