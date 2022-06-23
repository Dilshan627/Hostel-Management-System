package bo.custom.impl;

import bo.custom.DetailsBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.ReserveDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dto.CustomDTO;
import dto.StudentDTO;
import entity.Custom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetailsBOImpl implements DetailsBO {

    private final RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);
    private final ReserveDAOImpl reserveDAO = DAOFactory.getInstance().getDAO(DAOType.RESERVE);

    private final QueryDAOImpl queryDAO=DAOFactory.getInstance().getDAO(DAOType.QUERY);

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

    @Override
    public List<CustomDTO> studentDetails(String Id) throws IOException {
        List<Custom> customs = queryDAO.studentDetails(Id);
        List<CustomDTO> list = new ArrayList<>();
        for (Custom custom:customs) {
            list.add(new CustomDTO(custom.getName(),custom.getAddress(),custom.getContact(),custom.getDob(),custom.getGender(),custom.getRooId(),custom.getDate()));
        }
        return list;
    }

}
