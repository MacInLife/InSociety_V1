package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import DAO.PersonnelDAO;
import DAO.ReservationDAO;
import DAO.Salle_ReunionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Personnel;
import metier.Reservation;
import metier.Salle_Reunion;

public class GResAddController {
	
		@FXML
		private GridPane ResAddView;;
			@FXML
			private TextField NbPerso;
			@FXML
			private DatePicker DateSRD;
			@FXML
			private DatePicker DateSRF;
			@FXML
			private ComboBox<String> NomSR;
			@FXML
			private ComboBox<String> Login;
			@FXML
			private Button AddRes;
			@FXML
			private Button AnnulAddRes;
		
			@FXML
			private ChoiceBox<String> HSRD;
			@FXML
			private ChoiceBox<String> MSRD;
			@FXML
			private ChoiceBox<String> HSRF;
			@FXML
			private ChoiceBox<String> MSRF;
			
			
			private Stage dialogStage;
		    private Reservation res;
		    private boolean okClicked = false;

		    @FXML
		    private void initialize() {
		    	ObservableList<String> olmin = FXCollections.observableArrayList();
		    	for(int i = 0; i<=60; i++) {
 		    		String min = "";
		    		if(i<10) min+="0";
		    		min+=i;
		    		olmin.add(min);
		    	}
		    	ObservableList<String> olheure = FXCollections.observableArrayList();
		    	for(int i = 0; i<=24; i++) {
		    		String heure = "";
		    		if(i<10) heure+="0";
		    		heure+=i;
		    		olheure.add(heure);
		    	}
		    	
		    	HSRD.setItems(olheure);
		    	HSRF.setItems(olheure);
		    	MSRD.setItems(olmin);
		    	MSRF.setItems(olmin);
		    	
		    	
		    	try {
					NomSR.setItems(Salle_ReunionDAO.getSalleRList());
					Login.setItems(PersonnelDAO.getUserRList());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

		    /**
		     * Sets the stage of this dialog.
		     *
		     * @param dialogStage
		     */
		    public void setDialogStage(Stage dialogStage) {
		        this.dialogStage = dialogStage;
		    }

		  
		    public boolean isOkClicked() {
		        return okClicked;
		    }

		  
		    @FXML
		    private void AddOk() {
		        if (isInputValid()) {
		        	res = new Reservation();
		            //Creer objet NomSR
		        	Salle_Reunion salle = new Salle_Reunion();
		        	salle.setNomSR(NomSR.getValue());
		        	res.setSalle(salle);

		        	res.setNbPers(Integer.parseInt(NbPerso.getText()));
		        	
		        	Date date = Date.valueOf(DateSRD.getValue());
		        	Timestamp time = new Timestamp(date.getTime() + Integer.parseInt(HSRD.getValue())*3600*1000 + Integer.parseInt(MSRD.getValue())*60*1000);
		        	res.setDate_d(time);
		        	
		        	date = Date.valueOf(DateSRF.getValue());
		          	time = new Timestamp(date.getTime() + Integer.parseInt(HSRF.getValue())*3600*1000 + Integer.parseInt(MSRF.getValue())*60*1000);
		        	res.setDate_f(time);
		        	
		        	  //Creer objet Login
		        	Personnel pers = new Personnel();
		        	pers.setLogin(Login.getValue());
		        	res.setPersonnel(pers);
		          
		            try {
						ReservationDAO.ajoutRes(res);
					} catch (ClassNotFoundException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
		            
		            okClicked = true;
		            dialogStage.close();
		        }
		    }

		    /**
		     * Called when the user clicks cancel.
		     */
		    @FXML
		    private void AddCancel() {
		        dialogStage.close();
		    }

		    /**
		     * Validates the user input in the text fields.
		     *
		     * @return true if the input is valid
		     */
		    private boolean isInputValid() {
		        String errorMessage = "";

		        if (NomSR.getValue() == null || NomSR.getValue().length() == 0) {
		            errorMessage += "Nom de la salle non valide!\n";
		        }

		        if (NbPerso.getText() == null || NbPerso.getText().length() == 0) {
		            errorMessage += "Nombre de personne non valide!\n";
		        }
		        
		        //if DateSRD
		        //if DateSRF
		       

		        if (Login.getValue() == null || Login.getValue().length() == 0) {
		            errorMessage += "No valid statut!\n";
		        }

		        if (errorMessage.length() == 0) {
		            return true;
		        } else {
		            // Show the error message.
		            Alert alert = new Alert(AlertType.ERROR);
		            alert.initOwner(dialogStage);
		            alert.setTitle("Invalid Fields");
		            alert.setHeaderText("Please correct invalid fields");
		            alert.setContentText(errorMessage);

		            alert.showAndWait();

		            return false;
		        }
		    }
}


		    
		    



