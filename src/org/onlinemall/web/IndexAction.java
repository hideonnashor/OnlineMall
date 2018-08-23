package org.onlinemall.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexAction {

    @RequestMapping(value = "/")
    public ModelAndView getIndex(){
        return new ModelAndView("/index.html");
    }
}
