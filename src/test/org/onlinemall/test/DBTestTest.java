package test.org.onlinemall.test;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.onlinemall.appconfig.ContextFactory;
import org.onlinemall.dao.DaoFactory;
import org.onlinemall.dao.itf.CategoryDao;
import org.onlinemall.dao.itf.ItemDao;
import org.onlinemall.domain.Category;
import org.onlinemall.domain.Item;
import org.onlinemall.domain.User;
import org.onlinemall.service.ServiceFactory;
import org.onlinemall.service.itf.UserService;
import org.onlinemall.utils.GenerateUnique;
import org.onlinemall.web.util.WebUtils;
import org.springframework.context.ApplicationContext;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

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
public void itemInsert(){
    ItemDao itemDao = DaoFactory.getDaoFactory().getItemDao();
    Item item = new Item();
//    item.setItemId(123);
    item.setItemName("12");
    item.setItemMnfc("12");
    item.setItemCate("手地方机");
    item.setItemImage("12");
    item.setItemStock(9200);
    item.setItemPrice(1200);
    item.setItemIntro("12");
    itemDao.insert(item);
}

@Test
public void generateUnique() throws NoSuchAlgorithmException, UnsupportedEncodingException {
//    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//    byte[] bytes = "1电脑123asd".getBytes("utf-8");
//    System.out.println(bytes+" "+bytes.length);
//    byte[] bytes1 = messageDigest.digest(bytes);
//    System.out.println(bytes1+" "+bytes1.length);
//    for (int i : bytes1){
//        i = i & 0xff;
//        if (i < 16) {
//            System.out.println("i小于16 "+i+" "+Integer.toHexString(i));;
//        }
//        System.out.println(i+" "+Integer.toHexString(i));
//    }
    int i = GenerateUnique.generateItemId();
    System.out.println(i);
}

@Test
public void searchCategory() throws SQLException {
    CategoryDao categoryDao = DaoFactory.getDaoFactory().getCategoryDao();
    Category category = categoryDao.queryByName("电脑、办公");
    System.out.println(category.getCateId());
}

@Test
public void dbConnect() throws SQLException {
    System.out.println(WebUtils.nameOrEmail("sdfsfdf!@"));
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
@Test
    public void insertUser() throws Exception {
//        User user = new User();
//        user.setUserName("1");
//        user.setUserEmail("1");
//        user.setUserPassword("1");
//        user.setUserId("2");
//        user.setUserPortrait("1");
//        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();
//        userDao.insert(user);
}
@Test
    public void encrypt() throws Exception{
    String s = "hah士大夫啊空军飞机阿佛加送i放假哦i骄傲的身份大师傅";
    System.out.println(WebUtils.ecpMD5(s));
}
@Test
    public void userSignIn() throws Exception{
        User user = new User();
        user.setUserName("p90");
        user.setUserEmail("pregfind@126.com");
        user.setUserPassword("123456");

        UserService userService = ServiceFactory.getServiceFactory().getUserService();
        User user1 = userService.signIn(user,"name");
        User user2 = userService.signIn(user,"email");

    System.out.println(user1.getUserName());
    System.out.println(user1.getUserEmail());
    System.out.println(user1.getUserPassword());

    System.out.println(user2.getUserName());
    System.out.println(user2.getUserEmail());
    System.out.println(user2.getUserPassword());
}
@Test
    public void BeanTest(){
    ApplicationContext applicationContext = ContextFactory.getContextFactory().getApplicationContext();
    Item item = applicationContext.getBean(Item.class);


    item.setItemCate("1");
    System.out.println(item.getItemCate());
}
}
