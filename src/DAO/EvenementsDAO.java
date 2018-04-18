
package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Evenements;
import metier.Salle_Reunion;

import java.sql.*;

@SuppressWarnings("unused")
public class EvenementsDAO {

	public static int GetIdEvent(String nomEvt) throws ClassNotFoundException, SQLException {
		int i = 0;
		Connection co = Connect.getInstance().getConnection();
		// constitution d'une commande basée sur une requête SQL
		// en vue d'être exécutée sur une connexion donnée
		String req = "SELECT id_event FROM evenement WHERE nomEvt = ?";

		PreparedStatement pst = co.prepareStatement(req);
		pst.setString(1, nomEvt);

		ResultSet table = pst.executeQuery();

		while (table.next()) {
			i = table.getInt("id_event");
		}
		return i;
	}

	public static void ajoutEvent(Evenements event) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();

		// Création de la requête inserer new evenements
		String requeteSQL = "INSERT INTO `evenement`(`nomEvt`,`jour_d`,`jour_f`,`h_debut`, `h_fin`, `type`, `lieu`, `id_SR`)"
				+ "VALUES (?,?,?,?,?,?,?,?)";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setString(1, event.getNomEvt());
		pst.setDate(2, event.getJour_d());
		pst.setDate(3, event.getJour_f());
		pst.setTime(4, event.getH_debut());
		pst.setTime(5, event.getH_fin());
		pst.setString(6, event.getType());
		pst.setString(7, event.getLieu());
		pst.setInt(8, Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR()));
	
		// faire un GetId_SR avec le nom dans salle de réunion et appeler pou renvoyer
		// les données requètes
		/*int test = Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR());
		if ( test != 0)
			pst.setInt(8, test);
		else 
			pst.setString(8, null);
		*/
		// Récupère et vérifier la clé étrangère de la table Salle de Réunion
		// id_SR

		// pst.setInt(4, RoleDAO.GetIdRole(pers.getRole().getNom_role()));

		int nbligne = pst.executeUpdate();

	}

	public static void ModifEvent(Evenements event) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
		System.out.println(event.getId_evt());
		// Création de la requête inserer new pers
		String requeteSQL = "UPDATE `evenement` SET `nomEvt`= ?,`jour_d`= ?,`jour_f`= ?,`h_debut`= ?, `h_fin`= ?, `type`= ?,`lieu`= ?,`id_SR`= ? WHERE  id_event = ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setString(1, event.getNomEvt());
		pst.setDate(2, event.getJour_d());
		pst.setDate(3, event.getJour_f());
		pst.setTime(4, event.getH_debut());
		pst.setTime(5, event.getH_fin());
		pst.setString(6, event.getType());
		pst.setString(7, event.getLieu());
		// Recup�re et verif cl� etrang�re de la table Salle_Reunion
		pst.setInt(8, Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR()));
		/*int test = Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR());
		if ( test != 0)
			pst.setInt(8, test);
		else 
			pst.setString(8, null);*/
		pst.setInt(9, event.getId_evt());

		int nbligne = pst.executeUpdate();

	}

	public static void SuppEvent(Evenements event) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();

		// Création de la requête supprimer evenements
		String requeteSQL = "DELETE FROM `evenement` WHERE id_event = ? ";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setInt(1, event.getId_evt());

		int i = pst.executeUpdate();

	}

	public static ObservableList<Evenements> GetListeEvent() throws ClassNotFoundException, SQLException {
		ObservableList<Evenements> EvtList = FXCollections.observableArrayList();
		// constitution d'une commande bas�e sur une requ�te SQL
		// en vue d'�tre ex�cut�e sur une connexion donn�e
		String req = "select * from evenement";
		Connection cnx = Connect.getInstance().getConnection();
		int id_evt;
		String nomEvt;
		String type;
		Date jour_d;
		Date jour_f;
		Time h_debut;
		Time h_fin;
		String lieu;
		int idSR;

		PreparedStatement pst = cnx.prepareStatement(req);

		ResultSet table = pst.executeQuery();
		while (table.next()) {

			id_evt = table.getInt("id_event");
			nomEvt = table.getString("nomEvt");
			type = table.getString("type");
			jour_d = table.getDate("jour_d");
			jour_f = table.getDate("jour_f");
			h_debut = table.getTime("h_debut");
			h_fin = table.getTime("h_fin");
			lieu = table.getString("lieu");
			idSR = table.getInt("id_SR");

			Evenements event = new Evenements();
			event.setId_evt(id_evt);
			event.setNomEvt(nomEvt);
			event.setType(type);
			event.setJour_d(jour_d);
			event.setJour_f(jour_f);
			event.setH_debut(h_debut);
			event.setH_fin(h_fin);

			event.setLieu(lieu);
			Salle_Reunion salle = new Salle_Reunion();
			salle.setIdSR(idSR);
			salle.setNomSR(Salle_ReunionDAO.GetSalle(idSR).getNomSR());
			event.setSalle(salle);
			System.out.println(event);
			EvtList.add(event);

		}
		table.close();
		pst.close();
		cnx.close();
		return EvtList;
	}

}
