package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.DetailsBOImpl;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.DetailsTm;

import java.io.IOException;
import java.util.List;

public class DetailsFormController {


    public TableView<DetailsTm> tblDetails;
    private final DetailsBOImpl detailsBO = BOFactory.getInstance().getBO(BOType.DETAILS);

    public void initialize() {
        tblDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));

        loadAll();
    }

    private void loadAll() {
        tblDetails.getItems().clear();
        try {
            List<Object[]> details = detailsBO.details();
            for (Object[] objects : details) {
                tblDetails.getItems().add(new DetailsTm(objects[0], objects[1], objects[2], objects[3], objects[4], objects[5], objects[6]));
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
