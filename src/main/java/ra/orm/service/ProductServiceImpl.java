package ra.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.orm.entity.Product;
import ra.orm.repository.IProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll(int page,int size) {
        return productRepository.findAll(page,size);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return productRepository.findByName(name) ;
    }

    @Override
    public int count() {
        return productRepository.count().intValue();
    }
}
