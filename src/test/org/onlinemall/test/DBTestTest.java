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
import org.onlinemall.domain.User;
import org.onlinemall.service.ServiceFactory;
import org.onlinemall.service.itf.UserService;
import org.onlinemall.service.utils.GenerateUnique;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* DBTest Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2018</pre> 
* @version 1.0 
*/

public class DBTestTest {
    static {

    }

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

@Test
public void dbConnect() throws SQLException {
    //    ��־
    Logger logger = Logger.getLogger("DBTestTest");
    logger.setLevel(Level.INFO);

    try {
        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();
//        System.out.println(userDao.queryById(1).getUserEmail());
        logger.info(userDao.queryByEmail("pregfind@126.com").getUserName());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
@Test
    public void userSignUp() throws Exception {
    //    ��־
    Logger logger = Logger.getLogger("DBTestTest");
    logger.setLevel(Level.INFO);

    User user = new User();
    user.setUserName("p920");
    user.setUserEmail("pregfind@226.com");
    user.setUserPassword("123456");

    UserService userService = ServiceFactory.getServiceFactory().getUserService();
    String result = userService.signUp(user);
    logger.info("注册结果为:"+result);
}
@Test
    public void generateUniqueId(){
    GenerateUnique generateUnique = new GenerateUnique();
    System.out.println(generateUnique.generateUserId());
}
}
