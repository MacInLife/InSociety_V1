package metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Notes {
	private IntegerProperty id_notes;
    private StringProperty Txt_not;
    Personnel personnel;

    //Constructeur par defaut JavaFX
   public Notes(){
	   this.id_notes = new SimpleIntegerProperty();
    this.Txt_not = new SimpleStringProperty();

}
// Création des getters et setters Property
   public IntegerProperty getId_notesPro(){
       return id_notes;
   }
   public void setId_notesPro(IntegerProperty  id_notes){
        this. id_notes =  id_notes;
   }
   
   public StringProperty getTxt_notPro(){
       return Txt_not;
   }
   public void setTxt_notPro(StringProperty Txt_not){
        this.Txt_not = Txt_not;
   }
   
   public Personnel getPersonnel(){
       return personnel;
   }
   public void setPersonnel(Personnel personnel){
       this.personnel = personnel;
   }
   
   //CrÃ©ation des getters et setters basique
   public int getId_notes(){
       return id_notes.get();
   }
   public void setId_notes(int id_notes){
        this.id_notes.set(id_notes);
   }
   
   @Override
public String toString() {
	return  ""+ getTxt_not() ;
}
public String getTxt_not(){
       return Txt_not.get();
   }
   public void setTxt_not(String Txt_not){
        this.Txt_not.set(Txt_not);
   }
}