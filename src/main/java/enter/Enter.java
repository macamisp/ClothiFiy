package enter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
public class Enter {
    @FXML
    public void ADMINONACTION(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Login/admin_Login.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

@FXML
    public void CASHIERONACTION(ActionEvent event) {
    Stage stage = new Stage();
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Login/cashier_Login.fxml"))));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
    window.hide();
    }
}
