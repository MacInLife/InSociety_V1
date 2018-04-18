package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Personnel;
import metier.Salle_Reunion;
import metier.Service;
import metier.Evenements;
import metier.Notes;

public class NotesDAO {
	// recup données
	public static ObservableList<Notes> GetListeNotes() throws ClassNotFoundException, SQLException {
		ObservableList<Notes> NotesList = FXCollections.observableArrayList();
		// constitution d'une commande basée sur une requête SQL
		// en vue d'être exécutée sur une connexion donnée
		String req = "select * from notes";
		Connection cnx = Connect.getInstance().getConnection();
		PreparedStatement pst = cnx.prepareStatement(req);
		ResultSet table = pst.executeQuery();
		while (table.next()) {
			Notes notes = new Notes();
			notes.setId_notes(table.getInt("id_notes"));
			notes.setTxt_not(table.getString("Txt_not"));
			notes.setPersonnel(PersonnelDAO.GetPers(table.getInt("id_admin")));
			NotesList.add(notes);
		}
		table.close();
		pst.close();
		cnx.close();
		return NotesList;
	}

	public static void insertNotes(Notes notes) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();

		// CrÃ©ation de la requÃªte inserer new evenements
		String requeteSQL = "INSERT INTO `notes`(`id_notes`,`Txt_not`, `id_admin`) " + "VALUES (?,?,?)";

		// prÃ©parer la requÃªte
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les donnÃ©es de la requÃªte
		pst.setInt(1, notes.getId_notes());
		pst.setString(2, notes.getTxt_not());
		pst.setInt(3, notes.getPersonnel().getId());

		int nbligne = pst.executeUpdate();

	}

	public static void ModifNotes(Notes notes) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
		System.out.println("dao Note : " + notes);
		// CrÃ©ation de la requÃªte inserer new pers
		String requeteSQL = "UPDATE `notes` SET `Txt_not`= ?, `id_admin` = ? WHERE  `id_notes` = ?";

		// prÃ©parer la requÃªte
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les donnÃ©es de la requÃªte
		pst.setString(1, notes.getTxt_not());
		pst.setInt(2, notes.getPersonnel().getId());
		pst.setInt(3, notes.getId_notes());
		
		// Recupère et verif clé etrangère de la table Salle_Reunion

		int nbligne = pst.executeUpdate();

	}

	public static void SuppNotes(Notes notes) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();

		// CrÃ©ation de la requÃªte supprimer personne
		String requeteSQL = "DELETE FROM `notes` WHERE id_notes = ?";

		// prÃ©parer la requÃªte
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les donnÃ©es de la requÃªte
		pst.setInt(1, notes.getId_notes());
		int i = pst.executeUpdate();

		int a = 1;

	}

	public static void insertNotes(ObservableList<Notes> ListNotes) {
		// for()
	}

}
