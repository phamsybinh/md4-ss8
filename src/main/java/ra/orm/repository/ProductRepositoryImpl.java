package ra.orm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.orm.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> findAll(int page,int size) {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product", Product.class);

        return query.setFirstResult(page*size).setMaxResults(size).getResultList();
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(product);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class,id);
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(findById(id));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("FROM Product WHERE name LIKE :productName", Product.class);
        query.setParameter("productName", "%" + name + "%");
        return query.list();
    }

    @Override
    public Long count() {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.createQuery("select count(*) from Product").uniqueResult();
    }
}
