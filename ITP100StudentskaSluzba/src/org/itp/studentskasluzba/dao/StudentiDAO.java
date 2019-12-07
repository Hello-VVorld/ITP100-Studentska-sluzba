package org.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import org.itp.studentskasluzba.dto.StudentiDTO;

public class StudentiDAO {

	public static Vector<StudentiDTO> getAll() {
		Vector<StudentiDTO> retVal = new Vector<StudentiDTO>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM  ciklus";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
				retVal.add(new StudentiDTO(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5)
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

	public static boolean dodajStudenti(StudentiDTO st) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "INSERT INTO ciklus (naziv) VALUES (?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, st.getIme());
			ps.setString(2, st.getPrezime());
			ps.setInt(3, st.getIndeks());
			ps.setInt(4, st.getUpis());
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

	public static boolean azurirajStudenti(int id, String ime, String prezime, int indeks, int upis) {
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
			ps.setInt(4, indeks);
			ps.setInt(5, upis);
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

	public static boolean obrisiStudenta(int id) {
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

//	public static StudentiDTO getById(int stu) {
//		StudentiDTO retVal = new StudentiDTO();
//		Connection conn = null;
//		java.sql.PreparedStatement ps = null;
//		ResultSet rs = null;
//		String query = "SELECT * FROM ciklus WHERE id = ?";
//		try {
//			conn = ConnectionPool.getInstance().checkOut();
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, stu);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				retVal.setId(rs.getInt(1));
//				retVal.setIme(rs.getString(2));
//				retVal.setPrezime(rs.getString(3));
//				retVal.setIndeks(rs.getInt(4));
//				retVal.setUpis(rs.getInt(5));
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
