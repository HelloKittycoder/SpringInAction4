package spittr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.web.po.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shucheng on 2020/8/9 21:34
 */
@Controller
public class HomeController {

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("mycontext", ctx);

        Map<String, String> map = new HashMap<>();
        map.put("101", "张三");
        map.put("102", "李四");
        map.put("103", "王五");
        model.addAttribute("studentMap", map);

        Student student = new Student(1, "张三", 10);
        model.addAttribute("studentPojo", student);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(new Student(2, "李四", 20));
        studentList.add(new Student(3, "王五", 30));
        model.addAttribute("studentList", studentList);
        return "index";
    }
}
