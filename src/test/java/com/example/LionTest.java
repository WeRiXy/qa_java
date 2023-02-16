package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        Mockito.when(feline.getKittens()).thenReturn(0);
        Assert.assertEquals(0,lion.getKittens());
        Mockito.verify((Family)feline,Mockito.times(1)).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),lion.getFood());
        Mockito.verify(feline,Mockito.times(1)).getFood("Хищник");
    }
    @Test
    public void LionTestNewInstanceReturnThrow() throws Exception {
        Throwable exception = assertThrows(Exception.class, () -> new Lion(feline,"Самса"));
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    };
}