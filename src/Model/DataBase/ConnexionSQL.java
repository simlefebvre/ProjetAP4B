package Model.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

public class ConnexionSQL {
	
	
	public static Connection conn = null;
	
	 public static void connect() {
	        try {
	            // db parameters
	            String url = "jdbc:sqlite:db/Database.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	 }
	 
	 public static void newMateriel(Materiel mat){
		 String sql = "insert into materiel(ID, Marque, Salle, etat) values (?,?,?,?)";
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setInt(1, mat.getID());
			 pstmt.setString(2, mat.getMarque());
			 pstmt.setString(3, mat.getSalle());
			 pstmt.setString(4, mat.getEtat());
			 pstmt.executeUpdate();
		 } catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
		 
		 if(mat instanceof Ordinateur) {
			 String rq = "insert into ordinateur (ID,Capacite,fixe,souris) values (?,?,?,?)";
			 try (PreparedStatement pstmt = conn.prepareStatement(rq)){
				 pstmt.setInt(1, mat.getID());
				 pstmt.setInt(2, ((Ordinateur)mat).getCapacite());
				 pstmt.setBoolean(3, ((Ordinateur)mat).getFixe());
				 pstmt.setBoolean(4, ((Ordinateur) mat).getSouris());
				 pstmt.executeUpdate();
			 } catch(SQLException e){
				 System.out.println(e.getMessage());
			 }
		 }else if(mat instanceof Tablette) {
			 String rq = "insert into tablette (ID,clavier) values (?,?)";
			 try (PreparedStatement pstmt = conn.prepareStatement(rq)){
				 pstmt.setInt(1, mat.getID());
				 pstmt.setBoolean(2, ((Tablette)mat).getClavier());
				 pstmt.executeUpdate();
			 } catch(SQLException e){
				 System.out.println(e.getMessage());
			 }
		 }else if(mat instanceof VideoProjecteur) {
			 String rq = "insert into VideoProjecteur (ID,telecomande) values (?,?)";
			 try (PreparedStatement pstmt = conn.prepareStatement(rq)){
				 pstmt.setInt(1, mat.getID());
				 pstmt.setBoolean(2, ((VideoProjecteur)mat).getTelecommande());
				 pstmt.executeUpdate();
			 } catch(SQLException e){
				 System.out.println(e.getMessage());
			 }
		 }
	 }
 
	 public static void delMateriel(int ID){
		 String sql = "delete from materiel where materiel.ID = ?";
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setInt(1, ID);
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 String rq1 = "delete from reservation where reservation.mat = ?";
		 try (PreparedStatement pstmt = conn.prepareStatement(rq1)){
			 pstmt.setInt(1, ID);
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 String rq2 = "delete from ordinateur where ordinateur.ID = ?";
		 try (PreparedStatement pstmt = conn.prepareStatement(rq2)){
			 pstmt.setInt(1, ID);
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 String rq3 = "delete from tablette where tablette.ID = ?";
		 try (PreparedStatement pstmt = conn.prepareStatement(rq3)){
			 pstmt.setInt(1, ID);
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 String rq4 = "delete from videoprojecteur where videoprojecteur.ID = ?";
		 try (PreparedStatement pstmt = conn.prepareStatement(rq4)){
			 pstmt.setInt(1, ID);
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }

	 public static void modifMat(int ID, String etat, String marque, String salle,int Capacite, boolean  fixe, boolean souris) {
		 String sql = "update materiel set "
		 		+ "etat = ?,"
		 		+ "marque = ?,"
		 		+ "salle = ? "
		 		+ "where materiel.ID = ?;";
		 String sql1 = "update ordinateur set "
		 		+ "capacite = ?,"
		 		+ "fixe = ?,"
		 		+ "souris = ? "
		 		+ "where ordinateur.ID = ?;";
		 try (PreparedStatement pstmt = conn.prepareStatement(sql);
				 PreparedStatement pstmt2 = conn.prepareStatement(sql1)){
			 pstmt.setString(1, etat);
			 pstmt.setString(2, marque);
			 pstmt.setString(3, salle);
			 pstmt.setInt(4, ID);
			 pstmt.executeUpdate();
			 
			 pstmt2.setInt(1, Capacite);
			 pstmt2.setBoolean(2, fixe);
			 pstmt2.setBoolean(3, souris);
			 pstmt2.setInt(4, ID);
			 pstmt2.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 public static void modifMat(int ID, String etat, String marque, String salle, boolean telecommande) {
		 String rq = "select ID from tablette where tablette.ID = ?;";
		 try(PreparedStatement pstmt1 = conn.prepareStatement(rq)){
			 pstmt1.setInt(1, ID);
			 ResultSet rs = pstmt1.executeQuery();
			 
		 	String sql = "update materiel set "
			 		+ "etat = ?,"
			 		+ "marque = ?,"
			 		+ "salle = ? "
			 		+ "where materiel.ID = ?;";
			 String sql1 = "update videoprojecteur set "
			 		+ "telecommande = ? "
			 		+ "where videoprojecteur.ID = ?;";
			 String sql2 = "update tablette set "
				 		+ "clavier = ? "
				 		+ "where tablette.ID = ?;";
			 try (PreparedStatement pstmt = conn.prepareStatement(sql);
					 PreparedStatement pstmt2 = conn.prepareStatement(sql1);
					 PreparedStatement pstmt3 = conn.prepareStatement(sql2)){
				 
				pstmt.setString(1, etat);
				pstmt.setString(2, marque);
				pstmt.setString(3, salle);
				pstmt.setInt(4, ID);
				pstmt.executeUpdate();
				 
				pstmt2.setBoolean(1, telecommande);
				pstmt2.setInt(2, ID);
				pstmt2.executeUpdate();
				 
				pstmt3.setBoolean(1, telecommande);
				pstmt3.setInt(2, ID);
				pstmt3.executeUpdate();
					 
			 }catch (SQLException e) {
				 System.out.println(e.getMessage());
			 }
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 } 

	 public static void newUtil(Utilisateur util) {
	 	 String sql = "insert into utilisateur(mail,nom,prenom,mot_de_passe,administrateur) values (?,?,?,?,?)";
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setString(1, util.getMail());
			 pstmt.setString(2, util.getNom());
			 pstmt.setString(3, util.getPrenom());
			 pstmt.setString(4, util.getMDP());
			 pstmt.setBoolean(5, util instanceof Administrateur);
			 pstmt.executeUpdate();
		 } catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
 	 }

	 public static void delUtil(String mail) {
		 String sql = "delete from utilisateur where utilisateur.mail = ?";
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setString(1, mail);
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }

	 
	 //Modifier utilisateur en modifiant mot de passe
	 public static void modifUtil(String ancienMail, String nouveauMail, String nom, String prenom, String mdp, boolean admin) {
		 String sql = "update utilisateur set "
			 		+ "nom = ?,"
			 		+ "prenom = ?,"
			 		+ "mot_de_passe = ?,"
			 		+ "administrateur = ? "
			 		+ "where utilisateur.mail = \"" + ancienMail + "\";";
		//TODO On change admin ?? Si on change, modif ModifierInfosUtilisateur
		 
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setString(1, nouveauMail);
			 pstmt.setString(2, nom);
			 pstmt.setString(3, prenom);
			 pstmt.setString(4, mdp);
			 pstmt.setBoolean(5, admin);
			 
			 pstmt.executeUpdate();
		 }catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 
	//Modifier utilisateur sans modifier le mot de passe
		 public static void modifUtil(String ancienMail, String nouveauMail, String nom, String prenom, boolean admin) {
			 String sql = "update utilisateur set "
					 	+ "mail = ?,"
				 		+ "nom = ?,"
				 		+ "prenom = ?,"
				 		+ "administrateur = ? "
				 		+ "where utilisateur.mail = \"" + ancienMail + "\";";
			 //TODO On change admin ?? Si on change, modif ModifierInfosUtilisateur
			 
			 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				 pstmt.setString(1, nouveauMail);
				 pstmt.setString(2, nom);
				 pstmt.setString(3, prenom);
				 pstmt.setBoolean(4, admin);
				 
				 pstmt.executeUpdate();
			 }catch (SQLException e) {
				 System.out.println(e.getMessage());
			 }
		 }
}
