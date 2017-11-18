package controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.PersonnelDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
		private void connexion (ActionEvent actionEvent) {
			 
			 try {
				 	boolean verifAcces = PersonnelDAO.adminVerif(login.getText(),  mdp.getText());
				 	
				 	if ( verifAcces) {
				 		// Load person overview.
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
				 		accueil.setLayoutX(37);
				 		accueil.setLayoutY(143);
				 		Scene scene = mainPane.getScene();
		              
				 		scene.setRoot(header);
		                stage.setScene(scene);
		            // Set person overview into the center of root layout.
				 	} else {
				 		/** TODO : add show message error **/
				 	}
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (SQLException e) {
		        	e.printStackTrace();
				} finally   {
					/** TODO : ajout un message d'erreur "Une erreur interne est survenue**/ 
				}
		    }
			 
			 
		 
}
