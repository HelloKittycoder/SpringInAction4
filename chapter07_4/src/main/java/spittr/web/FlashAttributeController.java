package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;

/**
 * Created by shucheng on 2020/7/7 22:42
 */
@Controller
public class FlashAttributeController {

    // Model只能传简单属性，如：字符串、数字等
    // http://localhost:8081/redirect?username=zhangsan&id=1
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(Spitter spitter, Model model) {
        model.addAttribute("username", spitter.getUsername());
        model.addAttribute("id", spitter.getId());
        return "redirect:/credirect/{username}";
    }

    // flash属性可以传递对象
    // http://localhost:8081/redirect2?username=zhangsan&id=1
    @RequestMapping(value = "/redirect2", method = RequestMethod.GET)
    public String redirect2(Spitter spitter, RedirectAttributes model) {
        model.addAttribute("username", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/credirect/{username}";
    }

    @RequestMapping(value = "/credirect/{username}", method = RequestMethod.GET)
    public void catchRedirect(@PathVariable String username, Spitter spitter) {
        System.out.println("username=======" + spitter.getUsername());
        System.out.println("id=======" + spitter.getId());
    }
}
