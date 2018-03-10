package controller;

import DAO.Salle_ReunionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Evenements;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

public class GEvtEditController {
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
	private Button EditEvt;
	@FXML
	private Button AnnulEditEvt;

	private Stage dialogStage;
	private Evenements events;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
		ObservableList<String> olmin = FXCollections.observableArrayList();
		for (int i = 0; i <= 60; i++) {
			String min = "";
			if (i < 10)
				min += "0";
			min += i;
			olmin.add(min);
		}
		ObservableList<String> olheure = FXCollections.observableArrayList();
		for (int i = 0; i <= 24; i++) {
			String heure = "";
			if (i < 10)
				heure += "0";
			heure += i;
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

	/**
	 * Sets the person to be edited in the dialog.
	 *
	 * @param person
	 */
	public void setEvenements(Evenements events) {
		this.events = events;
		System.out.println(this.events);
		NomEvt.setText(this.events.getNomEvt());
		// DateEvtD
		String date = String.valueOf(this.events.getJour_d());
		LocalDate d = LocalDate.parse(date);
		DateEvtD.setValue(d);
		DateEvtD.setPromptText("dd.mm.yyyy");

		// DateEvtF
		String date0 = String.valueOf(this.events.getJour_d());
		LocalDate d0 = LocalDate.parse(date0);
		DateEvtF.setValue(d0);
		DateEvtF.setPromptText("dd.mm.yyyy");

		// Heure et Minutes
		int hsrd = this.events.getH_debut().getHours();
		String shsrd = "";
		if (hsrd < 10)
			shsrd += "0" + hsrd;
		else
			shsrd += hsrd;
		HSRD.setValue(shsrd);

		int hsrf = this.events.getH_fin().getHours();
		String shsrf = "";
		if (hsrf < 10)
			shsrf += "0" + hsrf;
		else
			shsrf += hsrf;
		HSRF.setValue(shsrf);

		int msrd = this.events.getH_debut().getMinutes();
		String smsrd = "";
		if (msrd < 10)
			smsrd += "0" + msrd;
		else
			smsrd += msrd;
		MSRD.setValue(smsrd);

		int msrf = this.events.getH_fin().getMinutes();
		String smsrf = "";
		if (msrf < 10)
			smsrf += "0" + msrf;
		else
			smsrf += msrf;
		MSRF.setValue(smsrf);
		TypeEvt.setText(this.events.getType());
		LieuEvt.setText(this.events.getLieu());

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
			events.setNomEvt(NomEvt.getText());
			events.setJour_d(Date.valueOf(DateEvtD.getValue()));
			events.setJour_f(Date.valueOf(DateEvtF.getValue()));
			// person.setDate_naissance(Date.valueOf(DatedeNaissance.getValue()));

			// events.setH_debut(HeureEvtD.getText());
			// //events.setH_fin(HeureEvtF.getText());
			Time time = new Time(Integer.parseInt(HSRD.getValue()), Integer.parseInt(MSRD.getValue()), 0);
			events.setH_debut(time);

			time = new Time(Integer.parseInt(HSRF.getValue()), Integer.parseInt(MSRF.getValue()), 0);

			events.setH_fin(time);

			events.setType(TypeEvt.getText());
			events.setLieu(LieuEvt.getText());
			try {
				events.setSalle(Salle_ReunionDAO.GetListeSalle().get(Salle_ReunionDAO.GetIdSR(SalleEvt.getValue())));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
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

		if (NomEvt.getText() == null || NomEvt.getText().length() == 0) {
			errorMessage += "Nom  non valide!\n";
		}
		if (DateEvtD.getValue() == null || DateEvtD.getPromptText().length() == 0) {
			errorMessage += "Date début non valide!\n";
		}
		if (DateEvtF.getValue() == null || DateEvtF.getPromptText().length() == 0) {
			errorMessage += "Date Fin non valide!\n";
		}
		if (HSRD.getValue() + MSRD.getValue() == null || HSRD.getValue().length() + MSRD.getValue().length() == 0) {
			errorMessage += "Heure et/ ou minute de début non valide ! \n";
		}
		if (HSRF.getValue() + MSRF.getValue() == null || HSRF.getValue().length() + MSRF.getValue().length() == 0) {
			errorMessage += "Heure de fin non valide ! \n";
		}

		if (TypeEvt.getText() == null || TypeEvt.getText().length() == 0) {
			errorMessage += "Type non valide!\n";
		}
		if (LieuEvt.getText() == null || LieuEvt.getText().length() == 0) {
			errorMessage += "Lieu non valide!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Champs non valide");
			alert.setHeaderText("Veuillez corriger les champs non valides");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

}
