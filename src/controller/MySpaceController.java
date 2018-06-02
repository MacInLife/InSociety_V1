package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class MySpaceController {

	@FXML
	 private void github (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://github.com"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	@FXML
	 private void ocs (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://www.ocsinventory-ng.org/fr/"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	@FXML
	 private void oneNote (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://www.onenote.com"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	@FXML
	 private void outlook (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://outlook.com"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	 @FXML
	 private void glpi (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("http://glpi-project.org"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @FXML
	 private void centreon (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://www.centreon.com"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @FXML
	 private void bdd (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("http://localhost/phpmyadmin/"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @FXML
	 private void mediawiki (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://www.mediawiki.org"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @FXML
	 private void intranet (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("http://127.0.0.1:8024/connexion"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @FXML
	 private void MIB (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://www.mailinblack.com"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @FXML
	 private void horoquartz (ActionEvent evt) {
		 try {
			Desktop.getDesktop().browse(new URI("https://www.horoquartz.fr"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}