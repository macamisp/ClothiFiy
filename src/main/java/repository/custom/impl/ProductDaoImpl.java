package repository.custom.impl;

import dto.ProductDTO;
import dto.SuplierDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.custom.ProductDao;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {


    @Override
    public boolean save(ProductDTO productDTO) {
        String SQL = "INSERT INTO product VALUES (?,?,?,?,?)";

        try {
            return CrudUtil.execute(SQL,   productDTO.getID(), productDTO.getName(), productDTO.getSize(),productDTO.getPrice(), productDTO.getStock());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList getAll() {
        ObservableList<ProductDTO> ProductObservableList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM product";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL);
            while (resultSet.next()) {
                ProductObservableList.add(new ProductDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            return ProductObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        String SQL = "DELETE FROM product WHERE id = ?";
        try {
            return CrudUtil.execute(SQL,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }     }

    @Override
    public ProductDTO search(String id) {
        String SQL = "SELECT * FROM product WHERE id = ?";
        try {
            ResultSet resultSet = CrudUtil.execute(SQL,id);
            if (resultSet.next()) {
                return new ProductDTO(
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
        return null;}

    @Override
    public boolean update(ProductDTO productDTO) {
        String SQL = "UPDATE product SET  price = ?,  Name = ?,  size = ?, Stock = ?  WHERE ID=?";
        try {
            return CrudUtil.execute(SQL,
                    productDTO.getName(),
                    productDTO.getSize(),
                    productDTO.getPrice(),
                    productDTO.getStock(),
                    productDTO.getID()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String findLastId() {
        String SQL = "SELECT MAX(id) FROM   product";
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
    }


