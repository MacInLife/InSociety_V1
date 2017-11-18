package controller;

import java.sql.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
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
	private TextField DatedeNaissance;
	@FXML
	private TextField Service;
	@FXML
	private TextField Role;
	@FXML
	private TextField Mail;
	@FXML
	private TextField Tel;
	@FXML
	private TextField Adresse;
	@FXML
	private TextField Localisation;
	@FXML
	private TextField Statut;
	@FXML
	private Button AddUser;
	@FXML
	private Button AnnulAddUser;
	
	private Stage dialogStage;
    private Personnel person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
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
    /*public void setPersonnel(Personnel person) {
    	
        this.person = person;
        
        System.out.println(this.person);
        Login.setText(this.person.getLogin());
        mdp.setText(this.person.getMdp());
        Nom.setText(this.person.getNom());
        Prenom.setText(this.person.getPrenom());
        DatedeNaissance.setText(this.person.getDate_naissance().toString());
        DatedeNaissance.setPromptText("dd.mm.yyyy");
        Service.setText(this.person.getService().getType_service());
        Role.setText(this.person.getRole().getNom_role());
        Mail.setText(this.person.getMail());
        Tel.setText(this.person.getTel());
        Adresse.setText(this.person.getAdresse());
        Localisation.setText(this.person.getLocalisation());
        Statut.setText(this.person.getStatut().getLibeller());
      		  
        //birthdayField.setText(DateUtil.format(person.getBirthday()));
       // birthdayField.setPromptText("dd.mm.yyyy");
    }*/

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
    private void AddOk() {
        if (isInputValid()) {
            person.setLogin(Login.getText());
            person.setMdp(mdp.getText());
            person.setNom(Nom.getText());
            person.setPrenom(Prenom.getText());
           person.setDate_naissance(Date.valueOf(DatedeNaissance.getText()));
         
           Service serv = new Service();
			serv.setType_service(Service.getText());
			person.setService(serv);
			
			Role role = new Role();
			role.setNom_role(Role.getText());
			person.setRole(role);
            
            person.setMail(Mail.getText());
            person.setTel(Tel.getText());
            person.setAdresse(Adresse.getText());
            person.setLocalisation(Localisation.getText());
            //Creer objet statut
            Statut statu = new Statut();
            statu.setLibeller(Statut.getText());
            person.setStatut(statu);
          
            
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

       if (DatedeNaissance.getText() == null || DatedeNaissance.getText().length() == 0) {
            errorMessage += "No valid date!\n";
     
        }
        

        if (Service.getText() == null || Service.getText().length() == 0) {
            errorMessage += "No valid Service!\n";
        }
        if (Role.getText() == null || Role.getText().length() == 0) {
            errorMessage += "No valid Role!\n";
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
        if (Statut.getText() == null || Statut.getText().length() == 0) {
            errorMessage += "No valid statut!\n";
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


    
    

