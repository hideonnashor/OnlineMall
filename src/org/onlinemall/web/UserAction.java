package org.onlinemall.web;

import org.onlinemall.domain.User;
import org.onlinemall.service.ServiceFactory;
import org.onlinemall.service.itf.UserService;
import org.onlinemall.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;

@RestController
@RequestMapping("/")
public class UserAction {
    @RequestMapping(value = "/sign")
    public ModelAndView userSignUp() throws Exception {
        return new ModelAndView("/user_sign.html");
    }

    @RequestMapping(value = "/user/signup")
    public ModelAndView signUp(@RequestParam("username")String userName, @RequestParam("useremail")String userEmail, @RequestParam("userpassword")String userPassword) throws Exception {
        User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserPassword(WebUtils.ecpMD5(userPassword));

        UserService userService = ServiceFactory.getServiceFactory().getUserService();
        String result = userService.signUp(user);

        ModelAndView modelAndView = new ModelAndView("forward:/html/message.jsp");
        modelAndView.addObject("signupMessage",result);

        return modelAndView;
    }

    @RequestMapping(value = "/user/signin")
    public ModelAndView signIn(@RequestParam("usersign")String userSign, @RequestParam("userpassword")String userPassword, HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        userPassword = WebUtils.ecpMD5(userPassword);

//        判断登陆方式
        String type = WebUtils.nameOrEmail(userSign);
//        判断是否已经登陆
        int alreadyLogged = WebUtils.isLogged(request.getServletContext(),userSign);
        if (alreadyLogged == 1){
            modelAndView.addObject("signupMessage","用户已登陆");
            modelAndView.setViewName("forward:/html/message.jsp");
            return modelAndView;
        }
//        根据登录方式type封装user
        if (type.equalsIgnoreCase("name")){
            user.setUserName(userSign);
        }else {
            user.setUserEmail(userSign);
        }
        user.setUserPassword(userPassword);

        UserService userService = ServiceFactory.getServiceFactory().getUserService();
        User userToLogin = userService.signIn(user,type);
//        密码错误
        if (userToLogin == null){
            modelAndView.addObject("signupMessage","登陆账户或密码错误");
            modelAndView.setViewName("forward:/html/message.jsp");
            return modelAndView;
        }
//        session和application都存入用户登陆状态
        request.getSession().setAttribute("login_status","logged");
        request.getSession().setAttribute("userName",userToLogin.getUserName());
        request.getSession().setAttribute("userEmail",userToLogin.getUserEmail());
        WebUtils.applicationLoggerMapAdd(request.getServletContext(),userToLogin.getUserName(),userToLogin.getUserEmail());
        modelAndView.setViewName("redirect:/");
        return  modelAndView;
    }

}
