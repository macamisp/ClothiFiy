package service.custom;

import dto.CustomerDTO;
import javafx.collections.ObservableList;
import service.Superservice;

public interface CustomerService extends Superservice {
    boolean addCustomer(CustomerDTO customer);

    boolean deleteCustomer(String customerId);

    CustomerDTO searchCustomer(String search);

    boolean updateCustomer(CustomerDTO customer);

    String generateCustomerId();

    ObservableList<CustomerDTO> getAllCustomers();
}
