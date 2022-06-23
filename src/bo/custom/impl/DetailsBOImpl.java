package bo.custom.impl;

import bo.custom.DetailsBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.ReserveDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetailsBOImpl implements DetailsBO {

    private final RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);
    private final ReserveDAOImpl reserveDAO = DAOFactory.getInstance().getDAO(DAOType.RESERVE);

    private final StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public List<String> roomId() throws IOException {
        return roomDAO.roomId();
    }

    @Override
    public List<String> StudentId() throws IOException {
        return reserveDAO.StudentId();
    }

    @Override
    public List<String> search(String id) throws IOException {
        return reserveDAO.search(id);
    }

    @Override
    public List<StudentDTO> searchStudent(String id) throws IOException {
        List<Student> list = studentDAO.search(id);
        List<StudentDTO> studentDTO = new ArrayList<>();
        for (Student student : list) {
            studentDTO.add(new StudentDTO(student.getStudentId(), student.getName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
        }
        return studentDTO;
    }

}
