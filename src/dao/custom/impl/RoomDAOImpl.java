package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Room.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<String> roomId() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query studentId = session.createQuery("SELECT roomId FROM Room");
        List<String> list = studentId.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<Room> search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query room = session.createQuery("FROM Room  WHERE roomId = :id");
        room.setParameter("id", id);
        List<Room> list = room.list();
        transaction.commit();
        session.close();
        return list;
    }
}
