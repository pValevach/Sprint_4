package com.example;

import lombok.NonNull;

public class Account {

    private final String name;

    public Account(@NonNull String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return checkNameToSymbolsCount(name) && checkNameToOnlyOneSpaceChar(name) && checkNameToSpacePosition(name);
    }

    // строке не меньше 3 и не больше 19 символов
    public boolean checkNameToSymbolsCount(String name) {
        return 3 <= name.length() && name.length() <= 19;
    }

    //в строке есть только один пробел
    public boolean checkNameToOnlyOneSpaceChar(String name) {
        int spaceCount = 0;
        for (char element : name.toCharArray()) {
            if (element == ' ') spaceCount++;
        }
        return spaceCount == 1;
    }

    //пробел стоит не в начале и не в конце строки
    public boolean checkNameToSpacePosition(String name) {
        return !name.startsWith(" ") && !name.endsWith(" ");
    }
}