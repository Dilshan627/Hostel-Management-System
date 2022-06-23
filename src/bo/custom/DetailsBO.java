package bo.custom;

import bo.SuperBO;
import dto.ReserveDTO;
import dto.StudentDTO;
import entity.Reserve;
import entity.Student;

import java.io.IOException;
import java.util.List;

public interface DetailsBO extends SuperBO {

    List<String> roomId() throws IOException;

    List<String> StudentId() throws IOException;

    List<String> search(String id) throws IOException;

    List<StudentDTO> searchStudent(String id) throws IOException;
}
