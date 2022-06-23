package bo.custom;

import bo.SuperBO;
import dto.ReserveDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface RegistrationBo extends SuperBO {

    ArrayList<ReserveDTO> getAll() throws Exception;

    boolean add(ReserveDTO reserveDTO) throws Exception;

    String generateNewID() throws IOException;

    String count(String id) throws IOException;

}
