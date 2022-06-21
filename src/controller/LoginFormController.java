package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane context;
    public Label lblLogin;
    public Label lblAccount;
    public JFXPasswordField txtConfirm;
    public JFXButton btnSlideSignIn;
    public JFXButton btnSlideSignup;
    public JFXButton btnSignIn;
    public JFXButton btnSignup;
    public JFXTextField txtShow;
    public JFXPasswordField txtPassword;
    public JFXButton btnHide;
    public JFXButton btnShow;

    public void signOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(context, "dashboard");

    }

    public void signupOnAction(ActionEvent actionEvent) {
        lblLogin.setVisible(false);
        lblAccount.setVisible(true);
        txtConfirm.setVisible(true);

        btnSignup.setVisible(false);
        btnSignIn.setVisible(false);

        btnSlideSignup.setVisible(true);
        btnSlideSignIn.setVisible(true);


    }

    public void slideSignOnAction(ActionEvent actionEvent) {
        lblLogin.setVisible(true);
        lblAccount.setVisible(false);
        txtConfirm.setVisible(false);

        btnSignup.setVisible(true);
        btnSignIn.setVisible(true);

        btnSlideSignup.setVisible(false);
        btnSlideSignIn.setVisible(false);
    }

    public void slideSignupOnAction(ActionEvent actionEvent) {
    }

    public void passwordShowOnAction(ActionEvent actionEvent) {
        txtShow.setVisible(true);
        txtPassword.setVisible(false);
        txtShow.requestFocus();

        btnShow.setVisible(false);
        btnHide.setVisible(true);

        txtShow.setText(txtPassword.getText());

    }

    public void passwordHideOnAction(ActionEvent actionEvent) {
        txtShow.setVisible(false);
        txtPassword.setVisible(true);
        txtPassword.requestFocus();

        btnShow.setVisible(true);
        btnHide.setVisible(false);

        txtPassword.setText(txtShow.getText());
    }
}
