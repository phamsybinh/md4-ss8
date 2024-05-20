package ra.orm.controller;

import groovyjarjarpicocli.CommandLine;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ra.orm.entity.Employee;

import java.util.Date;

@Controller
public class HomeController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("date",new Date());
        model.addAttribute("arr",new int[]{1,3,5,7,9});
        model.addAttribute("employee",new Employee(1,"hung",new Date(),true, true));
        return "home";
    }
}
