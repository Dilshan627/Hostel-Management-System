package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.StudentBOImpl;
import dto.StudentDTO;

import java.time.LocalDate;
import java.util.Date;

public class StudentFormController {

    StudentBOImpl studentBO =BOFactory.getInstance().getBO(BOType.Student);
    public void initialize() {

    }
}
