package controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.PersonnelDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vue.VueFXMain;

public class VuePageConnexionController {

		@FXML
		private Button co ;
		@FXML 
		private Pane  mainPane ;
		@FXML 
		private Pane  header ;
	
		@FXML
		private TextField login ;
		@FXML
		private PasswordField mdp ;
		@FXML
		private Label msg;
		 
		private Stage dialogStage;
	
		@FXML
		private void connexion (ActionEvent actionEvent) {
			 
			 try {
				 	int verifAcces = PersonnelDAO.adminVerif(login.getText(),  mdp.getText());
				 	
				 	switch(verifAcces) {
				 	case 0 :
				 		FXMLLoader loader = new FXMLLoader();
				 		loader.setLocation(VueFXMain.class.getClassLoader().getResource("VueFrame/MenuFixe.fxml"));
				 		header = (Pane) loader.load();
		           
				 		//Chargement partie Accueil
				 		FXMLLoader acc = new FXMLLoader();
				 		acc.setLocation(VueFXMain.class.getClassLoader().getResource("VueFrame/Accueil.fxml"));
				 		Pane accueil = (Pane) acc.load();
				 		Stage stage =  (Stage) mainPane.getScene().getWindow();
				 		// Set person overview into the center of root layout.
				 		header.getChildren().add(accueil);
				 		accueil.setLayoutX(5);
				 		accueil.setLayoutY(143);
				 		Scene scene = mainPane.getScene();
		              
				 		scene.setRoot(header);
		                stage.setScene(scene);
		                break;
				 	/*case 1: 
				 		Alert alert = new Alert(AlertType.ERROR);
			            alert.initOwner(dialogStage);
			            alert.setTitle("Erreur de Connexion");
			            alert.setHeaderText("Erreur d'identification");
			            alert.setContentText("Login ou mot de passe incorrect");
			            alert.showAndWait();
				 		
				 		break;
				 	case 2:
				 		//message => 
				 		Alert alert2 = new Alert(AlertType.ERROR);
				 		alert2.initOwner(dialogStage);
				 		alert2.setTitle("Erreur de Connexion");
				 		alert2.setHeaderText("Erreur de confidentialité");
				 		alert2.setContentText("Vous n'avez pas les droits d'acces..");
				 		alert2.showAndWait();
				 		break; 
				 	default:
				 		//message => .
				 		Alert alert3 = new Alert(AlertType.ERROR);
				 		alert3.initOwner(dialogStage);
				 		alert3.setTitle("Erreur de Connexion");
				 		alert3.setHeaderText("Erreur inconnu");
				 		alert3.setContentText("Une erreur est survenue.");
			            alert3.showAndWait();
				 		break;*/
				 	}
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (SQLException e) {
		        	e.printStackTrace();
				}
		    }
			 
			 
		 
}
