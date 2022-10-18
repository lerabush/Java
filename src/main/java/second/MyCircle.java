package second;

import java.time.LocalDate;
import java.util.Objects;

public class MyCircle {
    private Node first = null;
    private Node last = null;
    private int size = 0;
    private Node current = null;

    @Override
    public String toString() {
        Node curr = next();
        StringBuilder str = new StringBuilder();
        if (first != null) {
            do {
                str.append(curr.getInfo()).append(curr.next != first ? " - " : "");
                curr = next();
            } while (curr != first);
        }
        return str.toString();
    }

    public Node next() {
        if (current == null) {
            current = first;
        }
        Node tmp = current;
        current = current.next;
        return tmp;
    }

    public void add(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        last.next = first;
        size++;
    }

    public Node findNode(String value) {
        Node tmp = first;
        if (first == null) return null;

        do {
            if (Objects.equals(tmp.getInfo(), value)) {
                return tmp;
            }
        } while (tmp != first);
        return null;
    }

    public Node getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    public class Node {
        private String info;
        private Node next;

        public Node(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }
    }

}
