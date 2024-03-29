package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import exceptions.PackDAOException;
import speedy.Pack;


public class PackDAO extends AbstractDAO implements IPackDao {
	private static final String INSERT_NEW_PACK_SQL = "INSERT INTO speedy.packs (pack_api_id,sender,reciever,content,time_taken,is_delivered) VALUES (?,?,?,?,?,?);";
	private static final String UPDATE_PACK_SQL = "UPDATE speedy.packs SET is_delivered = ?, content = ? WHERE pack_api_id = ?;";
	
	
	public int addPack(Pack pack) throws PackDAOException {
		if (pack != null) {

			try {
				java.sql.PreparedStatement ps = getCon().prepareStatement(
						INSERT_NEW_PACK_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, pack.getUniqueId());
				ps.setString(2, pack.getSender().toString());
				ps.setString(3, pack.getReciever().toString());
				ps.setString(4, pack.getContent());
				ps.setTimestamp(5,pack.getTimeTaken());
				ps.setBoolean(6, pack.isDelivered());
				
				ps.executeUpdate();

				ResultSet result = ps.getGeneratedKeys();
				result.next();
				return result.getInt(1);

			} catch (SQLException e) {
				e.printStackTrace();
				throw new PackDAOException("Pack not created.", e);
			}
		} else {
			throw new PackDAOException("Input pack is null");
		}
	}
	
	public void updatePack(Pack pack) throws PackDAOException {
		if (pack != null) {

			try {
				java.sql.PreparedStatement ps = getCon().prepareStatement(
						UPDATE_PACK_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setBoolean(1, pack.isDelivered());
				ps.setString(2, pack.getContent());
				ps.setInt(3, pack.getUniqueId());

				
				ps.executeUpdate();

				ResultSet result = ps.getGeneratedKeys();
				result.next();
				

			} catch (SQLException e) {
				e.printStackTrace();
				throw new PackDAOException("Pack not created.", e);
			}
		} else {
			throw new PackDAOException("Input pack is null");
		}
	}
}