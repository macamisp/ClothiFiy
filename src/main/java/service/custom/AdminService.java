package service.custom;

import dto.AdminDTO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import service.Superservice;

public interface AdminService extends Superservice {
    ObservableList<AdminDTO> getAdmin();
    boolean addAdmin(AdminDTO adminDTO);
    boolean updateAdmin(AdminDTO adminDTO);
    boolean deleteAdmin(AdminDTO adminDTO);
    CustomerDTO searchAdmin(String id);
}
