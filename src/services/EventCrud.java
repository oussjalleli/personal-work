/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.Evenement;
import entities.sponsors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import util.MYDB;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Admin
 */
public class EventCrud implements ICService<Evenement>{
    private Connection cnx;
    public String adresse;

    public EventCrud() {
        cnx = MYDB.getInstance().getConnection();
    }
       
     public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_evenement FROM evenement";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_evenement"));}
            Collections.sort(st);
            for(int i=0;i<st.size() && test==false;i++)
            {int b= (int)st.get(i);
               if(j<b)
                    test= true;
                else
                  j++;
            };
         } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return j;
    }
    
    
     public void ajouter(Evenement e){
         
         int id = id_auto();
         java.sql.Date d = new java.sql.Date(e.getDate_evenement().getTime());
         try{
         String req="INSERT INTO evenement (id_evenement,nom,nbmax_participants, date_evenement,id_sponsor, description,image_event) VALUES(?,?,?,?,?,?,?)";
      PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            pst.setString(2,e.getNom());
            pst.setInt(3,e.getNbmax_participant());
            pst.setDate(4,d);
            pst.setInt(5,e.getId_sponsor());
            pst.setString(6,e.getDescription());
            pst.setString(7,e.getImage());
            
            pst.executeUpdate();
            System.out.println("Event ajoutée !");
            
        }
        
        catch(SQLException ex){
//            Logger.getLogger(SponsorsCrud.class.getTitre);  
         
     }
     }

   

    
    public List<Evenement> afficher() {
         List<Evenement> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM evenement";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Evenement e = new Evenement();
                       e.setId_evenement(rs.getInt(1));
                       e.setNom(rs.getString(2));
                       e.setNbmax_participant(rs.getInt(3));
                       e.setDate_evenement(rs.getDate(4));
                       e.setId_sponsor(rs.getInt(5));
                       e.setDescription(rs.getString(6));
                       e.setImage(rs.getString(7));
                list.add(e);
            }
    }

  
        catch(SQLException ex){
            
        }
        return list ;  
}

   
    public void modifier(Evenement e) {
        java.sql.Date d = new java.sql.Date(e.getDate_evenement().getTime());
        try{
            String req = "UPDATE evenement SET nom = ?,nbmax_participants= ?, date_evenement=?,id_sponsor =?, description = ?, image_event=? WHERE id_evenement= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
       
        ps.setString(1,e.getNom());
        ps.setInt(2,e.getNbmax_participant());
        ps.setDate(3,d);
        ps.setInt(4,e.getId_sponsor());
        ps.setString(5,e.getDescription());
        ps.setString(6,e.getImage());
        ps.setInt(7,e.getId_evenement());
        System.out.println("Modification...");
        ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException ex){
           
       }
               
    }

    
    public void supprimer(int id) {
             try{
            String req = "DELETE FROM evenement WHERE id_evenement = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }
             
    }  
    
     public List<Evenement> afficherId(int id) {
         List<Evenement> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM evenement where id_evenement= "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Evenement e = new Evenement();
                       e.setId_evenement(rs.getInt(1));
                       e.setNom(rs.getString(2));
                       e.setNbmax_participant(rs.getInt(3));
                       e.setDate_evenement(rs.getDate(4));
                       e.setId_sponsor(rs.getInt(5));
                       e.setDescription(rs.getString(6));
                       e.setImage(rs.getString(7));
                list.add(e);
            }
    }

  
        catch(SQLException ex){
            
        }
        return list ;  
}

     public List<Evenement> recherche(String nom) {
         List<Evenement> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM evenement where nom LIKE '%"+nom+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Evenement e = new Evenement();
                       e.setId_evenement(rs.getInt(1));
                       e.setNom(rs.getString(2));
                       e.setNbmax_participant(rs.getInt(3));
                       e.setDate_evenement(rs.getDate(4));
                       e.setId_sponsor(rs.getInt(5));
                       e.setDescription(rs.getString(6));
                       e.setImage(rs.getString(7));
                list.add(e);
            }
    }

  
        catch(SQLException ex){
            
        }
        return list ;  
}
     
     //fonction pour la récupération des addresses email des utilisateurs et les stocker
     public String RecupAdd() throws SQLException{
         
         String req = "SELECT email FROM utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            String arr = null;
            while (rs.next()) {
                   String em = rs.getString("EM_ID");
                   arr = em.replace("\n", ",");
                   System.out.println(arr);
                }
          adresse= arr;  
          return adresse;
             
     }
     
    
     
     public void sendMail(String recepient) throws Exception {
        String adresse= RecupAdd(); 
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "oussama.jalleli@esprit.tn";
        //Your gmail password
        String password = "Hannamina1";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        
        Message message = prepareMessage(session, myAccountEmail, adresse);

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String adresse) throws SQLException {
                 MimeMessage mail=new MimeMessage(session); 
        MimeMultipart multipart = new MimeMultipart("related");
MimeBodyPart htmlPart = new MimeBodyPart();

        try {
  

multipart.addBodyPart(htmlPart);

MimeBodyPart imgPart=new MimeBodyPart();
String path = "../images/valo.jpeg";
DataSource ds=new FileDataSource(path);
imgPart.setDataHandler(new DataHandler(ds));    
imgPart.setHeader("Content-ID","the-img-1");
multipart.addBodyPart(imgPart);

mail.setContent(multipart);

mail.setSentDate(new Date());
mail.setHeader("X-Mailer", "ALS Notifier Build 1.0.0.10");
            //Message message = new MimeMessage(session);
            mail.setFrom(new InternetAddress(myAccountEmail));
            mail.setRecipient(Message.RecipientType.BCC, new InternetAddress("kalboussikarim3@gmail.com"));
            mail.setSubject("New EVENTS Valorant E-Sport");
            String htmlCode = " <h1>On vous invite à consulter les nouveaux évenements\n</h1><h2>De la part de l'équipe primordial</h2>";
            mail.setContent(htmlCode, "text/html");
            return mail;
        } catch (MessagingException ex) {
            Logger.getLogger(EventCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    
     

    

