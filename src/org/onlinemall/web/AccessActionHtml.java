package org.onlinemall.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/html")
public class AccessActionHtml {

    @RequestMapping(value = "/*")
    public ModelAndView loginAccess(HttpServletRequest request) throws Exception {
        try{
//        url检查
//            int flag  = request.getHeader("referer").indexOf("OnlineMall");

//            if (flag<0){
//                return new ModelAndView("redirect:/index.html");
//            }
//        session登陆属性检查
            String loginStatus = (String) request.getSession().getAttribute("login_status");
            if (!loginStatus.equalsIgnoreCase("logged")){
                return new ModelAndView("redirect:/sign");
            };
        }catch (NullPointerException e){
            return new ModelAndView("redirect:/sign");
        }
        return new ModelAndView();
    }
}
