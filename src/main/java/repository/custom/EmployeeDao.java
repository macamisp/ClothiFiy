package repository.custom;

import dto.EmployeeDTO;
import repository.CrudDao;

public interface EmployeeDao extends CrudDao<EmployeeDTO> {
    String findLastId();
}
