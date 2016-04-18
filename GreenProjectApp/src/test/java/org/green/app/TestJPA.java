package org.green.app;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.green.app.entities.AssignationsEquipe;
import org.green.app.entities.Equipe;
import org.green.app.entities.SessionApp;
import org.green.app.entities.Utilisateur;
import org.green.app.metier.IRespoAppMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
	ClassPathXmlApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
	}

	@Test
	public void test1() {
		try {
			IRespoAppMetier metier= 
					(IRespoAppMetier) context.getBean("metier");
			List<Utilisateur> sesap1=metier.listUtilisateur();
			metier.ajouterUtilisateur(new Utilisateur("tata@gmail.com", "tataLDAP" , "tataNom", "tataPrenom", "etudiantISEP"));
			metier.ajouterUtilisateur(new Utilisateur("toto@gmail.com", "totoLDAP" , "totoNom", "totoPrenom", "etudiantISEP"));
			List<Utilisateur> sesap2=metier.listUtilisateur();
			assertTrue(sesap1.size()+2==sesap2.size());
		}
		catch(Exception e){
			assertTrue(e.getMessage(),false);
		}
	}
	
	
	@Test
	public void test2() {
		try {
			IRespoAppMetier metier= 
					(IRespoAppMetier) context.getBean("metier");
			List<SessionApp> sep1=metier.listSassionApp();
			Utilisateur u = new Utilisateur("toto@gmail.com", "totoLDAP" , "totoNom", "totoPrenom", "etudiantISEP");
			metier.ajouterUtilisateur(u);
			metier.ajouterSessionApp(new SessionApp("APPInfosemestre1", "Description app info 2016", u));
			metier.ajouterSessionApp(new SessionApp("AppElectrosem2", "Description app electro 2016", u));
			List<SessionApp> sep2=metier.listSassionApp();
			assertTrue(sep1.size()+2==sep2.size());
		}
		catch(Exception e){
			assertTrue(e.getMessage(),false);
		}
	}
	
	@Test
	public void test3() {
		try {
			IRespoAppMetier metier= 
					(IRespoAppMetier) context.getBean("metier");
			List<Equipe> equ1=metier.listEquipe();
			Utilisateur u = new Utilisateur("tutu@gmail.com", "totuLDAP" , "tutuNom", "tetePrenom", "etudiantesISEP");
			metier.ajouterUtilisateur(u);
			
			metier.ajouterSessionApp(new SessionApp("APPInfosemestre1", "Description app info 2016", u));
			SessionApp sa = new SessionApp("AppElectrosem2", "Description app electro 2016", u);
			metier.ajouterSessionApp(sa);
			metier.ajouterEquipe(new Equipe("GoupeA1", sa));
			metier.ajouterEquipe(new Equipe("GoupeB2", sa));
			List<Equipe> equ2=metier.listEquipe();
			assertTrue(equ1.size()+2==equ2.size());
		}
		catch(Exception e){
			assertTrue(e.getMessage(),false);
		}
	}
	
	@Test
	public void test4() {
		try {
			IRespoAppMetier metier= 
					(IRespoAppMetier) context.getBean("metier");
			List<AssignationsEquipe> ae1=metier.listAssignEquipe();
			
			Utilisateur u = new Utilisateur("tutu@gmail.com", "totuLDAP" , "tutuNom", "tetePrenom", "etudiantesISEP");
			metier.ajouterUtilisateur(u);
			
			SessionApp sa = new SessionApp("AppElectrosem2", "Description app electro 2016", u);
			metier.ajouterSessionApp(sa);
			
			Equipe e = new Equipe("GoupeA1", sa);
			metier.ajouterEquipe(e);
			
			metier.ajouterAssignEquipe(new AssignationsEquipe(u,e));
			metier.ajouterAssignEquipe(new AssignationsEquipe(u,e));
			List<AssignationsEquipe> ae2=metier.listAssignEquipe();
			assertTrue(ae1.size()+2==ae2.size());
		}
		catch(Exception e){
			assertTrue(e.getMessage(),false);
		}
	}

}
