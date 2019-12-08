package org.itp.studentskasluzba.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import org.itp.studentskasluzba.dto.StudijskiProgramDTO;

public class StudijskiProgramDAO {

	public static Vector<StudijskiProgramDTO> getAll() {
		Vector<StudijskiProgramDTO> retVal = new Vector<StudijskiProgramDTO>();
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM  program";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
				retVal.add(new StudijskiProgramDTO(
						 rs.getInt(1), 
						 rs.getString(2), 
						 rs.getInt(3)
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

	
	
	public static boolean dodajStudijskiProgram(StudijskiProgramDTO sp) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "INSERT INTO studijski_program (naziv, id_studijski_program) VALUES (?, ?)";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1, sp.getNaziv());
			ps.setInt(2, sp.getCiklusId());
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
	
	public static boolean azurirajStudijskiProgram(int id, String naziv) {
		boolean retVal = false;
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		String query = "UPDATE ciklus SET naziv=? WHERE id=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, naziv);
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
	
	public static boolean obrisiStudijskiProgram(int id) {
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
	
//	public static StudijskiProgramDTO getById(int studijskiProgram) {
//		StudijskiProgramDTO retVal = new StudijskiProgramDTO();
//		Connection conn = null;
//		java.sql.PreparedStatement ps = null;
//		ResultSet rs = null;
//		String query = "SELECT * FROM studijskiprogram WHERE id = ?";
//		try {
//			conn = ConnectionPool.getInstance().checkOut();
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, studijskiProgram);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				retVal.setId(rs.getInt(1));
//				retVal.setNaziv(rs.getString(2));
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
