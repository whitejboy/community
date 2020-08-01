package com.forum.commuity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:IndexController
 * Package:com.forum.commuity.controller
 *
 * @Date:2020/8/1 8:56
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
