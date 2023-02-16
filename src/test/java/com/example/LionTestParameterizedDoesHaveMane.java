package com.example;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;

@RunWith(Parameterized.class)
public class LionTestParameterizedDoesHaveMane {
    private final String sex;
    private final Object hasMane;
    @Mock
    Feline feline;

    public LionTestParameterizedDoesHaveMane(String sex,Object hasMane) throws Exception {
        this.sex=sex;
        this.hasMane=hasMane;
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"Самец",true},
                {"Самка",false},
                {"Самец-Самка","Используйте допустимые значения пола животного - самей или самка"},
        };
    }

    @Test
    public void doesHave() {
        try {
            Lion lion = Mockito.spy(new Lion(feline,sex));
            Assert.assertEquals(hasMane, lion.doesHaveMane());
            Mockito.verify(lion, Mockito.times(1)).doesHaveMane();
        } catch (Exception e) {
            Assert.assertEquals(hasMane, e.getMessage());
        }
    }
}
