package service.custom;


import dto.EmployeeDTO;
import javafx.collections.ObservableList;
import service.Superservice;

public interface EmployeeService extends Superservice {
    boolean addEmployee(EmployeeDTO employee);

    boolean deleteEmployee(String employeeId);

    EmployeeDTO searchEmployee(String search);

    boolean updateEmployee(EmployeeDTO employee);

    String generateEmployeeId();

    ObservableList<EmployeeDTO> getAllEmployee();
}

