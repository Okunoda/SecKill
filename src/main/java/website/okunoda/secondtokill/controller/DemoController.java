package website.okunoda.secondtokill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Okunoda
 * @date 2023年03月11日16:14
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","============");
        return "hello";
    }
}
