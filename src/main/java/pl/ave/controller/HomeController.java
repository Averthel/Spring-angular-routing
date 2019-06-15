package pl.ave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index.html";
    }

    @RequestMapping("/comment")
    public String com(){
        return "comment.html";
    }
}
