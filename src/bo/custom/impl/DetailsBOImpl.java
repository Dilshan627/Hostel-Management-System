package bo.custom.impl;

import bo.custom.DetailsBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.ReserveDAOImpl;
import dao.custom.impl.RoomDAOImpl;

import java.io.IOException;
import java.util.List;

public class DetailsBOImpl implements DetailsBO {

    private final RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);
    private final ReserveDAOImpl reserveDAO = DAOFactory.getInstance().getDAO(DAOType.RESERVE);

    @Override
    public List<String> roomId() throws IOException {
        return roomDAO.roomId();
    }

    @Override
    public List<String> StudentId() throws IOException {
        return reserveDAO.StudentId();
    }

    @Override
    public List<String> search(String id) throws IOException {
        return reserveDAO.search(id);
    }
}
