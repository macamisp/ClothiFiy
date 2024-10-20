package controller.employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.EventObject;

public class EmployeeController {
    @FXML public void logonaction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Home/employeeHome.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }


@FXML
    public void backonaction(ActionEvent Event) {
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

    

