package repository.custom;

import dto.CustomerDTO;
import repository.CrudDao;

public interface CustomerDao extends CrudDao<CustomerDTO> {
    String findLastId();
}
