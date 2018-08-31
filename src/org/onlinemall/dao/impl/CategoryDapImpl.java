package org.onlinemall.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.onlinemall.appconfig.ContextFactory;
import org.onlinemall.dao.itf.CategoryDao;
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.domain.Category;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class CategoryDapImpl implements CategoryDao {
    @Override
    public Category queryByName(String cateName){
//        IOC
        ApplicationContext applicationContext = ContextFactory.getContextFactory().getApplicationContext();
        Category category = applicationContext.getBean(Category.class);
        QueryRunner queryRunner = applicationContext.getBean(QueryRunner.class);
        Connection connection = DBConnectionFactory.getDBConnectionFactory().getMysqlConnection();

        String sql = "select * from category where cate_name like ?";
        try {
            Map<String, Object> map = queryRunner.query(connection, sql, new MapHandler(),cateName);
            category = category.mapToBean(map);
            return category;
        } catch (NullPointerException | SQLException e) {
            System.out.println("找不到这种物品类别");
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭错误");
            }
        }
    }
}
