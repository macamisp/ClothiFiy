package controller.employee;


import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.IOException;

public class LoginController {
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;

    public void logonaction(ActionEvent Event) {
        String userName = "sachin";
        String password = "12345";

        if(txtUserName.getText().equals(userName) && txtPassword.getText().equals(password)){

            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Home/employeeHome.fxml"))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Window window = ((Stage) ((Node) Event.getSource()).getScene().getWindow());
            window.hide();
        }else{
            new Alert(Alert.AlertType.ERROR,"Login Failed!").show();
        }

    }

    public void backonaction(ActionEvent event) {
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
