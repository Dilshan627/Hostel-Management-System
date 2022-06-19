package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DashboardFormController {
    public AnchorPane context;
    public AnchorPane slideContext;
    public Label lblTime;
    public Label lblDate;

    public void initialize() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(context, "dashboard");
    }

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(slideContext, "student");
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(slideContext, "room");
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        util.navigation.navigate(context, "login");
    }

}
