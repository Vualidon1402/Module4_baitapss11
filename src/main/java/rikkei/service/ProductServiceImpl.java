package rikkei.service;

import rikkei.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductServiceImpl implements IProductService {
    private static final List<Product> products = new ArrayList<Product>();

    @Override
    public List<Product> searchByName(String keyword) {
        return products.stream()
                .filter(pro->pro.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
//        for (Product product : products) {
//            if (product.getId()==id){
//                return product;
//            }
//        }
//        return null;
        return products.stream()
                .filter(pro-> Objects.equals(pro.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Product product) {
        if(product.getId()==null){
            // thêm mới
            product.setId(getNewId()); // id tu tăng
            products.add(product);
        }else {
            products.set(products.indexOf(findById(product.getId())),product);
        }
    }

    @Override
    public void deleteById(Integer id) {
        products.remove(findById(id));
    }
    private Integer getNewId(){
//        Integer maxId=0;
//        for(Product p : products){
//            if(p.getId()>maxId){
//                maxId=p.getId();
//            }
//        }
//        return maxId+1;
        return products.stream().map(Product::getId).max(Integer::compareTo).orElse(0)+1;
    }
}
