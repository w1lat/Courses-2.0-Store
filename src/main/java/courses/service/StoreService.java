package courses.service;

import courses.model.Product;
import courses.exception.*;

import java.util.List;


/**
 * Created by Vitalii on 21.01.2017.
 */
public interface StoreService {

    Product getProduct(int id) throws ProductNotFoundException;
    Product remove(int id) throws ProductNotFoundException;
    List<Product> getAllProducts() throws StoreIsEmptyException;
    List<Product> getAllProducts(Product filter) throws StoreIsEmptyException;
}
