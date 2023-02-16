package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    Lion lion;

    @Mock
    Feline feline;

    {
        try {
            lion = new Lion(new Feline(),"Самец");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        Assert.assertEquals(0,lion.getKittens());
        Mockito.verify((Family)feline,Mockito.times(1)).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        Assert.assertEquals(new ArrayList<String>(),lion.getFood());
        Mockito.verify(feline,Mockito.times(1)).getFood("Хищник");
    }

}