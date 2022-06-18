package controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane context;
    public AnchorPane slideContext;

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(context,"dashboard");
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(slideContext,"room");
    }
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(context,"login");
    }


}
