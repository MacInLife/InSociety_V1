package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Notes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotesDAO {
	// recup donn�es
	public static ObservableList<Notes> GetListeNotes() throws ClassNotFoundException, SQLException {
		ObservableList<Notes> NotesList = FXCollections.observableArrayList();
		// constitution d'une commande bas�e sur une requ�te SQL
		// en vue d'�tre ex�cut�e sur une connexion donn�e
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

		// Création de la requête inserer new evenements
		String requeteSQL = "INSERT INTO `notes`(`id_notes`,`Txt_not`, `id_admin`) " + "VALUES (?,?,?)";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setInt(1, notes.getId_notes());
		pst.setString(2, notes.getTxt_not());
		pst.setInt(3, notes.getPersonnel().getId());

		int nbligne = pst.executeUpdate();

	}

	public static void ModifNotes(Notes notes) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
		System.out.println("dao Note : " + notes);
		// Création de la requête inserer new pers
		String requeteSQL = "UPDATE `notes` SET `Txt_not`= ?, `id_admin` = ? WHERE  `id_notes` = ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setString(1, notes.getTxt_not());
		pst.setInt(2, notes.getPersonnel().getId());
		pst.setInt(3, notes.getId_notes());
		
		// Recup�re et verif cl� etrang�re de la table Salle_Reunion

		int nbligne = pst.executeUpdate();

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
		// for()
	}

}
