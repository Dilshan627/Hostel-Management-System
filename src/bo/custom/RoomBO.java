package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface RoomBO extends SuperBO {

    ArrayList<RoomDTO> getAll() throws Exception;

    boolean add(RoomDTO roomDTO) throws Exception;

    boolean update(RoomDTO roomDTO) throws Exception;

    boolean delete(String code) throws Exception;

    List<String> roomId() throws IOException;

    List<RoomDTO> search(String id) throws IOException;
}
