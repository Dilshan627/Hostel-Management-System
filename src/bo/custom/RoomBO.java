package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface RoomBO extends SuperBO {

    ArrayList<RoomDTO> getAll() throws Exception;

    boolean add(RoomDTO roomDTO) throws Exception;

    boolean update(RoomDTO roomDTO) throws Exception;

    boolean delete(String code) throws Exception;
}
