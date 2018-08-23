package org.onlinemall.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/user")
public class UserInfoAction {

    @RequestMapping(value = "/info")
    public ModelAndView userInfo(){
        return new ModelAndView("forward:/html/user_info.html");
    }
    @RequestMapping(value = "/buy")
    public ModelAndView userBuy(){
        return new ModelAndView("forward:/html/user_info_buy.html");
    }
    @RequestMapping(value = "/changeinfo")
    public ModelAndView userChangeInfo(){
        return new ModelAndView("forward:/html/user_info_changInfo.html");
    }
    @RequestMapping(value = "/order")
    public ModelAndView userOrder(){
        return new ModelAndView("forward:/html/user_info_order.html");
    }
    @RequestMapping(value = "/profile")
    public ModelAndView userProfile(){
        return new ModelAndView("forward:/html/user_info_profile.html");
    }
    @RequestMapping(value = "/cart")
    public ModelAndView userCart(){
        return new ModelAndView("forward:/html/user_info_shoppingcart.html");
    }
    @RequestMapping(value = "/authentication")
    public ModelAndView userCustomerAuthen(){
        return new ModelAndView("forward:/html/customer_authentication.html");
    }
}
