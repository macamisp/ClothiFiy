package controller.admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
public class AdminController {

@FXML
    public void LoginONACTION(ActionEvent Event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Home/admin_Home.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) Event.getSource()).getScene().getWindow());
        window.hide();
    }





















@FXML
    public void backONACTION(ActionEvent Event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/enteer/enterns.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) Event.getSource()).getScene().getWindow());
        window.hide();
    }
@FXML
public void back1(ActionEvent event) {
    Stage stage = new Stage();
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Home/admin_Home.fxml"))));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
    window.hide();
    }
}
