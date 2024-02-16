package com.epam;

@FunctionalInterface
public interface InterfaceB {
    default int getIndex() {
        return 2;
    }

    static int staticIndex() {
        return 22;
    }

    int getName();
}
