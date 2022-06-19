package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    ArrayList<StudentDTO> getAll() throws Exception;

    boolean add(StudentDTO studentDTO) throws Exception;

    boolean update(StudentDTO studentDTO) throws Exception;

    boolean delete(String code) throws Exception;

}
