package com.ecom.productcatalog.respository;

import com.ecom.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query
    List<Product> findByCategory_Id(Long categoryId);
}
