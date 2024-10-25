package repository.custom.impl;


import dto.CustomerDTO;
import dto.EmployeeDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.custom.EmployeeDao;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public boolean save(EmployeeDTO employee) {
        String SQL = "INSERT INTO employee VALUES (?,?,?,?,?)";

        try {
            return CrudUtil.execute(SQL, employee.getEmployeeId(), employee.getName(), employee.getMobile(),employee.getAddress(), employee.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public ObservableList<EmployeeDTO> getAll() {

        ObservableList<EmployeeDTO> employeeObservableList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM employee";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL);
            while (resultSet.next()) {
                employeeObservableList.add(new EmployeeDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            return employeeObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        String SQL = "DELETE FROM employee WHERE id = ?";
        try {
            return CrudUtil.execute(SQL,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO search(String id) {
        String SQL = "SELECT * FROM employee WHERE id = ?";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL,id);
            if (resultSet.next()) {
                return new EmployeeDTO(
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
    public boolean update(EmployeeDTO employee) {
        String SQL = "UPDATE employee SET Namne = ?, address = ?, mobile = ?, email = ?  WHERE id=?";
        try {
            return CrudUtil.execute(SQL,
                    employee.getName(),
                    employee.getAddress(),
                    employee.getMobile(),
                    employee.getEmail(),
                    employee.getEmployeeId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String findLastId() {
        String SQL = "SELECT MAX(id) FROM employee";
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
