package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private int size;
    private TNode sentinal;

    private class TNode {
        private T item;
        private TNode prev;
        private TNode next;

        /**
         * Creates a TNode
         */
        TNode(T item, TNode prev, TNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Creates an empty LinkedListDeque
     */
    public LinkedListDeque() {
        size = 0;
        sentinal = new TNode(null, null, null);
        sentinal.prev = sentinal;
        sentinal.next = sentinal;
    }


    /**
     * Return the size of the LinkedListDeque
     */
    public int size() {
        return size;
    }

    public void addLast(T item) {
        TNode newNode = new TNode(item, sentinal.prev, sentinal);
        sentinal.prev.next = newNode;
        sentinal.prev = newNode;
        size += 1;
    }

    public void addFirst(T item) {
        TNode newNode = new TNode(item, sentinal, sentinal.next);
        sentinal.next.prev = newNode;
        sentinal.next = newNode;
        size += 1;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line
     */
    public void printDeque() {
        for (TNode p = sentinal.next; p != sentinal; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    /**
     * Returns the element whose index is the same as given
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        TNode p = sentinal.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.item;
    }

    /**
     * Removes the last element and return its item
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        TNode theLast = sentinal.prev;
        theLast.prev.next = sentinal;
        sentinal.prev = theLast.prev;
        size -= 1;
        return theLast.item;
    }

    /**
     * Removes the first element and return its item
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        TNode theFirst = sentinal.next;
        theFirst.next.prev = sentinal;
        sentinal.next = theFirst.next;
        size -= 1;
        return theFirst.item;
    }

    /**
     * Same as get, but uses recursion
     */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinal.next, index);
    }

    private T getRecursiveHelper(TNode node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        TNode pointerPos;

        LinkedListDequeIterator() {
            pointerPos = sentinal.next;
        }

        public boolean hasNext() {
            return pointerPos != sentinal;
        }

        public T next() {
            T result = pointerPos.item;
            pointerPos = pointerPos.next;
            return result;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        if (size() != ((Deque<T>) o).size()) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            T x = get(i);
            T y = ((Deque<T>) o).get(i);
            if (!x.equals(y)) {
                return false;
            }
        }
        return true;
    }

}
