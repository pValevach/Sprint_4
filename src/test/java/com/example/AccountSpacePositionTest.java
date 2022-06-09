package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountSpacePositionTest {
    private final String name;
    private final boolean expected;

    public AccountSpacePositionTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {" Текст", false},//пробел в начале
                {"Текст ", false},//пробел в конце
                {" Текст ", false},//пробелы и в начале и в конце
                {"Текст Текст", true},//пробел в середине
                {" Текст Текст ", false},//пробелы в начале, в середине и в конце
        };
    }

    @Test
    public void differentSpacePositionTest() {
        Account account = new Account(name);

        assertEquals("Неккоректное расположение пробела в поле 'Имя'", expected, account.checkNameToSpacePosition(name));
    }
}
