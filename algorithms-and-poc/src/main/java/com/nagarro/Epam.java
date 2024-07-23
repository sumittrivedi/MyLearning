package com.nagarro;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Epam {

    /*
   create key value from the String ArrayList in Java8 ,
  where key is the string as in list and value is the count
  and sort them?
   */
    public static void main(String[] args) {
        String x = "aabcddcghijef";
//        String x = "cbbd";
        String tempPlaindrome = "";
        for (int i = 0; i < x.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < x.length() && x.charAt(j) == x.charAt(k)) {
                j--;
                k++;
            }
            String temp = x.substring(j + 1, k );
            if(temp.length() > tempPlaindrome.length()) {
                tempPlaindrome = temp;
            }

            j = i;
            k = i + 1;
            while (j >= 0 && k < x.length() && x.charAt(j) == x.charAt(k)) {
                j--;
                k++;
            }

            String temp2 = x.substring(j + 1, k );
            if(temp2.length() > tempPlaindrome.length()) {
                tempPlaindrome = temp2;
            }
        }
       System.out.println(tempPlaindrome);
    }
}


//    private static void helper(Node head) {
//        Node slow = head;
//        Node fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }

//    }


    /*
    You are given the head of a singly linked-list. The list can be
    represented as:
    L0 → L1 → … → Ln - 1 → Ln

    Reorder the list to be on the following form:
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …


    You may not modify the values in the list's nodes.
    Only nodes themselves may be changed.

    */
//}



//        Node head = new Node(0, null);
//        head.next = new Node(1, null);
//        Node second = head.next;
//        second.next = new Node(2, null);
//        Node third = second.next;
//        third.next = new Node(3, null);



//        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
//
//       names.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()))
//        .forEach((key, value) -> System.out.println(key + " " + value));
//
//        names.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
//                .sorted((x,y) -> {
//                    return x.getKey().compareTo(y.getKey());
//                })
//                .forEach(System.out::println);
//class Node {
//    int data;
//    Node next;
//    public Node(int data, Node next) {
//        this.data = data;
//        this.next = next;
//    }
//
//
//    String x = "aabcddcghijef"
//}
