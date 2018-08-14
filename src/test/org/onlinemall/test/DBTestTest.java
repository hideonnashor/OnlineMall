package test.org.onlinemall.test; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.onlinemall.dao.DBUtils;
import org.onlinemall.dao.UserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* DBTest Tester. 
* 
* @author <Authors name> 
* @since <pre>°ËÔÂ 14, 2018</pre> 
* @version 1.0 
*/

public class DBTestTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

@Test
public void dbConnect() throws SQLException {
    Connection connection = DBUtils.getConnection();
    try {
        Statement sta = connection.createStatement();
        ResultSet res = sta.executeQuery("select * from all_user");
        System.out.println(res.next());
        System.out.println(res.getInt(1));
        System.out.println(res.getString(2));
        System.out.println(res.getString(3));
        System.out.println(res.getByte("customer_id"));
        res.close();
        sta.close();
    } catch (SQLException e) {
        throw new SQLException("failed");
    }finally {
        connection.close();
    }
}
}
