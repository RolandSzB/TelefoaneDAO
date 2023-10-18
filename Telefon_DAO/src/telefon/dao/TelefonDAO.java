package telefon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import telefon.helper.*;
import telefon.pojo.*;

public class TelefonDAO {


	public static ArrayList<Telefon> getAll() throws SQLException {
		ArrayList<Telefon> result = new ArrayList<Telefon>();
		Connection conn = TelHelper.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select * from telefoane";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Telefon t = new Telefon();
			t.setId(rs.getInt("id"));
			t.setMarca(rs.getString("marca"));
			t.setDimensiune(rs.getInt("dimensiune"));
			t.setAparitie(rs.getDate("aparitie"));
			result.add(t);
		}

		return result;
	}

	public static Telefon getById(int id) throws SQLException {
		Telefon result = null;
		Connection conn = TelHelper.getConnection();
		String query = "select * from telefoane where id=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			result = new Telefon();
			result.setId(rs.getInt("id"));
			result.setMarca(rs.getString("marca"));
			result.setDimensiune(rs.getInt("dimensiune"));
			result.setAparitie(rs.getDate("aparitie"));
		}
		return result;
	}

	
	public static void create(Telefon t) throws SQLException {
		Connection c=  TelHelper.getConnection();
		String query = "insert into telefoane (marca, dimensiune, aparitie) values (?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, t.getMarca());
		ps.setInt(2, t.getDimensiune());
		ps.setDate(3, t.getAparitie());
		ps.executeUpdate();
		System.out.println("S-a inserat cu succes "+ t.getMarca());
				
	}
	
	
	public static String delete(String marca) throws SQLException {
		Connection c = TelHelper.getConnection();
		String deleteQuery = "delete from telefoane where marca=?";
		PreparedStatement ps = c.prepareStatement(deleteQuery);
		ps.setString(1, marca);
		int deleted = ps.executeUpdate();

		return deleted == 0 ? "Nu a fost sters nici-o inregistrare"
				: "A fost sters cu succes " + deleted + " inregistrari";

	}

	
	public static boolean update(Telefon t) throws SQLException {

		Connection c = TelHelper.getConnection();
		String query = "update telefoane set marca=?, dimensiune=?, aparitie=? where id=?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, t.getMarca());
		ps.setInt(2, t.getDimensiune());
		ps.setDate(3, t.getAparitie());
		ps.setInt(4, t.getId());

		int ar = ps.executeUpdate();

		return ar == 0 ? false : true;

	}
}
