package com.epam;

@FunctionalInterface
public interface InterfaceA {
    int x = 9;
    default int getIndex() {
        return 1;
    }

    static int staticIndex() {
        return 11;
    }

    int getName();
}
