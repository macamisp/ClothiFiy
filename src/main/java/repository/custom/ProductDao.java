package repository.custom;


import dto.ProductDTO;
import repository.CrudDao;

public interface ProductDao extends CrudDao<ProductDTO> {
    String findLastId();
}
