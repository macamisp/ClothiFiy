package controller.order;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class OrderController {
 @FXML
 public void back1(ActionEvent Event) {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Home/employeeHome.fxml"))));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            Window window = ((Stage) ((Node) Event.getSource()).getScene().getWindow());
            window.hide();
        }

    public void logout1(ActionEvent Event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/enteer/enterns.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) Event.getSource()).getScene().getWindow());
        window.hide();
    }
}

