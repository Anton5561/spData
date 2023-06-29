package ru.denis.all.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class LogSt {

    @GetMapping("/login")
    public String login(){
        System.out.println("LOOOOOOGIN");

        return "login";
    }
    @ResponseBody
    @GetMapping("/test")
    public String getEr() {
        return "TEST page";
    }


    @ResponseBody
    @GetMapping("/cat")
    @PreAuthorize("hasRole('ADMIN')")
    public String getCat() {
        return "CATERPILLAR CATERPILLAR CATERPILLAR";
    }





}
