// [27070179_1]_[40081513_2]_A1
package coen352.ch4.dictionary;

public class LinkedLDictionary<Key, E> implements ADTDictionary<Key, E> {

    protected Node<Key, E> head; // Head of the linked list

    // Constructors
    LinkedLDictionary() {
        head = null;
    }

    // Inner Node class for the linked list
    static class Node<Key, E> {
        Key key;
        E value;
        Node<Key, E> next;

        Node(Key key, E value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Reinitialize
    public void clear() {
        head = null;
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
        
        /** Insert an element: append to the linked list */
        public void insert(Key k, E e) {
            // Check if the key already exists, and if so, return without inserting
            if (find(k) != null) {
                return;
            }
            
            // Create a new node and add it to the end of the linked list
            Node<Key, E> newNode = new Node<>(k, e);
            if (head == null) {
                head = newNode;
            } else {
                Node<Key, E> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        /** Use sequential search to find and remove an element */
        public E remove(Key k) {
            Node<Key, E> current = head;
            Node<Key, E> prev = null;

            while (current != null) {
                if (k.equals(current.key)) {
                    if (prev == null) {
                        // Removing the first node
                        head = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    return current.value;
                }
                prev = current;
                current = current.next;
            }

            return null; // Key not found
        }

        /** Remove the current element */
        public E removeAny() {
            if (head != null) {
                Node<Key, E> removedNode = head;
                head = head.next;
                return removedNode.value;
            } else {
                return null; // Dictionary is empty
            }
        }

        /** Get the size of the dictionary */
        public int size() {
            int count = 0;
            Node<Key, E> current = head;

            while (current != null) {
                count++;
                current = current.next;
            }

            return count;
        }

        /** String representation of each item <key, value> per line or by tab space */
        public String toString() {
            StringBuilder out = new StringBuilder();
            Node<Key, E> current = head;

            while (current != null) {
                out.append(current.key.toString()).append(":").append(current.value.toString());
                current = current.next;

                if (current != null) {
                    out.append(" , ");
                }
            }

            return out.toString();
        }
    }
 