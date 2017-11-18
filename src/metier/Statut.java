
package metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Statut {
    //initialisation des variable de la classe Statut
    private StringProperty libeller;

    /*//Constructeur
    public Statut(String libeller) {
    this.libeller = libeller;
    }*/
    public Statut(){
        this.libeller = new SimpleStringProperty();
    }
    
    //Création des getters et setters
    public StringProperty getLibellerPro(){
        return libeller;
    }
    public void setLibellerPro(StringProperty libeller){
        this.libeller = libeller;
    }
    
    //Création des getters et setters
    public String getLibeller(){
        return libeller.get();
    }
    public void setLibeller(String libeller){
        this.libeller.set(libeller);
    }
    
}
