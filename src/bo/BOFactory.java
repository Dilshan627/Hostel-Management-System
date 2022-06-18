package bo;

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
            default:
                return null;
        }
    }
}
