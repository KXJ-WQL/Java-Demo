package com.WQL.control;

import com.WQL.exception.MyResponseStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class welcome {

    @RequestMapping("/")
    public String come(){

        if (true) {
            throw new MyResponseStatus();
        }
        return "index.html";
    }
}
