package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by shucheng on 2020/7/2 22:06
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    public static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    // 无参数
    // 写法一：
    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        // model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
         model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
         return "spittles";
    }*/

    // 写法二：
    /*@RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(Model model) {
        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
    }*/

    // 带参数
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // PathVariable的value不写时，变量名字默认和方法参数名一样；注意RequestMapping里的路径变量必须要写
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    // 写法一：
    /*@RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        try {
            spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
            return "redirect:/spittles";
        } catch (DuplicateSpittleException e) {
            return "error/duplicate";
        }
    }*/

    // 写法二：
    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

    /*@ExceptionHandler(DuplicateSpittleException.class)
    public String handleNotFound() {
        return "error/duplicate";
    }*/
}
