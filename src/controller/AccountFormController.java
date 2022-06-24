package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.AccountBOImpl;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.List;

public class AccountFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPassword;

    private final AccountBOImpl accountBO = BOFactory.getInstance().getBO(BOType.ACCOUNT);
    static String userName;
    public String loadUser;

    public void initialize() {

        txtUserName.setEditable(false);
        txtPassword.setEditable(false);
        txtConfirmPassword.setEditable(false);
        loadDate();
    }

    private void loadDate() {
        try {
            List<UserDTO> list = accountBO.search(userName);
            for (UserDTO dto : list) {
                loadUser = dto.getUserName();
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


        if (!txtUserName.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            if (txtPassword.getText().equals(txtConfirmPassword.getText())) {
                try {
                    accountBO.delete(loadUser);
                    accountBO.save(new UserDTO(txtUserName.getText(), txtPassword.getText()));
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, "Invalid user name").show();
                    throw new RuntimeException(e);
                }

            } else new Alert(Alert.AlertType.ERROR, "Invalid Data").show();

        } else new Alert(Alert.AlertType.ERROR, "Invalid Data").show();

    }

    public static void username(String id) {
        userName = id;
    }
}
