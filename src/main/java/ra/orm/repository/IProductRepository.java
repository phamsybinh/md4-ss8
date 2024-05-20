package ra.orm.repository;

import ra.orm.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll(int page,int size);
    void save(Product product);
    Product findById(int id);
    void remove(int id);
    List<Product> findByName(String name);
    Long count();
}
