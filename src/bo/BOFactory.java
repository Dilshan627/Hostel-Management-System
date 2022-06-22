package bo;

import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.RoomBOImpl;
import bo.custom.impl.StudentBOImpl;

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
                return (T) new StudentBOImpl();
            case ROOM:
                return (T) new RoomBOImpl();
            case RESERVE:
                return (T) new RegistrationBOImpl();
            default:
                return null;
        }
    }
}
