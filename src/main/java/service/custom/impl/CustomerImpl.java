package service.custom.impl;

import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.CustomerDao;
import service.custom.CustomerService;
import util.DaoType;

public class CustomerImpl implements CustomerService {

    private CustomerDao customerDao = DaoFactory.getInstance().getDaoType(DaoType.CUSTOMER);
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public ObservableList<CustomerDTO> getCustomers() {
        return null;
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        return customerDao.save(modelMapper.map(customerDTO, Customer.class));

    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public boolean deleteCustomer(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        return null;
    }
}
