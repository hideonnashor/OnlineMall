package org.onlinemall.web.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;

public class WebUtils {

    public static String ecpMD5 (String src){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] byteArray = src.getBytes("UTF-8");
            byte[] md5Bytes = messageDigest.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

//    判断登陆方式
    public static String nameOrEmail(String sign){
        String type = null;
        type = sign.indexOf("@")<0?"name":"email";
        return type;
    }

    public static int isLogged(ServletContext application, String userSign) {
        try{

            Hashtable loggedUsers = (Hashtable) application.getAttribute("loggedUsers");
            for (Object name:loggedUsers.keySet()){
                System.out.println("登陆的用户有"+name+"验证的用户为"+userSign);
                //        name登陆
                if (name.equals(userSign)){
                    return 1;//存在
                }//        email登陆
                if (userSign.equals(loggedUsers.get(name))){
                    return 1;
                }
            }
        }catch (NullPointerException e){//如果出错不能获取loggedUsers
            System.out.println("application 登陆列表获取错误");
            return 0;
        }
        return 0;
    }

    public static void applicationLoggerMapAdd(ServletContext application,String userName, String userEmail) {
        Hashtable loggedUsers = (Hashtable) application.getAttribute("loggedUsers");
        loggedUsers.put(userName,userEmail);
        application.setAttribute("loggedUsers",loggedUsers);
    }
    public static void applicationLoggerMapDelete(ServletContext application,String userName, String userEmail) {
        Hashtable loggedUsers = (Hashtable) application.getAttribute("loggedUsers");
        loggedUsers.remove(userName,userEmail);
        application.setAttribute("loggedUsers",loggedUsers);
    }
}
