package com.example.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoneyManagerController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
