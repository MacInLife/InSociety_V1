package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class AddConfirmController {
	@FXML
	private GridPane AddVue;
	@FXML
	private Button OuiAdd;
	@FXML
	private Button NonAdd;

	private Stage dialogStage;
	private boolean okClicked = false;

	
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

	  @FXML
	    private void OuiAdd() {
		  vue.VueFXMain.VueGEvtAdd();
	      
	    }
	  
	  @FXML
	    private void NonAdd() {
	        dialogStage.close();
	    }
		public boolean isOkClicked() {
			return okClicked;
		}
}
