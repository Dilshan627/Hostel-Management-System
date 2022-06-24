package bo.custom.impl;

import bo.custom.DashboardBo;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.ReserveDAOImpl;
import dao.custom.impl.StudentDAOImpl;

import java.io.IOException;

public class DashboardBoImpl implements DashboardBo {
    private final StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    private final ReserveDAOImpl dao = DAOFactory.getInstance().getDAO(DAOType.RESERVE);

    @Override
    public String allCount() throws IOException {
        return studentDAO.allCount();
    }

    @Override
    public String allRegCount() throws IOException {
        return dao.allCount();
    }
}
