package org.onlinemall.dao;

import org.onlinemall.domain.Customer;

import java.util.List;

public class CustomerDaoImpl implements Dao {

    @Override
    public void insertCustomer(Customer customer) throws Exception {
        String sql = "insert into all_user()";
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {

    }

    @Override
    public void deletetCustomer(Customer customer) throws Exception {

    }

    @Override
    public Customer queryById(int customerId) throws Exception {
        return null;
    }

    @Override
    public List<Customer> queryAll() throws Exception {
        return null;
    }
}
