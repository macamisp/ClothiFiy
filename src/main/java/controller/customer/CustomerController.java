package controller.customer;

import dto.CustomerDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import service.ServiceFactory;
import service.custom.CustomerService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    private TableView<CustomerDTO> tablview;

    @FXML
    private TableColumn<?,?> colID;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colName;

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
        loadTable();
        clearInputFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (service.deleteCustomer(txtCustomerID.getText())) {
            new Alert(Alert.AlertType.INFORMATION, "Customer remove successful !").show();
        } else {
            new Alert(Alert.AlertType.ERROR).show();
        }
        clearInputFields();
        loadTable();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        CustomerDTO customer = new CustomerDTO(
                txtCustomerID.getText(),
                txtMobile.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtEmail.getText()
        );

        if (isValidCustomerInputDetails(customer)) {
            if (service.updateCustomer(customer)) {
                new Alert(Alert.AlertType.INFORMATION, "Customer updated successful !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Customer not updated :(").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please fill out all fields correctly !").show();
        }
        loadTable();
        clearInputFields();


    }
    private boolean isValidCustomerInputDetails(CustomerDTO customerEntity) {
        if (customerEntity.getId().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "CustomerId is required !").show();
            return false;
        }
        if (customerEntity.getName().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Name is required.").show();
            return false;
        }

        if (customerEntity.getAddress().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Address is required.").show();
            return false;
        }

        return true;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tablview.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setTextToValue(newValue);
            }
        });

        loadTable();
        txtCustomerID.setText(generateCustomerId());
    }

    private void setTextToValue(CustomerDTO newValue) {
        txtCustomerID.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtMobile.setText(newValue.getMobile());
        txtAddress.setText(newValue.getAddress());
        txtEmail.setText(newValue.getEmail());
    }

    private void clearInputFields() {
        txtCustomerID.setText(generateCustomerId());
        txtName.setText("");
        txtAddress.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
    }

    private String generateCustomerId() {
        String base = "C";
        int integer = Integer.parseInt(service.generateCustomerId());
        if (integer < 10) {
            base += "00";
        } else if (integer < 100) {
            base += "0";

        }
        return base+(integer + 1);
    }

    private void loadTable() {
        ObservableList<CustomerDTO> customerObservableList = service.getAllCustomers();
        tablview.setItems(customerObservableList);
    }


    public void searchonAction(ActionEvent event) {
        setTextToValue(service.searchCustomer(txtSearch.getText()));
    }
}
