package com.lucien.container;

public class MiniStack<T> {

    private int size;
    private Object[] array = new Object[4];

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized int size() {
        return size;
    }

    private synchronized void expandCapacity() {
        Object[] newArray = new Object[size * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public synchronized void push(T t) {
        array[size] = t;
        size++;
        if (size == array.length) {
            expandCapacity();
        }
    }

    public synchronized T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) array[size - 1];
        }
    }

    public synchronized T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T t = peek();
            array[size - 1] = null;
            size--;
            return t;
        }
    }
}
