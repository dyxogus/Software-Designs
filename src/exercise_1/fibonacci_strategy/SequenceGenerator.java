package exercise_1.fibonacci_strategy;

import java.util.Iterator;

public abstract class SequenceGenerator implements Iterable<Integer> {
    SequenceStrategy strategy;

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
                int result = strategy.term(index);
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
