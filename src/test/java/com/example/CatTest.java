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
public class CatTest {
    @Spy
    Feline felineSpy = new Feline();
    @Mock
    Cat catMock;
    @Mock
    Feline felineMock;
    @Mock
    Predator predatorMock;

    @Test
    public void getSoundWithStub() {
        Mockito.when(catMock.getSound()).thenReturn("Мяф");
        Assert.assertEquals("Мяф",catMock.getSound());
        Mockito.verify(catMock, Mockito.times(1)).getSound();
    }

    @Test
    public void getFoodWithMock() throws Exception {
        predatorMock = felineMock;
        Cat cat = new Cat(felineMock);
        Assert.assertEquals(new ArrayList<String>(),cat.getFood());
        Mockito.verify(predatorMock, Mockito.times(1)).eatMeat();
    }
    @Test
    public void getFoodWithSpy() throws Exception {
        Cat cat = new Cat(felineSpy);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),cat.getFood());
        Mockito.verify(felineSpy, Mockito.times(1)).eatMeat();
    }
}