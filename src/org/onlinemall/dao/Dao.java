package org.onlinemall.dao;

import org.onlinemall.domain.Customer;

import java.util.List;

public interface Dao {

    public void insertCustomer(Customer customer) throws Exception;
    public void updateCustomer(Customer customer) throws Exception;
    public void deletetCustomer(Customer customer) throws Exception;
    public Customer queryById(int customerId) throws Exception;
    public List<Customer> queryAll() throws Exception;
}
