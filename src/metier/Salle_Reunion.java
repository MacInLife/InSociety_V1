
package metier;
import java.sql.Date;
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
    private StringProperty nb_place;
    private ObjectProperty<Date> horaire;
    private ObjectProperty<Date> jour;
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
        this.nb_place = new SimpleStringProperty();
        this.horaire = new SimpleObjectProperty<Date>();
       this.jour = new SimpleObjectProperty<Date>();
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

    public StringProperty getNb_placePro() {
        return nb_place;
    }

    public void setNb_placePro(StringProperty nb_place) {
        this.nb_place = nb_place;
    }
    public StringProperty getLieuPro() {
        return lieu;
    }

    public void setLieuPro(StringProperty lieu) {
        this.lieu = lieu;
    }

    public ObjectProperty<Date> getHorairePro() {
        return horaire;
    }

    public void setHorairePro(ObjectProperty<Date> horaire) {
        this.horaire = horaire;
    }

    public ObjectProperty<Date> getJourPro() {
        return jour;
    }

    public void setJourPro(ObjectProperty<Date> jour) {
        this.jour = jour;
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

    public String getNb_place() {
        return nb_place.get();
    }

    public void setNb_place(String nb_place) {
        this.nb_place.set(nb_place);
    }

    public Date getHoraire() {
        return horaire.get();
    }

    public void setHoraire(Date horaire) {
        this.horaire.set(horaire);
    }

    public Date getJour() {
        return jour.get();
    }

    public void setJour(Date jour) {
        this.jour.set(jour);
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
