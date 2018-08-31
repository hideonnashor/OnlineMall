package org.onlinemall.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.onlinemall.appconfig.ContextFactory;
import org.onlinemall.dao.itf.ItemDao;
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.domain.Item;
import org.onlinemall.utils.GenerateUnique;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDaoImpl implements ItemDao {

    @Override
    public void insert(Item item) {
        ApplicationContext applicationContext = ContextFactory.getContextFactory().getApplicationContext();
        QueryRunner queryRunner = applicationContext.getBean(QueryRunner.class);
        Connection connection = DBConnectionFactory.getDBConnectionFactory().getMysqlConnection();

//      values
        int itemId = GenerateUnique.generateItemId();
        String itemName = item.getItemName();
        String itemMnfc = item.getItemMnfc();
        String itemImage = item.getItemImage();
        String itemIntro = item.getItemIntro();
        float itemPrice = item.getItemPrice();
        int itemStock = item.getItemStock();
        String itemCate = item.getItemCate();

        String sql1 = "insert into item values(?,?,?,?,?,?,?,?)";
//        String sql2 = "insert into item_cate values(?,?)";

//      物品表插入记录,同时做数据重复异常处理
        try {
            queryRunner.update(connection,sql1,itemId,itemName,itemMnfc,itemImage,itemIntro,itemPrice,itemStock,itemCate);
        } catch (SQLException e) {
            System.out.println("插入物品表失败");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭失败");
            }
        }
////      将cateid和itemid一同存入物品类别表
//        try {
//            itemCate = item.getItemCate();
//            int cateId = DaoFactory.getDaoFactory().getCategoryDao().queryByName(itemCate).getCateId();
//            queryRunner.update(connection,sql2,itemId,cateId);
//        } catch (SQLException e) {
//            System.out.println("物品类别表更新失败，停止物品插入数据库");
//            return;
//        }finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("物品类别表更新失败,数据库连接关闭错误");
//            }
//        }
    }

    @Override
    public List<Item> queryByCate(String itemCate) {
        return null;
    }

    @Override
    public List<Item> queryByCate(String itemCate, int page) {
        ApplicationContext applicationContext = ContextFactory.getContextFactory().getApplicationContext();
        QueryRunner queryRunner = applicationContext.getBean(QueryRunner.class);
        Connection connection = DBConnectionFactory.getDBConnectionFactory().getMysqlConnection();
        List itemMapList;
        List<Item> itemList;

        String sql = "SELECT a.item_id,a.item_name,a.item_mnfc,a.item_image,a.item_intro,a.item_price,a.item_stock,a.item_cate " +
                "from item a join " +
                "(select * FROM item WHERE item_cate LIKE ? LIMIT ?,?)b ON a.item_id = b.item_id ;";
        try {
            itemList = new ArrayList<Item>();
            itemMapList = queryRunner.query(connection,sql,new MapListHandler(),itemCate,(page-1),12);
            for (int i = 0;i< (itemMapList).size();i++){
                Map<String,Object> itemMap = (Map<String, Object>) itemMapList.get(i);
                Item item = new Item().mapToBean(itemMap);
                itemList.add(item);
            }
        } catch (SQLException e) {
            System.out.println("按类型分页查询出错");
            return null;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭失败");
            }
        }
        return itemList;
    }
}
