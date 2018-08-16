package org.onlinemall.dao.impl;

import org.onlinemall.dao.itf.CustomerDao;
import org.onlinemall.domain.Customer;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void insert(Customer customer) throws Exception {
        String sql = "insert into all_user()";
    }

    @Override
    public void update(Customer customer) throws Exception {

    }

    @Override
    public void deletet(Customer customer) throws Exception {

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
