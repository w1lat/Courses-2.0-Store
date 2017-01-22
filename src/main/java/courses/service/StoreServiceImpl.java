package courses.service;

import courses.model.Product;
import courses.model.Store;
import courses.exception.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Vitalii on 21.01.2017.
 */
public class StoreServiceImpl implements StoreService{

    private Store store;

    public StoreServiceImpl(Store store) {
        this.store = store;
    }

    public Product addProduct(Product product) throws ProductNotAddedException {
        Product addedProduct = store.addProduct(product);
        if(addedProduct == null){
            throw new ProductNotAddedException("Product was not added");
        }

        return addedProduct;
    }

    public Product getProduct(int id) throws ProductNotFoundException {
        Product product = store.getProduct(id);
        if(product == null){
            throw new ProductNotFoundException("Product was not found");
        }
        return product;
    }

    public Product remove(int id) throws ProductNotFoundException {
        Product product = store.getProduct(id);
        if(product == null){
            throw new ProductNotFoundException("Product was not found");
        }
        store.remove(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() throws StoreIsEmptyException {
        Map<Integer, Product> products = store.getProducts();
        List<Product> allProducts = products.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        if(allProducts.isEmpty()){
            throw new StoreIsEmptyException("Sorry but store is empty, add some products");
        }
        return allProducts;
    }

    @Override
    public List<Product> getAllProducts(Product filter) throws StoreIsEmptyException {
        Map<Integer, Product> products = store.getProducts(filter);
        List<Product> allProducts = products.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        if(allProducts.isEmpty()){
            throw new StoreIsEmptyException("Sorry but store is empty, add some products");
        }
        return allProducts;
    }


}
