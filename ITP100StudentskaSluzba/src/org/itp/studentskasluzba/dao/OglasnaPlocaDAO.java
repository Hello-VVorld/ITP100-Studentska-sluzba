package org.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import org.itp.studentskasluzba.dto.OglasnaPlocaDTO;

public class OglasnaPlocaDAO {

	public static Vector<OglasnaPlocaDTO> getAll() {
		Vector<OglasnaPlocaDTO> retVal = new Vector<OglasnaPlocaDTO>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM  ciklus";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
				retVal.add(new OglasnaPlocaDTO(
						rs.getInt(1), 
						rs.getString(2)
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

	public static boolean dodajOglasnaPloca(OglasnaPlocaDTO ob) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "INSERT INTO ciklus (naziv) VALUES (?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, ob.getObavjest());
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

	public static boolean azurirajOglasnaPloca(int id, String obavjest) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "UPDATE ciklus SET naziv=? WHERE id=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, obavjest);
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

	public static boolean obrisiOglasnaPloca(int id) {
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

//	public static OglasnaPlocaDTO getById(int oglasna) {
//		OglasnaPlocaDTO retVal = new OglasnaPlocaDTO();
//		Connection conn = null;
//		java.sql.PreparedStatement ps = null;
//		ResultSet rs = null;
//		String query = "SELECT * FROM ciklus WHERE id = ?";
//		try {
//			conn = ConnectionPool.getInstance().checkOut();
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, oglasna);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				retVal.setId(rs.getInt(1));
//				retVal.setObavjest(rs.getString(2));
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
