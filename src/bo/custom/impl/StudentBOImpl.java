package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO= DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
       return studentDAO.save(new Student(
                studentDTO.getStudentId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }
}
