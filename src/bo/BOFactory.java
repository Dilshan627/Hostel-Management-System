package bo;

import dao.custom.impl.StudentDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType) {
            case Student:
                return (T) new StudentDAOImpl();
            default:
                return null;
        }
    }
}
