package org.onlinemall.dao.itf;

import org.onlinemall.domain.Cart;

public interface CartDao {
    public void insert(Cart cart,String userName) throws Exception;
    public void delete(Cart cart,String userName) throws Exception;
    public Cart query(String userName);
}
