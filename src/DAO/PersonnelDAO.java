
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Personnel;
import metier.Service;
import metier.Statut;
import metier.Role;

public class PersonnelDAO {

	public static boolean adminVerif(String login, String mdp) throws SQLException {
	     
		Connection cnx = Connect.getInstance().getConnection();
		String req = "SELECT nom_role, type_service FROM Personnel, Service, Role "
				+ "WHERE login=? AND mdp=? AND Personnel.id_role = Role.id_role AND Service.id_service = Personnel.id_service";
		PreparedStatement pst = cnx.prepareStatement(req);
		pst.setString(1, login);
	    pst.setString(2, mdp);
		ResultSet userInformation = pst.executeQuery();
		while(userInformation .next()) {
			
		 String f = userInformation.getString("nom_role") ;
		 String g =   userInformation.getString("type_service") ;

		 if(f.startsWith("Resp")  && g.startsWith("Info"))
		 {
			 return  true;
		 }
		}
	
		return false;
	}

	public static int GetIdPers(String mail) throws ClassNotFoundException, SQLException {
		int i = 0;
		Connection co = Connect.getInstance().getConnection();
		// constitution d'une commande basée sur une requête SQL
		// en vue d'être exécutée sur une connexion donnée
		String req = "SELECT `id_pers` FROM `personnel` WHERE mail =?";

		PreparedStatement pst = co.prepareStatement(req);

		ResultSet table = pst.executeQuery();

		while (table.next()) {
			i = table.getInt("id_pers");
		}
		return i;
	}

	public static void insertPers(Personnel pers) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();

		// Création de la requête inserer new pers
		String requeteSQL = "INSERT INTO `personnel`(`nom`, `prenom`, `adresse`, `mail`, `Tel`,"
				+ "`id_role`, `id_service`, `id_statut`, `login`, `date_naissance`, `localisation`, `mdp`)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setString(1, pers.getNom());
		pst.setString(2, pers.getPrenom());
		pst.setString(3, pers.getAdresse());
		pst.setString(4, pers.getMail());
		pst.setString(5, pers.getTel());

		// Récupère et vérifier la clé étrangère de la table Role puis pareil pour
		// Service, Statut

		pst.setInt(6, RoleDAO.GetIdRole(pers.getRole().getNom_role()));
		pst.setInt(7, ServiceDAO.GetIdServ(pers.getService().getType_service()));
		pst.setInt(8, StatutDAO.GetIdStat(pers.getStatut().getLibeller()));

		// renvoyer et vérifier les données de la requête (suite)
		pst.setString(9, pers.getLogin());
		pst.setDate(10, pers.getDate_naissance());
		pst.setString(11, pers.getLocalisation());
		pst.setString(12, pers.getMdp());

		int nbligne = pst.executeUpdate();

	}

	public static void SuppPers(Personnel pers) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();

		// Création de la requête supprimer personne
		String requeteSQL = "DELETE FROM `personnel` WHERE id_pers = ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setInt(1, pers.getId());
		int i = pst.executeUpdate();
	}

	public static void ModifPers(Personnel  pers) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
System.out.println(pers.getId());
		// Création de la requête inserer new pers
		String requeteSQL = "UPDATE `personnel` " + "SET `nom`= ?,`prenom`= ?,`adresse`= ?,`mail`= ?,`Tel`= ?,"
				+ "`id_role`= ?,`id_service`= ?,`id_statut`= ?,`login`= ?,`date_naissance`= ?,"
				+ "`localisation`= ?, `mdp`= ? WHERE  id_pers = ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setString(1, pers.getNom());
		pst.setString(2, pers.getPrenom());
		pst.setString(3, pers.getAdresse());
		pst.setString(4, pers.getMail());
		pst.setString(5, pers.getTel());

		// Récupère et vérifier la clé étrangère de la table Role puis pareil pour
		// Service, Statut

		pst.setInt(6, RoleDAO.GetIdRole(pers.getRole().getNom_role()));
		pst.setInt(7, ServiceDAO.GetIdServ(pers.getService().getType_service()));
		pst.setInt(8, StatutDAO.GetIdStat(pers.getStatut().getLibeller()));

		// renvoyer et vérifier les données de la requête (suite)
		pst.setString(9, pers.getLogin());
		pst.setDate(10, pers.getDate_naissance());
		pst.setString(11, pers.getLocalisation());
		pst.setString(12, pers.getMdp());
		pst.setInt(13, pers.getId());

		int nbligne = pst.executeUpdate();

	}

	public static ObservableList<Personnel> GetListePersonnel() throws ClassNotFoundException, SQLException {
		ObservableList<Personnel> UserList = FXCollections.observableArrayList();
		// constitution d'une commande bas�e sur une requ�te SQL
		// en vue d'�tre ex�cut�e sur une connexion donn�e
		String req = "select * from personnel";
		Connection cnx = Connect.getInstance().getConnection();
		int id ;
		String nom;
		String prenom;
		String login;
		String adresse;
		String mail;
		String tel;
		Date date_naissance;
		String localisation;
		String mdp;
		int id_service;
		int id_statut;
		int id_role;
		PreparedStatement pst = cnx.prepareStatement(req);

		ResultSet table = pst.executeQuery();
		while (table.next()) {
             id = table.getInt("id_pers");
			nom = table.getString("nom");
			prenom = table.getString("prenom");
			login = table.getString("login");
			adresse = table.getString("adresse");
			mail = table.getString("mail");
			tel = table.getString("tel");
			date_naissance = table.getDate("date_naissance");
			localisation = table.getString("localisation");
			mdp = table.getString("mdp");
			id_service = table.getInt("id_service");
			id_statut = table.getInt("id_statut");
			id_role = table.getInt("id_role");

			Personnel user = new Personnel();
           user.setId(id);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setLogin(login);
			user.setAdresse(adresse);
			user.setDate_naissance(date_naissance);
			user.setMail(mail);
			user.setTel(tel);
			user.setLocalisation(localisation);
			user.setMdp(mdp);
			Service serv = new Service();
			serv.setType_service(ServiceDAO.getTypeService(id_service));
			user.setService(serv);
			Statut statu = new Statut();
			statu.setLibeller(StatutDAO.getLibeller(id_statut));
			user.setStatut(statu);
			Role rol = new Role();
			rol.setNom_role(RoleDAO.getNomRole(id_role));
			user.setRole(rol);
			UserList.add(user);

		}
		table.close();
		pst.close();
		cnx.close();
		return UserList;
	}
	
	public static ObservableList<Personnel> GetListFiltrePers(String filtre) throws ClassNotFoundException, SQLException
 	{     
		Connection cnx = Connect.getInstance().getConnection();
 	ObservableList<Personnel> UserListF = FXCollections.observableArrayList();
 	
 	filtre = filtre
 			.replace("!", "!!")
 			.replace("%", "!%")
 			.replace("_", "!_")
 			.replace("[", "![");
 	
 	String req = "SELECT id, nom, prenom, login, mail "
 			+ "FROM personnel WHERE  id LIKE ? ESCAPE '!' OR nom LIKE ? ESCAPE '!' "
 			+ "OR prenom LIKE ? ESCAPE '!' OR login LIKE ? ESCAPE '!' OR mail LIKE ? ESCAPE '!'";
 	
 	int id;
 	String nom;
 	String prenom;
 	String login;
 	String mail;
 
 	PreparedStatement pst = cnx.prepareStatement(req);
    	pst.setString(1, filtre +  "%");
    	pst.setString(2, filtre +  "%");
    	pst.setString(3, filtre +  "%");
    	pst.setString(4, filtre +  "%");
    	pst.setString(5, filtre +  "%");
     
    	ResultSet jeu = pst.executeQuery();
 
    	while(jeu.next())
    	{
    		id = jeu.getInt("id");
		 	nom = jeu.getString("nom");
		 	prenom = jeu.getString("prenom");
		 	login = jeu.getString("login");
		 	mail= jeu.getString("mail");
	 
		 	Personnel pers = new Personnel();
		 	pers.setId(id);
		 	pers.setNom(nom);
		 	pers.setPrenom(prenom);
		 	pers.setLogin(login);
		 	pers.setMail(mail);
		
	 
    		UserListF.add(pers);
    		System.out.println(pers);
    	}

    	jeu.close();
    	jeu.close();
    	pst.close();
    	cnx.close();
 		return UserListF;
 	}


}