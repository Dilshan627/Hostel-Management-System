package dao.custom.impl;

import dao.custom.ReserveDAO;
import entity.Reserve;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReserveDAOImpl implements ReserveDAO {
    @Override
    public ArrayList<Reserve> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Reserve entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reserve entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public String generateNewID() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT resId FROM reserve ORDER BY resId DESC LIMIT 1");
        String id = (String) sqlQuery.uniqueResult();
        String newID = null;
        if (id == null) {
            newID = "R00-001";
        } else {
            int newCustomerId = Integer.parseInt(id.replace("R00-", "")) + 1;
            newID = String.format("R00-%03d", newCustomerId);
        }
        transaction.commit();
        session.close();
        return newID;
    }

    @Override
    public String count(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select count(room_id) from reserve where room_id= :id");
        sqlQuery.setParameter("id", id);
        List<String> list = sqlQuery.list();
        String count = String.valueOf(list.listIterator().next());
        transaction.commit();
        session.close();
        return count;

    }

    @Override
    public List<String> StudentId() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery listId = session.createSQLQuery("select student_id from Reserve");
        List list = listId.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<String> search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select student_id from reserve where room_id= :id");
        sqlQuery.setParameter("id", id);
        List list = sqlQuery.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String allCount() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT count(resId) from Reserve");
        List list = query.list();
        String count = String.valueOf(list.listIterator().next());
        transaction.commit();
        session.close();
        return count;
    }


}
