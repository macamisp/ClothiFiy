package service.custom.impl;

import dto.CustomerDTO;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.CustomerDao;
import service.custom.CustomerService;
import util.DaoType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerImpl implements CustomerService {

    private CustomerDao customerDao = DaoFactory.getInstance().getDaoType(DaoType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customer) {
        return customerDao.save(customer);
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        return customerDao.delete(customerId);
    }

    @Override
    public CustomerDTO searchCustomer(String customerId) {
        return customerDao.search(customerId);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
      return   customerDao.update(customer);

    }

    @Override
    public String generateCustomerId() {
        String lastId = customerDao.findLastId();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(lastId);
        return (matcher.find()) ? matcher.group() : null;
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomers() {
        return customerDao.getAll();
    }
}
