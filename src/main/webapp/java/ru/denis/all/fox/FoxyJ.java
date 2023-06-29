package ru.denis.all.fox;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
//@AllArgsConstructor
public class FoxyJ {
    Lemon lemon;

//    public FoxyJ(Lemon lemon) {
//         this.lemon = lemon;
//      }

    public String getRealName() {
        System.out.println("1111111111");
        return "Настоящее имя:" + lemon.getColour();
    }
}
