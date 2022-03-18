/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import javafx.scene.control.Button;

/*

id_evenement 

nom 

nbmax_participants 

date_evenement 

id_sponsor 

description 

image_event
/**
 *
 * @author farah
 */
public class Evenement {
    private int id_evenement;
    private int nbmax_participant;
    private Date date_evenement;
    private String nom;
    private int id_sponsor;
    private String description;
    private String image;

    
    private Button modifier;
    private Button supprimer;

    public Evenement(int id_evenement, int nbmax_participant, Date date_evenement, String nom, int id_sponsor, String description, String image) {
        this.id_evenement = id_evenement;
        this.nbmax_participant = nbmax_participant;
        this.date_evenement = date_evenement;
        this.nom = nom;
        this.id_sponsor = id_sponsor;
        this.description = description;
        this.image = image;
       
    }

    public Evenement(int nbmax_participant, Date date_evenement, String nom, int id_sponsor, String description, String image) {
        this.nbmax_participant = nbmax_participant;
        this.date_evenement = date_evenement;
        this.nom = nom;
        this.id_sponsor = id_sponsor;
        this.description = description;
        this.image = image;
      
    }

    public Evenement(int id_evenement, int nbmax_participant, Date date_evenement, String nom, int id_sponsor, String description) {
        this.id_evenement = id_evenement;
        this.nbmax_participant = nbmax_participant;
        this.date_evenement = date_evenement;
        this.nom = nom;
        this.id_sponsor = id_sponsor;
        this.description = description;
    }

    

    public Evenement(int nbmax_participant, String nom, int id_sponsor, String description) {
        this.nbmax_participant = nbmax_participant;
        this.nom = nom;
        this.id_sponsor = id_sponsor;
        this.description = description;
    }

    public Evenement() {
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public int getNbmax_participant() {
        return nbmax_participant;
    }

    public Date getDate_evenement() {
        return date_evenement;
    }

    public String getNom() {
        return nom;
    }

    public int getId_sponsor() {
        return id_sponsor;
    }

    public String getDescription() {
        return description;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setNbmax_participant(int nbmax_participant) {
        this.nbmax_participant = nbmax_participant;
    }

    public void setDate_evenement(Date date_evenement) {
        this.date_evenement = date_evenement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Button getModifier() {
        return modifier;
    }

    public Button getSupprimer() {
        return supprimer;
    }

    public void setModifier(Button modifier1) {
        this.modifier = modifier1;
    }

    public void setSupprimer(Button supprimer1) {
        this.supprimer = supprimer1;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", nbmax_participant=" + nbmax_participant + ", date_evenement=" + date_evenement + ", nom=" + nom + ", id_sponsor=" + id_sponsor + ", description=" + description + ", image=" + image + ", modifier=" + modifier + ", supprimer=" + supprimer + '}';
    }

   
    
    

  

    public String setDate_evenement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
