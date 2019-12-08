package org.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import org.itp.studentskasluzba.dto.PredmetDTO;

public class PredmetDAO {

	public static Vector<PredmetDTO> getAll() {
		Vector<PredmetDTO> retVal = new Vector<PredmetDTO>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM  ciklus";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
				retVal.add(new PredmetDTO(
						rs.getInt(1), 
						rs.getString(2),
						rs.getBoolean(3),
						rs.getInt(4)
						));
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}

	public static boolean dodajPredmet(PredmetDTO pr) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "INSERT INTO ciklus (naziv) VALUES (?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, pr.getNaziv());
			ps.setBoolean(2, pr.isObavezan());
			ps.setInt(3, pr.getEcts());
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return retVal;
	}

	public static boolean azurirajPredmet(int id, String naziv, boolean obavezan, int ects) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "UPDATE ciklus SET naziv=? WHERE id=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, naziv);
			ps.setBoolean(3, obavezan);
			ps.setInt(4, ects);
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return retVal;
	}

	public static boolean obrisiPredmet(int id) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "DELETE FROM ciklus WHERE id = ?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps);
		}
		return retVal;
	}

	public static PredmetDTO getById(int pred) {
		PredmetDTO retVal = new PredmetDTO();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM ciklus WHERE id = ?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, pred);
			rs = ps.executeQuery();
			while (rs.next()) {
				retVal.setId(rs.getInt(1));
				retVal.setNaziv(rs.getString(2));
				retVal.setObavezan(rs.getBoolean(3));
				retVal.setEcts(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			DBUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
	
}
