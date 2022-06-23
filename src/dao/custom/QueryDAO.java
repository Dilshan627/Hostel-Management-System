package dao.custom;

import dao.SuperDAO;
import entity.Custom;

import java.io.IOException;
import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<String> StudentId() throws IOException;

    List<Custom> studentDetails(String Id) throws IOException;
}
