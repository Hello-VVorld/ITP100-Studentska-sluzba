package org.itp.studentskasluzba.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import org.itp.studentskasluzba.dto.IspitiDTO;

public class IspitiDAO {

	public static Vector<IspitiDTO> getAll() {
		Vector<IspitiDTO> retVal = new Vector<IspitiDTO>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM  ciklus";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
				retVal.add(new IspitiDTO(
						rs.getInt(1), 
						rs.getString(2),
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getInt(8)
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

	public static boolean dodajIspit(IspitiDTO i) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "INSERT INTO ciklus (naziv) VALUES (?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, i.getDatum());
			ps.setInt(2, i.getOcjena());
			ps.setInt(3, i.getBrojBodova());
			ps.setInt(4, i.getNastavnikId());
			ps.setInt(5, i.getPredmetId());
			ps.setInt(6, i.getStudentiId());
			ps.setInt(7, i.getStudijskiProgramId());
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

	public static boolean azurirajIspit(int id, String datum, int ocjena, int brojBodova, int nastavnikId, int predmetId, int studentiId, int studijskiProgramId) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "UPDATE ciklus SET naziv=? WHERE id=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, datum);
			ps.setInt(3, ocjena);
			ps.setInt(4, brojBodova); 
			ps.setInt(5, nastavnikId); 
			ps.setInt(6, predmetId); 
			ps.setInt(7, studentiId);
			ps.setInt(8, studijskiProgramId);
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

	public static boolean obrisiIspit(int id) {
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

//	public static IspitiDTO getById(int ispiti) {
//		IspitiDTO retVal = new IspitiDTO();
//		Connection conn = null;
//		java.sql.PreparedStatement ps = null;
//		ResultSet rs = null;
//		String query = "SELECT * FROM ciklus WHERE id = ?";
//		try {
//			conn = ConnectionPool.getInstance().checkOut();
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, ispiti);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				retVal.setId(rs.getInt(1));
//				retVal.setDatum(rs.getString(2));
//				retVal.setOcjena(rs.getInt(3));
//				retVal.setBrojBodova(rs.getInt(4));
//				retVal.setNastavnikId(rs.getInt(5));
//				retVal.setPredmetId(rs.getInt(6));
//				retVal.setStudentiId(rs.getInt(7));
//				retVal.setStudijskiProgramId(rs.getInt(8));
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
