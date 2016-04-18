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

@Entity
public class Equipe implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEquipe;
	private String nomEquipe;
	@ManyToOne
	@JoinColumn(name="idSessionApp")
	private SessionApp sessionAppEquipe;
	@OneToMany(mappedBy="equipe")
	private Collection<AssignationsEquipe> assignEquipes;
	@OneToMany(mappedBy="equipe")
	private Collection<Note> notes;

	
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Equipe(String nomEquipe, SessionApp sessionAppEquipe) {
		super();
		this.nomEquipe = nomEquipe;
		this.sessionAppEquipe = sessionAppEquipe;
	}
	public long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public SessionApp getSessionAppEquipe() {
		return sessionAppEquipe;
	}
	public void setSessionAppEquipe(SessionApp sessionAppEquipe) {
		this.sessionAppEquipe = sessionAppEquipe;
	}
	public Collection<AssignationsEquipe> getAssignEquipes() {
		return assignEquipes;
	}
	public void setAssignEquipes(Collection<AssignationsEquipe> assignEquipes) {
		this.assignEquipes = assignEquipes;
	}
	public Collection<Note> getNotes() {
		return notes;
	}
	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}
	
	

}
