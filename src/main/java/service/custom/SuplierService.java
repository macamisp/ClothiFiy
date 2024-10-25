package service.custom;

import dto.EmployeeDTO;
import dto.SuplierDTO;
import javafx.collections.ObservableList;
import repository.custom.SuplierDao;
import service.Superservice;

public interface SuplierService extends Superservice {
    boolean addSuplier(SuplierDTO suplier);

    boolean deleteSuplier(String suplierId);

    SuplierDTO searchSuplier(String search);

    boolean updateSuplier(SuplierDTO suplier);

    String generateSuplierId();

    ObservableList<SuplierDTO> getAllSuplier();
}
