package bo.custom.impl;

import bo.custom.DetailsBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.ReserveDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetailsBOImpl implements DetailsBO {
    private final QueryDAOImpl queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);

    @Override
    public List<Object[]> details() throws IOException {
        return queryDAO.details();
    }


}
