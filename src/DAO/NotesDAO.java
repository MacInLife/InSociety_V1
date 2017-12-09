package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Personnel;
import metier.Service;
import metier.Notes;


public class NotesDAO {
	//recup donn�es
		public static ObservableList<Notes> GetListeNotes(int id_pers ) throws ClassNotFoundException, SQLException {
			ObservableList<Notes> NotesList = FXCollections.observableArrayList();
			// constitution d'une commande bas�e sur une requ�te SQL
			// en vue d'�tre ex�cut�e sur une connexion donn�e
			String req = "select * from notes where   id_admin= ?";
			Connection cnx = Connect.getInstance().getConnection();
			int id_notes ;
			String Txt_not;
		
			
			PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, id_pers);
            
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				 id_pers = table.getInt("id_admin");
	             id_notes = table.getInt("id_notes");
				Txt_not = table.getString("Txt_not");
		
				Notes notes = new Notes();
	           notes.setId_notes(id_notes);
	           notes.setTxt_not(Txt_not);
	       
			NotesList.add(notes);

			}
			table.close();
			pst.close();
			cnx.close();
			return NotesList;
		}
		
		public static void SuppNotes(Notes notes) throws SQLException, ClassNotFoundException {
			// Je me connecte
			Connection co = Connect.getInstance().getConnection();

			// Création de la requête supprimer personne
			String requeteSQL = "DELETE FROM `notes` WHERE id_notes = ?";

			// préparer la requête
			PreparedStatement pst = co.prepareStatement(requeteSQL);

			// renvoyer et verifier les données de la requête
			pst.setInt(1, notes.getId_notes());
			int i = pst.executeUpdate();
			
			
			int a = 1;
		
		}
	
		public static void insertNotes(ObservableList<Notes> ListNotes) {
			//for()
		}
		
		
}
