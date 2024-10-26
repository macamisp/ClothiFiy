package service.custom.impl;

import dto.ProductDTO;
import javafx.collections.ObservableList;
import repository.DaoFactory;
import repository.custom.ProductDao;
import service.custom.ProductService;
import util.DaoType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductImpl implements ProductService {
    private ProductDao productDao= DaoFactory.getInstance().getDaoType(DaoType.PRODUCT);
    @Override
    public boolean addProduct(ProductDTO product) {
        return productDao.save(product);
    }

    @Override
    public boolean deleteProduct(String productId) {
        return productDao.delete(productId);
    }

    @Override
    public ProductDTO searchproduct(String search) {
        return (ProductDTO) productDao.search(search);    }

    @Override
    public boolean updateProduct(ProductDTO product) {
        return productDao.update(product);    }

    @Override
    public String generateProductId() {
        String lastId = productDao.findLastId();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(lastId);
        return (matcher.find()) ? matcher.group() : null;
    }

    @Override
    public ObservableList<ProductDTO> getAllProduct() {
        ObservableList<ProductDTO> productDTOObservableList = productDao.getAll();
        System.out.println(productDTOObservableList);
        return productDTOObservableList;    }
}
