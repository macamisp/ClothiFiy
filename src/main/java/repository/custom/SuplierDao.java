package repository.custom;


import dto.SuplierDTO;
import repository.CrudDao;

public interface SuplierDao extends CrudDao<SuplierDTO> {
    String findLastId();
}
