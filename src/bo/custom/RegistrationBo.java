package bo.custom;

import dto.ReserveDTO;

import java.util.ArrayList;

public interface RegistrationBo {

    ArrayList<ReserveDTO> getAll() throws Exception;

    boolean add(ReserveDTO reserveDTO) throws Exception;
}
