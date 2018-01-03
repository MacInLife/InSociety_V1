package controller;

import java.sql.Date;
import java.sql.Time;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Evenements;
import metier.Salle_Reunion;
import metier.Statut;

public class GEvtAddController {
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

	  
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	  
	    @FXML
	    private void AddOk() {
	        if (isInputValid()) {
	        	events.setNomEvt(NomEvt.getText());
	        	/*DateEvtD.setOnAction(event -> {
	        		Date jour_d = jour_d.valueOf(DateEvtD.getValue());
	        		events.setJour_d(Date.valueOf(DateEvtD.getValue()));
	        	});
	        	DateEvtF.setOnAction(event -> {
	        		Date jour_f = jour_f.valueOf(DateEvtF.getValue());
	        		events.setJour_f(Date.valueOf(DateEvtF.getValue()));
	        	});
	        	/*HeureEvtD.setOnAction(event -> {
	        		Time h_debut = h_debut.valueOf(HeureEvtD.getValue());
	        		events.setH_debut(Time.valueOf(HeureEvtD.getValue()));
	        	});
	        	HeureEvtF.setOnAction(event -> {
	        		Time h_fin = h_fin.valueOf(HeureEvtF.getValue());
	        		events.setH_fin(Time.valueOf(HeureEvtF.getValue()));
	        	});*/
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
