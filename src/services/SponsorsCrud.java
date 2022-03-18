/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.sponsors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MYDB;

/**
 *
 * @author Admin
 */
public class SponsorsCrud implements ICService<sponsors>{
    private Connection cnx;

    public SponsorsCrud() {
        cnx = MYDB.getInstance().getConnection();
    }
       
     public void ajouter(sponsors s){
         try{
         String req="INSERT INTO sponsor (nom,email, num_contact,type) VALUES('"+s.getNom()+"','"+s.getEmail()+"',"+s.getNum_contact()+",'"+s.getType()+"')";
      Statement statement = cnx.createStatement();
//            System.out.println("Insertion...");
           statement.executeUpdate(req);
            
            System.out.println("Une ligne insérée dans la table...");
            
        }
        
        catch(SQLException e){
//            Logger.getLogger(SponsorsCrud.class.getTitre);  
         
     }
     }

   

    
    public List<sponsors> afficher() {
         List<sponsors> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM sponsor";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                sponsors s = new sponsors();
                       s.setId_sponsors(rs.getInt(1));
                       s.setNom(rs.getString(2));
                       s.setEmail(rs.getString(3));
                       s.setNum_contact(rs.getInt(4));
                       s.setType(rs.getString(5));
                
                list.add(s);
            }
    }

  
        catch(SQLException e){
            
        }
        return list ;  
}

   
    public void modifier(sponsors s) {
        try{
            String req = "UPDATE sponsor SET nom = ?, email = ?, num_contact= ? , type= ? WHERE id_sponsor= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
       
        ps.setString(1,s.getNom());
        ps.setString(2,s.getEmail());
        ps.setInt(3,s.getNum_contact());
        ps.setString(4,s.getType());
        ps.setInt(5,s.getId_sponsors());
        System.out.println("Modification...");
        ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException e){
           
       }
               
    }

    
    public void supprimer(int id) {
             try{
            String req = "DELETE FROM sponsor WHERE id_sponsor = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }
             
    }  
 public List<sponsors> afficherId(int id) {
         List<sponsors> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM sponsor where id_sponsor="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                sponsors s = new sponsors();
                       s.setId_sponsors(rs.getInt(1));
                       s.setNom(rs.getString(2));
                       s.setEmail(rs.getString(3));
                       s.setNum_contact(rs.getInt(4));
                       s.setType(rs.getString(5));
                
                list.add(s);
            }
    }

  
        catch(SQLException e){
            
        }
        return list ;  
}
}
    
     
