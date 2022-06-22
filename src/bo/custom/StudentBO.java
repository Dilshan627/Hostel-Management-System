package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {

    ArrayList<StudentDTO> getAll() throws Exception;

    boolean add(StudentDTO studentDTO) throws Exception;

    boolean update(StudentDTO studentDTO) throws Exception;

    boolean delete(String code) throws Exception;

    List<String> StudentId() throws IOException;

    List<StudentDTO> search(String id) throws IOException;

}
