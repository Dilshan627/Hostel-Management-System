package controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane context;

    public void signOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(context,"dashboard");
    }
}
