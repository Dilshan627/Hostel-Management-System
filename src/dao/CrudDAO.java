package dao;

import entity.SuperEntity;

import java.util.ArrayList;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {

    ArrayList<T> getAll() throws Exception;

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    T search(ID id) throws Exception;


    boolean delete(ID id) throws Exception;

}
