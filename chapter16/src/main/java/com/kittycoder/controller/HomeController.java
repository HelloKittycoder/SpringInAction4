package com.kittycoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by shucheng on 2020/7/2 21:57
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

    @RequestMapping(method = GET)
    @ResponseBody
    public String home() {
        // System.out.println("public String home");
        return "home";
    }
}
