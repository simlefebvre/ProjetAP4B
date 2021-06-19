package Model.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Model.Agenda.Reservation;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Personnel;
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
			 String rq = "insert into VideoProjecteur (ID,telecommande) values (?,?)";
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
		 
		 for(Reservation r : getReservationMat(ID)) {
			 delReservation(r.getID());
		 }
		 
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
			 
			 for(Reservation r : getReservationUsr(mail)) {
				 delReservation(r.getID());
			 }
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }

	 public static void newReservation(Reservation r) {
		 String sql = "insert into reservation(id,mat,deb,fin,util) values (?,?,?,?,?);";
		 
		 try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			 pstmt.setString(1, r.getID());
			 pstmt.setInt(2, r.getMat().getID());
			 pstmt.setString(3, Reservation.formatDate.format(r.getDebut()));
			 pstmt.setString(4, Reservation.formatDate.format(r.getFin()));
			 pstmt.setString(5, r.getPar().getMail());
			 
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 //Modifier utilisateur en modifiant mot de passe
	 public static void modifUtil(String mail, String nom, String prenom, String mdp, boolean admin) {
		 String sql = "update utilisateur set "
			 		+ "nom = ?,"
			 		+ "prenom = ?,"
			 		+ "mot_de_passe = ?,"
			 		+ "administrateur = ? "
			 		+ "where utilisateur.mail = \"" + mail + "\";";
		 
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setString(1, nom);
			 pstmt.setString(2, prenom);
			 pstmt.setString(3, mdp);
			 pstmt.setBoolean(4, admin);
			 
			 pstmt.executeUpdate();
		 }catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 
	//Modifier utilisateur sans modifier le mot de passe
	 public static void modifUtil(String mail, String nom, String prenom, boolean admin) {
		 String sql = "update utilisateur set "
			 		+ "nom = ?,"
			 		+ "prenom = ?,"
			 		+ "administrateur = ? "
			 		+ "where utilisateur.mail = \"" + mail + "\";";
		 
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setString(1, nom);
			 pstmt.setString(2, prenom);
			 pstmt.setBoolean(3, admin);
			 
			 pstmt.executeUpdate();
		 }catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 public static LinkedList<Utilisateur> getUtilisateurs(){
		 LinkedList<Utilisateur> util = new LinkedList<>();
		 
		 String sql = "select * from utilisateur;";
		 try(Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(sql)){
					 while(rs.next()) {
						 if(rs.getBoolean(5)) { 
							 util.add(new Administrateur(rs.getString(1), rs.getString(2), rs.getString(1), rs.getString(4)));
						 }else {
							 util.add(new Personnel(rs.getString(1), rs.getString(2), rs.getString(1), rs.getString(4)));
						 }
					 }
		 }catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
		 
		 return util;
	 }
	 
	 public static LinkedList<Materiel> getMateriels(){
		 LinkedList<Materiel> mat = new LinkedList<>();
		 
		 String sql = "select * from materiel;";
		 
		 try(Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(sql)){
			 
			 while(rs.next()) {
				 
				 String rqo = "select * from ordinateur where id = ?;";
				 String rqt = "select * from tablette where id = ?;";
				 String rqvp = "select * from VideoProjecteur where id = ?;";
				 
				 try(PreparedStatement pstmto = conn.prepareStatement(rqo);
						 PreparedStatement pstmtt = conn.prepareStatement(rqt);
						 PreparedStatement pstmtvp = conn.prepareStatement(rqvp);){
					 
					 
					 pstmto.setInt(1, rs.getInt(1));
					 pstmtt.setInt(1, rs.getInt(1));
					 pstmtvp.setInt(1, rs.getInt(1));
					 
					 ResultSet rso = pstmto.executeQuery();
					 ResultSet rst = pstmtt.executeQuery();
					 ResultSet rsvp = pstmtvp.executeQuery();
					 
					 while(rso.next()) {
						 mat.add(new Ordinateur(rs.getString(2),rs.getString(4),rs.getString(3),rso.getBoolean(2),rso.getBoolean(3),rso.getInt(4),rs.getInt(1)));
					 }
					 while(rst.next()) {
						 mat.add(new Tablette(rs.getString(2),rs.getString(4),rs.getString(3),rst.getBoolean(2),rs.getInt(1)));
					 }
					 while(rsvp.next()) {
						 mat.add(new VideoProjecteur(rs.getString(2),rs.getString(4),rs.getString(3),rsvp.getBoolean(2),rs.getInt(1)));
					 }
				 }catch(SQLException e) {
					 System.out.println(e.getMessage());
				 }
				 
			 }
			 
		 }catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
		 
		 
		 return mat;
	 }

	 public static Utilisateur getUtilisateur(String string) {
		 String sql = "select * from utilisateur where mail = \""+ string +"\";";
		 
		 try(Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(sql)){
			//pstmt.setString(1, string);
			
			while(rs.next()) {
				if(rs.getBoolean(5)) {
					return new Administrateur(rs.getString(3), rs.getString(2),rs.getString(1), rs.getString(4));
				}else {
					return new Personnel(rs.getString(3), rs.getString(2),rs.getString(1), rs.getString(4));
				}
				
			}
		 }catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
		 
		 return null;
	 }
	 
	 public static Materiel getMateriel(int id) {
		 
		 
		 String sql = "select * from materiel where id = ?;";
		 
		 try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			 
			 pstmt.setInt(1, id);
			 
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 
				 String rqo = "select * from ordinateur where id = ?;";
				 String rqt = "select * from tablette where id = ?;";
				 String rqvp = "select * from VideoProjecteur where id = ?;";
				 
				 try(PreparedStatement pstmto = conn.prepareStatement(rqo);
						 PreparedStatement pstmtt = conn.prepareStatement(rqt);
						 PreparedStatement pstmtvp = conn.prepareStatement(rqvp);){
					 
					 
					 pstmto.setInt(1, rs.getInt(1));
					 pstmtt.setInt(1, rs.getInt(1));
					 pstmtvp.setInt(1, rs.getInt(1));
					 
					 ResultSet rso = pstmto.executeQuery();
					 ResultSet rst = pstmtt.executeQuery();
					 ResultSet rsvp = pstmtvp.executeQuery();
					 
					 while(rso.next()) {
						 return new Ordinateur(rs.getString(2),rs.getString(4),rs.getString(3),rso.getBoolean(2),rso.getBoolean(3),rso.getInt(4),rs.getInt(1));
					 }
					 while(rst.next()) {
						 return new Tablette(rs.getString(2),rs.getString(4),rs.getString(3),rst.getBoolean(2),rs.getInt(1));
					 }
					 while(rsvp.next()) {
						 return new VideoProjecteur(rs.getString(2),rs.getString(4),rs.getString(3),rsvp.getBoolean(2),rs.getInt(1));
					 }
				 }catch(SQLException e) {
					 System.out.println(e.getMessage());
				 }
			 }
	 }catch(SQLException e){
		 System.out.println(e.getMessage());
	 }
		 return null;
 }

	 public static LinkedList<Reservation> getReservationMat(int id) {
		 String sql = "select * from reservation where mat = ?;";
		 LinkedList<Reservation> res = new LinkedList<>();
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setInt(1, id);
			 ResultSet rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 res.add(new Reservation(Reservation.strToDate(rs.getString(3)), Reservation.strToDate(rs.getString(4)), ConnexionSQL.getUtilisateur(rs.getString(5)),ConnexionSQL.getMateriel(rs.getInt(2))));
			 }
		 }catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
		 return res;
	 }
	 
	 public static LinkedList<Reservation> getReservationUsr(String id) {
		 String sql = "select * from reservation where util = \""+id+"\";";
		 LinkedList<Reservation> res = new LinkedList<>();
		 try (Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(sql)){
			 while(rs.next()) {
				 res.add(new Reservation(Reservation.strToDate(rs.getString(3)), Reservation.strToDate(rs.getString(4)), ConnexionSQL.getUtilisateur(rs.getString(5)),ConnexionSQL.getMateriel(rs.getInt(2))));
			 }
		 }catch(SQLException e){
			 System.out.println(e.getMessage());
		 }
		 return res;
	 }
	 
	 public static void delReservation(String id) {
		 String sql = "delete from reservation where id = ? ;";
		 try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setString(1, id);
			 pstmt.executeUpdate();
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 
	 }
}
