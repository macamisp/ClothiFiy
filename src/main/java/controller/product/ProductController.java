package controller.product;

import dto.ProductDTO;
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
import service.custom.ProductService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    private final ProductService service = ServiceFactory.getInstance().getServiceType(ServiceType.PRODUCT);


    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSise;

    @FXML
    private TableColumn<?, ?> colStock;

    @FXML
    private TableColumn<?, ?> colUnit;

    @FXML
    private TextField search;

    @FXML
    private TableView<ProductDTO> tblVIEW;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSise;

    @FXML
    private TextField txtStock;

    @FXML
    private TextField txtUnit;


    @FXML
    void back5(ActionEvent event) {
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
    void log5(ActionEvent event) {
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
    void searchbutton(ActionEvent event) {
        setTextToValue(service.searchproduct(search.getText()));

    }

    @FXML
    void updatebutton(ActionEvent event) {
        ProductDTO product = new ProductDTO(
                txtId.getText(),
                txtStock.getText(),
                txtName.getText(),
                txtSise.getText(),
                txtUnit.getText()
        );

        if (isValidCustomerInputDetails(product)) {
            if (service.updateProduct(product)) {
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

    private boolean isValidCustomerInputDetails(ProductDTO productEntity) {
        if (productEntity.getID().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "EmployeeID is required !").show();
            return false;
        }
        if (productEntity.getName().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Name is required.").show();
            return false;
        }

        if (productEntity.getPrice().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Address is required.").show();
            return false;
        }

        return true;
    }

    @FXML
    void addbutton(ActionEvent event) {
        ProductDTO product = new ProductDTO(
                txtId.getText(),
                txtName.getText(),
                txtSise.getText(),
                txtStock.getText(),
                txtUnit.getText()
        );

        if (service.addProduct(product)) {
            new Alert(Alert.AlertType.INFORMATION, "Product Added").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
        }
        loadTable();
        clearInputFields();

    }

    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colSise.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        colUnit.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tblVIEW.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setTextToValue((ProductDTO) newValue);
            }
        });

        loadTable();

        txtId.setText(generateProductId());


    }
    private void setTextToValue(ProductDTO newValue) {
        txtId.setText(newValue.getID());
        txtName.setText(newValue.getName());
        txtSise.setText(newValue.getPrice());
        txtStock.setText(newValue.getStock());
        txtUnit.setText(newValue.getPrice());
    }

    private void clearInputFields() {
        txtId.setText(generateProductId());
        txtName.setText("");
        txtSise.setText("");
        txtStock.setText("");
        txtUnit.setText("");
    }
    private String generateProductId() {
        String base = "P";
        int integer = Integer.parseInt(service.generateProductId());
        if (integer < 10) {
            base += "00";
        } else if (integer < 100) {
            base += "0";

        }
        return base+(integer + 1);
    }
    private void loadTable() {
        ObservableList<ProductDTO> productObservableList = service.getAllProduct();
        tblVIEW.setItems(productObservableList);
    }
         @FXML
         void deletebutton(ActionEvent event) {
             if (service.deleteProduct(txtId.getText())) {
                 new Alert(Alert.AlertType.INFORMATION, "Product remove successful !").show();
             } else {
                 new Alert(Alert.AlertType.ERROR).show();
             }
             clearInputFields();
             loadTable();

    }


    }

