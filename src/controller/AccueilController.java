package controller;

import DAO.NotesDAO;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import metier.Notes;
import vue.VueFXMain;

import java.sql.SQLException;

public class AccueilController {

	@FXML
	private Pane AccueilView;
	@FXML
	private ImageView refresh;
	@FXML
	private ImageView addNotes;
	@FXML
	private ImageView EditNotes;
	@FXML
	private ImageView supN;

	@FXML
	private Label NomAdmin;
	@FXML
	private Label PrenomAdmin;
	@FXML
	private TableView<Notes> allNotes;
	// faire sa pour toute les colonnes du tableau salle
	@FXML
	private TableColumn<Notes, String> Notes;
	@FXML
	private TableColumn<Notes, String> Admin;
	Notes notes;

	@FXML
	private void initialize() throws ClassNotFoundException, SQLException {

		Notes.setCellValueFactory(cellData -> cellData.getValue().getTxt_notPro());
		Admin.setCellValueFactory(cellData -> cellData.getValue().getPersonnel().getNomPro());

		try {
			ObservableList<Notes> empData = NotesDAO.GetListeNotes();
			System.out.println(empData);
			allNotes.setItems(empData);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Bloc catch gï¿½nï¿½rï¿½ automatiquement
			e.printStackTrace();
		}
		
		allNotes.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub

				notes = allNotes.getSelectionModel().getSelectedItem();
			}
		});
	}

	// Ajouter Notes
	@FXML
	private void AddNotes() {
		VueFXMain.VueNotesAdd();
	}
	
	// Called when the user clicks the edit button. Opens a dialog to edit details
	// for the selected person.
	// Label Modifier Utilisateur
	@FXML
	private void editNote() {
		if (notes != null) {
			System.out.println(notes.toString());
			boolean okClicked = VueFXMain.VueNotesEdit(notes);
			if (okClicked) {
				// showPersonDetails(user);

				// tu fais appel ï¿½ ta methode modifierPersonnel dans la classe PersonnelDAO
				try {
					NotesDAO.ModifNotes(notes);
				} catch (ClassNotFoundException e) {
					// TODO Bloc catch gï¿½nï¿½rï¿½ automatiquement
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Bloc catch gï¿½nï¿½rï¿½ automatiquement
					e.printStackTrace();
				}
				// tu refresh tableView
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(VueFXMain.getPrimaryStage());
			alert.setTitle("Aucune Sélection");
			alert.setHeaderText("Aucune note n'est selectionnée");
			alert.setContentText("Merci de sélectionner une note ou une ligne dans le tableau !");

			alert.showAndWait();

		}

	}

	@FXML
	private void supN() {
		Notes selectedIndex = allNotes.getSelectionModel().getSelectedItem();
		if (selectedIndex != null) {
			allNotes.getItems().remove(selectedIndex);
			// appel a la fonction du NotesDAO SuppPers
			try {
				NotesDAO.SuppNotes(selectedIndex);
			} catch (ClassNotFoundException e) {
				// TODO Bloc catch gï¿½nï¿½rï¿½ automatiquement
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Bloc catch gï¿½nï¿½rï¿½ automatiquement
				e.printStackTrace();
			}
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(VueFXMain.getPrimaryStage());
			alert.setTitle("Aucune Selection");
			alert.setHeaderText("Aucune Note n'est sélectionnée");
			alert.setContentText("Merci de sélectionner une note ou une ligne dans le tableau !");

			alert.showAndWait();
		}
	}

	@FXML
	public void Refresh(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			ObservableList<Notes> empData = NotesDAO.GetListeNotes();
			System.out.println(empData);
			allNotes.setItems(empData);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Bloc catch gï¿½nï¿½rï¿½ automatiquement
			e.printStackTrace();
		}
	}
}
