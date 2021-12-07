package by.s.bagautdinov.lesson3.service;

import by.s.bagautdinov.lesson3.model.Product;
import by.s.bagautdinov.lesson3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public List<Product> findAll() {

        return repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }
}
