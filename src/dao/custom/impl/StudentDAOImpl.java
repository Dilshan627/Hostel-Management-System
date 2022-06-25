package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getAll() throws Exception {
        ArrayList<Student> allStudent = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        List<Student> list = session.getSession().createCriteria(Student.class).list();
        for (Student student : list) {
            allStudent.add(new Student(student.getStudentId(), student.getName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
        }
        session.close();
        return allStudent;
    }

    @Override
    public boolean save(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
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
        session.delete(session.get(Student.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query student = session.createQuery("FROM Student  WHERE studentId = :id");
        student.setParameter("id", id);
        List<Student> list = student.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String allCount() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT count(studentId) from Student");
        List list = query.list();
        String count = String.valueOf(list.listIterator().next());
        transaction.commit();
        session.close();
        return count;
    }
}
