package com.user.profile.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class RootController {

    public RootController() {
    }

    @GetMapping()
    public @ResponseBody
    String getRoot() {
        return "Profile Application";
    }
}
