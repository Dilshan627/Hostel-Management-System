package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.DetailsBOImpl;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.DetailsTm;

import java.io.IOException;
import java.util.List;

public class DetailsFormController {
    public JFXComboBox cmdRoomId;
    public JFXComboBox cmdStudentId;
    private final DetailsBOImpl detailsBO = BOFactory.getInstance().getBO(BOType.DETAILS);
    public TableView<DetailsTm> tblData;

    public void initialize() {
        tblData.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        cmdRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                tblData.getItems().clear();
                try {
                    List<String> list = detailsBO.roomId();
                    for (String Id : list) {
                        tblData.getItems().add(new DetailsTm(Id));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        roomIdLoad();
        studentIdLoad();
    }

    private void roomIdLoad() {
        try {
            List<String> list = detailsBO.roomId();
            for (String Id : list) {
                cmdRoomId.getItems().add(Id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void studentIdLoad() {
        try {
            List<String> list = detailsBO.StudentId();
            for (String Id : list) {
                cmdStudentId.getItems().add(Id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
