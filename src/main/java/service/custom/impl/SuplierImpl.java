package service.custom.impl;

import dto.EmployeeDTO;
import dto.SuplierDTO;
import javafx.collections.ObservableList;
import repository.DaoFactory;
import repository.custom.SuplierDao;
import service.custom.SuplierService;
import util.DaoType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuplierImpl implements SuplierService {
    private SuplierDao suplierDao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);


    @Override
    public boolean addSuplier(SuplierDTO suplier) {
        return SuplierDao.save(suplier);
    }

    @Override
    public boolean deleteSuplier(String suplierId) {
        return SuplierDao.delete(suplierId);
    }

    @Override
    public EmployeeDTO searchSuplier(String search) {
        return suplierDao.search(search);
    }

    @Override
    public boolean updateSuplier(SuplierDTO suplier) {
        return suplierDao.update(suplier)    }

    @Override
    public String generateSuplierId() {

        String lastId = suplierDao.findLastId();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(lastId);
        return (matcher.find()) ? matcher.group() : null;
    }

    @Override
    public ObservableList<SuplierDTO> getAllSuplier() {
        ObservableList<SuplierDTO> suplierDTOObservableList = suplierDao.getAll();
        System.out.println(suplierDTOObservableList);
        return suplierDTOObservableList;
    }
}
