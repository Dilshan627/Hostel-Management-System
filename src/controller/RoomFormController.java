package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.RoomBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.RoomTM;

import java.util.ArrayList;
import java.util.Arrays;

public class RoomFormController {
    public JFXTextField txtPrice;
    public JFXTextField txtQty;
    public JFXComboBox<String> txtType;
    public Label txtId;
    public TableView<RoomTM> tblRoom;
    public JFXButton btnAdd;

    private final RoomBOImpl roomBO = BOFactory.getInstance().getBO(BOType.ROOM);

    public void initialize() {
        tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("rent"));
        tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        txtType.getItems().add("AC");
        txtType.getItems().add("AC/Food ");
        txtType.getItems().add("Non-AC");
        txtType.getItems().add("Non-AC/Food");
        loadAllRoom();
        txtId.setText(generateNewId());
    }

    private void loadAllRoom() {
        tblRoom.getItems().clear();

        ArrayList<RoomDTO> allRoom = null;
        try {
            allRoom = roomBO.getAll();
            for (RoomDTO room : allRoom) {
                tblRoom.getItems().add(new RoomTM(room.getRoomId(), room.getType(), room.getRent(), room.getQty()));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void addOnAction(ActionEvent actionEvent) {
        int qty= Integer.parseInt(txtQty.getText());
        try {
            roomBO.add(new RoomDTO(txtId.getText(),txtType.getValue(),txtPrice.getText(),qty));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
