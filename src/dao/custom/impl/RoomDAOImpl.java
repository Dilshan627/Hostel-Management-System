package dao.custom.impl;

import dao.custom.RoomDAO;
import dao.custom.StudentDAO;
import entity.Room;

import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public ArrayList<Room> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Room entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Room entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(StudentDAO studentDAO) throws Exception {
        return false;
    }
}
