package com.lucien.queue;

import com.lucien.container.MiniStack;
import org.junit.Test;

import java.util.Random;
import java.util.Stack;

public class QueueTest {

    final int Max = 1 << 23;

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<Integer>();
        Random random = new Random();
        int value;
        for (int i = 1; i <= Max; i++) {
            value = random.nextInt(Max);
            if (value % 3 != 0) {
                stack.push(value);
            } else if (!stack.isEmpty()) {
                stack.peek();
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }
    @Test
    public void testMiniStack() {
        MiniStack<Integer> stack = new MiniStack<Integer>();
        Random random = new Random();
        int value;
        for (int i = 1; i <= Max; i++) {
            value = random.nextInt(Max);
            if (value % 3 != 0) {
                stack.push(value);
            } else if (!stack.isEmpty()) {
                stack.peek();
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }
}
