package second;

import java.io.PrintStream;

public class Task17 {
    public static void main(String[] args) {
        PrintStream out = System.out;
        new IterableQueue()
                .add("a");
    }

    private static class IterableQueue extends Task16.Queue {

        IterableQueue print(PrintStream out){
            for (IterableQueue.Iterator iterator = iterator(); iterator.hasNext(); ) {
                out.print(iterator.next().item + " ");
            }
            out.println();
            return this;
        }

        Iterator iterator() {
            return new Iterator();
        }

        private class Iterator {
            Node node;

            Iterator() {
                this.node = first;
            }

            Node next() {
                Node tmp = node;
                node = node.next;
                return tmp;
            }

            boolean hasNext() {
                return node != null;
            }
        }
    }
}
