package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface AccountBO extends SuperBO {

    boolean save(UserDTO dto) throws Exception;

    List<UserDTO> search(String id) throws IOException;

    boolean update(UserDTO dto) throws Exception;

    boolean delete(String code) throws Exception;
}
