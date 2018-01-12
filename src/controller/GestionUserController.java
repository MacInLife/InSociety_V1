package controller;

import java.sql.Date;
import java.sql.SQLException;

import DAO.PersonnelDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import metier.Personnel;
import metier.Service;
import vue.VueFXMain;

public class GestionUserController {
	@FXML
	private Label alluser;
	@FXML
	private ImageView allUser;
	@FXML
	private Label editUserView;
	@FXML
	private Label addUserView;
	@FXML
	private Label suppUserView;
	@FXML
	private GridPane UserEditView;
	@FXML
	private GridPane UserAddView;
	
	@FXML
	private ImageView editUserView0;
	@FXML
	private ImageView addUserView0;
	@FXML
	private ImageView suppUserView0;
	@FXML
	private ImageView UserEditView0;
	@FXML
	private ImageView UserAddView0;
	
	@FXML
	private  TableView<Personnel> tabUser;
	@FXML
	private TableColumn<Personnel, Integer> id;
	//faire sa pour toute les colonnes du tableau USER
	@FXML
	private TableColumn<Personnel, String> Login;
	@FXML
	private TableColumn<Personnel, String> Nom;
	@FXML
	private TableColumn<Personnel, String> Prenom;
	@FXML
	private TableColumn<Personnel, Date> DateN;
	@FXML
	private TableColumn<Personnel, String> Service;
	@FXML
	private TableColumn<Personnel, String> Role;
	@FXML
	private TableColumn<Personnel, String> Mail;
	@FXML
	private TableColumn<Personnel, String> Tel;
	@FXML
	private TableColumn<Personnel, String> Adresse;
	@FXML
	private TableColumn<Personnel, String> Localisation;
	@FXML
	private TableColumn<Personnel, String> Statut;
	Personnel user;
	@FXML
	private TextField filtreUser;
	@FXML
	private ImageView actualise;
	 
	@FXML
	private void initialize() {
		Login.setCellValueFactory(cellData -> cellData.getValue().getLoginPro());
		Nom.setCellValueFactory(cellData -> cellData.getValue().getNomPro());
		Prenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomPro());
		DateN.setCellValueFactory(cellData -> cellData.getValue().getDate_naissancePro());
		Service.setCellValueFactory(cellData -> cellData.getValue().getService().getType_servicePro());
		Role.setCellValueFactory(cellData -> cellData.getValue().getRole().getNom_rolePro());
		Mail.setCellValueFactory(cellData -> cellData.getValue().getMailPro());
		Tel.setCellValueFactory(cellData -> cellData.getValue().getTelPro());
		Adresse.setCellValueFactory(cellData -> cellData.getValue().getAdressePro());
		Localisation.setCellValueFactory(cellData -> cellData.getValue().getLocalisationPro());
		Statut.setCellValueFactory(cellData -> cellData.getValue().getStatut().getLibellerPro());
		tabUser.setOnMouseClicked(new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			// TODO Auto-generated method stub
			
			 user =   tabUser.getSelectionModel().getSelectedItem()		;
		}
	});
	}

	
	//Label Afficher tout
	@FXML
public void afficher (MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		alluser.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {      	
	        		try {
						ObservableList<Personnel> empData =  PersonnelDAO.GetListePersonnel();
						tabUser.setItems(empData);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
	        }
	    });
	}
	
	
	//Actualiser
	@FXML
	public void refresh (MouseEvent actionEvent) {
		alluser.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle (MouseEvent event) {
				try {
					@SuppressWarnings("unused")
					ObservableList<Personnel> empData = PersonnelDAO.GetListePersonnel();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tabUser.refresh();
			}
		});
	}
	
	
	//imageView Oeil
	@FXML
public void Afficher (MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		allUser.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {      	
	        		try {
						ObservableList<Personnel> empData =  PersonnelDAO.GetListePersonnel();
						tabUser.setItems(empData);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
	        }
	    });
	}
	
	// Called when the user clicks the new button. Opens a dialog to edit details for a new person.
	//Ajouter Utilisateur Label
	@FXML
	private void addUser() {
	
		    boolean okClicked = VueFXMain.VueGUserAdd();
		    if (okClicked) {
		     //   VueFXMain.getPersonData().add(user);
		        // VueFXMain.getPersonData().add(user);
		    	
		    	//tu fais appel  à la methode insertPers dans la classe personnelDAO
		    }
		}
	
	//ImageView Ajout
	@FXML
	private void addUser0() {
	
		    boolean okClicked = VueFXMain.VueGUserAdd();
		    if (okClicked) {
		     //   VueFXMain.getPersonData().add(user);
		        // VueFXMain.getPersonData().add(user);
		    	
		    	//tu fais appel  à la methode insertPers dans la classe personnelDAO
		        try {
					PersonnelDAO.insertPers(user);;
				} catch (ClassNotFoundException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
		    	// apres tu refresh ta tableView
		    }
		}
	

	// Called when the user clicks the edit button. Opens a dialog to edit details for the selected person.
	//Label Modifier Utilisateur
	@FXML
	private void editUser() {
		System.out.println(user.toString());
		
	  	    if (user != null) {
	        boolean okClicked = VueFXMain.VueGUserEdit(user);
	        if (okClicked) {
	           // showPersonDetails(user);
	            
	            // tu fais appel à ta methode modifierPersonnel dans la classe PersonnelDAO
	        	try {
					PersonnelDAO.ModifPers(user);
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
	
	//ImageView Modifier Utilisateur
	@FXML
	private void editUser0() {
		System.out.println(user.toString());
		
	  	    if (user != null) {
	        boolean okClicked = VueFXMain.VueGUserEdit(user);
	        if (okClicked) {
	           // showPersonDetails(user);
	            
	            // tu fais appel à ta methode modifierPersonnel dans la classe PersonnelDAO
	        	try {
					PersonnelDAO.ModifPers(user);
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
	//label supp user
	@FXML
	private void suppUser() {
	Personnel selectedIndex = tabUser.getSelectionModel().getSelectedItem();
	    if (selectedIndex!=null) {
	        tabUser.getItems().remove(selectedIndex );
	        //appel a la fonction du PersonnelDAO SuppPers
	       try {
			PersonnelDAO.SuppPers(selectedIndex);
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
	//ImageView Supp User
	@FXML
	private void suppUser0() {
	Personnel selectedIndex = tabUser.getSelectionModel().getSelectedItem();
	    if (selectedIndex!=null) {
	        tabUser.getItems().remove(selectedIndex );
	        //appel a la fonction du PersonnelDAO SuppPers
	       try {
			PersonnelDAO.SuppPers(selectedIndex);
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
	
	//Permet de rechercher un personnel spécifiquement
	@FXML
	private void TriPers (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
		ObservableList<Personnel> empData = PersonnelDAO.GetListFiltrePers(filtreUser.getText());
		tabUser.setItems(empData);
	}
	
}
