package controller.customer;

import dto.CustomerDTO;
import entity.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import service.ServiceFactory;
import service.custom.CustomerService;
import util.ServiceType;

import java.io.IOException;

public class CustomerController {
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearch;

    private final CustomerService service = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

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

    @FXML
    void btnAddOnAction(ActionEvent event) {
        CustomerDTO customer = new CustomerDTO(
                txtCustomerID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtMobile.getText(),
                txtEmail.getText()
        );

        if(service.addCustomer(customer)){
            new Alert(Alert.AlertType.INFORMATION,"Customer Added").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
}
