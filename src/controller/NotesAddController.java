package controller;

import java.sql.Date;
import java.sql.SQLException;

import DAO.NotesDAO;
import DAO.PersonnelDAO;
import DAO.RoleDAO;
import DAO.ServiceDAO;
import DAO.StatutDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Notes;
import metier.Personnel;
import metier.Role;
import metier.Service;
import metier.Statut;

public class NotesAddController {
	@FXML
	private Button AddNotes;
	@FXML
	private Button AnnulAddNotes;
	@FXML
	private TextArea Note;
	@FXML
	private ComboBox<String> NomAdmin;
	@FXML
	private GridPane NotesAddVue;
	Notes notes;

	private Stage dialogStage;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
		ObservableList<String> ol;
		try {
			ol = PersonnelDAO.GetListeNomAdmin();
			NomAdmin.setItems(ol);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void AddOk() {
		if (isInputValid()) {
			try {
				notes = new Notes();
				notes.setTxt_not(Note.getText());
				notes.setPersonnel(PersonnelDAO.GetPersbyNom(NomAdmin.getValue()));
				System.out.println(notes);
				NotesDAO.insertNotes(notes);
			} catch (ClassNotFoundException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
			// apres tu refresh ta tableView

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

	        if (Note.getText() == null || Note.getText().length() == 0) {
	            errorMessage += "Aucune note n'as été écrite ! Note non valide !\n";
	        }
	        if (NomAdmin.getValue() == null || NomAdmin.getValue().length() == 0) {
	            errorMessage += "Merci de séléctionner un nom d'administrateur pour cette note !\n";
	        }
	             

	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message.
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(dialogStage);
	            alert.setTitle("Champs non valides");
	            alert.setHeaderText("Veuillez corriger les champs non valides");
	            alert.setContentText(errorMessage);

	            alert.showAndWait();

	            return false;
	        }

	}
}
