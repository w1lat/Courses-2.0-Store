package courses.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Vitalii on 21.01.2017.
 */
public class Store {

    private Map<Integer, Product> products;

    public Store() {
        products = new HashMap<>(10);
    }



    public Product getProduct(int id) {

        return products.get(id);
    }

    public Product remove(Product product) {

        products.remove(product.getId());

        return product;
    }

    public Map getProducts() {
        return products;
    }

    public Map getProducts(Product filter) {
        Map<Integer, Product> filteredProducts = products.entrySet().stream().filter(map -> map.getValue().getClass().equals(filter.getClass())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return filteredProducts;
    }

    public Product addProduct(Product product) {
        products.put(product.getId(), product);

        return product;
    }
}
