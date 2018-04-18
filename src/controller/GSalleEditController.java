package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

import DAO.StatutDAO;
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
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Salle_Reunion;
import metier.Statut;

public class GSalleEditController {

	@FXML
	private GridPane SalleEditView;
		@FXML
		private TextField NomSR;
		@FXML
		private TextField NbPlaceSR;
		@FXML
		private TextField LieuSR;
		@FXML
		private ComboBox<String> statutSR;
		@FXML
		private Button editSalleView;
		@FXML
		private Button AnnulEditSalle;
		
		private Stage dialogStage;
	    private Salle_Reunion salles;
	    private boolean okClicked = false;
   

	    
	    @FXML
	    private void initialize() {
	  	try {
					statutSR.setItems(StatutDAO.getStatutList());
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
	    public void setSalle_Reunion(Salle_Reunion salles) {
	        this.salles = salles;
	        System.out.println(this.salles);
	        NomSR.setText(this.salles.getNomSR());
	        NbPlaceSR.setText("" + this.salles.getNbPlaceTotal());      	        
	        LieuSR.setText(this.salles.getLieu());
	        statutSR.setValue(this.salles.getStatut().getLibeller());
	      		  
	       
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
	        	salles.setNomSR(NomSR.getText());
	        	salles.setNbPlaceTotal(Integer.parseInt(NbPlaceSR.getText()));
	        	salles.setLieu(LieuSR.getText());
	            //Creer objet statut
	            Statut statu = new Statut();
	            statu.setLibeller(statutSR.getValue());
	            salles.setStatut(statu);
	          
	            
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

	      	        if (NomSR.getText() == null || NomSR.getText().length() == 0) {
	            errorMessage += "Nom de la salle non valide!\n";
	        }
	        if (NbPlaceSR.getText() == null || NbPlaceSR.getText().length() == 0) {
	            errorMessage += "Nombre de place Totale non valide!\n";
	        }
	
	       
	        if (LieuSR.getText() == null || LieuSR.getText().length() == 0) {
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


	    
	