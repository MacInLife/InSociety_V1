package controller;

import java.sql.SQLException;

import DAO.NotesDAO;
import DAO.PersonnelDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import metier.Notes;
import vue.VueFXMain;


public class AccueilController {
	
	@FXML
	private Pane AccueilView;
	@FXML
	private ImageView supN;
	@FXML
	private  ListView<Notes> allNotes;
	Notes notes;
	
	@FXML
	private void initialize() throws ClassNotFoundException, SQLException {
		// appel de la fonction NotesDAO
		int id = 1 ; 
		ObservableList<Notes> empData = NotesDAO.GetListeNotes(id);
		allNotes.setItems(empData);
	allNotes.setEditable(true);
	
		ListView<String> list = new ListView<String>();
		ObservableList<String> items =FXCollections.observableArrayList ();
		list.setItems(items);
	}
	 public static final ObservableList<String> data = 
		        FXCollections.observableArrayList();
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	final ListView listView = new ListView(data);
  
		@FXML
		private void supN() {
		Notes selectedIndex = allNotes.getSelectionModel().getSelectedItem();
		    if (selectedIndex!=null) {
		        allNotes.getItems().remove(selectedIndex );
		        //appel a la fonction du NotesDAO SuppPers
		       try {
				NotesDAO.SuppNotes(selectedIndex);
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
		        alert.setTitle("Aucune Selection");
		        alert.setHeaderText("Aucune Note n'est séléctionner");
		        alert.setContentText("Please select a person in the table.");

		        alert.showAndWait();
		    }
		}
	 
}
