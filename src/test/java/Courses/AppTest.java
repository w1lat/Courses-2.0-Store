package Courses;

import courses.exception.ProductNotAddedException;
import courses.exception.ProductNotFoundException;
import courses.model.MobilePhone;
import courses.model.Notebook;
import courses.model.Product;
import courses.model.Store;
import courses.service.StoreServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void addProduct() throws Exception{
        Store store = new Store();
        StoreServiceImpl storeService = new StoreServiceImpl(store);
        Product product = new Notebook(1,"Samsung", 3, new Date(),1000000);
        Product addedProduct = null;
        try {
            addedProduct = storeService.addProduct(product);
        } catch (ProductNotAddedException e) {
            e.printStackTrace();
        }
        assertTrue(addedProduct.equals(product));
    }

    @Test
    public void getProduct() throws Exception{
        Store store = new Store();
        StoreServiceImpl storeService = new StoreServiceImpl(store);
        Product product = new Notebook(1,"Samsung", 3, new Date(),1000000);
        Product gotProduct = null;
        try {
            storeService.addProduct(product);
            gotProduct = storeService.getProduct(1);
        } catch (ProductNotAddedException e) {
            e.printStackTrace();
        }
        assertTrue(gotProduct.equals(product));
    }

    @Test
    public void getAllProducts() throws Exception{
        Store store = new Store();
        StoreServiceImpl storeService = new StoreServiceImpl(store);
        Product product1 = new Notebook(1,"Samsung", 3, new Date(),100000);
        Product product2 = new MobilePhone(2,"Nokia", 35, new Date(),50000);
        List<Product> gotProducts = null;
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        try {
            storeService.addProduct(product1);
            storeService.addProduct(product2);
            gotProducts = storeService.getAllProducts();
        } catch (ProductNotAddedException e) {
            e.printStackTrace();
        }
        assertTrue(gotProducts.equals(products));
    }

    @Test(expected = ProductNotFoundException.class)
    public void removeProduct() throws Exception{
        Store store = new Store();
        StoreServiceImpl storeService = new StoreServiceImpl(store);
        Product product = new Notebook(1,"Samsung", 3, new Date(),1000000);
        Product gotProduct = null;
        try {
            storeService.addProduct(product);
            gotProduct = storeService.getProduct(1);
        } catch (ProductNotAddedException e) {
            e.printStackTrace();
        }
        assertTrue(gotProduct.equals(product));
        storeService.remove(1);
        storeService.getProduct(1);
    }

    @Test
    public void getFilteredProducts() throws Exception{
        Store store = new Store();
        StoreServiceImpl storeService = new StoreServiceImpl(store);
        Product product1 = new Notebook(1,"Samsung", 3, new Date(),100000);
        Product product2 = new MobilePhone(2,"Nokia", 35, new Date(),50000);
        Product filterProduct = new Notebook(56,"Samsung", 3, new Date(),100000);
        List<Product> gotProducts = null;
        List<Product> products = new ArrayList<>();
        products.add(product1);
        try {
            storeService.addProduct(product1);
            storeService.addProduct(product2);
            gotProducts = storeService.getAllProducts(product1);
        } catch (ProductNotAddedException e) {
            e.printStackTrace();
        }
        assertTrue(gotProducts.equals(products));
    }


}
