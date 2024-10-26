package controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HomeController {
    public void Employeeaction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/employeeManege.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

    public void backadminlogin(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Login/admin_Login.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

    public void logut1(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/enteer/enterns.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

    public void customerbuton(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/customerManege.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

    public void viewreportsbutton(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Reports/reports.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

    public void supplierbutton(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/supplierManage.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

    public void productbutton(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/ProductManage.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        window.hide();
    }
}
