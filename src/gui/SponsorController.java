/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import com.itextpdf.text.BaseColor;

import entities.Evenement;
import entities.sponsors;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.nio.file.Paths;
import static java.rmi.Naming.list;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.effect.DropShadow;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window; 
import services.SponsorsCrud;

import services.EventCrud;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.cache.FileBasedLocalCache;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import util.MYDB;



/**
 * FXML Controller class
 *
 * @author oussa
 */
public class SponsorController implements Initializable {
  private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Circle taswira;
    @FXML
    private Label nbt;
    @FXML
    private Label nbtnj;
    @FXML
    private TableView<sponsors> tableSponsor;
    @FXML
    private TableColumn<sponsors, String> NOM;
    @FXML
    private TableColumn<sponsors, String> EMAIL;
    @FXML
    private TableColumn<sponsors, Integer> NUM_CONTACT;
    @FXML
    private TableColumn<sponsors, String> TYPE;
    @FXML
    private TableColumn<sponsors, Button> MODIFIER;
    @FXML
    private TableColumn<sponsors, Button> SUPPRIMER;
    @FXML
    private TableColumn<sponsors, Integer> ID;
    @FXML
    private Button reload;
    @FXML
    private TextField getNom_tournoi;
    @FXML
    private TextField getNb_max;
    @FXML
    private TextField getR1;
    @FXML
    private TextField getR2;
    @FXML
    private TextField getR3;
    @FXML
    private TextField getP1;
    @FXML
    private TextField getP2;
    @FXML
    private TextField getP3;
    @FXML
    private ComboBox<?> etat_tournoi;
    @FXML
    private Button ajouterTournoi;
    @FXML
    private TextField getheure_tournoi;
    @FXML
    private DatePicker getDate_tournoi;
    @FXML
    private TextArea ima;
    @FXML
    private Button buttonima;
    @FXML
    private Button mapimag;
//    @FXML
//    private Button Statistics;
    @FXML
    private Label nbt1;
    @FXML
    private Label nbtnj1;
    @FXML
    private TableView<Evenement> tableEvent;
    @FXML
    private TableColumn<Evenement, String> NomE;
    @FXML
    private TableColumn<Evenement, Integer> nbmaxPart;
    @FXML
    private TableColumn<Evenement, Date> DATEEM;
    @FXML
    private TableColumn<Evenement, Integer> idspoE;
    @FXML
    private TableColumn<Evenement, String> descE;
    @FXML
    private TableColumn<Evenement, String> IMAGE;
    @FXML
    private TableColumn<Evenement, Button> MODIFIER1;
    @FXML
    private TableColumn<Evenement, Button> SUPPRIMER1;
    @FXML
    private TableColumn<Evenement, Integer> ID1;
    @FXML
    private Button reload1;
    @FXML
    private TextField getId_sponsors;
    @FXML
    private TextField getEquipe2;
    @FXML
    private ComboBox<?> etat_match;
    @FXML
    private Button ajouterEvent;
    @FXML
    private DatePicker getDate;
    @FXML
    private TextField getDescription;
    @FXML
    private TextField getNb_maxParticipant;
    @FXML
    private TextField getNomE;
    @FXML
    private TextField getNom;
    @FXML
    private TextField getEmail;
    @FXML 
    private TextField getTypes;
    @FXML
    private TextField getNum;
    
     SponsorsCrud st = new SponsorsCrud();
     List<sponsors> lt = st.afficher();
     EventCrud sm = new EventCrud();
     List<Evenement> lm = sm.afficher();
     
     @FXML
             private TextField filterField;
     
    
    Button[] modify_button = new Button[100];
       Button[] supprimerb = new Button[100];
       Button[] modify_button1 = new Button[100];
       Button[] Statistics =new Button[100];
       Button[] supprimerb1 = new Button[100];
        int index=101; 
       int pause=1;
    /**
     * Initializes the controller class.
     */
       
       @FXML
     public void chercher(){
    EventCrud tt = new EventCrud();
        lm = tt.recherche(filterField.getText());
          System.out.println("Recherche");
        System.out.println(filterField.getText());
        tableEvent.setEditable(true);
      
        afficher_Event(lm);
       
    }
       
       @FXML
             private void showStat(ActionEvent event)
    {
        try {
            
           
        FXMLLoader statevent= new FXMLLoader(getClass().getResource("lineEventChart.fxml"));
            Parent root = statevent.load();
            Scene scene1 = new Scene(root);
           Stage statStage = new Stage();
            
            statStage.setTitle("Hello World!");
            statStage.setScene(scene1);
            statStage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }
        
     }
             
             
             
             
             
             
          private void modifierButtonAction1 (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierSponsor.fxml"));
            Parent root = modif.load();
            ModifierSponsorController mcc = modif.getController();
            for (int i = 0; i < lt.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lt.get(index).getId_sponsors();
            String s=String.valueOf(index1);
            System.out.println(s);
            mcc.setTextID(s);
            mcc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                SponsorsCrud tt = new SponsorsCrud();
                List<sponsors> lt = tt.afficher();
             tableSponsor.getItems().clear();
          afficher_sponsor(lt);
//          ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lm);
//        nbt.setText(String.valueOf(nbt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(SponsorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
          
          
          
          
        private void modifierButtonAction2(ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierEvent.fxml"));
            Parent root = modif.load();
            ModifierEventController mcc = modif.getController();
            for (int i = 0; i < lm.size(); i++) {
            if (event.getSource() == modify_button1[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lm.get(index).getId_evenement();
            String s=String.valueOf(index1);
            System.out.println(s);
            mcc.setTextID(s);
            mcc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                EventCrud tt = new EventCrud();
                lm = tt.afficher();
             tableEvent.getItems().clear();
          afficher_Event(lm);
//          ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lm);
//        nbt.setText(String.valueOf(nbt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(SponsorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
                    
                    
                    
                    
                    
        
         private void handleButtonAction (ActionEvent event)
    {
       
         for (int i = 0; i < lt.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb[i])
             {
                 index=i;
             }
            
                 
         }
          System.out.println(index);
          int index1 = lt.get(index).getId_sponsors();
            SponsorsCrud tt = new SponsorsCrud();
            
             tt.supprimer(index1);
             lt = tt.afficher();
             tableSponsor.getItems().clear();
             afficher_sponsor(lt);
//          Sponsor ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
         
         
            private void handleButtonAction1 (ActionEvent event)
    {
       
         for (int i = 0; i < lm.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb1[i])
             {
                 index=i;
             }
            
                 
         }
          System.out.println(index);
          int index1 = lm.get(index).getId_evenement();
            EventCrud tt = new EventCrud();
            
             tt.supprimer(index1);
             lm = tt.afficher();
             tableEvent.getItems().clear();
          afficher_Event(lm);
//          Sponsor ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
             MediaPlayer mediaPlayer;
           String s ="C:/Users/oussa/Documents/cours/oussama pidev/oussama pidev/PIDEV/valorant-theme-song-halftrue-remix.mp3";
		Media h = new Media(Paths.get(s).toUri().toString());
                
      @FXML
    void sound(ActionEvent event) {
        pause++;
           music(mediaPlayer,pause);
    }
            
            @FXML
            private ImageView soundd;
            
            
            
             
             
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaPlayer = new MediaPlayer(h);
        
        Image soundon = new Image(getClass().getResourceAsStream("../images/soundon.png"));
        
         soundd.setImage(soundon);
        
         final FileChooser fileChooser = new FileChooser();
         buttonima.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ima.clear();
              Stage a =(Stage) buttonima.getScene().getWindow();
                File file = fileChooser.showOpenDialog(a);
                if (file != null) {
                    openFile(file);
                    List<File> files = Arrays.asList(file);
                    printLog(ima, files);
                }
            }
        });
         
        
                for (int i = 0; i < lt.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
            lt.get(i).setModifier(modify_button[i]);
             lt.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction);
            modify_button[i].setOnAction(this::modifierButtonAction1);
        }
                
                for (int i = 0; i < lm.size(); i++) {
            ImageView modify1 = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button1[i] = new Button("", modify1);
    ImageView supprimer1 = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb1[i] = new Button("", supprimer1);
            lm.get(i).setModifier(modify_button1[i]);
            lm.get(i).setSupprimer(supprimerb1[i]);
            supprimerb1[i].setOnAction(this::handleButtonAction1);
            modify_button1[i].setOnAction(this::modifierButtonAction2);
    
            
                }
                 ObservableList<sponsors> datalist = FXCollections.observableArrayList(lt);
        
          NOM.setCellValueFactory(new PropertyValueFactory<>("nom"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<>("email"));
        NUM_CONTACT.setCellValueFactory(new PropertyValueFactory<>("num_contact"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_sponsors"));

        tableSponsor.setItems(datalist);
        
        
        ObservableList<Evenement> datalist1 = FXCollections.observableArrayList(lm);
        
        ID1.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        NomE.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nbmaxPart.setCellValueFactory(new PropertyValueFactory<>("nbmax_participant"));
        DATEEM.setCellValueFactory(new PropertyValueFactory<>("date_evenement"));
        idspoE.setCellValueFactory(new PropertyValueFactory<>("id_sponsor"));
        descE.setCellValueFactory(new PropertyValueFactory<>("description"));
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("image"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        

        tableEvent.setItems(datalist1);
        nbt.setText(String.valueOf(lt.size()));
          nbt1.setText(String.valueOf(lm.size()));
    }    

    @FXML
    private void reloadd(ActionEvent event) {
    }

    @FXML
    private void select(ActionEvent event) {
    }

    @FXML
    private void ajouterSponsors(ActionEvent event) {
        if ((getNom.getText().equals(""))||(getEmail.getText().equals(""))||(getNum.getText().equals(""))||(getTypes.getText().equals("")))
       {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Il faut taper le nom !");
       }
       
       else if(!( Pattern.matches("[a-z,A-Z, ]*",getNom.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("NOM  doit etre de type String !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
        else if(!( Pattern.matches("[0-9]*",getNum.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("numero doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else if(!( Pattern.matches("[a-z,A-Z,@]*",getEmail.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Email de la forme xx@domain.domain !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else if(!( Pattern.matches("[a-z,A-Z, ]*",getTypes.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("type doit etre de type String !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else {
        
        
        SponsorsCrud sp= new SponsorsCrud();
        String nomajout = getNom.getText();
        int num_contact = Integer.parseInt(getNum.getText());
        String Email = getEmail.getText();
        String type = getTypes.getText();
       
        
          sponsors p = new sponsors(nomajout, Email, num_contact, type);
        
            sp.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("sponsors ajouté!");
            alert.show();
            getNom.setText("");
            getTypes.setText("");
            getEmail.setText("");
            getNum.setText("");
           
           
            SponsorsCrud tt = new SponsorsCrud();
             lt = tt.afficher();
             tableSponsor.getItems().clear();
            afficher_sponsor(lt);

         }
    }

    
   @FXML 
    private void ajouterEvent(ActionEvent event) throws Exception {
        
        if ((getNomE.getText().equals(""))||(getId_sponsors.getText().equals(""))||(getNb_maxParticipant.getText().equals(""))||(getDescription.getText().equals("")))
       {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Il faut taper le nom !");
       }
       
       else if(!( Pattern.matches("[a-z,A-Z, ]*",getNomE.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("NOM  doit etre de type String !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
        else if(!( Pattern.matches("[0-9]*",getId_sponsors.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Id sponsor doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else if(!( Pattern.matches("[0-9]*",getNb_maxParticipant.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Nb max doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else if(!( Pattern.matches("[a-z,A-Z, ]*",getDescription.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Description doit etre de type String !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else {
         ZoneId defaultZoneId = ZoneId.systemDefault();
        EventCrud sp= new EventCrud();
        String nomajout = getNomE.getText();
        int nbmax_participants = Integer.parseInt(getNb_maxParticipant.getText());
        Date dateajout = Date.from(getDate.getValue().atStartOfDay(defaultZoneId).toInstant());
        int Ajoutsponsors = Integer.parseInt(getId_sponsors.getText());
        String Ajoutdescription = getDescription.getText();
        String img = ima.getText();
       
        sp.sendMail("oussamajalleli208@gmail.com");
          Evenement p = new Evenement(nbmax_participants,dateajout,nomajout, Ajoutsponsors, Ajoutdescription,img);
        
            sp.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("evenement ajouté!");
            alert.show();
            getNomE.setText("");
            getNb_maxParticipant.setText("");
            getId_sponsors.setText("");
            getDescription.setText("");
            
           
           
            EventCrud tt = new EventCrud();
            lm = tt.afficher();
             tableSponsor.getItems().clear();
            afficher_Event(lm);

         }
    }
    

      @FXML
    void reloadd1(ActionEvent event) {
           
    }
    

    
    
    
     public void afficher_sponsor(List<sponsors> ltt)
    {
        for (int i = 0; i < ltt.size(); i++) {
           
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")) {});
         supprimerb[i] = new Button("", supprimer);
            ltt.get(i).setModifier(modify_button[i]);
             ltt.get(i).setSupprimer(supprimerb[i]);
               supprimerb[i].setOnAction(this::handleButtonAction);
          modify_button[i].setOnAction(this::modifierButtonAction1);
        }
       ObservableList<sponsors> datalist = FXCollections.observableArrayList(ltt);
        
          NOM.setCellValueFactory(new PropertyValueFactory<>("nom"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<>("email"));
        NUM_CONTACT.setCellValueFactory(new PropertyValueFactory<>("num_contact"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_sponsors"));

        tableSponsor.setItems(datalist); 
        nbt.setText(String.valueOf(lt.size()));
    }
     
     
     
     public void afficher_Event(List<Evenement> ltt)
    {
        for (int i = 0; i < ltt.size(); i++) {
           
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button1[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")) {});
         supprimerb1[i] = new Button("", supprimer);
            ltt.get(i).setModifier(modify_button1[i]);
             ltt.get(i).setSupprimer(supprimerb1[i]);
               supprimerb1[i].setOnAction(this::handleButtonAction1);
          modify_button1[i].setOnAction(this::modifierButtonAction2);
        }
        ObservableList<Evenement> datalist1 = FXCollections.observableArrayList(ltt);
        
        ID1.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        NomE.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nbmaxPart.setCellValueFactory(new PropertyValueFactory<>("nbmax_participant"));
        DATEEM.setCellValueFactory(new PropertyValueFactory<>("date_evenement"));
        idspoE.setCellValueFactory(new PropertyValueFactory<>("id_sponsor"));
        descE.setCellValueFactory(new PropertyValueFactory<>("description"));
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("image"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        

        tableEvent.setItems(datalist1);
          nbt1.setText(String.valueOf(lm.size()));
    }
     
     
     private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }}
    
	public void music(MediaPlayer mediaPlayer,int pause) {
            
            if (pause%2==0)
            {Image soundon = new Image(getClass().getResourceAsStream("../images/soundon.png"));
        
         soundd.setImage(soundon);
                mediaPlayer.play();}
            else if (pause%2==1)
            { Image soundoff = new Image(getClass().getResourceAsStream("../images/soundoff.png"));
        
         soundd.setImage(soundoff);
                mediaPlayer.pause();  }
		
	}
         @FXML
    private void exportPDF(ActionEvent event) throws ClassNotFoundException, ClassNotFoundException, SQLException, IOException, URISyntaxException, DocumentException {
         Connection cnxx;
        try {
                 cnxx = MYDB.getInstance().getConnection();
                 PreparedStatement pt = cnxx.prepareStatement("select * from sponsor");
                 ResultSet rs = pt.executeQuery();
            
                       /* Step-2: Initialize PDF documents - logical objects */

                       Document my_pdf_report = new Document(){};
                       
                       PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                       
                              my_pdf_report.open();  
//                             my_pdf_report.add(new Paragraph(new Date().toString()));
//                            Image img = Image.getInstance("c:/6.png");
//                            my_pdf_report.add(img);
                             my_pdf_report.add(new Paragraph("                                                                     sponsor"));
                             my_pdf_report.addCreationDate();
              
                       
                       //we have four columns in our table
                       PdfPTable my_report_table = new PdfPTable(4);
                             
                       //create a cell object
                       PdfPCell table_cell;
                       
                       
                                       table_cell=new PdfPCell(new Phrase(" nom"));
                                      table_cell.setBackgroundColor(BaseColor.WHITE);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("email"));
                                       table_cell.setBackgroundColor(BaseColor.WHITE);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("num_contact"));
                                       table_cell.setBackgroundColor(BaseColor.WHITE);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("type"));
                                       table_cell.setBackgroundColor(BaseColor.WHITE);
                                       my_report_table.addCell(table_cell);
                                       
                                       

                                      while(rs.next()){
                                      
                                       String nom= rs.getString("nom");
                                       table_cell=new PdfPCell(new Phrase(nom));
                                       my_report_table.addCell(table_cell);
                                       String email=rs.getString("email");
                                       table_cell=new PdfPCell(new Phrase(email));
                                       my_report_table.addCell(table_cell);
                                       String num_contact=String.valueOf(rs.getString("num_contact"));
                                       table_cell=new PdfPCell(new Phrase(num_contact));
                                       my_report_table.addCell(table_cell);
                                       String type= rs.getString("type");
                                       table_cell=new PdfPCell(new Phrase(type));
                                       my_report_table.addCell(table_cell);
                                       
                                       
                                        
                       }
                       /* Attach report table to PDF */
                       
                       my_pdf_report.add(my_report_table); 
                       
                       System.out.println(my_pdf_report);
                       my_pdf_report.close();
                       JOptionPane.showMessageDialog(null, "impression effectuée");

                       /* Close all DB related objects */
                       rs.close();
                       pt.close(); 
                       cnxx.close();               


       } catch (FileNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
       }


    }
    
    
     
         @FXML
            private ImageView mapim;   
        
            
        @FXML
      private void mapopen(ActionEvent event) throws InterruptedException
    {
         System.out.println("1");
        
        Process p ;
    map();
        
     }
    
   public void map() {
        // Create a TileFactoryInfo for OSM
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        tileFactory.setThreadPoolSize(8);

        // Setup local file cache
        File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
        tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));

        // Setup JXMapViewer
        JXMapViewer mapViewer = new JXMapViewer();
        mapViewer.setTileFactory(tileFactory);

        GeoPosition local1 = new GeoPosition(36.36702378263096, 10.537600024580636);
        GeoPosition local2 = new GeoPosition(37.28810234852007, 9.872579697358955);
        GeoPosition local3     = new GeoPosition(36.89941166959323, 10.189593871798582);
        GeoPosition local4 = new GeoPosition(52.652663251555616, 12.984945514235399);
        GeoPosition local5 = new GeoPosition(48.86255390816682, 2.34050780653153);

        // Set the focus
        mapViewer.setZoom(10);
        mapViewer.setAddressLocation(local1);

        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        // Create waypoints from the geo-positions
        Set<SwingWaypoint> waypoints = new HashSet<SwingWaypoint>(Arrays.asList(
                new SwingWaypoint("Retrouvez nous Dans cet evenement le 17/03/2022", local1),
                new SwingWaypoint("Retrouvez nous Dans cet evenement le 30/03/2022", local2),
                new SwingWaypoint("Retrouvez nous Dans cet evenement le 04/04/2022", local3),
                new SwingWaypoint("Retrouvez nous Dans cet evenement le 20/04/2022", local4),
                new SwingWaypoint("Retrouvez nous Dans cet evenement le 30/04/2022", local5)));

        // Set the overlay painter
        WaypointPainter<SwingWaypoint> swingWaypointPainter = new SwingWaypointOverlayPainter();
        swingWaypointPainter.setWaypoints(waypoints);
        mapViewer.setOverlayPainter(swingWaypointPainter);

        // Add the JButtons to the map viewer
        for (SwingWaypoint w : waypoints) {
            mapViewer.add(w.getButton());
        }

        // Display the viewer in a JFrame
        JFrame frame = new JFrame("Events Map");
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


