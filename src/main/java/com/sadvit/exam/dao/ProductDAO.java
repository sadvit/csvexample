package com.sadvit.exam.dao;

import com.sadvit.exam.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO extends AbstractDAO<Product> {

    public ProductDAO() {
        super(Product.class);
    }

}
