package controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.PersonnelDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import vue.VueFXMain;

public class MenuFixeController {
	@FXML
	private Pane GestionSalleView;
	@FXML
	private Pane GestionUserView;
	@FXML
	private Pane GestionDocsView;
	@FXML
	private Pane GestionEvtView;
	@FXML
	private Pane AccueilView;
	@FXML
	private Pane MySpaceView;
	@FXML
	private Pane mainPane;
	@FXML
	private Pane header;
	@FXML
	private Label Vaccueil;
	@FXML
	private Label Vspace;
	@FXML
	private Label Deco;

	//Accueil
	@FXML
	public void accueil (MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		Vaccueil.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	try 	{
	    			// Chargement partie Accueil
	    		FXMLLoader acc = new FXMLLoader();
	    		acc.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/Accueil.fxml"));
	    		Pane accueil = (Pane) acc.load();
	    		header.getChildren().removeAll();
	    		header.getChildren().add(accueil);
	    		accueil.setLayoutX(37);
	    		accueil.setLayoutY(143);
	    		
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	} finally {
	    		/** TODO : ajout un message d'erreur "Une erreur interne est survenue **/
	    	}
	        }
	    });
	}
	
// Partie GestionUser
	@FXML
	private void toto(ActionEvent actionEvent) {
		try {
			// Chargement partie GestionUser
			FXMLLoader acc = new FXMLLoader();
			acc.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/GestionUser.fxml"));
			Pane guser = (Pane) acc.load();
			header.getChildren().removeAll();
			header.getChildren().add(guser);
			guser.setLayoutX(37);
			guser.setLayoutY(143);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/** TODO : ajout un message d'erreur "Une erreur interne est survenue **/
		}
	}
	
	@FXML
	private void sal(ActionEvent actionEvent) {
		try 	{
			// Chargement partie GestionSalle
		FXMLLoader acc = new FXMLLoader();
		acc.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/GestionSalle.fxml"));
		Pane gsalle = (Pane) acc.load();
		header.getChildren().removeAll();
		header.getChildren().add(gsalle);
		gsalle.setLayoutX(37);
		gsalle.setLayoutY(143);
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		/** TODO : ajout un message d'erreur "Une erreur interne est survenue **/
	}
}
	
	@FXML
	private void docs(ActionEvent actionEvent) {
		try 	{
			// Chargement partie GestionDocs
		FXMLLoader acc = new FXMLLoader();
		acc.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/GestionDocs.fxml"));
		Pane gdoc = (Pane) acc.load();
		header.getChildren().removeAll();
		header.getChildren().add(gdoc);
		gdoc.setLayoutX(37);
		gdoc.setLayoutY(143);
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		/** TODO : ajout un message d'erreur "Une erreur interne est survenue **/
	}
}
	
	@FXML
	private void event(ActionEvent actionEvent) {
		try 	{
			// Chargement partie GestionEvt
		FXMLLoader acc = new FXMLLoader();
		acc.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/GestionEvt.fxml"));
		Pane gevent = (Pane) acc.load();
		header.getChildren().removeAll();
		header.getChildren().add(gevent);
		gevent.setLayoutX(37);
		gevent.setLayoutY(143);
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		/** TODO : ajout un message d'erreur "Une erreur interne est survenue **/
	}
}
	
	
	//MySpace
	@FXML
	public void space(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		Vspace.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	try 	{
	    			// Chargement partie MySpace
	    		FXMLLoader acc = new FXMLLoader();
	    		acc.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/MySpace.fxml"));
	    		Pane myspace = (Pane) acc.load();
	    		header.getChildren().removeAll();
	    		header.getChildren().add(myspace);
	    		myspace.setLayoutX(37);
	    		myspace.setLayoutY(143);
	    		
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	} finally {
	    		/** TODO : ajout un message d'erreur "Une erreur interne est survenue **/
	    	}
	        }
	    });
	}
	
	@FXML
	public void deco(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		Deco.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	try {
		            // Load person overview.
	        		FXMLLoader acc = new FXMLLoader();
		    		acc.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/VuePageConnexion.fxml"));
		    		Pane decos = (Pane) acc.load();
		    		header.getChildren().removeAll();
		    		header.getChildren().add(decos);
		    	
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	        }
	    });
	}
	
		 
		 
	    
}
