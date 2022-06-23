package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.AccountBOImpl;
import bo.custom.impl.LoginBOImpl;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.DAOType;
import dto.UserDTO;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.List;

public class AccountFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPassword;

    private final AccountBOImpl accountBO = BOFactory.getInstance().getBO(BOType.ACCOUNT);
    static String userName;
    public void initialize() {

        txtUserName.setEditable(false);
        txtPassword.setEditable(false);
        txtConfirmPassword.setEditable(false);
        loadDate();
    }

    private void loadDate() {
        try {
            List<UserDTO> list = accountBO.search(userName);
            for (UserDTO dto:list) {
                txtUserName.setText(dto.getUserName());
                txtPassword.setText(dto.getPassword());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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


    public static void username(String id) {
        userName = id;
        System.out.println(id);
    }
}
