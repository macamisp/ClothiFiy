package controller.employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HomeController {





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

    public void produt(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Managemnet/ProductManage.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

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

    public void BACK(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Login/employee_Login.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

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

    public void etid(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/ editprofile/employeeedit.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Window window = ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        window.hide();
    }

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
}
