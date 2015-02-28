package com.sadvit.lab6.dao;

import com.sadvit.lab6.domain.Customer;

/**
 * Эти пустые интерфейсы - нечто большее, чем просто задел на будущее,
 * когда понадобится расширение dao domain объектов. Они используются для того,
 * чтобы spring знал, что именно ему нужно иинъектить при создании сервисов.
 */
public interface CustomerDAO extends DAO<Customer> {

}
