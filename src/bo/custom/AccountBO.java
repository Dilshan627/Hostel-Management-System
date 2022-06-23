package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface AccountBO extends SuperBO {

    List<UserDTO> search(String id) throws IOException;
}
