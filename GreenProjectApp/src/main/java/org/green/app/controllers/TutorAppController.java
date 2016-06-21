package org.green.app.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.green.app.entities.Competence;
import org.green.app.entities.Equipe;
import org.green.app.entities.Note;
import org.green.app.entities.Utilisateur;
import org.green.app.metier.ITuteurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/tutorApp")
public class TutorAppController {
	@Autowired
	private ITuteurMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {

		return "gestionTutor";
	}

	@RequestMapping(value = "/listeEquipe")
	public String listeEquipe(Model model) {

		ArrayList<List<Utilisateur>> list = new ArrayList<List<Utilisateur>>();
		int nb = metier.nombreEquipe();
		for (int i = 1; i <= nb; i++) {
			list.add(metier.listUtilisateurParGroupe((long) i));
		}

		model.addAttribute("listElevesParGroupe", list);

		return "listeEquipe";
	}

	@RequestMapping(value = "/listeFamille")
	public String listeFamilles(Model model) {

		ArrayList<List<Competence>> list = new ArrayList<List<Competence>>();
		int nb = metier.nombreFamilleComp();
		System.out.println(nb);
		for (int i = 1; i <= nb; i++) {
			list.add(metier.listCompetenceParFamComp((long) i));
		}
		model.addAttribute("listCompetenceParFam", list);

		return "listeFamille";
	}

	@RequestMapping(value = "/selectToNote")
	public String indexSelect(Model model) {

		model.addAttribute("listAssigneEquipes", metier.listAssignEquipe());
		model.addAttribute("listEquipes", metier.listEquipe());

		ArrayList<List<Utilisateur>> list = new ArrayList<List<Utilisateur>>();
		int nb = metier.nombreEquipe();
		for (int i = 1; i <= nb; i++) {
			list.add(metier.listUtilisateurParGroupe((long) i));
		}
		System.out.println(nb);
		model.addAttribute("listElevesParGroupe", list);

		return "SelectToNote";

	}

	@RequestMapping(value = "/grilleNotes", method = RequestMethod.GET)
	public String grilleNote(Model model, @ModelAttribute("idUtilisateur") Long idUtilisateur,
			@ModelAttribute("idUtilisateur") Long idEquipe) {

		Utilisateur u = metier.getUtilisateur(idUtilisateur);
		model.addAttribute("utilisateur", u);
		System.out.println(u.getNomUtilisateur());
		// model.addAttribute("listCompetence",
		// metier.listNotesParUtilisateur((long) 1));

		ArrayList<List<Note>> list = new ArrayList<List<Note>>();
		int nb = metier.nombreFamilleComp();
		System.out.println(nb);
		for (int i = 1; i <= nb; i++) {
			list.add(metier.listNotesParUtilisateurParFamComp(idUtilisateur, (long) i));
		}
		model.addAttribute("listCompetenceParFam", list);

		return "GrilleNotes";
	}

	@RequestMapping(value = "/noter", method = RequestMethod.GET)
	public String ajouterNote(Model model, @ModelAttribute("idUtilisateur") Long idUtilisateur,
			@ModelAttribute("idEquipe") Long idEquipe) {

		System.out.println(idUtilisateur);
		model.addAttribute("id", idUtilisateur);
		System.out.println(idEquipe);
		model.addAttribute("idEquipe", idEquipe);
		model.addAttribute("noteForm", new Note());
		model.addAttribute("listEquipe", metier.listEquipes());
		model.addAttribute("listUtilisateur", metier.listUtilisateur());
		model.addAttribute("listComps", metier.listComptence());

		return "gestionTutorNote";
	}

	@RequestMapping(value = "/saveNote", method = RequestMethod.POST)
	public String saveUtilisateur(@Valid Note n, Model model) {

		metier.ajouterNote(n, n.getComptence().getIdCompetence(), n.getEquipe().getIdEquipe(),
				n.getUtilisateur().getIdUtilisateur());

		model.addAttribute("noteForm", new Note());
		return "gestionTutorNote";

	}

}