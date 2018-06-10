package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.RoleDAO;
import DAO.ServiceDAO;
import DAO.StatutDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Personnel;
import metier.Service;
import metier.Role;
import metier.Statut;

public class GUserEditController {

	@FXML
	private GridPane UserEditView;
	@FXML
	private TextField Login;
	@FXML
	private TextField mdp;
	@FXML
	private TextField Nom;
	@FXML
	private TextField Prenom;
	@FXML
	private DatePicker DatedeNaissance;
	@FXML
	private ComboBox<String> CServE;
	@FXML
	private ComboBox<String> CRoleE;
	@FXML
	private TextField Mail;
	@FXML
	private TextField Tel;
	@FXML
	private TextField Adresse;
	@FXML
	private TextField Localisation;
	@FXML
	private ComboBox<String> CStatutE;
	@FXML
	private Button SaveUser;
	@FXML
	private Button AnnulEditUser;

	private Stage dialogStage;
	private Personnel person;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
		try {
			ObservableList<String> ol = ServiceDAO.getServiceList();
			CServE.setItems(ol);
			ObservableList<String> ol1 = RoleDAO.getRoleNameList();
			CRoleE.setItems(ol1);
			ObservableList<String> ol2 = StatutDAO.getStatutList();
			CStatutE.setItems(ol2);
		} catch (Exception e) {
			// TODO mettre une erreur
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
	 * @throws SQLException
	 */
	public void loadPersonnel(Personnel person) throws SQLException {

		this.person = person;

		System.out.println(this.person);
		Login.setText(this.person.getLogin());
		mdp.setText(this.person.getMdp());
		Nom.setText(this.person.getNom());
		Prenom.setText(this.person.getPrenom());
		String date = String.valueOf(this.person.getDate_naissance());
		LocalDate d = LocalDate.parse(date);
		DatedeNaissance.setValue(d);

		DatedeNaissance.setPromptText("dd,mm,yyyy");
		CServE.setItems(ServiceDAO.getServiceList());
		CServE.setValue(this.person.getService().getType_service());
		CRoleE.setItems(RoleDAO.getRoleNameList());
		CRoleE.setValue(this.person.getRole().getNom_role());
		Mail.setText(this.person.getMail());
		Tel.setText(this.person.getTel());
		Adresse.setText(this.person.getAdresse());
		Localisation.setText(this.person.getLocalisation());
		CStatutE.setItems(StatutDAO.getStatutList());
		CStatutE.setValue(this.person.getStatut().getLibeller());

		// birthdayField.setText(DateUtil.format(person.getBirthday()));
		// birthdayField.setPromptText("dd.mm.yyyy");
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
			person.setLogin(Login.getText());
			person.setMdp(mdp.getText());
			person.setNom(Nom.getText());
			person.setPrenom(Prenom.getText());

			person.setDate_naissance(Date.valueOf(DatedeNaissance.getValue()));

			Service serv = new Service();
			serv.setType_service(CServE.getValue());
			person.setService(serv);

			Role role = new Role();
			role.setNom_role(CRoleE.getValue());
			person.setRole(role);

			person.setMail(Mail.getText());
			person.setTel(Tel.getText());
			person.setAdresse(Adresse.getText());
			person.setLocalisation(Localisation.getText());
			// Creer objet statut
			Statut statu = new Statut();
			statu.setLibeller(CStatutE.getValue());
			person.setStatut(statu);

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

		   if (Login.getText() == null || Login.getText().length() == 0) {
	            errorMessage += "Login invalide!\n";
	        }
	        if (mdp.getText() == null || mdp.getText().length() == 0) {
	            errorMessage += "Mot de passe invalide!\n";
	            /*} else {
	        	Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})(?=.*[0-9])");
	            Matcher m = p.matcher(Mail.getText());   // get a matcher object
	            if(!m.matches()) {
	            	errorMessage += "Le mot de passe n'est pas correct\n";
	            }*/
	        }
	        if (Nom.getText() == null || Nom.getText().length() == 0) {
	            errorMessage += "Nom invalide !\n";
	        }
	        if (Prenom.getText() == null ||Prenom.getText().length() == 0) {
	            errorMessage += "Prenom invalide!\n";
	        }

	       if ( DatedeNaissance.getValue() == null || DatedeNaissance.getPromptText().length() == 0) {
	            errorMessage += "Date de naissance invalide !\n";
	        }
	     
	        if (Mail.getText() == null || Mail.getText().length() == 0) {
	            errorMessage += "Mail invalide !\n";
	       /* } else {
	        	Pattern p = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
	        	///^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@([a-z0-9!#$%&'*+/=?^_`{|}~-]+(\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])$/
	            Matcher m = p.matcher(Mail.getText());   // get a matcher object
	            if(!m.matches()) {
	            	errorMessage += "Le mail n'est pas correct\n";
	            }*/
	        }
	        if (Tel.getText() == null || Tel.getText().length() == 0) {
	            errorMessage += "Numéro de Téléphone invalide !\n";
	            /*} else {
	        	Pattern p = Pattern.compile("[0-9].{10}");
	            Matcher m = p.matcher(Mail.getText());   // get a matcher object
	            if(!m.matches()) {
	            	errorMessage += "Le numéro entrée n'est pas correct\n";
	            }*/
	        }
	        if (Adresse.getText() == null || Adresse.getText().length() == 0) {
	            errorMessage += "Adresse invalide !\n";
	        }
	        if (Localisation.getText() == null || Localisation.getText().length() == 0) {
	            errorMessage += "Localisation incorrect !\n";
	        }
	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message.
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Champs non valides");
	            alert.setHeaderText("Veuillez corriger le champ non valide");
	            alert.setContentText(errorMessage);

	            alert.showAndWait();

	            return false;
		}
	}
}
