package dao.custom;

import dao.CrudDAO;
import entity.Reserve;

import java.io.IOException;
import java.sql.SQLException;

public interface RegistrationDAO extends CrudDAO<Reserve,String> {
    String generateNewID() throws IOException;
}
