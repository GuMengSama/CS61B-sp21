package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        this.comparator = c;
    }

    public T max() {
        return max(this.comparator);
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
}
