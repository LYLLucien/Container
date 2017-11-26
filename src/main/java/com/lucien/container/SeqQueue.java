package com.lucien.container;

class ListNode<T> {
    T value;
    ListNode<T> next;

    public ListNode(T value, ListNode<T> next) {
        super();
        this.value = value;
        this.next = next;
    }
}

public class SeqQueue<T> {
    private int size;
    private ListNode<T> head;
    private ListNode<T> last;

    public SeqQueue() {
        super();
        head = new ListNode<T>(null, null);
        last = head;
    }

    public synchronized void offer(T t) {
        ListNode<T> node = new ListNode<T>(t, null);
        last.next = node;
        last = node;
        size++;
    }

    public synchronized T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return head.next.value;
        }
    }

    public synchronized T poll() {
        if (isEmpty()) {
            return null;
        } else {
            ListNode<T> p = head.next;
            head.next = p.next;
            size--;
            if (size == 0) {
                last = head;
            }
            return p.value;
        }
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized int size() {
        return size;
    }

}
