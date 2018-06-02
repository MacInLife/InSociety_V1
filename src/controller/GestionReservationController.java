	package controller;

	import java.sql.SQLException;
	import java.sql.Timestamp;

import DAO.ReservationDAO;
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
import metier.Reservation;
	import vue.VueFXMain;

public class GestionReservationController {


		@FXML
		private Label allRes;
		@FXML
		private ImageView allResOeil;
		@FXML
		private ImageView refresh;
		@FXML
		private ImageView suppResViewImg;
		@FXML
		private ImageView editResViewImg;
		@FXML
		private ImageView addResViewImg;
		@FXML
		private TableView<Reservation> tabRes;
		@FXML
		private Button supResView;
		@FXML
		private TableColumn<Reservation, Integer> id_res;
		// faire sa pour toute les colonnes du tableau Reservation
		@FXML
		private TableColumn<Reservation, String> NomSR;
		@FXML
		private TableColumn<Reservation, Timestamp> DateD;
		@FXML
		private TableColumn<Reservation, Timestamp> DateF;
		@FXML
		private TableColumn<Reservation, Integer> NbPers;
		@FXML
		private TableColumn<Reservation, String> Login;
		Reservation res;

		@FXML
		private void initialize() {
			// idSR.setCellValueFactory(cellData ->
			// cellData.getValue().getIdSRPro().asObject());
			NomSR.setCellValueFactory(cellData -> cellData.getValue().getSallel().getNomSRPro());
			DateD.setCellValueFactory(cellData -> cellData.getValue().getDate_dPro());
			DateF.setCellValueFactory(cellData -> cellData.getValue().getDate_fPro());
			NbPers.setCellValueFactory(cellData -> cellData.getValue().getNbPersPro().asObject());
			Login.setCellValueFactory(cellData -> cellData.getValue().getPersonnel().getLoginPro());
			tabRes.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					// TODO Auto-generated method stub

					res = tabRes.getSelectionModel().getSelectedItem();
				}
			});
		}

		// Afficher tout
		@FXML
		public void VueAllRes(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
			try {
				ObservableList<Reservation> empData = ReservationDAO.GetListeRes();
				System.out.println(empData);
				tabRes.setItems(empData);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
		}

		// Called when the user clicks the new button. Opens a dialog to edit details
		// for a new person.

		// Ajouter Salle Label
		@FXML
		private void addRes() {

			boolean okClicked = VueFXMain.VueGResAdd();
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
		private void editRes() {
			

			if (res != null) {
				boolean okClicked = VueFXMain.VueGResEdit(res);
				if (okClicked) {
					// showPersonDetails(user);

					// tu fais appel à ta methode modifierPersonnel dans la classe PersonnelDAO
					try {
						ReservationDAO.ModifRes(res);
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
		private void suppRes() {
			Reservation selectedIndex = tabRes.getSelectionModel().getSelectedItem();
			if (selectedIndex != null) {
				tabRes.getItems().remove(selectedIndex);
				// appel a la fonction du PersonnelDAO SuppPers
				try {
					ReservationDAO.SuppRes(selectedIndex);
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
