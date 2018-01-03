package controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Evenements;

public class GEvtEditController {
	@FXML
	private GridPane EvtAddView;
		@FXML
		private TextField NomEvt;
		@FXML
		private DatePicker DateEvtD;
		@FXML
		private DatePicker DateEvtF;
		
		@FXML
		private DatePicker HeureEvtD;
		@FXML
		private DatePicker HeureEvtF;
		@FXML
		private TextField TypeEvt;
		@FXML
		private TextField LieuEvt;
		@FXML
		private Button AddEvt;
		@FXML
		private Button AnnulAddEvt;
		
		private Stage dialogStage;
	    private Evenements events;
	    private boolean okClicked = false;
	  
	    
	    @FXML
	    private void initialize() {
	    
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
	    public void setEvenements (Evenements events) {
	    	
	        this.events = events;
	        
	        System.out.println(this.events);
	        NomEvt.setText(this.events.getNomEvt());
	        //DateEvtD
	       /* String date =String.valueOf(this.person.getDate_naissance());
	        LocalDate d = LocalDate.parse(date);
	        DatedeNaissance.setValue(d);	        
	        DatedeNaissance.setPromptText("dd,mm,yyyy");*/
	        
	        String date = String.valueOf(this.events.getJour_d());
	        LocalDate d = LocalDate.parse(date);
	        DateEvtD.setValue(d);
	        DateEvtD.setPromptText("dd.mm.yyyy");
	        
	        
	        //DateEvtF
	        String date0 = String.valueOf(this.events.getJour_d());
	        LocalDate d0 = LocalDate.parse(date0);
	        DateEvtF.setValue(d0);
	        DateEvtF.setPromptText("dd.mm.yyyy");
	        
	        //HeureEvtD
	        String date1 = String.valueOf(this.events.getH_debut());
	        LocalDate d1 = LocalDate.parse(date1);
	        HeureEvtD.setValue(d1);
	        HeureEvtD.setPromptText("hh.mm");
	        
	        //HeureEvtF
	        String date2 = String.valueOf(this.events.getH_fin());
	        LocalDate d2 = LocalDate.parse(date2);
	        HeureEvtF.setValue(d2);
	        HeureEvtF.setPromptText("hh.mm");
	        
	        TypeEvt.setText(this.events.getType());
	   
	      		  
	        //birthdayField.setText(DateUtil.format(person.getBirthday()));
	       // birthdayField.setPromptText("dd.mm.yyyy");
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
	        	events.setNomEvt(NomEvt.getText());
	        	//events.setJour_d(DateEvtD.getText());
	        	 DateEvtD.setOnAction(event -> {
	               	Date date = Date.valueOf(DateEvtD.getValue());
	                 events.setJour_d(Date.valueOf(DateEvtD.getValue()));
	                });
	        	//events.setJour_f(DateEvtF.getText());
	        	 DateEvtF.setOnAction(event -> {
		               	Date date = Date.valueOf(DateEvtF.getValue());
		                 events.setJour_f(Date.valueOf(DateEvtF.getValue()));
		                });
	        	//events.setH_debut(HeureEvtD.getText());
	        	 
	        	//events.setH_fin(HeureEvtF.getText());
	        	events.setType(TypeEvt.getText());
	        	events.setLieu(LieuEvt.getText());

	       
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

	        if (NomEvt.getText() == null || NomEvt.getText().length() == 0) {
	            errorMessage += "Nom  non valide!\n";
	        }
	        if (DateEvtD.getValue() == null || DateEvtD.getPromptText().length() == 0) {
	            errorMessage += "Date début non valide!\n";
	        }
	        if (DateEvtF.getValue() == null || DateEvtF.getPromptText().length() == 0) {
	            errorMessage += "Date Fin non valide!\n";
	        }
	        if(HeureEvtD.getValue() == null || HeureEvtD.getPromptText().length() ==0) {
	        	errorMessage += "Heure de début non valide ! \n";
	        }
	        if(HeureEvtF.getValue() == null || HeureEvtF.getPromptText().length() ==0) {
	        	errorMessage += "Heure de fin non valide ! \n";
	        }
	      
	        if (TypeEvt.getText() == null || TypeEvt.getText().length() == 0) {
	            errorMessage += "No valid type!\n";
	        }
	        if (LieuEvt.getText() == null || LieuEvt.getText().length() == 0) {
	            errorMessage += "No valid Lieu!\n";
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


	    
	    



