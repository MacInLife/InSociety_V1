package metier;

import java.sql.Timestamp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Reservation {
	   //Initialisation des variables 
		private IntegerProperty id_res;
	    private ObjectProperty<Timestamp> date_d;
	    private ObjectProperty<Timestamp> date_f;
	    private IntegerProperty nbPers;
	    Personnel personnel ;
	    Salle_Reunion salle ;
	    
	    public Reservation(){
	    	this.id_res = new SimpleIntegerProperty();
	        this.nbPers = new SimpleIntegerProperty();
	        this.date_d = new SimpleObjectProperty<Timestamp>();
	       this.date_f = new SimpleObjectProperty<Timestamp>();
	       personnel = new Personnel();
	       salle = new Salle_Reunion();
	       
	    }
	    

	    //Création des getters et setters Property
	     public IntegerProperty getId_resPro() {
	         return id_res;
	     }

	     public void setId_resPro(IntegerProperty id_res) {
	         this.id_res = id_res;
	     }

	     public IntegerProperty getNbPersPro() {
	         return nbPers;
	     }

	     public void setNbPersPro(IntegerProperty nbPers) {
	         this.nbPers = nbPers;
	     }

	     public ObjectProperty<Timestamp> getDate_dPro() {
	         return date_d;
	     }

	     public void setDate_dPro(ObjectProperty<Timestamp> date_d) {
	         this.date_d = date_d;
	     }

	     public ObjectProperty<Timestamp> getDate_fPro() {
	         return date_f;
	     }

	     public void setDate_fPro(ObjectProperty<Timestamp> date_f) {
	         this.date_f = date_f;
	     }

	     
	    //Création des getters et setters
	     public int getId_res() {
	     	return id_res.get();
	     }
	     public void setId_res(int id_res) {
	     	this.id_res.set(id_res);
	     }

	     public int getNbPers() {
	     	return nbPers.get();
	     }
	     public void setNbPers(int nbPers) {
	     	this.nbPers.set(nbPers);
	     }

	     public Timestamp getDate_d() {
	         return date_d.get();
	     }

	     public void setDate_d(Timestamp date_d) {
	         this.date_d.set(date_d);
	     }
	     public Timestamp getDate_f() {
	         return date_f.get();
	     }

	     public void setDate_f(Timestamp date_f) {
	         this.date_f.set(date_f);
	     }
	     
	   
	     public Personnel getPersonnel() {
	         return personnel;
	     }

	     public void setPersonnel(Personnel personnel) {
	         this.personnel = personnel;
	     }
	     public Salle_Reunion getSallel() {
	         return salle;
	     }

	     public void setSalle(Salle_Reunion salle) {
	         this.salle = salle;
	     }
}
