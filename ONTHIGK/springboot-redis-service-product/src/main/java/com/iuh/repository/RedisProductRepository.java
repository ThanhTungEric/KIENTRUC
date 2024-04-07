package com.iuh.repository;

import com.iuh.model.Product;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisProductRepository {
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public RedisProductRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

        public void save(Product product){
            hashOperations.put("PRODUCT", product.getProductId(), product);
        }
    public List<Product> findAll(){
        return hashOperations.values("PRODUCT");
    }
    public void delete(String productId){
        hashOperations.delete("PRODUCT");
    }
    public Product findById(String productId){
        return (Product) hashOperations.get("PRODUCT", productId);
    }
}
