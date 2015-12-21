package exercise_1.fibonacci_strategy;

public class TriangularSequence implements SequenceStrategy {
    @Override
    public int term(int n) {
        //
        if (n < 1) throw new IllegalArgumentException("Term cannot be negative or Zero");

        //
        if (n == 1) return 1;

        //
        return (n * (n + 1)) / 2;
    }
}
