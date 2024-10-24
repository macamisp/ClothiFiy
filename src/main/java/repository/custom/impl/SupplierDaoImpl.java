package repository.custom.impl;

import entity.Supplier;
import javafx.collections.ObservableList;
import repository.SuperDAO;
import repository.custom.SuplierDao;

public class SupplierDaoImpl implements SuplierDao {
    @Override
    public boolean save(Supplier supplier) {
        return false;
    }

    @Override
    public boolean update(Supplier supplier) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<Supplier> findAll() {
        return null;
    }

    @Override
    public Supplier findById(String id) {
        return null;
    }
}
