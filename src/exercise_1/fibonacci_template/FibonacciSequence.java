package exercise_1.fibonacci_template;

public class FibonacciSequence extends NumberSequenceTemplate {

    public int term(int i) {
        if (i < 0) throw new IllegalArgumentException("Not defined for negative terms");
        if (i < 2) return 1;

        return term(i - 1) + term(i - 2);
    }
}
