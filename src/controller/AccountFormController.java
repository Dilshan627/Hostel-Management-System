package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

public class AccountFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPassword;


    public void initialize() {
        txtUserName.setEditable(false);
        txtPassword.setEditable(false);
        txtConfirmPassword.setEditable(false);
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        txtUserName.setEditable(true);
        txtPassword.setEditable(true);
        txtConfirmPassword.setEditable(true);
        txtUserName.requestFocus();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        txtUserName.setEditable(false);
        txtPassword.setEditable(false);
        txtConfirmPassword.setEditable(false);
    }
}
