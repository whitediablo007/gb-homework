package by.s.bagautdinov.lesson3.repository;

import by.s.bagautdinov.lesson3.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> productDB;

    public ProductRepository() {
        this.productDB = new CopyOnWriteArrayList<>();
        productDB.add(Product.builder()
                .id(1L)
                .title("Pen")
                .cost(new BigDecimal(10))
                .build());
    }

    public List<Product> findAll() {
        System.err.println(productDB.stream().collect(Collectors.toUnmodifiableList()));
        return productDB.stream().collect(Collectors.toUnmodifiableList());
    }

    public Optional<Product> findById(Long id) {
        return productDB.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(productDB.size() + 1L);
        }
        productDB.add(product);
    }
}
