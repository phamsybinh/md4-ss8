package ra.orm.service;

import ra.orm.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(int page,int size);
    void save(Product product);
    Product findById(int id);
    void remove(int id);
    List<Product> findProductByName(String name);
    int count();
}
