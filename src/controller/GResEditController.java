package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import DAO.PersonnelDAO;
import DAO.Salle_ReunionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Personnel;
import metier.Reservation;
import metier.Salle_Reunion;

public class GResEditController {

	@FXML
	private GridPane ResEditView;
		@FXML
		private ComboBox<String> NomSR;
		@FXML
		private ComboBox<String> Login;
		@FXML
		private TextField NbPerso;
		@FXML
		private DatePicker DateSRD;
		@FXML
		private DatePicker DateSRF;
		@FXML
		private Button editResView;
		@FXML
		private Button AnnulEditRes;
		
		private Stage dialogStage;
	    private Reservation res;
	    private boolean okClicked = false;
   
		@FXML
		private ChoiceBox<String> HSRD;
		@FXML
		private ChoiceBox<String> MSRD;
		@FXML
		private ChoiceBox<String> HSRF;
		@FXML
		private ChoiceBox<String> MSRF;
		
		@FXML Spinner<String> SpinHSRF;
	    
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

	    /**
	     * Sets the person to be edited in the dialog.
	     *
	     * @param person
	     */
	    public void setReservation(Reservation res) {
	        this.res = res;
	        System.out.println(this.res);
	        NomSR.setValue(this.res.getSallel().getNomSR());
	        Login.setValue(this.res.getPersonnel().getLogin());
	        NbPerso.setText("" + this.res.getNbPers());
	        DateSRD.setValue(this.res.getDate_d().toLocalDateTime().toLocalDate());
	        DateSRF.setValue(this.res.getDate_f().toLocalDateTime().toLocalDate());
	        
	        @SuppressWarnings("deprecation")
			int hsrd = this.res.getDate_d().getHours();
	        String shsrd = "";
	        if(hsrd<10) 
	        	shsrd += "0" + hsrd;
	         else 
	        	shsrd += hsrd;
	        HSRD.setValue(shsrd);
	        
	        @SuppressWarnings("deprecation")
			int hsrf = this.res.getDate_f().getHours();
	        String shsrf = "";
	        if(hsrf<10) 
	        	shsrf += "0" + hsrf;
	         else 
	        	shsrf += hsrf;
	        HSRF.setValue(shsrf);
	        
	        @SuppressWarnings("deprecation")
			int msrd = this.res.getDate_d().getMinutes();
	        String smsrd = "";
	        if(msrd<10) 
	        	smsrd += "0" + msrd;
	         else 
	        	smsrd += msrd;
	        MSRD.setValue(smsrd);
	        
	        @SuppressWarnings("deprecation")
			int msrf = this.res.getDate_f().getMinutes();
	        String smsrf = "";
	        if(msrf<10) 
	        	smsrf += "0" + msrf;
	         else 
	        	smsrf += msrf;
	         MSRF.setValue(smsrf);

	      		  
	       
	    }
	    
	    

	    /**
	     * Returns true if the user clicked OK, false otherwise.
	     *
	     * @return
	     */
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	    /**
	     * Called when the user clicks ok.
	     */
	    @FXML
	    private void SaveEditOk() {
	        if (isInputValid()) {
	            //Creer objet nomSR
	        	Salle_Reunion salle = new Salle_Reunion();
	        	salle.setNomSR(NomSR.getValue());
	        	res.setSalle(salle);
	        	 //Creer objet Login
	        	Personnel pers = new Personnel();
	        	pers.setLogin(Login.getValue());
	        	res.setPersonnel(pers);
	        	
	        	res.setNbPers(Integer.parseInt(NbPerso.getText()));
	        	
	        	Date date = Date.valueOf(DateSRD.getValue());
	        	Timestamp time = new Timestamp(date.getTime() + Integer.parseInt(HSRD.getValue())*3600*1000 + Integer.parseInt(MSRD.getValue())*60*1000);
	        	res.setDate_d(time);
	        	
	        	date = Date.valueOf(DateSRF.getValue());
	          	time = new Timestamp(date.getTime() + Integer.parseInt(HSRF.getValue())*3600*1000 + Integer.parseInt(MSRF.getValue())*60*1000);
	        	res.setDate_f(time);
	
	            
	            okClicked = true;
	            dialogStage.close();
	        }
	    }

	    /**
	     * Called when the user clicks cancel.
	     */
	    @FXML
	    private void EditCancel() {
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


	    
	