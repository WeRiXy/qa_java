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
public class FelineTest {

    @Spy
    Feline feline;


    @Test
    public void eatMeat() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void eatMeatWitStub() throws Exception {
        Mockito.doReturn(new ArrayList<String>()).doThrow(new RuntimeException()).when((Animal)feline).getFood(Mockito.anyString());
        Assert.assertEquals(new ArrayList<String>(), feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }


    @Test
    public void getFamily() {
        String family = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        Assert.assertEquals("Кошачьи", family);
    }


    @Test
    public void getFamilyWithStub() throws Exception {
        Mockito.when(feline.getFamily()).thenAnswer(invocation -> new Animal().getFamily());
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",feline.getFamily());
        Mockito.verify(feline,Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        Assert.assertEquals(1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensKittensCount2Return2() {
        Assert.assertEquals(2, feline.getKittens(2));
        Mockito.verify(feline, Mockito.times(1)).getKittens(Mockito.anyInt());
    }


}