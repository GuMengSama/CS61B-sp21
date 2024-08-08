package deque;

public class ArrayDeque<T> {
    private int start;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int arraySize;
    T[] items;

    /**
     * Creates an empty ArrayDeque
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        start = 4;
        nextFirst = 3;
        nextLast = 4;
        arraySize = items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    public void addFirst(T item) {
        if (size == arraySize) {
            resize(arraySize * 2);
        }
        size += 1;
        items[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = arraySize - 1;
        }
        start = nextFirst + 1;
        if (start >= arraySize) {
            start -= arraySize;
        }
    }

    public void addLast(T item) {
        if (size == arraySize) {
            resize(arraySize * 2);
        }
        size += 1;
        items[nextLast] = item;
        nextLast += 1;
        if (nextLast >= arraySize) {
            nextLast = 0;
        }
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < size; i +=1) {
            newItems[i + capacity / 4] = items[arrayIndex(i)];
        }
        items = newItems;
        arraySize = capacity;
        start = arraySize / 4;
        nextLast = start + size;
        nextFirst = start - 1;
    }

    private int arrayIndex(int i) {
        if (start + i >= arraySize) {
            return start + i - arraySize;
        }
        return start + i;
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[arrayIndex(i)] + " ");
        }
        System.out.println();
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (arraySize >= 16 && (size - 1) / (double)arraySize < 0.25) {
            resize(arraySize / 2);
        }
        nextLast = nextLast - 1;
        if (nextLast < 0) {
            nextLast += arraySize;
        }
        size -= 1;
        T theLast = items[nextLast];
        items[nextLast] = null;
        return theLast;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (arraySize >= 16 && (size - 1) / (double)arraySize < 0.25) {
            resize(arraySize / 2);
        }
        nextFirst = nextFirst + 1;
        if (nextFirst >= arraySize) {
            nextFirst -= arraySize;
        }
        size -= 1;
        T theFirst = items[nextFirst];
        items[nextFirst] = null;
        start = nextFirst + 1;
        if (start >= arraySize) {
            start -= arraySize;
        }
        return theFirst;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[arrayIndex(index)];
    }

}
