
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Personnel;
import metier.Role;
import metier.Salle_Reunion;
import metier.Service;
import metier.Statut;

public class Salle_ReunionDAO  {

       public static int GetIdSR(String nomSR) throws ClassNotFoundException, SQLException
     {
          int i =0 ;
          Connection co = Connect.getInstance().getConnection();
         // constitution d'une commande basée sur une requête SQL 
         // en vue d'être exécutée sur une connexion donnée     
         String req = "SELECT `id_SR` FROM `Salle_Reunion` WHERE nomSR = ?";
        
         PreparedStatement pst = co.prepareStatement(req);
         pst.setString(1, nomSR);
       
         ResultSet table = pst.executeQuery();
         
         while(table.next())
         {
             i = table.getInt("id_SR");
         }
         return i;
     }
    
 public static void ajoutSalleReu(Salle_Reunion salleReu) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `salle_reunion`(`NbPlaceTotal`,`nbPers`, `date_d`, `date_f`, `nomSR`, `id_statut`, `lieu`) "
                + "VALUES (?,?,?,?,?,?,?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setInt(1, salleReu.getNbPlaceTotal());
         pst.setInt(2, salleReu.getNbPers());
         pst.setTimestamp(3, salleReu.getDate_d());
         pst.setTimestamp(4, salleReu.getDate_f());
         pst.setString(5, salleReu.getNomSR());
         pst.setInt(6,StatutDAO.GetIdStat(salleReu.getStatut().getLibeller()));
         pst.setString(7, salleReu.getLieu());
               
       int nbligne =  pst.executeUpdate();
    
    }
 
 
	public static void ModifSalleReu(Salle_Reunion  salleReu) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
System.out.println(salleReu.getIdSR());
		// Création de la requête inserer new pers
		String requeteSQL = "UPDATE `salle_reunion` SET `nbPlaceTotal`= ?,`nbPers`= ?,`date_d`= ?,`date_f`= ?,`nomSR`= ?,`id_statut`= ?,`lieu`= ? WHERE  id_SR = ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setInt(1, salleReu.getNbPlaceTotal());
		pst.setInt(2, salleReu.getNbPers());
		pst.setTimestamp(3, salleReu.getDate_d());
		pst.setTimestamp(4, salleReu.getDate_f());
		pst.setString(5, salleReu.getNomSR());
		//Recup�re et verif cl� etrang�re de la table Statut
		pst.setInt(6, StatutDAO.GetIdStat(salleReu.getStatut().getLibeller()));
		pst.setString(7, salleReu.getLieu());
		pst.setInt(8, salleReu.getIdSR());
	

		int nbligne = pst.executeUpdate();

	}
 
    public static void SuppSalleReu(Salle_Reunion salleReu ) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `salle_reunion` WHERE id_SR = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
          //renvoyer et verifier les données de la requête
         pst.setInt(1, salleReu.getIdSR());
        
         
        int i = pst.executeUpdate();
    
    }
    
   public static ObservableList<Salle_Reunion> GetListeSalle() throws ClassNotFoundException, SQLException {
		ObservableList<Salle_Reunion> SalleList = FXCollections.observableArrayList();
		// constitution d'une commande bas�e sur une requ�te SQL
		// en vue d'�tre ex�cut�e sur une connexion donn�e
		String req = "select * from salle_reunion";
		Connection cnx = Connect.getInstance().getConnection();
		int idSR;
		String nomSR;
		int nbPlaceTotal;
		int nbPers;
		Timestamp date_d;
		Timestamp date_f;
		String lieu;
		int id_statut;
	
		PreparedStatement pst = cnx.prepareStatement(req);

		ResultSet table = pst.executeQuery();
		while (table.next()) {
			idSR = table.getInt("id_SR");
			nomSR = table.getString("nomSR");
			nbPlaceTotal = table.getInt("nbPlaceTotal");
			nbPers = table.getInt("nbPers");
			date_d = table.getTimestamp("date_d");
			date_f = table.getTimestamp("date_f");
			lieu = table.getString("lieu");
			id_statut = table.getInt("id_statut");
		
			Salle_Reunion salle = new Salle_Reunion();
			salle.setIdSR(idSR);
			salle.setNomSR(nomSR);
			salle.setNbPlaceTotal(nbPlaceTotal);
			salle.setNbPers(nbPers);
			salle.setDate_d(date_d);
			salle.setDate_f(date_f);
			salle.setLieu(lieu);
			Statut statu = new Statut();
			statu.setLibeller(StatutDAO.getLibeller(id_statut));
			salle.setStatut(statu);
			SalleList.add(salle);

		}
		table.close();
		pst.close();
		cnx.close();
		return SalleList;
	}
   
	public static ObservableList<String> getSalleRList() throws SQLException {
		ObservableList<String> slist = FXCollections.observableArrayList();
        Connection co = Connect.getInstance().getConnection();
        String requeteSQL = "SELECT `nomSR` FROM `salle_reunion`";
        PreparedStatement pst = co.prepareStatement(requeteSQL);
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
        	slist.add(rs.getString("nomSR"));
        }
		
	    return slist;
		
	}   
}
