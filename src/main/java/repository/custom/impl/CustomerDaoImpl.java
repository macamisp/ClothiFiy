package repository.custom.impl;

import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.custom.CustomerDao;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(CustomerDTO customer) {
        String SQL = "INSERT INTO customer VALUES (?,?,?,?,?)";

        try {
            return CrudUtil.execute(SQL, customer.getId(), customer.getName(), customer.getAddress(), customer.getMobile(), customer.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<CustomerDTO> getAll() {
        ObservableList<CustomerDTO> customerObservableList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM customer";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL);
            while (resultSet.next()) {
                customerObservableList.add(new CustomerDTO(
                        resultSet.getString("id"),
                        resultSet.getString("namne"),
                        resultSet.getString("address"),
                        resultSet.getString("mobile"),
                        resultSet.getString("email")
                ));
            }
            return customerObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(CustomerDTO customer) {
        String SQL = "UPDATE customer SET Namne = ?, address = ?, mobile = ?, email = ?  WHERE id=?";
        try {
            return CrudUtil.execute(SQL,
                    customer.getName(),
                    customer.getAddress(),
                    customer.getMobile(),
                    customer.getEmail(),
                    customer.getId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean delete(String id) {
        String SQL = "DELETE FROM customer WHERE id = ?";
        try {
            return CrudUtil.execute(SQL,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public CustomerDTO search(String id) {
        String SQL = "SELECT * FROM customer WHERE id = ?";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL,id);
            if (resultSet.next()) {
                return new CustomerDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String findLastId() {
        String SQL = "SELECT MAX(id) FROM customer";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL);
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
