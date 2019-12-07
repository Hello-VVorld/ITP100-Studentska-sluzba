package org.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import org.itp.studentskasluzba.dto.NastavnikDTO;

public class NastavnikDAO {

	public static Vector<NastavnikDTO> getAll() {
		Vector<NastavnikDTO> retVal = new Vector<NastavnikDTO>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM  ciklus";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
				retVal.add(new NastavnikDTO(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
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

	public static boolean dodajNastavnik(NastavnikDTO n) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "INSERT INTO ciklus (naziv) VALUES (?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, n.getIme());
			ps.setString(2, n.getPrezime());
			ps.setString(3, n.getZvanje());
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

	public static boolean azurirajNastavnike(int id, String ime, String prezime, String zvanje) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "UPDATE ciklus SET naziv=? WHERE id=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, ime);
			ps.setString(3, prezime);
			ps.setString(4, zvanje);
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

	public static boolean obrisiNastavnika(int id) {
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

//	public static NastavnikDTO getById(int nastavnik) {
//		NastavnikDTO retVal = new NastavnikDTO();
//		Connection conn = null;
//		java.sql.PreparedStatement ps = null;
//		ResultSet rs = null;
//		String query = "SELECT * FROM ciklus WHERE id = ?";
//		try {
//			conn = ConnectionPool.getInstance().checkOut();
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, nastavnik);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				retVal.setId(rs.getInt(1));
//				retVal.setIme(rs.getString(2));
//				retVal.setPrezime(rs.getString(3));
//				retVal.setZvanje(rs.getString(4));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			DBUtilities.getInstance().showSQLException(e);
//		} finally {
//			ConnectionPool.getInstance().checkIn(conn);
//			DBUtilities.getInstance().close(ps, rs);
//		}
//		return retVal;
//	}
	
}
