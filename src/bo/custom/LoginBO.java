package bo.custom;

import bo.SuperBO;
import dto.UserDTO;


import java.io.IOException;
import java.util.List;


public interface LoginBO extends SuperBO {

    boolean save(UserDTO dto) throws Exception;

    boolean login(String username,String password)throws IOException;
}
