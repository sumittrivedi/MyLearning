package com.epam;

import java.util.Stack;


//wrong output
 public class NextGreaterElement {
    public static void main(String args[]) {
        int[] array = {5,2,66,44,8,58,92,34};
        int[] output = new NextGreaterElement().nextGreaterElement(array);
        for (int x : output)
            System.out.println(x);
    }

    private int[] nextGreaterElement(int[] array) {
        // Write your code here.
        int n = array.length;
        int output[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int j =0;
        for(int i = n-1; i >=0; i-- ){
            while(j < i && array[j] < array[i])
                j++;
            if(array[j] <= array[i])
                output[i] = -1;
            else{
                output[i] = array[j];
                stack.push(array[j]);
            }
            stack.push(array[i]);
        }
        return output;
    }
}
