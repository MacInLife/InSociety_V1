package controller;

import java.sql.Date;
import java.sql.SQLException;

import DAO.PersonnelDAO;
import DAO.RoleDAO;
import DAO.ServiceDAO;
import DAO.StatutDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.Personnel;
import metier.Service;
import metier.Role;
import metier.Statut;

public class GUserAddController {
@FXML
private GridPane UserAddView;
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
	private ComboBox<String> CServ;
	@FXML
	private ComboBox<String> CRole;
	@FXML
	private TextField Mail;
	@FXML
	private TextField Tel;
	@FXML
	private TextField Adresse;
	@FXML
	private TextField Localisation;
	@FXML
	private ComboBox<String> CStatut;
	@FXML
	private Button AddUser;
	@FXML
	private Button AnnulAddUser;
	
	private Stage dialogStage;
    private Personnel person;
    private boolean okClicked = false;

    @FXML
	private void initialize()  {
    	try {
    		ObservableList<String> ol = ServiceDAO.getServiceList();
    		CServ.setItems(ol);
    		ObservableList<String> ol1 = RoleDAO.getRoleNameList();
    		CRole.setItems(ol1);
    		ObservableList<String> ol2 = StatutDAO.getStatutList();
    		CStatut.setItems(ol2);
    	} catch (Exception e) {
    		//TODO mettre une erreur 
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
        	person = new Personnel();
            person.setLogin(Login.getText());
            person.setMdp(mdp.getText());
            person.setNom(Nom.getText());
            person.setPrenom(Prenom.getText());
            person.setDate_naissance(Date.valueOf(DatedeNaissance.getValue()));
            Service serv = new Service();
			serv.setType_service(CServ.getValue());
			person.setService(serv);
			
			Role role = new Role();
			role.setNom_role(CRole.getValue());
			person.setRole(role);
            
            person.setMail(Mail.getText());
            person.setTel(Tel.getText());
            person.setAdresse(Adresse.getText());
            person.setLocalisation(Localisation.getText());
            //Creer objet statut
            Statut statu = new Statut();
            statu.setLibeller(CStatut.getValue());
            person.setStatut(statu);
          
            System.out.println(person);
            
            try {
				PersonnelDAO.insertPers(person);
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

        if (Login.getText() == null || Login.getText().length() == 0) {
            errorMessage += "No valid login!\n";
        }
        if (mdp.getText() == null || mdp.getText().length() == 0) {
            errorMessage += "No valid mot de passe!\n";
        }
        if (Nom.getText() == null || Nom.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (Prenom.getText() == null ||Prenom.getText().length() == 0) {
            errorMessage += "No valid prenom!\n";
        }

       if ( DatedeNaissance.getValue() == null || DatedeNaissance.getPromptText().length() == 0) {
            errorMessage += "No valid date!\n";
        }

        if (Mail.getText() == null || Mail.getText().length() == 0) {
            errorMessage += "No valid Mail!\n";
        }
        if (Tel.getText() == null || Tel.getText().length() == 0) {
            errorMessage += "No valid ctel!\n";
        }
        if (Adresse.getText() == null || Adresse.getText().length() == 0) {
            errorMessage += "No valid adresse!\n";
        }
        if (Localisation.getText() == null || Localisation.getText().length() == 0) {
            errorMessage += "No valid Localisation!\n";
        }
        if (CStatut.getValue() == null || CStatut.getValue().length() == 0) {
            errorMessage += "No valid city!\n";
        }
        if (CServ.getValue() == null || CServ.getValue().length() == 0) {
            errorMessage += "No valid city!\n";
        }
        if (CRole.getValue() == null || CRole.getValue().length() == 0) {
            errorMessage += "No valid city!\n";
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


    
    

