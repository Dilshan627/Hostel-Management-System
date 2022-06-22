package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private final StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public ArrayList<StudentDTO> getAll() throws Exception {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();
        for (Student student : all) {
            allStudent.add(new StudentDTO(student.getStudentId(), student.getName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
        }
        return allStudent;
    }

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(new Student(studentDTO.getStudentId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact(), studentDTO.getDob(), studentDTO.getGender()));

    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(studentDTO.getStudentId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact(), studentDTO.getDob(), studentDTO.getGender()));

    }

    @Override
    public boolean delete(String code) throws Exception {
        return studentDAO.delete(code);
    }

    @Override
    public List<String> StudentId() throws IOException {
        return studentDAO.StudentId();
    }

    @Override
    public List<StudentDTO> search(String id) throws IOException {
        List<Student> list = studentDAO.search(id);
        List<StudentDTO>studentDTO=new ArrayList<>();
        for (Student student:list) {
            studentDTO.add(new StudentDTO(student.getStudentId(), student.getName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
        }
        return studentDTO;
    }

}
