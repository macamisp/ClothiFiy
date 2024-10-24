package service.custom;

import dto.CustomerDTO;
import javafx.collections.ObservableList;
import service.Superservice;

public interface CustomerService extends Superservice {
    ObservableList<CustomerDTO> getCustomers();
    boolean addCustomer(CustomerDTO customerDTO);
    boolean updateCustomer(CustomerDTO customerDTO);
    boolean deleteCustomer(CustomerDTO customerDTO);
    CustomerDTO searchCustomer(String id);
}
