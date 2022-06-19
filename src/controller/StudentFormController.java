package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentFormController {

    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXComboBox<String> cmdGender;
    public JFXButton btnAdd;
    public Label txtId;
    public JFXDatePicker txtDob;
    public TableView<StudentTm> tblStudent;

    private final StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.Student);

    public void initialize() {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
        cmdGender.getItems().add("Male");
        cmdGender.getItems().add("Female");

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnAdd.setText(newValue != null ? "Update" : "Add");
            if (newValue != null) {
                txtId.setText(newValue.getStudentId());
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtContact.setText(newValue.getContact());
                txtDob.setValue(LocalDate.parse(newValue.getDob()));
                cmdGender.setValue(newValue.getGender());

            }
        });

        loadAllStudent();
        txtId.setText(generateNewId());
    }

    private void loadAllStudent() {
        tblStudent.getItems().clear();

        ArrayList<StudentDTO> allStudent = null;
        try {
            allStudent = studentBO.getAll();
            for (StudentDTO student : allStudent) {
                tblStudent.getItems().add(new StudentTm(student.getStudentId(), student.getName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void addOnAction(ActionEvent actionEvent) {
        if (!txtName.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtContact.getText().isEmpty() && !cmdGender.getValue().isEmpty()) {
            String code = txtId.getText();
            String dob = String.valueOf(txtDob.getValue());
            if (btnAdd.getText().equalsIgnoreCase("Add")) {
                try {
                    studentBO.add(new StudentDTO(txtId.getText(), txtName.getText(), txtAddress.getText(), txtContact.getText(), String.valueOf(txtDob.getValue()), cmdGender.getValue()));

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else {
                try {
                    studentBO.update(new StudentDTO(txtId.getText(), txtName.getText(), txtAddress.getText(), txtContact.getText(), dob, cmdGender.getValue()));

                    StudentTm selectedStudent = tblStudent.getSelectionModel().getSelectedItem();
                    selectedStudent.setStudentId(txtId.getText());
                    selectedStudent.setName(txtName.getText());
                    selectedStudent.setAddress(txtAddress.getText());
                    selectedStudent.setContact(txtContact.getText());
                    selectedStudent.setDob(dob);
                    selectedStudent.setGender(cmdGender.getValue());
                    tblStudent.refresh();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } else {

        }
        loadAllStudent();
        txtId.setText(generateNewId());
    }

    public void newOnAction(ActionEvent actionEvent) {
        txtId.setText(generateNewId());
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtDob.getEditor().clear();
        btnAdd.setText("Add");
        cmdGender.setValue("");
        txtName.requestFocus();
        tblStudent.getSelectionModel().clearSelection();
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        if (!txtName.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtContact.getText().isEmpty() && !cmdGender.getValue().isEmpty()) {
            String code = tblStudent.getSelectionModel().getSelectedItem().getStudentId();

            try {
                studentBO.delete(code);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
            tblStudent.getSelectionModel().clearSelection();

        }
    }

    private String generateNewId() {
        if (tblStudent.getItems().isEmpty()) {
            return "S00-001";

        } else {
            String id = getLastItemId();
            int newItemId = Integer.parseInt(id.replace("S00-", "")) + 1;
            return String.format("S00-%03d", newItemId);
        }
    }

    private String getLastItemId() {
        ArrayList<StudentTm> tempItemList = new ArrayList<>(tblStudent.getItems());
        Arrays.sort(new ArrayList[]{tempItemList});
        return tempItemList.get(tempItemList.size() - 1).getStudentId();
    }


}
