package com.webreach.mirth.server.mule.components.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    public WebController() {
    }

    @RequestMapping({"/index"})
    public String getIndex() {
        return "index";
    }
}
