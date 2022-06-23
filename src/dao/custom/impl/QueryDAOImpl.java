package dao.custom.impl;

import dao.custom.QueryDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<String> StudentId() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        // Query studentId = session.createQuery("SELECT studentId FROM Student");
        // List<String> list = studentId.list();

        NativeQuery sqlQuery = session.createSQLQuery("SELECT studentId FROM student ss WHERE NOT EXISTS( SELECT student_id FROM reserve e WHERE ss.studentId = e.student_id)");
        List list = sqlQuery.list();
        transaction.commit();
        session.close();
        return list;
    }
}
