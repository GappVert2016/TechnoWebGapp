package org.green.app.metier;

import java.util.List;

import org.green.app.entities.Note;
import org.green.app.entities.Utilisateur;

public interface ITuteurMetier extends IEtudiantMetier {
	
	public List<Utilisateur> listUtilisateur();
	public List<Utilisateur> utilisateurParMotCle(String mc);	
	public Utilisateur getUtilisateur(Long idUtilisateur);
	
	public Long ajouterNote(Note n, Long idCompetence, Long idEquipe, Long idUtilisateur);
	public void supprimerNote(Long idNt);
	public void modifierNote(Note n);

}
