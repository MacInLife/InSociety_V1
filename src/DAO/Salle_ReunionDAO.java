
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Salle_Reunion;
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
       
       public static Salle_Reunion GetSalle(int id) throws ClassNotFoundException, SQLException
     {
          Salle_Reunion salle = new Salle_Reunion();
          Connection co = Connect.getInstance().getConnection();
         // constitution d'une commande basée sur une requête SQL 
         // en vue d'être exécutée sur une connexion donnée     
         String req = "SELECT * FROM `Salle_Reunion` WHERE id_SR = ?";
        
         PreparedStatement pst = co.prepareStatement(req);
         pst.setInt(1, id);
       
         ResultSet table = pst.executeQuery();
         
         while(table.next())
         {
             salle.setIdSR(table.getInt("id_SR"));
             salle.setNomSR(table.getString("NomSR"));

             
         }
         return salle;
     }
    
 public static void ajoutSalleReu(Salle_Reunion salleReu) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `salle_reunion`(`NbPlaceTotal`,`nomSR`, `id_statut`, `lieu`) "
                + "VALUES (?,?,?,?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setInt(1, salleReu.getNbPlaceTotal());
         pst.setString(2, salleReu.getNomSR());
         pst.setInt(3,StatutDAO.GetIdStat(salleReu.getStatut().getLibeller()));
         pst.setString(4, salleReu.getLieu());
         pst.executeUpdate();
    
    }
 
 
	public static void ModifSalleReu(Salle_Reunion  salleReu) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
System.out.println(salleReu.getIdSR());
		// Création de la requête inserer new pers
		String requeteSQL = "UPDATE `salle_reunion` SET `NbPlaceTotal`= ?, `nomSR`= ?,`id_statut`= ?,`lieu`= ? WHERE  id_SR = ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setInt(1, salleReu.getNbPlaceTotal());
		pst.setString(2, salleReu.getNomSR());
		//Recup�re et verif cl� etrang�re de la table Statut
		pst.setInt(3, StatutDAO.GetIdStat(salleReu.getStatut().getLibeller()));
		pst.setString(4, salleReu.getLieu());
		pst.setInt(5, salleReu.getIdSR());
		pst.executeUpdate();

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
        pst.executeUpdate();
    
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
		String lieu;
		int id_statut;
	
		PreparedStatement pst = cnx.prepareStatement(req);

		ResultSet table = pst.executeQuery();
		while (table.next()) {
			idSR = table.getInt("id_SR");
			nomSR = table.getString("nomSR");
			nbPlaceTotal = table.getInt("nbPlaceTotal");
			lieu = table.getString("lieu");
			id_statut = table.getInt("id_statut");
		
			Salle_Reunion salle = new Salle_Reunion();
			salle.setIdSR(idSR);
			salle.setNomSR(nomSR);
			salle.setNbPlaceTotal(nbPlaceTotal);
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
