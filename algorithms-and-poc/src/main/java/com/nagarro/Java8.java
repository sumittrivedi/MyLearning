package com.nagarro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8 {

    private static List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(101, "John", new int[]{80, 90, 85}),
            new Student(102, "Jane", new int[]{75, 88, 92}),
            new Student(103, "Bob", new int[]{95, 87, 89}),
            new Student(104, "Jay", new int[]{97, 17, 99}),
            new Student(105, "Vijay", new int[]{92, 83, 87}),
            new Student(106, "Suman", new int[]{52, 82, 57})
    ));

    public static <Char> void main(String args[]) {
            String str = "Hello World";
            str.chars().mapToObj(x -> (char) x).filter(x -> ("AEIOUaeiou".indexOf(x) != -1)).forEach(System.out::println);
            int[] array = {1,14,22,15,33,24};
            Arrays.stream(array).filter(x -> String.valueOf(x).startsWith("1")).forEach(System.out::println);

            int i =0;
//            studentList.stream().filter(x -> )
            System.out.println(Java8.getThirdHighestId());
            System.out.println(Java8.getTotalMarks());
    }

    public static int getThirdHighestId() {
        return studentList.stream().map(x -> x.id).sorted((id1, id2) -> Integer.compare(id2, id1)).skip(2).findFirst()
                .orElseThrow(() -> new RuntimeException("Not enough distinct student IDs"));
    }

    public static int getTotalMarks() {
        return studentList.stream()
                .flatMapToInt(student -> Arrays.stream(student.marks))
                .sum();
    }


}

class Student {
    int id;
    String name;
    int[] marks;

    public Student(int id, String name, int[] marks) {
        this.id = id;
        this.marks = marks;
        this.name = name;
    }

}
