package gb.spring.service.impl;

import gb.spring.service.ProductRepositoryService;
import gb.spring.service.source.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class ProductRepository implements ProductRepositoryService {
    private List<Product> productList;

    @PostConstruct
    public void initRepository() {
        System.out.println("Updating product repository...");
        productList = new CopyOnWriteArrayList<>();
        productList.add(new Product(1, "Scanner", new BigDecimal(10)));
        productList.add(new Product(2, "Pencil", new BigDecimal(20)));
        productList.add(new Product(3, "Rocket", new BigDecimal(30)));
        productList.add(new Product(4, "Inverter", new BigDecimal(40)));
        productList.add(new Product(5, "Nail", new BigDecimal(50)));
        productList.add(new Product(6, "Gas", new BigDecimal(60)));
        System.out.println("Product repository update complete!");
        System.out.println("-----------------------------------------------------");
        productList.stream()
                .map(p -> "Product with ID " + p.getId() + ", with name: " + p.getName() + " in repository")
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
    }

    public Product getByName(String str) {
        return productList.stream()
                .filter(p -> p.getName()
                        .equalsIgnoreCase(str))
                .findFirst()
                .orElse(null);
    }

    public Product getById(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllItems() {
        return productList;
    }

}
