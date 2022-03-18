/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	package entities;

	import java.util.Date;
	import java.util.logging.Logger;
import javafx.scene.control.Button;

	/**
	 *
	 * @author Admin
	 */
public class sponsors {
	
	
	    private int id_sponsors;
	    private String nom;
	    private String email;
	      private int num_contact;
	    private String type;
            private Button modifier;
            private Button supprimer;

	    public sponsors(int id_sponsors, String nom, String email, int num_contact, String type) {
	        this.id_sponsors= id_sponsors;
	        this.nom= nom;
	        this.email= email;
	        this.num_contact= num_contact;
	        this.type= type;
	    }

    public sponsors(String nom, String email, int num_contact, String type) {
        this.nom = nom;
        this.email = email;
        this.num_contact = num_contact;
        this.type = type;
    }

	   

	    public sponsors() {
	    }

	    @Override
	    public String toString() {
	        return "Sponsors{" + "id_sponsors=" + id_sponsors + ", nom=" + nom + ", email=" + email + ", num_contact=" + num_contact + ", type=" + type + '}';
	    }
	    

	    public void setId_sponsors(int id_sponsors) {
	        this.id_sponsors = id_sponsors;
	    }

	    public int getId_sponsors() {
	        return id_sponsors;
	    }

    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }

    public void setSupprimer(Button supprimer) {
        this.supprimer = supprimer;
    }

    public Button getSupprimer() {
        return supprimer;
    }


	    public String getNom() {
	        return nom;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public int getNum_contact() {
	        return num_contact;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setNom(String nom) {
	        this.nom= nom;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setNum_contact(int num_contact) {
	        this.num_contact=num_contact;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    
	   
	    
	

}
