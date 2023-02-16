package com.example;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionTestParameterizedDoesHaveMane {
    private final String sex;
    private final boolean hasMane;
    @Mock
    Feline feline;

    public LionTestParameterizedDoesHaveMane(String sex,boolean hasMane) throws Exception {
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
        };
    }

    @Test
    public void doesHave() throws Exception {
            Lion lion = new Lion(feline,sex);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
    }
}
