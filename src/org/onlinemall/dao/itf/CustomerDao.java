package org.onlinemall.dao.itf;

import org.onlinemall.domain.Customer;

import java.util.List;

public interface CustomerDao {

    public void insert(Customer customer) throws Exception;
    public void update(Customer customer) throws Exception;
    public void deletet(Customer customer) throws Exception;
    public Customer queryById(int customerId) throws Exception;
    public List<Customer> queryAll() throws Exception;
}
