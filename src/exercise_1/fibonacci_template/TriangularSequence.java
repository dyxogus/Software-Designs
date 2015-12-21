package exercise_1.fibonacci_template;

/**
 * Template Method Implementation of the Triangular Sequence Generator
 */
public class TriangularSequence extends NumberSequenceTemplate {
    @Override
    public int term(int n) {
        // Throw and exception for any number that is 0 or smaller
        if (n < 1) throw new IllegalArgumentException("Term cannot be negative or Zero");

        // Base Case :: N=1 => 1
        if (n == 1) return 1;

        // Recursive Case :: (Nx(N+1))/2
        return (n * (n + 1)) / 2;
    }
}
