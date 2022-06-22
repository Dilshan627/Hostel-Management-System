package bo.custom.impl;

import bo.custom.RegistrationBo;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.RegistrationDAOImpl;
import dto.ReserveDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBo {

    private final RegistrationDAOImpl dao = DAOFactory.getInstance().getDAO(DAOType.RESERVE);

    @Override
    public ArrayList<ReserveDTO> getAll() throws Exception {

        return null;
    }

    @Override
    public boolean add(ReserveDTO reserveDTO) throws Exception {
        return false;
    }

    @Override
    public String generateNewID() throws IOException{
        return dao.generateNewID();
    }
}
