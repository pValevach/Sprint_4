package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountSymbolsCountTest {
    private final String name;
    private final boolean expected;

    public AccountSymbolsCountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {"Те", false},//2 символа
                {"Тек", true},//3 символа
                {"ТекстТекстТекстТекс", true},//19 символа
                {"ТекстТекстТекстТекст", false},//20 символа
        };
    }

    @Test
    public void differentNameLengthTest() {
        Account account = new Account(name);

        assertEquals("Неккоректная длина поля 'Имя'", expected, account.checkNameToSymbolsCount(name));
    }
}
