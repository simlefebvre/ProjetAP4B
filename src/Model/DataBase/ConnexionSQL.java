package Model.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;

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
}
