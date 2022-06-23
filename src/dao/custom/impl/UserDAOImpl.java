package dao.custom.impl;

import dao.custom.UserDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.List;

public class UserDAOImpl implements UserDAO {


    @Override
    public boolean save(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws Exception {
        return false;
    }

    @Override
    public List<User> search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query student = session.createQuery("FROM User  WHERE userName = :id");
        student.setParameter("id", id);
        List list = student.list();
        transaction.commit();
        session.close();
        return list;
    }


}
