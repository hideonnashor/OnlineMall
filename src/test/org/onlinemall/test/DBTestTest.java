package test.org.onlinemall.test; 

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.onlinemall.dao.DaoFactory;
import org.onlinemall.dao.itf.UserDao;
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.dao.util.MySqlGetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* DBTest Tester. 
* 
* @author <Authors name> 
* @since <pre>∞À‘¬ 14, 2018</pre> 
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
    //    »’÷æ
    Logger logger = Logger.getLogger("DBTestTest");
    logger.setLevel(Level.INFO);

    try {
        UserDao userDao = new DaoFactory().getUserDao();
//        System.out.println(userDao.queryById(1).getUserEmail());
        logger.info(userDao.queryByName("p90").getUserEmail());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
