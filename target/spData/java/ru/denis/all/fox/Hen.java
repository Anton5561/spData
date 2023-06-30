package ru.denis.all.fox;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Hen {
   public String getHen(){
       return "hen";
   }

}
