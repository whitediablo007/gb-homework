package gb.spring.service;

import gb.spring.service.source.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepositoryService productRepository;

    private Map<Product, Integer> map;


    public Cart() {
        this.map = new Hashtable<>();
    }

    @Autowired
    public void setProductRepository(ProductRepositoryService productRepository) {
        this.productRepository = productRepository;
    }

    public void getAll() {
        if (map.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            map.forEach((k, v) -> System.out.println(k.getName() + " - " + v + " x " + k.getCost() + " = " + v.intValue() * k.getCost().intValue()));
        }
    }

    public void addProduct(Product product, int amount) {
        map.merge(product, amount, Integer::sum);
        System.out.println("Product is added!");
    }

    public void addProduct(int id, int amount) {
        Product product = productRepository.getById(id);
        map.merge(product, amount, Integer::sum);
        System.out.println("Product: " + productRepository.getById(id).getName() + " added.");
    }

    public void remove(int id, int amount) {
        try {
            Product product = productRepository.getById(id);
            if (map.get(product) == amount || map.get(product) < amount) {
                map.remove(product);
            } else {
                map.put(product, map.get(product) - amount);
            }
            System.out.println(productRepository.getById(id).getName() + " removed.");
        }catch (Exception p){
            System.err.println("This product not found");
        }
    }


    public void clear() {
        map.clear();
        System.out.println("Cart cleared!");
    }

}
