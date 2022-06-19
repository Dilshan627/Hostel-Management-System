package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import view.tm.RoomTM;
import view.tm.StudentTm;

import java.util.ArrayList;
import java.util.Arrays;

public class RoomFormController {
    public JFXTextField txtPrice;
    public JFXTextField txtQty;
    public JFXComboBox txtType;
    public Label txtId;
    public TableView tblRoom;
    public JFXButton btnAdd;

    public void initialize(){


        txtId.setText(generateNewId());
    }

    public void addOnAction(ActionEvent actionEvent) {
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    private String generateNewId() {
        if (tblRoom.getItems().isEmpty()) {
            return "R00-001";

        } else {
            String id = getLastItemId();
            int newItemId = Integer.parseInt(id.replace("R00-", "")) + 1;
            return String.format("R00-%03d", newItemId);
        }
    }

    private String getLastItemId() {
        ArrayList<RoomTM> tempItemList = new ArrayList<>(tblRoom.getItems());
        Arrays.sort(new ArrayList[]{tempItemList});
        return tempItemList.get(tempItemList.size() - 1).getRoomId();
    }
}
