package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        this.c = c;
    }

    public T max() {
        return max(this.c);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T result = get(0);
        for (int i = 1; i < size(); i += 1) {
            if (c.compare(result, get(i)) <= 0) {
                result = get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Comparator<Integer> intComparator = Integer::compareTo;
        MaxArrayDeque<Integer> L = new MaxArrayDeque<>(intComparator);
        L.addLast(1);
        L.addLast(2);
        L.addFirst(3);


    }
}
