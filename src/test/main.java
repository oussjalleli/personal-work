/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Evenement;
import entities.sponsors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.EventCrud;
import services.SponsorsCrud;



import util.MYDB;

/**
 *
 * @author msi
 */
public class main {
    
    
     public static void main(String[] args)throws ParseException, Exception {
          SimpleDateFormat d = new SimpleDateFormat("yyyy/MM/dd");
        
             java.util.Date date =d.parse("2021/12/05");
         
         MYDB.getInstance(); 
         SponsorsCrud sc = new SponsorsCrud();
         sponsors s = new sponsors("hhhh", "ggggdf",5435435,"cfjk"); 
         
     // sc.ajouter(s);
   //   sc.modifier(new sponsors ("cfb","fcbjjh",3543,"gfhbcv"));
       //sc.supprimer(1);
       System.out.println(sc.afficher());
    
    EventCrud ec = new EventCrud();
    Evenement e = new Evenement(45,date,"nom",4,"djxlvldkjfldskf","rrrrrrrr");
   ec.ajouter(e);
   //ec.modifier(e);
   //ec.supprimer(1);
    System.out.println(ec.afficher());
        
    
     }
}
    
    
