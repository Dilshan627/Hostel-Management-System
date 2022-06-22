package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import java.io.IOException;
import java.util.List;

public class RegistrationFormController {
    public JFXComboBox<String> cmbStudentId;
    public JFXComboBox cmbRoomId;
    public JFXDatePicker cmbDate;

    private final StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.Student);

    public void initialize() {
        studentIdLoad();
    }

    private void studentIdLoad() {
        try {
            List<String> list = studentBO.StudentId();
            for (String Id : list) {
                cmbStudentId.getItems().add(Id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
