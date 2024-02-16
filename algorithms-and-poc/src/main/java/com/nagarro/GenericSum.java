package com.nagarro;

public class GenericSum {

    // Generic method to calculate the sum of two numbers
    public <T extends Number> T sum(T num1, T num2) {
        if (num1 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Long) {
            return (T) Long.valueOf(num1.longValue() + num2.longValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    public static void main(String[] args) {
        GenericSum calculator = new GenericSum();

        int intResult = calculator.sum(5, 10);
        System.out.println("Sum of integers: " + intResult);

        long longResult = calculator.sum(123456789L, 987654321L);
        System.out.println("Sum of longs: " + longResult);

        double doubleResult = calculator.sum(3.14, 2.71);
        System.out.println("Sum of doubles: " + doubleResult);
    }
}

