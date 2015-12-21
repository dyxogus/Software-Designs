package exercise_1.fibonacci_strategy;

public class FibonacciSequence implements SequenceStrategy {
    public int term(int input) {
        if (input < 0) throw new IllegalArgumentException("Cannot be applied to negative integers");
        if (input < 2) return 1;

        return term(input - 1) + term(input - 2);
    }
}
