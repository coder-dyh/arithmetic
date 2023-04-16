package com.dyh.fuxi;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/15 16:02
 * @version: v1.0.0
 */
public class DLinkedList<E> {

    private transient Node<E> first;
    private transient Node<E> last;

    private transient int size;

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void addLast(E e) {
        Node<E> l = last;
        final Node<E> newNode = new Node<>(last, null, e);
        if (l == null) {
            first = newNode;
            last = newNode;
        } else {
            l.next = newNode;
            last = newNode;
        }
        size++;
    }

    class Node<E> {
        private Node<E> pre;
        private Node<E> next;
        private E value;


        public Node(Node<E> pre, Node<E> next, E value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }
}
