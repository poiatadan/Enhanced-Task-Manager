package com.danutsrl.testare.controllers;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


@Controller
public class ViewController {
    @RequestMapping("/")
    public String viewHomePage() {


        return "index";
    }
}




