/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Evenement;
import entities.sponsors;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.EventCrud;
import services.SponsorsCrud;

/**
 * FXML Controller class
 *
 * @author oussa
 */
public class ModifierEventController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField IDm;
    @FXML
    private Button modifyEvent;
    @FXML
    private TextField getNomE;
    @FXML
    private Label getType1;
    @FXML
    private TextField getId_sponsors;
    @FXML
    private TextField getNb_maxParticipant;
    @FXML
    private Label getNum_Cont;
    @FXML
    private Label getNum_Cont1;
    @FXML
    private TextField getDescription;
     @FXML
    private DatePicker getDate;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setTextID (String message)
    {
        this.IDm.setText(message);
    }
    public void setItems (int id)
    {
        
         EventCrud sp= new EventCrud();
                 
         List<Evenement> ll = sp.afficherId(id);
  
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(ll.get(0).getDate_evenement());
 LocalDate date = LocalDate.parse(dateToString);
 
            getNomE.setText(ll.get(0).getNom());
            getNb_maxParticipant.setText(String.valueOf(ll.get(0).getNbmax_participant()));
            getId_sponsors.setText(String.valueOf(ll.get(0).getId_sponsor()));
            getDescription.setText(ll.get(0).getDescription());
            getDate.setValue(date);
            
            
            ModifItems(id);
    }
    
    public void ModifItems (int id)
    {
                 
          
        modifyEvent.setOnAction(e -> {
             EventCrud sp= new EventCrud();
                 
         List<Evenement> ll = sp.afficherId(id);
            String img = ll.get(0).getImage();
              String nomajout = getNomE.getText();
        int nbmaxPartajout = Integer.parseInt(getNb_maxParticipant.getText());
          int idSponsorsjout = Integer.parseInt(getId_sponsors.getText());
            String descriptionajout = getDescription.getText();
       ZoneId defaultZoneId = ZoneId.systemDefault();
        Date dateajout = Date.from(getDate.getValue().atStartOfDay(defaultZoneId).toInstant());
        
      
        
       Evenement p = new Evenement(id,nbmaxPartajout,dateajout ,nomajout, idSponsorsjout, descriptionajout,img);
           
            sp.modifier(p);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Evenement modifié!");
            alert.show(); 
                
           
        });
        }
    
}
