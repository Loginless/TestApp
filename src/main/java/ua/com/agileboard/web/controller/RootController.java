package ua.com.agileboard.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {


    @GetMapping("/")
    public String root() {
        return "redirect:users";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

}
