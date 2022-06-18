package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.StudentBOImpl;

public class StudentFormController {

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.Student);

    public void initialize() {
     /*   Date date = new Date();
        try {
            studentBO.add(new StudentDTO("S002","kamal","negombo","0772759120", date,"male"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}
