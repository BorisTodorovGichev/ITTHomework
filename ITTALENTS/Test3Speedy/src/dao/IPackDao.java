package dao;

import speedy.Pack;
import exceptions.PackDAOException;

public interface IPackDao {
	public int addPack(Pack pack) throws PackDAOException;
	public void updatePack(Pack pack) throws PackDAOException;

}