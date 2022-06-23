package bo;

import bo.custom.impl.*;

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
            case DETAILS:
                return (T) new DetailsBOImpl();
            case LOGIN:
                return (T) new LoginBOImpl();
            case ACCOUNT:
                return (T) new AccountBOImpl();
            default:
                return null;
        }
    }
}
