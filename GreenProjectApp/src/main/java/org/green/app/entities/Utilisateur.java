package org.green.app.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Utilisateur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUtilisateur;
	@NotEmpty
	private String nomUtilisateur;
	private String password;
	private boolean actived;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Role> roles;
	@OneToMany(mappedBy="utilisateur")
	private Collection<SessionApp> sessionApps;
	@OneToMany(mappedBy="utilisateur")
	private Collection<AssignationsEquipe> assignEquipes;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Note> notes;

	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nomUtilisateur, String password, boolean actived) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.password = password;
		this.actived = actived;
	}

	public long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<SessionApp> getSessionApps() {
		return sessionApps;
	}

	public void setSessionApps(Collection<SessionApp> sessionApps) {
		this.sessionApps = sessionApps;
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
