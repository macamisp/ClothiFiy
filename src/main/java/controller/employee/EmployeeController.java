package controller.employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;


public class EmployeeController {
@FXML
    public void logonaction(ActionEvent Event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Home/employeeHome.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((javafx.scene.Node) Event.getSource()).getScene().getWindow());
        window.hide();
        
    }
@FXML
    public void placeorder(ActionEvent event) {

            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Order/placeOrder.fxml"))));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
            window.hide();
        }
@FXML
    public void produt(ActionEvent event) {

            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/ItemManage.fxml"))));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
            window.hide();
        }
@FXML
    public void supplier(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/supplierManage.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        window.hide();
    }
@FXML
    public void reports(ActionEvent event) {
    Stage stage = new Stage();
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Reports/reports.fxml"))));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
    window.hide();
    }
@FXML
    public void custpomer(ActionEvent event) {
    Stage stage = new Stage();
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/customerManage.fxml"))));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
    window.hide();
    }
@FXML
    public void etid(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/employeeManege.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        window.hide();
    }
@FXML
    public void passwrd(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/reset/reset passweord.fxml"))));
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
@FXML
    public void BACK(ActionEvent event) {
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



    

