package second;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task16 {
    public static void main(String[] args) {
        Queue que = new Queue();
        MyCircle circle = new MyCircle();
        circle.add("one");
        circle.add("two");
        circle.add("three");
        System.out.println(circle.toString());
    }

    static class Queue {
        protected Node first;
        protected Node last;
        protected int size = 0;

        void add(String val) {
            Node l = last;
            last = new Node(l, null, val);
            if (l != null) {
                l.next = last;
            } else {
                first = last;
            }
            size++;
        }

        void remove() {
            first = first.next;
            size--;
        }

        int getSize() {
            return size;
        }

        Queue print(PrintStream out) {
            String queueString = Stream.iterate(first, Objects::nonNull, node -> node.next)
                    .map(node -> node.item)
                    .collect(Collectors.joining(" "));
            out.println(queueString);
            return this;
        }


        static class Node {
            protected Node next;
            protected Node prev;
            protected String item;

            Node(Node prev, Node next, String item) {
                this.prev = prev;
                this.next = next;
                this.item = item;
            }
        }

    }

    private static void print2(Queue q) {
        for (Task16.Queue.Node node = q.first; node != null; node = node.next) {
            System.out.print(node.item + " ");
        }
        System.out.println();
    }

    private static void print3(Queue q) {
        Task16.Queue.Node node = q.first;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }
}
