package exercise_1.fibonacci;

import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer> {
    public int term(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for negative terms");
        }
        if (i < 2) {
            return 1;
        }
        return term(i - 1) + term(i - 2);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int index;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                int result = term(index);
                index++;
                return result;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
