/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.io.IOException;
import java.util.List;

import controller.GUserAddController;
import controller.GUserEditController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.Personnel;

/**
 *
 * @author STAPS
 */
public class VueFXMain extends Application {
   private static  Stage primaryStage;
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) {
		try {
			this.setPrimaryStage(primaryStage);
			 new BorderPane();
			
			FXMLLoader acc = new FXMLLoader() ;
			acc.setLocation( VueFXMain.class.getClassLoader().getResource("vueFrame/VuePageConnexion.fxml"));
			Pane rootL = (Pane)acc.load();
			Scene scene = new Scene(rootL,850,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.getPrimaryStage().setScene(scene);
			this.getPrimaryStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
     * Returns the main stage.
     * @return
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
	public static void main (String[] args) {
		launch(args);
	}
	
	/**
	 * Opens a dialog to edit details for the specified person. If the user
	 * clicks OK, the changes are saved into the provided person object and true
	 * is returned.
	 *
	 * @param tabUser the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public static boolean VueGUserAdd() {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/GUserAdd.fxml"));
	        Pane page = (Pane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Add Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);      
	        
	        // Set the person into the controller.
	        GUserAddController controller = loader.getController();
	//        controller.setPersonnel(person);
	        controller.setDialogStage(dialogStage);
	        

	     // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
 }
	    
	public static boolean VueGUserEdit(Personnel person) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(VueFXMain.class.getClassLoader().getResource("vueFrame/GUserEdit.fxml"));
	        Pane page = (Pane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	  
	    
	        System.out.println(person);
	        // Set the person into the controller.
	        GUserEditController controller = loader.getController();
	        controller.setPersonnel(person);
	        controller.setDialogStage(dialogStage);
	        
	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public static void setPrimaryStage(Stage primaryStage) {
		VueFXMain.primaryStage = primaryStage;
	}
	public static List<Personnel> getPersonData() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}
	
	
	
	
	
}
