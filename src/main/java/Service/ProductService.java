package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "candy", "sweet", 30.0));
        productMap.put(2, new Product(2, "book", "to read", 40.0));
        productMap.put(3, new Product(3, "note book", "to write", 50.0));
        productMap.put(4, new Product(4, "pencil", "write to the note book", 60.0));

    }
    public ArrayList<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public Product findById(int id) {
        return productMap.get(id);
    }
    public void remove(int id){
        productMap.remove(id);
    }
//
//    public static void main(String[] args) {
//        System.out.println(productMap.values());
//    }
}
