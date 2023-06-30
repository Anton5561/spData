package ru.denis.all.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.denis.all.fox.Hen;

@Controller

public class LogSt {

//    public final Hen hen;
//
//    @Autowired
//    public LogSt(Hen hen) {
//        this.hen = hen;
//    }

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
        return "CATERPILLAR ";// + hen.getHen();
    }





}
