package service.custom;

import dto.ProductDTO;
import javafx.collections.ObservableList;
import service.Superservice;

public interface ProductService extends Superservice {
    boolean addProduct(ProductDTO  product);

    boolean deleteProduct(String productId);

    ProductDTO searchproduct(String search);

    boolean updateProduct(ProductDTO product);

    String generateProductId();

    ObservableList<ProductDTO> getAllProduct();
}
