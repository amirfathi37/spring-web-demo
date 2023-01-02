package com.alian.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlianController {

    @GetMapping(path = "/home")
    public String home(int id) {
        return "home.jsp";
    }

    @GetMapping(path = "alians")
    public String alians(int id) {
        return "alianshow.jsp";
    }
}
