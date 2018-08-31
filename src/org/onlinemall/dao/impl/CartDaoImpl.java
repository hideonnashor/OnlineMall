package org.onlinemall.dao.impl;

import org.onlinemall.dao.itf.CartDao;
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.domain.Cart;
import org.onlinemall.utils.Serialization;
import redis.clients.jedis.Jedis;

public class CartDaoImpl implements CartDao {
    @Override
    public void insert(Cart cart, String userName) throws Exception{

    }

    @Override
    public void delete(Cart cart, String userName) throws Exception{

    }

    @Override
    public Cart query(String userName) {
        byte[] keyBytes = (userName+"cart").getBytes();

        Jedis jedis = DBConnectionFactory.getDBConnectionFactory().getRedisConnection();
        byte[] valueBytes = jedis.get(keyBytes);
        Object valueObj = Serialization.unserizlize(valueBytes);

        return (Cart) valueObj;
    }
}
