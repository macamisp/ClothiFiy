package repository.custom.impl;
import dto.SuplierDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.custom.SuplierDao;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDaoImpl implements SuplierDao {

    @Override
    public String findLastId() {

            String SQL = "SELECT MAX(id) FROM   suplier";
            try {
                ResultSet resultSet = CrudUtil.execute(SQL);
                if (resultSet.next()) {
                    return resultSet.getString(1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;


    }

    @Override
    public boolean save(SuplierDTO suplierDTO) {
        String SQL = "INSERT INTO suplier VALUES (?,?,?,?,?)";

        try {
            return CrudUtil.execute(SQL,   suplierDTO.getSuplierId(), suplierDTO.getName(), suplierDTO.getMobile(),suplierDTO.getAddress(), suplierDTO.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<SuplierDTO> getAll() {
        ObservableList<SuplierDTO> suplierObservableList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM suplier";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL);
            while (resultSet.next()) {
                suplierObservableList.add(new SuplierDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            return suplierObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public boolean delete(String id) {
        String SQL = "DELETE FROM suplier WHERE id = ?";
        try {
            return CrudUtil.execute(SQL,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public SuplierDTO search(String id) {
        String SQL = "SELECT * FROM suplier WHERE id = ?";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL,id);
            if (resultSet.next()) {
                return new SuplierDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)

                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean update(SuplierDTO suplierDTO) {
        String SQL = "UPDATE suplier SET Namne = ?, address = ?, mobile = ?, email = ?  WHERE id=?";
        try {
            return CrudUtil.execute(SQL,
                    suplierDTO.getName(),
                    suplierDTO.getAddress(),
                    suplierDTO.getMobile(),
                    suplierDTO.getEmail(),
                    suplierDTO.getSuplierId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }
}
