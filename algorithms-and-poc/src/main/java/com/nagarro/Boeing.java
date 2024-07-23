package com.nagarro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    // 11,22,33,11,55,33,37,22
    public static void main(String args[]) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(5, "Sumit");
        hashMap.put(3, "Kumar");
        hashMap.put(4, "Arnav");
        hashMap.put(6, "Amit");
        Map.Entry entrySet  = (Map.Entry) hashMap.entrySet();
        entrySet.getValue()

    }
}
