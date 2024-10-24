package repository.custom.impl;

import entity.Customer;
import javafx.collections.ObservableList;
import repository.custom.CustomerDao;
import util.CrudUtil;

import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer customer) {
        String SQL = "INSERT INTO customer VALUES (?,?,?,?,?)";

        try {
            return CrudUtil.execute(SQL, customer.getId(), customer.getName(), customer.getAddress(), customer.getMobile(), customer.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(String id) {
        return null;
    }
}
