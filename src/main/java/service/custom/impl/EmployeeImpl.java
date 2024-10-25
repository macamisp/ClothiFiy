package service.custom.impl;

import dto.EmployeeDTO;
import javafx.collections.ObservableList;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import service.custom.EmployeeService;
import util.DaoType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  EmployeeImpl implements EmployeeService {
    private EmployeeDao employeeDao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);

    @Override
    public boolean addEmployee(EmployeeDTO employee) {
        return employeeDao.save(employee);
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        return employeeDao.delete(employeeId);
    }

    @Override
    public EmployeeDTO searchEmployee(String search) {
        return employeeDao.search(search);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employee) {
        return employeeDao.update(employee);
    }

    @Override
    public String generateEmployeeId() {
        String lastId = employeeDao.findLastId();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(lastId);
        return (matcher.find()) ? matcher.group() : null;
    }

    @Override
    public ObservableList<EmployeeDTO> getAllEmployee() {
        ObservableList<EmployeeDTO> employeeDTOObservableList = employeeDao.getAll();
        System.out.println(employeeDTOObservableList);
        return employeeDTOObservableList;
    }
}
