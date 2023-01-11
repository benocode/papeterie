package fr.eni.papeterie.dal;

import java.util.List;

/**
 * Interface générique pour connection au SGBD
 * 
 * @author benocode
 * @date 11/01/2023
 */
public interface DAO<T> {

	public T selectById(int id) throws DALException;

	public List<T> selectAll() throws DALException;

	public void update(T object) throws DALException;

	public void insert(T object) throws DALException;

	public void delete(int id) throws DALException;
}
