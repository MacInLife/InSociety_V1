
package metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Role {
    //initialisation des variable de la classe Role
    private StringProperty nom_role;
    
    /*//Constructeur
   public  Role(String nom_role){
        this.nom_role = nom_role;
    }*/
    public Role(){
        this.nom_role = new SimpleStringProperty();
    }
    
    //Création des getters et setters Property
    public StringProperty getNom_rolePro(){
        return nom_role;
    }
    public void setNom_rolePro(StringProperty nom_role){
        this.nom_role = nom_role;
    }
    
    //Création des getters et setters
    public String getNom_role(){
        return nom_role.get();
    }
    public void setNom_role(String nom_role){
        this.nom_role.set(nom_role);
    }
    
    
}
