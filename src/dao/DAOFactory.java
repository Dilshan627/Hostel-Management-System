package dao;

import dao.custom.impl.RegistrationDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType) {
        switch (daoType) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ROOM:
                return (T) new RoomDAOImpl();
            case RESERVE:
                return (T) new RegistrationDAOImpl();
            default:
                return null;
        }
    }

}
