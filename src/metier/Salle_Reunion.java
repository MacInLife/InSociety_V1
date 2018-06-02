
package metier;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Salle_Reunion {
    //Initialisation des variables 
	private IntegerProperty idSR;
    private StringProperty nomSR;
    private IntegerProperty nbPlaceTotal;
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

    public StringProperty getLieuPro() {
        return lieu;
    }

    public void setLieuPro(StringProperty lieu) {
        this.lieu = lieu;
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
