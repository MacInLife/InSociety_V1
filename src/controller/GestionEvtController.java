package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import DAO.EvenementsDAO;
import DAO.Salle_ReunionDAO;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import metier.Evenements;
import metier.Salle_Reunion;

public class GestionEvtController {
	@FXML
	private Label allEvent;
	@FXML
	private  TableView<Evenements> tabEvent;
	@FXML
	private TableColumn<Evenements, Integer> idEvt;
	//faire sa pour toute les colonnes du tableau salle
	@FXML
	private TableColumn<Evenements, String> NomEvt ;
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
	private TableColumn<Evenements, String> SalleEvt;
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
		SalleEvt.setCellValueFactory(cellData -> cellData.getValue().getSalle().getNomSRPro());
		
		
		tabEvent.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
				 events =   tabEvent.getSelectionModel().getSelectedItem();
			}
		});
	}
	
	@FXML
	public void VueAllEvt(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {
		allEvent.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {      	
	        		try {
						ObservableList<Evenements> empData =  EvenementsDAO.GetListeEvent();
						tabEvent.setItems(empData);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
	        }
	    });
	}
}

/*
// Called when the user clicks the new button. Opens a dialog to edit details for a new person.

@FXML
private void addEvt() {
	System.out.println(event.toString());
	    boolean okClicked = VueFXMain.VueEvtAdd(user);
	    if (okClicked) {
	        VueFXMain.getPersonData().add(event);
	        // VueFXMain.getPersonData().add(user);
	    	//tu fais appel  à la methode iinsertPers dans la classe personnelDAO
	    	// apres tu refresh ta tableView
	    }
	}




// Called when the user clicks the edit button. Opens a dialog to edit details for the selected person.

@FXML
private void editSalle() {
	System.out.println(salle.toString());
  	    if (salle != null) {
        boolean okClicked = VueFXMain.VueGSalleEdit(salle);
        if (okClicked) {
           // showPersonDetails(user);
            
            // tu fais appel à ta methode modifierPersonnel dans la classe PersonnelDAO
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
@FXML
private void suppSalle() {
    int selectedIndex = tabSalle.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        tabSalle.getItems().remove(selectedIndex);
        //appel à la fonction en donnant param nom+Mail
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
}*/


