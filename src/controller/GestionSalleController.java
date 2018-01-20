package controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import DAO.Salle_ReunionDAO;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import metier.Salle_Reunion;
import vue.VueFXMain;

public class GestionSalleController {
	@FXML
	private Label allSalle;
	@FXML
	private ImageView allSalleOeil;
	@FXML
	private ImageView refresh;
	@FXML
	private ImageView suppSalleViewImg;
	@FXML
	private ImageView editSalleViewImg;
	@FXML
	private ImageView addSalleViewImg;
	@FXML
	private TableView<Salle_Reunion> tabSalle;
	@FXML
	private Button supSalleView;
	@FXML
	private TableColumn<Salle_Reunion, Integer> idSR;
	// faire sa pour toute les colonnes du tableau salle
	@FXML
	private TableColumn<Salle_Reunion, String> NomSR;
	@FXML
	private TableColumn<Salle_Reunion, String> Statut;
	@FXML
	private TableColumn<Salle_Reunion, Timestamp> DateD;
	@FXML
	private TableColumn<Salle_Reunion, Timestamp> DateF;
	@FXML
	private TableColumn<Salle_Reunion, Integer> NbPlace;
	@FXML
	private TableColumn<Salle_Reunion, Integer> NbPers;
	@FXML
	private TableColumn<Salle_Reunion, String> LieuSR;
	Salle_Reunion salle;

	@FXML
	private void initialize() {
		// idSR.setCellValueFactory(cellData ->
		// cellData.getValue().getIdSRPro().asObject());
		NomSR.setCellValueFactory(cellData -> cellData.getValue().getNomSRPro());
		Statut.setCellValueFactory(cellData -> cellData.getValue().getStatut().getLibellerPro());
		DateD.setCellValueFactory(cellData -> cellData.getValue().getDate_dPro());
		DateF.setCellValueFactory(cellData -> cellData.getValue().getDate_fPro());
		NbPlace.setCellValueFactory(cellData -> cellData.getValue().getNbPlaceTotalPro().asObject());
		NbPers.setCellValueFactory(cellData -> cellData.getValue().getNbPersPro().asObject());
		LieuSR.setCellValueFactory(cellData -> cellData.getValue().getLieuPro());
		Statut.setCellValueFactory(cellData -> cellData.getValue().getStatut().getLibellerPro());
		tabSalle.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub

				salle = tabSalle.getSelectionModel().getSelectedItem();
			}
		});
	}

	// Afficher tout
	@FXML
	public void VueAllSalle(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			ObservableList<Salle_Reunion> empData = Salle_ReunionDAO.GetListeSalle();
			System.out.println(empData);
			tabSalle.setItems(empData);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}

	// Called when the user clicks the new button. Opens a dialog to edit details
	// for a new person.

	// Ajouter Salle Label
	@FXML
	private void addSalle() {

		boolean okClicked = VueFXMain.VueGSalleAdd();
		if (okClicked) {
			// VueFXMain.getPersonData().add(user);
			// VueFXMain.getPersonData().add(user);

			// apres tu refresh ta tableView
		}
	}

	// Called when the user clicks the edit button. Opens a dialog to edit details
	// for the selected person.
	// Label Modifier Utilisateur
	@FXML
	private void editSalle() {
		

		if (salle != null) {
			boolean okClicked = VueFXMain.VueGSalleEdit(salle);
			if (okClicked) {
				// showPersonDetails(user);

				// tu fais appel à ta methode modifierPersonnel dans la classe PersonnelDAO
				try {
					Salle_ReunionDAO.ModifSalleReu(salle);
				} catch (ClassNotFoundException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
				// tu refresh tableView
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(VueFXMain.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();

		}

	}

	// Called when the user clicks on the delete button.
	// label supp user
	@FXML
	private void suppSalle() {
		Salle_Reunion selectedIndex = tabSalle.getSelectionModel().getSelectedItem();
		if (selectedIndex != null) {
			tabSalle.getItems().remove(selectedIndex);
			// appel a la fonction du PersonnelDAO SuppPers
			try {
				Salle_ReunionDAO.SuppSalleReu(selectedIndex);
			} catch (ClassNotFoundException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(VueFXMain.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}
}
