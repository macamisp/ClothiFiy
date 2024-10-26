package controller.supplier;

import dto.EmployeeDTO;
import dto.SuplierDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import service.ServiceFactory;
import service.custom.EmployeeService;
import service.custom.SuplierService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SupplierController implements Initializable {
    private final SuplierService service = ServiceFactory.getInstance().getServiceType(ServiceType.SUPPLIER);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("SuplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblVIEW.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setTextToValue( newValue);
            }
        });

        loadTable();

        txtId.setText(generateSuplierId());
    }

    @FXML
    private TableView<SuplierDTO> tblVIEW;


        @FXML
        private TableColumn<?, ?> colAddress;

        @FXML
        private TableColumn<?, ?> colEmail;

        @FXML
        private TableColumn<?, ?> colId;

        @FXML
        private TableColumn<?, ?> colMobile;

        @FXML
        private TableColumn<?, ?> colName;

        @FXML
        private TextField txtAdress;

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtId;

        @FXML
        private TextField txtMobile;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtsearch;

        @FXML
        void addACTION(ActionEvent event) {
            SuplierDTO suplier = new SuplierDTO(
                    txtId.getText(),
                    txtName.getText(),
                    txtAdress.getText(),
                    txtMobile.getText(),
                    txtEmail.getText()
            );

            if(service.addSuplier(suplier)){
                new Alert(Alert.AlertType.INFORMATION,"Supplier Added").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
            loadTable();
            clearInputFields();

        }



        @FXML
        void deleteACTION(ActionEvent event) {
            if (service.deleteSuplier(  txtId.getText())) {
                new Alert(Alert.AlertType.INFORMATION, "Supplier remove successful !").show();
            } else {
                new Alert(Alert.AlertType.ERROR).show();
            }
            clearInputFields();
            loadTable();

        }



        @FXML
        void searchACTION(ActionEvent event) {
            setTextToValue(service.searchSuplier(txtsearch.getText()));

        }

        @FXML
        void updateACTION(ActionEvent event) {
            SuplierDTO suplier = new SuplierDTO(
                    txtId.getText(),
                    txtMobile.getText(),
                    txtName.getText(),
                    txtAdress.getText(),
                    txtEmail.getText()
            );

            if (isValidCustomerInputDetails(suplier)) {
                if (service.updateSuplier(suplier)) {
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

    private boolean isValidCustomerInputDetails(SuplierDTO suplierEntity) {
        if (suplierEntity.getSuplierId().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "SuplierID is required !").show();
            return false;
        }
        if (suplierEntity.getName().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Name is required.").show();
            return false;
        }

        if (suplierEntity.getAddress().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Address is required.").show();
            return false;
        }

        return true;
    }
    private void setTextToValue(SuplierDTO newValue) {
        txtId.setText(newValue.getSuplierId());
        txtName.setText(newValue.getName());
        txtMobile.setText(newValue.getMobile());
        txtAdress.setText(newValue.getAddress());
        txtEmail.setText(newValue.getEmail());
    }
    private void clearInputFields() {
        txtId.setText(generateSuplierId());
        txtName.setText("");
        txtAdress.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
    }
    private String generateSuplierId() {
        String base = "S";
        int integer = Integer.parseInt(service.generateSuplierId());
        if (integer < 10) {
            base += "00";
        } else if (integer < 100) {
            base += "0";

        }
        return base+(integer + 1);
    }
    private void loadTable() {
        ObservableList<SuplierDTO> SuplierObservableList = service.getAllSuplier();
        tblVIEW.setItems(SuplierObservableList);
    }
























    public void back4(ActionEvent event) {
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

    public void log4(ActionEvent event) {
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
