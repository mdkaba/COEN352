// [27070179_1]_[40081513_2]_A1

package coen352.ch4.dictionary;

public class DoubleLinkedListDictionary<Key, E> implements ADTDictionary<Key, E> {

    private Node<Key, E> head; // Head of the double linked list
    private Node<Key, E> tail; // Tail of the double linked list

    // Constructors
    public DoubleLinkedListDictionary() {
        head = null;
        tail = null;
    }

    // Inner Node class for the double linked list
    private static class Node<Key, E> {
        Key key;
        E value;
        Node<Key, E> next;
        Node<Key, E> prev;

        Node(Key key, E value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    // Reinitialize
    public void clear() {
        head = null;
        tail = null;
    }

    public E find(Key k) {
        Node<Key, E> current = head;

        while (current != null) {
            if (k.equals(current.key)) {
                return current.value;
            }
            current = current.next;
        }

        return null; // Key not found
    }

    public int findByKey(Key k) {
        Node<Key, E> current = head;
        int index = 0;

        while (current != null) {
            if (k.equals(current.key)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1; // Key not found
    }

    public void insert(Key k, E e) {
        // Check if the key already exists, and if so, return without inserting
        if (find(k) != null) {
            return;
        }

        Node<Key, E> newNode = new Node<>(k, e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E remove(Key k) {
        Node<Key, E> current = head;

        while (current != null) {
            if (k.equals(current.key)) {
                if (current == head) {
                    head = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current == tail) {
                    tail = current.prev;
                } else {
                    current.next.prev = current.prev;
                }
                return current.value;
            }
            current = current.next;
        }

        return null; // Key not found
    }

    public E removeAny() {
        if (tail == null) {
            return null; // Dictionary is empty
        }

        Node<Key, E> removedNode = tail;

        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        return removedNode.value;
    }

    public int size() {
        int count = 0;
        Node<Key, E> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        Node<Key, E> current = head;

        while (current != null) {
            out.append(current.key.toString()).append(":").append(current.value.toString());
            current = current.next;
            if (current != null) {
                out.append(" , ");}
        }

        return out.toString();
    }
}