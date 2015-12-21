package exercise_1.test;


import exercise_1.fibonacci.FibonacciSequence;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by dyxogus on 2013/11/13
 * This is a simple test program designed to explore and test the correctness of the implementations
 * of the Fibinacci sequence and the various strategies of implementing them
 *
 * @see FibonacciSequence
 */
public class FibonacciSequenceTest {
    /**
     * Instance variable of the fibonacci sequence implementation to be tested
     */
    FibonacciSequence fibonacci = new FibonacciSequence();

    @Test
    public void negativeTerms() {
        try {
            fibonacci.term(-1);
            fail("Expected exception");
        } catch (IllegalArgumentException iae) {
            assertEquals("Not defined for negative terms", iae.getMessage());
        }
    }

    /**
     * Tests the output of the first two terms, which should be 1
     */
    @Test
    public void firstTwoTerms() {
        assertEquals(1, fibonacci.term(0));
        assertEquals(1, fibonacci.term(1));
    }

    @Test
    public void hasEachTermEqualToTheSumOfThePreviousTwo() {
        assertEquals(2, fibonacci.term(2));
        assertEquals(3, fibonacci.term(3));
        assertEquals(5, fibonacci.term(4));
        assertEquals(8, fibonacci.term(5));
    }

    @Test
    public void canBeIteratedThrough() {
        Iterable<Integer> sequence = fibonacci;

        Iterator<Integer> i = sequence.iterator();
        assertTrue(i.hasNext());
        assertThat(i.next(), is(1));
        assertThat(i.next(), is(1));
        assertThat(i.next(), is(2));
        assertThat(i.next(), is(3));
        assertTrue(i.hasNext());
    }

    @Test
    public void canHaveMultipleIndependentIterators() {
        Iterator<Integer> i1 = fibonacci.iterator();
        Iterator<Integer> i2 = fibonacci.iterator();

        assertThat(i1.next(), is(1));
        assertThat(i1.next(), is(1));

        assertThat(i2.next(), is(1));
        assertThat(i2.next(), is(1));
        assertThat(i2.next(), is(2));
        assertThat(i2.next(), is(3));

        assertThat(i1.next(), is(2));
        assertThat(i1.next(), is(3));
    }
}
