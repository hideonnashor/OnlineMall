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
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.domain.Category;
import org.onlinemall.domain.Item;
import org.onlinemall.domain.User;
import org.onlinemall.service.ServiceFactory;
import org.onlinemall.service.itf.ItemService;
import org.onlinemall.service.itf.UserService;
import org.onlinemall.utils.GenerateUnique;
import org.onlinemall.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/** 
* DBTest Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2018</pre> 
* @version 1.0 
*/

public class DBTestTest {
    @Autowired
    private Item item1;
    private Item item2;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}
@Test
public void redisTest(){
//    Jedis jedis = new Jedis("localhost");
//    System.out.println(jedis.ping());
//    jedis.set("1","1");
//    System.out.println(jedis.get("1"));
    Jedis jedis = DBConnectionFactory.getDBConnectionFactory().getRedisConnection();
    System.out.println(jedis.get("1"));
//    jedis.set("2","2");
}
@Test
public void getUserInfo(){
    UserService userService = ServiceFactory.getServiceFactory().getUserService();
    try {
        User user = userService.getUserInfo("1@qq.com");
        System.out.println(user.getUserName());
    } catch (Exception e) {
        System.out.println(e);
    }
}
@Test
public void iocUseTest(){
    item1 = ContextFactory.getContextFactory().getApplicationContext().getBean(Item.class);
    item2 = ContextFactory.getContextFactory().getApplicationContext().getBean(Item.class);
    this.item1.setItemCate("1");
    this.item2.setItemCate("2");
    System.out.println(this.item1.getItemCate()+this.item2.getItemCate());
}
@Test
public void randomTest(){
    System.out.println((int)(Math.random()*11));
}
@Test
public void itemInsert(){
    ItemDao itemDao = DaoFactory.getDaoFactory().getItemDao();
    Item item = new Item();
//    item.setItemId(123);

    String[] mnfc = {"华为","中兴","NVIDIA","AMD","INTEL","RStar","小米","华硕",
            "华擎","微星","索泰","耕升"};
    String[] cate = {"电脑、办公","礼品箱包","运动健康","家用电器","手机","服饰内衣",
            "厨具","个护化妆","整车","图书、音像、电子书刊","数码","家居家装","钟表",
            "鞋靴","母婴","食品饮料、保健用品","珠宝","汽车用品","运动健康","玩具乐器",
            "彩票、旅行、充值、票务","生鲜"};
    String[] image = {"https://img12.360buyimg.com/cms/jfs/t21208/295/122640178/10690/a45aa107/5afd28acNdceda8ca.jpg!q80.webp",
    "https://img13.360buyimg.com//n2/jfs/t22852/127/2026209196/247854/8b787a68/5b71ae7eNe7e0fbac.jpg!q80.webp",
    "https://img12.360buyimg.com//n2/jfs/t20590/183/2638302167/377208/5b849ccc/5b60543bNfe1c6c67.jpg!q80.webp",
    "https://img11.360buyimg.com//n2/jfs/t24538/9/740998333/216449/326c6bd2/5b407275N04b99b97.jpg!q80.webp",
    "https://img10.360buyimg.com//n2/jfs/t24388/39/2023397895/200068/30b1d7b2/5b715433N67883a79.jpg!q80.webp",
    "https://img12.360buyimg.com/n2/jfs/t22834/274/482276515/286721/1ac51677/5b30ae35N9160f3b9.jpg!q90.jpg",
    "https://img11.360buyimg.com/n2/jfs/t19753/142/1460158165/183014/b386da40/5aca3dd6Na056a47b.jpg!q90.jpg",
    "https://img10.360buyimg.com/n2/jfs/t24145/108/2326107632/332355/f49bd31e/5b7b76cbN5c8abbeb.jpg!q90.jpg",
    "https://img13.360buyimg.com/da/jfs/t24322/149/2121009755/4394/317b5c6e/5b762b9cNe22089c9.jpg!q90.jpg",
    "https://img13.360buyimg.com/da/jfs/t19897/44/1539014682/36396/f77db3c9/5b20b004N221833e5.jpg!q90.jpg",
    "https://img20.360buyimg.com/da/jfs/t20638/154/1126322105/4056/2841a603/5b20afdeN6d3e6be1.jpg!q90.jpg",
    "https://img14.360buyimg.com/n1/jfs/t18163/18/2278777704/138907/3d4fe83b/5aefa519N5d15997d.jpg",
    "https://img14.360buyimg.com/n1/jfs/t5107/64/1144297096/42946/a86c0512/590c3068N27dd0101.jpg",
    "https://img14.360buyimg.com/n1/jfs/t25942/311/473645414/245117/c6642f5d/5b71a4e5Na4b628f5.jpg",
    "https://img14.360buyimg.com/n1/jfs/t24958/315/637321326/180289/2f4dfd93/5b76a251Nde6a5775.jpg",
    "https://img14.360buyimg.com/n1/jfs/t21253/202/722060549/197895/a4d6ed1a/5b1674d6N7d123523.jpg",
    "https://img14.360buyimg.com/n1/jfs/t20266/216/1223951946/35337/78aad1a/5b2365d3N48d0ac4e.jpg",
    "https://img14.360buyimg.com/n1/jfs/t24064/319/2197355803/463825/71291756/5b7510b7N587cd944.jpg",
    "https://img14.360buyimg.com/n1/jfs/t24352/183/1944728812/241191/c8f7aae4/5b6e5249Nfc953778.jpg",
    "https://img14.360buyimg.com/n1/jfs/t22150/61/2116719412/114292/789b3e02/5b485ce4N04836ee7.jpg",
    "https://img14.360buyimg.com/n1/jfs/t23617/30/1527554833/108264/b58a6294/5b627614Nd5c0c645.jpg",
    "https://img14.360buyimg.com/n1/jfs/t20992/351/2598287278/186773/40443136/5b5e7916N024de452.jpg",
    "https://img14.360buyimg.com/n1/jfs/t20533/95/1082378097/131596/c63507c2/5b1f8121N6d3b9b37.jpg",
    "https://img14.360buyimg.com/n1/jfs/t23191/163/1047707376/86222/1074ecd6/5b4e9bf7N1269927e.jpg",
    "https://img14.360buyimg.com/n1/jfs/t21202/229/1122493778/116043/bd5f9691/5b20c461Nc728f6a4.jpg",
    "https://img14.360buyimg.com/n1/jfs/t21355/255/1027604983/170847/1632567b/5b1f6ee0N794a2e6a.jpg",
    "https://img14.360buyimg.com/n1/jfs/t21721/28/1059463944/122081/b3cbc45b/5b1f8181N82e14f46.jpg",
    "https://img14.360buyimg.com/n1/jfs/t24892/285/211503534/112464/11f3d857/5b695490Na985adf1.jpg",
    "https://img14.360buyimg.com/n1/jfs/t24322/267/2334214909/84779/7b40f8ba/5b7d0a13N63e4e3d0.jpg",
    "https://m.360buyimg.com/babel/jfs/t22639/47/2446569072/24744/2959f69d/5b7e253cNe0eef23b.jpg",
    "https://m.360buyimg.com/babel/jfs/t24421/315/2041435937/10755/d8247b95/5b72878aN1f3d3f56.jpg",
    "https://m.360buyimg.com/babel/jfs/t25588/260/853201050/18305/d69439bf/5b7e2550N1d4b57b3.jpg",
    "https://m.360buyimg.com/babel/jfs/t23929/118/2469636989/29238/d5b54896/5b7f6b31N37f27185.jpg",
    "https://img14.360buyimg.com/n7/jfs/t5833/273/120885697/136166/c3392826/591d69f7Na685c02c.jpg",
    "https://img12.360buyimg.com/n7/jfs/t11614/23/696544110/311837/b3ca57c0/59f69d5fN40fee0a4.jpg",
    "https://img14.360buyimg.com//n2/jfs/t24700/215/354930654/227933/2dbdbfc7/5b6c7115N06eeb630.jpg!q80.webp",
    "https://img12.360buyimg.com/cms/jfs/t13495/107/974159154/25320/28d45cf5/5a17805cN9a49e6b7.png!q80.webp"};
    String intro[] = {"华硕（ASUS）DUAL-GeForce GTX1060-O6G",
    "七彩虹(Colorful)iGame1060烈焰战神S-6GD5 Top GTX1060",
    "【电竞吃鸡,优选索泰游戏显卡】LOGO信仰灯,3热管2风扇散热更出众!★选至尊更有料★",
    "酷炫RGB龙魂灯,龙纹铝制合金强化背板,零噪智能风扇散热技术,PCB强化散热装甲,畅玩游戏盛宴!点我升级1070红龙",
    "【首发LCD视窗技术】iGame电竞荣耀彰显，一键超频，全新SWORIZER散热器，LCD智能监控只为信仰发烧【升级LCD高频版】",
    "【三年质保】前置可侦测负载igame多色信仰灯，镀银PCB更耐用，热管直触，金属背板，物超所值！【U系列好价来袭】",
    "【领券立减100评论送信仰杯】10相超合金供电,RGB炫彩灯效,热管直触三风扇,低躁静音!畅玩吃鸡高画质!>>点击优惠券>>",
    "电竞显卡性能新高度！【更多信仰N卡，敬请点击>>>】",
    "【玩家推荐，好评如潮!】RGB自定义灯效!双HDMI接口!热管直触三风扇!一键超频，流畅游戏真显卡!※1080专业吃鸡显卡※",
    "【满1500减200】8G大显存，全新Dual-X 四热管双风扇散热系统，提供更快更顺畅的游戏体验【点此：买RX580 送10000刀币】",
    "酷炫RGB龙魂灯,碳纤维铝制合金强化背板,零噪智能风扇散热技术,非公8+2强化供电设计,三重闪电散热,畅玩游戏盛宴!升级高规1080Ti红龙",
    "【电竞吃鸡,优选索泰游戏显卡】酷炫信仰灯!10相壕供电!4风扇散热更出色!★加点Ti游戏更快★"};
//    for (int i =4272;i<100000;i++){
//        item.setItemName(String.valueOf(i));
//        item.setItemMnfc(mnfc[(int)(Math.random()*11)]);
//        item.setItemCate(cate[(int)(Math.random()*20)]);
//        item.setItemImage(image[(int)(Math.random()*35)]);
//        item.setItemStock((int)(Math.random()*1000));
//        item.setItemPrice((int)(Math.random()*99999));
//        item.setItemIntro(intro[(int)(Math.random()*11)]);
//        itemDao.insert(item);
//    }
}
@Test
public void searchItemByCateService(){
    ItemService itemService = ServiceFactory.getServiceFactory().getItemService();
    System.out.println(itemService.getItemByCate("手机",3).get(0).toString());
}
@Test
public void searchItemByCateDao(){
    ItemDao itemDao = DaoFactory.getDaoFactory().getItemDao();
    List<Item> list = itemDao.queryByCate("手机",3);
    for (Item item : list){
        System.out.println(item.toString());
    }
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
