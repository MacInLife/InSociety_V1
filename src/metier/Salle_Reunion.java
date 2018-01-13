
package metier;
import java.sql.Date;
import java.sql.Timestamp;
//Bibliothèque
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Salle_Reunion {
    //Initialisation des variables 
	private IntegerProperty idSR;
    private StringProperty nomSR;
    private IntegerProperty nbPlaceTotal;
    private IntegerProperty nbPers;
    private ObjectProperty<Timestamp> date_d;
    private ObjectProperty<Timestamp> date_f;
    private Statut statut;
    private StringProperty lieu;

    /* //Constructeur
   public Salle_Reunion(String nomSR, String nb_place, LocalDate horaire, LocalDate jour){
       this.nomSR = nomSR;
       this. nb_place = nb_place;
       this.horaire = horaire;
       this.jour = jour; 
   }*/
    
    public Salle_Reunion(){
    	this.idSR = new SimpleIntegerProperty();
        this.nomSR = new SimpleStringProperty();
        this.nbPlaceTotal = new SimpleIntegerProperty();
        this.nbPers = new SimpleIntegerProperty();
        this.date_d = new SimpleObjectProperty<Timestamp>();
       this.date_f = new SimpleObjectProperty<Timestamp>();
       statut = new Statut();
       this.lieu = new SimpleStringProperty();
    }
  
   //Création des getters et setters Property
    public IntegerProperty getIdSRPro() {
        return idSR;
    }

    public void setIdSRPro(IntegerProperty idSR) {
        this.idSR = idSR;
    }
    public StringProperty getNomSRPro() {
        return nomSR;
    }

    public void setNomSRPro(StringProperty nomSR) {
        this.nomSR = nomSR;
    }

    public IntegerProperty getNbPlaceTotalPro() {
        return nbPlaceTotal;
    }

    public void setNbPlaceTotalPro(IntegerProperty nbPlaceTotal) {
        this.nbPlaceTotal = nbPlaceTotal;
    }
    public IntegerProperty getNbPersPro() {
        return nbPers;
    }

    public void setNbPersPro(IntegerProperty nbPers) {
        this.nbPers = nbPers;
    }
    public StringProperty getLieuPro() {
        return lieu;
    }

    public void setLieuPro(StringProperty lieu) {
        this.lieu = lieu;
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
    public int getIdSR() {
    	return idSR.get();
    }
    public void setIdSR(int idSR) {
    	this.idSR.set(idSR);
    }
    
    
    public String getNomSR() {
        return nomSR.get();
    }

    public void setNomSR(String nomSR) {
        this.nomSR.set(nomSR);
    }

    public int getNbPlaceTotal() {
    	return nbPlaceTotal.get();
    }
    public void setNbPlaceTotal(int nbPlaceTotal) {
    	this.nbPlaceTotal.set(nbPlaceTotal);
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
    
  
    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut  statut) {
        this.statut = statut;
    }
    
    public String getLieu() {
        return lieu.get();
    }

    public void setLieu(String lieu) {
        this.lieu.set(lieu);
    }






}
