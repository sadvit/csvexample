package com.sadvit.exam.dao;

import com.sadvit.exam.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO extends AbstractDAO<Customer> {

    public CustomerDAO() {
        super(Customer.class);
    }

}
