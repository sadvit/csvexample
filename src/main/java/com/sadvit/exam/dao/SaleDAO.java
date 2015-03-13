package com.sadvit.exam.dao;

import com.sadvit.exam.domain.Sale;
import org.springframework.stereotype.Repository;

@Repository
public class SaleDAO extends AbstractDAO<Sale> {

    public SaleDAO() {
        super(Sale.class);
    }

}
