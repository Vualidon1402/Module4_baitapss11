package rikkei.service;

import rikkei.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> searchByName(String keyword);
    Product findById(Integer id);
    void save(Product product);  // vừa thêm moi vưa cap nhap
    void deleteById(Integer id);
}
