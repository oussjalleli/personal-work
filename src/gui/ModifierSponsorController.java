/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.sponsors;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.SponsorsCrud;

/**
 * FXML Controller class
 *
 * @author oussa
 */
public class ModifierSponsorController implements Initializable {

    @FXML
    private TextField IDm;
    @FXML
    private Button modifytournoi;
    @FXML
    private TextField getNom;
    @FXML
    private TextField getEmail;
    @FXML
    private Label getType1;
    @FXML
    private TextField getType;
    @FXML
    private TextField getNum;
    
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
        
         SponsorsCrud sp= new SponsorsCrud();
                 
         List<sponsors> ll = sp.afficherId(id);
  
    
 
            getNom.setText(ll.get(0).getNom());
            getType.setText(ll.get(0).getType());
            getEmail.setText(ll.get(0).getEmail());
            getNum.setText(String.valueOf(ll.get(0).getNum_contact()));
            
            
            ModifItems(id);
    }
    
    public void ModifItems (int id)
    {
                 
          
        modifytournoi.setOnAction(e -> {
            
             SponsorsCrud sp= new SponsorsCrud();
                 
         List<sponsors> ll = sp.afficherId(id);
              String nomajout = getNom.getText();
        int numajout = Integer.parseInt(getNum.getText());
          String typeajout = getType.getText();
            String emailajout = getEmail.getText();
       
        
      
        
       sponsors p = new sponsors(id,nomajout,emailajout,numajout,typeajout);
           // SponsorsCrud sp = new SponsorsCrud();
            sp.modifier(p);
            ((Node)(e.getSource())).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Sponsor modifié!");
            alert.show(); 
                
           
        });
        }
    
}
