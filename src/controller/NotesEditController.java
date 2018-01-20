package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

import DAO.NotesDAO;
import DAO.PersonnelDAO;
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
import metier.Evenements;
import metier.Notes;

public class NotesEditController {
	@FXML
	private Button EditNotes;
	@FXML
	private Button AnnulEditNotes;
	@FXML
	private TextArea Note;
	@FXML
	private ComboBox<String> NomAdmin;
	@FXML
	private GridPane NotesEditVue;
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
	public void setNotes(Notes notes) {
		this.notes = notes;
		Note.setText(notes.getTxt_not());
		NomAdmin.setValue(notes.getPersonnel().getNom());

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
			try {
				notes.setTxt_not(Note.getText());
				notes.setPersonnel(PersonnelDAO.GetPersbyNom(NomAdmin.getValue()));
				System.out.println("test : " + notes);
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

		if (Note.getText() == null || Note.getText().length() == 0) {
			errorMessage += "Note  non valide!\n";
		}
			if (NomAdmin.getValue() == null || NomAdmin.getValue().length() == 0) {
			errorMessage += "Note  non valide!\n";
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
