package org.onlinemall.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoggedState {
    @RequestMapping(value = "/loginstate")
    public void isLogged(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Map<String,String> map = new HashMap<>();
//        公共
        jsonObject.put("dataType","loginstate");
        jsonObject.put("appCode","101");
        jsonObject.put("version","v1.0");
        jsonObject.put("retcode","200");

//        判断登陆状态
        boolean isLogged = (String.valueOf(session.getAttribute("loginState"))).equalsIgnoreCase("logged")?true:false;
        System.out.println(isLogged);
        if (isLogged){
            map.put("state","logged");
            map.put("userName", (String) session.getAttribute("userName"));
        }else {
            map.put("state","not logged");
            map.put("userName","visitor");
        }

        jsonArray.put(map);
        jsonObject.put("Mbody",jsonArray);
        try {
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            System.out.println("api LoggedState 无法返回数据给浏览器");
            throw new RuntimeException(e);
        }
        return;
    }
}
