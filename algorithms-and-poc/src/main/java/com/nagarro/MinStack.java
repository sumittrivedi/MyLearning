package com.nagarro;

import java.util.LinkedList;

class MinStack {
    LinkedList<Integer> stack;
    int lastIdx;
    int minElement;

    public MinStack() {
        this.stack = new LinkedList<Integer>();
        lastIdx = -1;
        minElement = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.add(val);
        lastIdx++;
        if (val < minElement)
            minElement = val;
    }

    public void pop() {
        stack.remove(lastIdx--);
        updateMin();
    }

    public int top() {
        return stack.get(lastIdx);
    }

    public int getMin() {
        return minElement;
    }

    private void updateMin() {
        minElement = Integer.MAX_VALUE;
        int i = lastIdx;
        while (i >= 0) {
            if (stack.get(i) < minElement)
                minElement = stack.get(i);
            i--;
        }
    }
}