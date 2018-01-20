package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import DAO.EvenementsDAO;
import DAO.Salle_ReunionDAO;
import DAO.StatutDAO;
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
		private ChoiceBox<String> HSRD;
		@FXML
		private ChoiceBox<String> MSRD;
		@FXML
		private ChoiceBox<String> HSRF;
		@FXML
		private ChoiceBox<String> MSRF;
		@FXML
		private TextField TypeEvt;
		@FXML
		private TextField LieuEvt;
		@FXML
		private ComboBox<String> SalleEvt;
		@FXML
		private Button AddEvt;
		@FXML
		private Button AnnulAddEvt;
		
		private Stage dialogStage;
	    private Evenements events;
	    private boolean okClicked = false;

	    @FXML
	    private void initialize() {
	    	ObservableList<String> olmin = FXCollections.observableArrayList();
	    	for(int i = 0; i<60; i++) {
		    		String min = "";
	    		if(i<10) min+="0";
	    		min+=i;
	    		olmin.add(min);
	    	}
	    	ObservableList<String> olheure = FXCollections.observableArrayList();
	    	for(int i = 0; i<24; i++) {
	    		String heure = "";
	    		if(i<10) heure+="0";
	    		heure+=i;
	    		olheure.add(heure);
	    	}
	    	
	    	HSRD.setItems(olheure);
	    	HSRF.setItems(olheure);
	    	MSRD.setItems(olmin);
	    	MSRF.setItems(olmin);
	    	
	    	Salle_ReunionDAO srdao = new Salle_ReunionDAO();
			ObservableList<String> li;
			try {
				li = srdao.getSalleRList();
				SalleEvt.setItems(li);
				
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
	        	events = new Evenements();
	        	events.setNomEvt(NomEvt.getText());
	        	events.setJour_d(Date.valueOf(DateEvtD.getValue()));
	        	events.setJour_f(Date.valueOf(DateEvtF.getValue()));
	        	
	        	Time time = new Time(Integer.parseInt(HSRD.getValue())*3600*1000 + Integer.parseInt(MSRD.getValue())*60*1000);
	        	events.setH_debut(time);
	        	
	        	time = new Time(Integer.parseInt(HSRF.getValue())*3600*1000 + Integer.parseInt(MSRF.getValue())*60*1000);
	        	events.setH_fin(time);
	        
	        	events.setType(TypeEvt.getText());
	        	events.setLieu(LieuEvt.getText());
	        	
	        	try {
					EvenementsDAO.ajoutEvent(events);
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

	        if (NomEvt.getText() == null || NomEvt.getText().length() == 0) {
	            errorMessage += "Nom  non valide!\n";
	        }
	        if (DateEvtD.getValue() == null || DateEvtD.getPromptText().length() == 0) {
	            errorMessage += "Date début non valide!\n";
	        }
	        if (DateEvtF.getValue() == null || DateEvtF.getPromptText().length() == 0) {
	            errorMessage += "Date Fin non valide!\n";
	        }
	        if(HSRD.getValue()+ MSRD.getValue() == null || HSRD.getValue().length() + MSRD.getValue().length() ==0) {
	        	errorMessage += "Heure et/ ou minute de début non valide ! \n";
	        }
	        if(HSRF.getValue()+ MSRF.getValue() == null || HSRF.getValue().length() + MSRF.getValue().length() ==0) {
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
