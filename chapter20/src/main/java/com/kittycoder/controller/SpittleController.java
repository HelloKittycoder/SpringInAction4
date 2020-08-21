package com.kittycoder.controller;

import com.kittycoder.dao.SpittleRepository;
import com.kittycoder.po.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by shucheng on 2020/7/31 23:46
 */
@Controller
public class SpittleController {

    public static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private int spittersPerPage = DEFAULT_SPITTLES_PER_PAGE;

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping("/hello")
    public void sayHello() {
        System.out.println("hello");
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max) {
        return spittleRepository.findSpittles(max, spittersPerPage);
    }

    public int getSpittersPerPage() {
        return spittersPerPage;
    }

    public void setSpittersPerPage(int spittersPerPage) {
        this.spittersPerPage = spittersPerPage;
    }
}
