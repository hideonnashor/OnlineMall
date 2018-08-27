package org.onlinemall.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.onlinemall.appconfig.ContextFactory;
import org.onlinemall.dao.DaoFactory;
import org.onlinemall.dao.itf.ItemDao;
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.domain.Item;
import org.onlinemall.utils.GenerateUnique;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao {

    @Override
    public void insert(Item item) {
        ApplicationContext applicationContext = ContextFactory.getContextFactory().getApplicationContext();
        QueryRunner queryRunner = applicationContext.getBean(QueryRunner.class);
        Connection connection = DBConnectionFactory.getDBConnectionFactory().getConnection();

//      values
        int itemId = GenerateUnique.generateItemId();
        String itemName = item.getItemName();
        String itemMnfc = item.getItemMnfc();
        String itemImage = item.getItemMnfc();
        String itemIntro = item.getItemIntro();
        float itemPrice = item.getItemPrice();
        int itemStock = item.getItemStock();
//      将cateid和itemid一同存入物品类别表
        String sql2 = "insert into item_cate values(?,?)";
        try {
            String itemCate = item.getItemCate();
            int cateId = DaoFactory.getDaoFactory().getCategoryDao().queryByName(itemCate).getCateId();
            queryRunner.update(connection,sql2,itemId,cateId);
        } catch (SQLException e) {
            System.out.println("物品类别表更新失败，停止物品插入数据库");
            try {
                connection.close();
            } catch (SQLException e1) {
                System.out.println("物品类别表更新失败，数据库连接关闭失败");
            }
            return;
        }
//      物品表插入记录
        String sql1 = "insert into item values(?,?,?,?,?,?,?)";
        try {
            queryRunner.update(connection,sql1,itemId,itemName,itemMnfc,itemImage,itemIntro,itemPrice,itemStock);
        } catch (SQLException e) {
            System.out.println("插入物品表失败,可能因为物品记录已存在");
            return;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭错误");
            }
        }
    }
}
