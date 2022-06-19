package dao.custom.impl;

import dao.custom.RoomDAO;
import dao.custom.StudentDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public ArrayList<Room> getAll() throws Exception {
        ArrayList<Room> allRoom = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        List<Room> list = session.getSession().createCriteria(Room.class).list();
        for (Room room : list) {
            allRoom.add(new Room(room.getRoomId(), room.getType(), room.getRent(), room.getQty()));
        }
        session.close();
        return allRoom;
    }

    @Override
    public boolean save(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
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
