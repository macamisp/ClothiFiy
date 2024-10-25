package repository.custom.impl;

import dto.AdminDTO;
import javafx.collections.ObservableList;
import repository.custom.AdminDao;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean save(AdminDTO admin) {
        return false;
    }

    @Override
    public ObservableList<AdminDTO> getAll() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public AdminDTO search(String id) {
        return null;
    }

    @Override
    public boolean update(AdminDTO admin) {
        return false;
    }
}