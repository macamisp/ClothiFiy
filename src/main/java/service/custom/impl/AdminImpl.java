package service.custom.impl;

import dto.AdminDTO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.AdminDao;
import repository.custom.CustomerDao;
import service.custom.AdminService;
import util.DaoType;

public class AdminImpl implements AdminService {
    private AdminDao adminDao = DaoFactory.getInstance().getDaoType(DaoType.ADMIN);

    @Override
    public ObservableList<AdminDTO> getAdmin() {
        return null;
    }

    @Override
    public boolean addAdmin(AdminDTO adminDTO) {
        return false;


    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) {
        return false;
    }

    @Override
    public boolean deleteAdmin(AdminDTO adminDTO) {
        return false;
    }

    @Override
    public CustomerDTO searchAdmin(String id) {
        return null;
    }
}
