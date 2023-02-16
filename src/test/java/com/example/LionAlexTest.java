package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Feline feline;

    @Test
    public void getFood() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),lionAlex.getFood());
        Mockito.verify(feline,Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFriends() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        Assert.assertEquals(List.of("Марти", "Глория","Мелман"),lionAlex.getFriends());
    }

    @Test
    public void getPlaceOfLiving() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        Assert.assertEquals("Нью-Йоркский зоопарк",lionAlex.getPlaceOfLiving());
    }

    @Test
    public void getKittens() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        Assert.assertEquals(0,lionAlex.getKittens());
    }

    @Test
    public void doesHaveMane() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        Assert.assertEquals(true,lionAlex.doesHaveMane());
    }
}