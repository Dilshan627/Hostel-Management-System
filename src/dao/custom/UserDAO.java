package dao.custom;


import dao.SuperDAO;
import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO extends SuperDAO {

    boolean save(User entity) throws Exception;

    boolean update(User entity) throws Exception;

    List<User> search(String id) throws IOException;
}
