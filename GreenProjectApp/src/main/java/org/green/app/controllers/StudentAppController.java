package org.green.app.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.green.app.entities.Note;
import org.green.app.entities.Utilisateur;
import org.green.app.metier.IEtudiantMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/studentApp")
public class StudentAppController {
	@Autowired
	private IEtudiantMetier metier;
	@RequestMapping(value="/index", method= RequestMethod.GET)
	public String index(Model model, Principal principal){
		
		String name = principal.getName();
		System.out.println(name);
		model.addAttribute("nom", name);
		
		
        ArrayList<List<Note>> list = new ArrayList<List<Note>>();
        int nb = metier.nombreFamilleComp();
        System.out.println(nb);
        for(int i=1; i<=nb;i++){
                list.add(metier.listNotesParUtilisateurs(name, (long)i));
        }
        model.addAttribute("listCompetenceParFam", list);
		

		return "gestionStudent";
		
	}
}
