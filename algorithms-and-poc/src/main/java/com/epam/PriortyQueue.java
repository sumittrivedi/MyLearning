package com.epam;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriortyQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(12);
        queue.add(78);
        queue.add(11);
        queue.add(4);
        queue.add(7);
        queue.add(9);
        queue.remove();
        System.out.println(queue);
    }

}
