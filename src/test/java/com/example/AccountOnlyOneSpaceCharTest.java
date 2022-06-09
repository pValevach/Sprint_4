package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountOnlyOneSpaceCharTest {
    private final String name;
    private final boolean expected;

    public AccountOnlyOneSpaceCharTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {"ТекстТекст", false},//0 пробелов
                {"Текст Текст", true},//1 пробелов
                {"Текст Текст Текст", false},//2 пробела
        };
    }

    @Test
    public void differentSpaceCountTest() {
        Account account = new Account(name);

        assertEquals("Неккоректное кол-во пробелов в поле 'Имя'", expected, account.checkNameToOnlyOneSpaceChar(name));
    }
}
