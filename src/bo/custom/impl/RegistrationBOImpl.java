package bo.custom.impl;

import bo.custom.RegistrationBo;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.ReserveDAOImpl;
import dto.ReserveDTO;
import entity.Reserve;
import entity.Room;
import entity.Student;

import java.io.IOException;
import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBo {

    private final ReserveDAOImpl dao = DAOFactory.getInstance().getDAO(DAOType.RESERVE);

    @Override
    public ArrayList<ReserveDTO> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean add(ReserveDTO reserveDTO) throws Exception {
        return dao.save(new Reserve(reserveDTO.getResId(), reserveDTO.getDate(), new Student(reserveDTO.getStudent()), new Room(reserveDTO.getRoom()), reserveDTO.getStatus()));
    }

    @Override
    public String generateNewID() throws IOException {
        return dao.generateNewID();
    }

    @Override
    public String count(String id) throws IOException {
        return dao.count(id);
    }

}
