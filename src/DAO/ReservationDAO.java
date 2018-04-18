package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Notes;
import metier.Personnel;
import metier.Reservation;
import metier.Role;
import metier.Salle_Reunion;
import metier.Service;
import metier.Statut;

public class ReservationDAO {

    
 public static void ajoutRes(Reservation res) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
        System.out.println(res.getId_res());
        System.out.println(res.getNbPers());
        System.out.println(res.getDate_d());
        System.out.println(res.getDate_f());
        System.out.println(res.getSallel().getNomSR());
                System.out.println(Salle_ReunionDAO.GetIdSR(res.getSallel().getNomSR()));
        System.out.println(res.getPersonnel().getLogin());
        		System.out.println( PersonnelDAO.GetIdPers(res.getPersonnel().getLogin()));
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `reservation`(`nbPers`, `date_d`, `date_f`, `id_SR`, `id_pers`) "
                + "VALUES (?,?,?,?,?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
               pst.setInt(1, res.getNbPers());
         pst.setTimestamp(2, res.getDate_d());
         pst.setTimestamp(3, res.getDate_f()); 
      //   pst.setInt(8, Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR()));
         pst.setInt(4,Salle_ReunionDAO.GetIdSR(res.getSallel().getNomSR()));
        pst.setInt(5, PersonnelDAO.GetLogin(res.getPersonnel().getLogin()));
               
       @SuppressWarnings("unused")
	int nbligne =  pst.executeUpdate();
    
    }
 
 
	public static void ModifRes(Reservation res) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
System.out.println(res.getId_res());
		// Création de la requête inserer new pers
		String requeteSQL = "UPDATE `reservation` SET `nbPers`= ?,`date_d`= ?,`date_f`= ?,`id_pers`= ?,`id_SR`= ? WHERE  id_res = ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
			pst.setInt(1, res.getNbPers());
		pst.setTimestamp(2,res.getDate_d());
		pst.setTimestamp(3, res.getDate_f());
		//Recup�re et verif cl� etrang�re de la table Statut
		pst.setInt(4, PersonnelDAO.GetLogin(res.getPersonnel().getLogin()));
		pst.setInt(5, Salle_ReunionDAO.GetIdSR(res.getSallel().getNomSR()));
		pst.setInt(6, res.getId_res());
	

		@SuppressWarnings("unused")
		int nbligne = pst.executeUpdate();

	}
 
    public static void SuppRes(Reservation res ) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `reservation` WHERE id_res = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
          //renvoyer et verifier les données de la requête
         pst.setInt(1, res.getId_res());
        
         
        @SuppressWarnings("unused")
		int i = pst.executeUpdate();
    
    }
    
   public static ObservableList<Reservation> GetListeRes() throws ClassNotFoundException, SQLException {
		ObservableList<Reservation> ResList = FXCollections.observableArrayList();
		// constitution d'une commande bas�e sur une requ�te SQL
		// en vue d'�tre ex�cut�e sur une connexion donn�e
		String req = "select * from reservation";
		Connection cnx = Connect.getInstance().getConnection();
		int id_res;
		int nbPers;
		Timestamp date_d;
		Timestamp date_f;
		int id_pers;
		int id_SR;
	
		PreparedStatement pst = cnx.prepareStatement(req);

		ResultSet table = pst.executeQuery();
		while (table.next()) {
			id_res = table.getInt("id_res");
			nbPers = table.getInt("nbPers");
			date_d = table.getTimestamp("date_d");
			date_f = table.getTimestamp("date_f");
			id_pers = table.getInt("id_pers");
			id_SR = table.getInt("id_SR");
		
			Reservation res = new Reservation();
			res.setId_res(id_res);
			res.setNbPers(nbPers);
			res.setDate_d(date_d);
			res.setDate_f(date_f);
			
			Personnel pers = new Personnel();
			pers.setId(id_pers);
			pers.setLogin(PersonnelDAO.GetPers(id_pers).getLogin());
			res.setPersonnel(pers);

			Salle_Reunion salle = new Salle_Reunion();
			salle.setIdSR(id_SR);
			salle.setNomSR(Salle_ReunionDAO.GetSalle(id_SR).getNomSR());
			res.setSalle(salle);
			
		
			ResList.add(res);
 
		}
		table.close();
		pst.close();
		cnx.close();
		return ResList;
	}
   
	public static ObservableList<String> getResList() throws SQLException {
		ObservableList<String> slist = FXCollections.observableArrayList();
        Connection co = Connect.getInstance().getConnection();
        String requeteSQL = "SELECT `id_res` FROM `reservationn`";
        PreparedStatement pst = co.prepareStatement(requeteSQL);
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
        	slist.add(rs.getString("id_res"));
        }
		
	    return slist;
		
	}   


}

