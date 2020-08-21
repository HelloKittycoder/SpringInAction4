package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by shucheng on 2020/7/2 21:57
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(method = GET)
    public String home() {
        // System.out.println("public String home");
        return "home";
    }

    @RequestMapping(value = "/page", method = GET)
    public String page() {
        return "page";
    }
}
