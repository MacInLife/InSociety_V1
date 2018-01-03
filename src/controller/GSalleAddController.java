package controller;

import java.sql.Date;
import java.sql.Timestamp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Personnel;
import metier.Salle_Reunion;
import metier.Statut;

public class GSalleAddController {
	
		@FXML
		private GridPane SalleAddView;
			@FXML
			private TextField NomSR;
			@FXML
			private TextField NbPlaceSR;
			@FXML
			private TextField NbPerso;
			@FXML
			private DatePicker DateSRD;
			@FXML
			private DatePicker DateSRF;
			@FXML
			private TextField LieuSR;
			@FXML
			private TextField Statut;
			@FXML
			private Button AddSalle;
			@FXML
			private Button AnnulAddSalle;
			
			private Stage dialogStage;
		    private Salle_Reunion salles;
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
		        	salles.setNomSR(NomSR.getText());
		        	salles.setNbPlaceTotal(NbPlaceSR.getLength());
		        	salles.setNbPers(NbPerso.getLength());
		        	//DateSRD ?
		        	//DateSRF ?
		            salles.setLieu(LieuSR.getText());
		            //Creer objet statut
		            Statut statu = new Statut();
		            statu.setLibeller(Statut.getText());
		            salles.setStatut(statu);
		          
		            
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

		        if (NomSR.getText() == null || NomSR.getText().length() == 0) {
		            errorMessage += "Nom de la salle non valide!\n";
		        }
		        if (NbPlaceSR.getText() == null || NbPlaceSR.getText().length() == 0) {
		            errorMessage += "Nombre de place Totale non valide!\n";
		        }
		        if (NbPerso.getText() == null || NbPerso.getText().length() == 0) {
		            errorMessage += "Nombre de personne non valide!\n";
		        }
		        
		        //if DateSRD
		        //if DateSRF
		       
		        if (LieuSR.getText() == null || LieuSR.getText().length() == 0) {
		            errorMessage += "No valid Lieu!\n";
		        }
		        if (Statut.getText() == null || Statut.getText().length() == 0) {
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


		    
		    



