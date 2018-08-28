package org.onlinemall.web;

import org.json.JSONArray;
import org.json.JSONObject;
import org.onlinemall.domain.Item;
import org.onlinemall.service.ServiceFactory;
import org.onlinemall.service.itf.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/item")
public class ItemAction {

    @RequestMapping(value = "/showbytype",method = RequestMethod.GET)
    public void showItem(HttpServletRequest request, HttpServletResponse response){
//        拼接json head
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Map<String,Object> map;

        jsonObject.put("dataType","itembycate");
        jsonObject.put("appCode","100");
        jsonObject.put("version","v1.0");

        try {
            String itemCate = (String) request.getParameter("itemcate");
            int page = Integer.parseInt(request.getParameter("page"));
            ItemService itemService = ServiceFactory.getServiceFactory().getItemService();
            List<Item> items = itemService.getItemByCate(itemCate,page);
            for (Item item : items){
                map =  new HashMap<>();
                map.put("itemName",item.getItemName());
                map.put("itemIntro",item.getItemIntro());
                map.put("itemImage",item.getItemImage());
                jsonArray.put(map);
            }
        }catch (NullPointerException | NumberFormatException e){
            map =  new HashMap<>();
            map.put("itemName","");
            map.put("itemIntro","");
            map.put("itemImage","");
            jsonArray.put(map);
        }

        jsonObject.put("Mbody",jsonArray);

        response.setHeader("Content-type", "application/json;charset=UTF-8");
        String data = jsonObject.toString();
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(data);
        } catch (IOException e) {
            System.out.println("response获取writer失败");
        }

//        return jsonObject.toString();
    }
}
