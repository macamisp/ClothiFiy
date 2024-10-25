package controller.employee;

import dto.EmployeeDTO;
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
import service.custom.EmployeeService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class manageController implements Initializable {
    private final EmployeeService service = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);




        @FXML
        private TableColumn<?, ?> colAddrees;

        @FXML
        private TableColumn<?, ?> colEmail;

        @FXML
        private TableColumn<?, ?> colId;

        @FXML
        private TableColumn<?, ?> colMobile;

        @FXML
        private TableColumn<?, ?> colName;

        @FXML
        private TableView<EmployeeDTO> tblVIEW;

        @FXML
        private TextField txtAddress;

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtID;

        @FXML
        private TextField txtMobile;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtsearch;




        public void back(ActionEvent event) {
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

        public void log(ActionEvent event) {
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


        public void delete(ActionEvent event) {
            if (service.deleteEmployee(txtID.getText())) {
                new Alert(Alert.AlertType.INFORMATION, "Employee remove successful !").show();
            } else {
                new Alert(Alert.AlertType.ERROR).show();
            }
            clearInputFields();
            loadTable();
        }

        public void addEmployee(ActionEvent event) {
            EmployeeDTO employee = new EmployeeDTO(
                    txtID.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtMobile.getText(),
                    txtEmail.getText()
            );

            if(service.addEmployee(employee)){
                new Alert(Alert.AlertType.INFORMATION,"Employee Added").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
            loadTable();
            clearInputFields();

        }
        public void update(ActionEvent event) {
            EmployeeDTO employee = new EmployeeDTO(
                    txtID.getText(),
                    txtMobile.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtEmail.getText()
            );

            if (isValidCustomerInputDetails(employee)) {
                if (service.updateEmployee(employee)) {
                    new Alert(Alert.AlertType.INFORMATION, "Employee updated successful !").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Employee not updated :(").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Please fill out all fields correctly !").show();
            }
            loadTable();
            clearInputFields();

        }
    private boolean isValidCustomerInputDetails(EmployeeDTO customerEntity) {
        if (customerEntity.getEmployeeId().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "EmployeeID is required !").show();
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
        colId.setCellValueFactory(new PropertyValueFactory<>("EmployeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colAddrees.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblVIEW.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setTextToValue( newValue);
            }
        });

        loadTable();


    }
    private void setTextToValue(EmployeeDTO newValue) {
        txtID.setText(newValue.getEmployeeId());
        txtName.setText(newValue.getName());
        txtMobile.setText(newValue.getMobile());
        txtAddress.setText(newValue.getAddress());
        txtEmail.setText(newValue.getEmail());
    }

    private void clearInputFields() {
        txtID.setText(generateEmployeeId());
        txtName.setText("");
        txtAddress.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
    }
    private String generateEmployeeId() {
        String base = "E";
        int integer = Integer.parseInt(service.generateEmployeeId());
        if (integer < 10) {
            base += "00";
        } else if (integer < 100) {
            base += "0";

        }
        return base+(integer + 1);
    }

    private void loadTable() {
    ObservableList<EmployeeDTO> employeeObservableList = service.getAllEmployee();
        tblVIEW.setItems(employeeObservableList);
    }




    public void search(ActionEvent event) {
        setTextToValue(service.searchEmployee(txtsearch.getText()));
    }
}
