package org.green.app.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class FamilleCompetence implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFamille;
	private String nomFamille;
	@ManyToOne
	@JoinColumn(name="idApp")
	private SessionApp sessionApp;
	@OneToMany(mappedBy="familleCompetence")
	private Collection<Competence> competences;
	
	
	public FamilleCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilleCompetence(String nomFamille, SessionApp sessionApp) {
		super();
		this.nomFamille = nomFamille;
		this.sessionApp = sessionApp;
	}
	public long getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(long idFamille) {
		this.idFamille = idFamille;
	}
	public String getNomFamille() {
		return nomFamille;
	}
	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}
	public SessionApp getSessionApp() {
		return sessionApp;
	}
	public void setSessionApp(SessionApp sessionApp) {
		this.sessionApp = sessionApp;
	}
	public Collection<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(Collection<Competence> competences) {
		this.competences = competences;
	}
	
	

}
