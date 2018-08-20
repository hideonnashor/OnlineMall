package org.onlinemall.web;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.onlinemall.domain.User;
import org.onlinemall.service.ServiceFactory;
import org.onlinemall.service.itf.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class UserAction {

    @RequestMapping(value = "/user/signup")
    public ModelAndView signUp(@RequestParam("username")String username, @RequestParam("useremail")String useremail, @RequestParam("userpassword")String userpassword) throws Exception {
        User user = new User();
        user.setUserName(username);
        user.setUserEmail(useremail);
        user.setUserPassword(userpassword);

        UserService userService = ServiceFactory.getServiceFactory().getUserService();
        String result = userService.signUp(user);

        ModelAndView modelAndView = new ModelAndView("forward:/html/message.jsp");
        modelAndView.addObject("signupMessage",result);

        return modelAndView;
    }
    @RequestMapping(value = "/sign")
    public ModelAndView userSignUp() throws Exception {
        return new ModelAndView("/user_sign.html");
    }

}
