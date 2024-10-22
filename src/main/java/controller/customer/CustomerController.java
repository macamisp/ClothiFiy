package controller.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class CustomerController {

@FXML
    public void bbba(ActionEvent event) {
    Stage stage = new Stage();
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Home/employeeHome.fxml"))));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
    window.hide();
    }
@FXML
    public void LOGOUT(ActionEvent event) {
    Stage stage = new Stage();
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/enteer/enterns.fxml"))));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
    window.hide();
}
}
