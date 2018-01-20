package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import DAO.EvenementsDAO;
import DAO.Salle_ReunionDAO;
import DAO.StatutDAO;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import metier.Evenements;
import metier.Salle_Reunion;
import vue.VueFXMain;

public class GestionEvtController {
	@FXML
	private Label allEvent;
	@FXML
	private ImageView refresh;
	@FXML
	private ImageView oeil;
	@FXML
	private Label AddEvtVue;
	@FXML
	private Label EditEvtVue;
	@FXML
	private Label SuppEvtVue;
	@FXML
	private ImageView AddVue;
	@FXML
	private ImageView EditVue;
	@FXML
	private ImageView SuppVue;
	@FXML
	private TableView<Evenements> tabEvent;
	@FXML
	private TableColumn<Evenements, Integer> idEvt;
	// faire sa pour toute les colonnes du tableau salle
	@FXML
	private TableColumn<Evenements, String> NomEvt;
	@FXML
	private TableColumn<Evenements, String> DescEvt;
	@FXML
	private TableColumn<Evenements, Date> DateEvtD;
	@FXML
	private TableColumn<Evenements, Date> DateEvtF;
	@FXML
	private TableColumn<Evenements, Time> H_debutEvt;
	@FXML
	private TableColumn<Evenements, Time> H_finEvt;
	@FXML
	private TableColumn<Evenements, String> LieuEvt;
	@FXML
	private TableColumn<Evenements, String> SalleEvtV;
	Evenements events;

	@FXML
	private void initialize() {

		NomEvt.setCellValueFactory(cellData -> cellData.getValue().getNomEvtPro());
		DescEvt.setCellValueFactory(cellData -> cellData.getValue().getTypePro());
		DateEvtD.setCellValueFactory(cellData -> cellData.getValue().getJour_dPro());
		DateEvtF.setCellValueFactory(cellData -> cellData.getValue().getJour_fPro());
		H_debutEvt.setCellValueFactory(cellData -> cellData.getValue().getH_debutPro());
		H_finEvt.setCellValueFactory(cellData -> cellData.getValue().getH_finPro());
		LieuEvt.setCellValueFactory(cellData -> cellData.getValue().getLieuPro());
		//SalleEvt.setCellValueFactory(cellData -> cellData.getValue().getSalle().getNomSRPro());

		tabEvent.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub

				events = tabEvent.getSelectionModel().getSelectedItem();
			}
		});
		
	}

	@FXML
	public void VueAllEvt(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		allEvent.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				try {
					ObservableList<Evenements> empData = EvenementsDAO.GetListeEvent();
					System.out.println(empData);
					tabEvent.setItems(empData);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
			}
		});
	}

	// Called when the user clicks the new button. Opens a dialog to edit details
	// for a new person.

	// Ajouter Events Label
	@FXML
	private void addEvt() {

		boolean okClicked = VueFXMain.VueGEvtAdd();
		if (okClicked) {
			// VueFXMain.getPersonData().add(user);
			// VueFXMain.getPersonData().add(user);

			// apres tu refresh ta tableView
		}
	}

	// Called when the user clicks the edit button. Opens a dialog to edit details
	// for the selected person.
	// Label Modifier evenements
	@FXML
	private void editEvt() {
		if (events != null) {
			System.out.println(events.toString());
			boolean okClicked = VueFXMain.VueGEvtEdit(events);
			if (okClicked) {
				// showPersonDetails(user);

				// tu fais appel à ta methode modifierPersonnel dans la classe PersonnelDAO
				try {
					EvenementsDAO.ModifEvent(events);
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
	// label supp evenements
	@FXML
	private void suppEvt() {
		Evenements selectedIndex = tabEvent.getSelectionModel().getSelectedItem();
		if (selectedIndex != null) {
			tabEvent.getItems().remove(selectedIndex);
			// appel a la fonction du PersonnelDAO SuppPers
			try {
				EvenementsDAO.SuppEvent(selectedIndex);
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
