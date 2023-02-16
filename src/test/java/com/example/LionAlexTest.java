package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Feline feline;
    @Mock
    Lion lion;

    @Test
    public void getFood() throws Exception {
        LionAlex lionAlex = Mockito.spy(new LionAlex(feline));
        Assert.assertEquals(new ArrayList<String>(),lionAlex.getFood());
        Mockito.verify(feline,Mockito.times(1)).getFood(Mockito.anyString());
    }


    @Test
    public void getFriends() throws Exception {
        LionAlex lionAlex = Mockito.spy(new LionAlex(feline));
        Assert.assertEquals(List.of("Марти", "Глория","Мелман"),lionAlex.getFriends());
        Mockito.verify(lionAlex, Mockito.times(1)).getFriends();
    }

    @Test
    public void getPlaceOfLiving() throws Exception {
        LionAlex lionAlex = Mockito.spy(new LionAlex(feline));
        Assert.assertEquals("Нью-Йоркский зоопарк",lionAlex.getPlaceOfLiving());
        Mockito.verify(lionAlex,Mockito.times(1)).getPlaceOfLiving();
    }

    @Test
    public void getKittens() throws Exception {
        LionAlex lionAlex = Mockito.spy(new LionAlex(feline));
        Assert.assertEquals(0,lionAlex.getKittens());
        Mockito.verify(feline,Mockito.times(1)).getKittens(0);
    }

    @Test
    public void doesHaveMane() throws Exception {
        LionAlex lionAlex = Mockito.spy(new LionAlex(feline));
        Assert.assertEquals(true,lionAlex.doesHaveMane());
        Mockito.verify((Lion)lionAlex,Mockito.times(1)).doesHaveMane();
    }
}