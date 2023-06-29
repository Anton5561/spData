package ru.denis.all.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.*;
import org.springframework.util.Assert;

import ru.denis.all.exeption.SpringExeption;
import ru.denis.all.fox.FoxyJ;
import ru.denis.all.fox.Lemon;

@ExtendWith({MockitoExtension.class})
//@ExtendWith(SpringExeption.class)
//@ContextConfiguration()

public class FoxyTest {

    @Spy
    private Lemon lemon = new Lemon();



    @InjectMocks
    private FoxyJ foxyJ;

    @Test
    public void testFoxy1() {
        Assertions.assertEquals(foxyJ.getRealName(), "Настоящее имя:blue");
    }

    @Test
    public void testFoxy2() {
        Mockito.doReturn("green").when(lemon).getColour();
        //Mockito.doReturn("Настоящее имя:никакое").when(foxyJ).getRealName();
        Assertions.assertEquals(foxyJ.getRealName(), "Настоящее имя:green");
    }

}
