package gb.spring.service;

import gb.spring.service.source.Product;

import java.util.List;

public interface ProductRepositoryService {

    Product getByName(String name);
    Product getById(int id);
    List<Product> getAllItems();

}
