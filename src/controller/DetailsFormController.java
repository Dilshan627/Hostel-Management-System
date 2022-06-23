package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.DetailsBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.DetailsTm;

import java.io.IOException;
import java.util.List;

public class DetailsFormController {
    public JFXComboBox<String> cmdRoomId;
    public JFXComboBox<String> cmdStudentId;
    private final DetailsBOImpl detailsBO = BOFactory.getInstance().getBO(BOType.DETAILS);
    public TableView<DetailsTm> tblData;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtGender;
    public JFXTextField txtContact;
    public JFXTextField txtDob;

    public void initialize() {
        tblData.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        cmdRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                tblData.getItems().clear();
                try {
                    List<String> list = detailsBO.search(newValue);
                    for (String Id : list) {
                        tblData.getItems().add(new DetailsTm(Id));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        cmdStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                try {
                    List<StudentDTO> studentDTO = detailsBO.searchStudent(newValue);
                    for (StudentDTO dto : studentDTO) {
                        txtName.setText(dto.getName());
                        txtAddress.setText(dto.getAddress());
                        txtContact.setText(dto.getContact());
                        txtDob.setText(dto.getDob());
                        txtGender.setText(dto.getGender());
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
