package exercise_1.fibonacci;

import java.util.Iterator;

public class TriangularSequence implements Iterable<Integer> {
    public int term(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(
                    "Error 1 : Term cannot be negative or Zero");
        }
        if (n == 1) {
            return 1;
        }
        return (n * (n + 1)) / 2;
    }

    @Override
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
