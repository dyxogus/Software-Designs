package exercise_1.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import exercise_1.fibonacci.TriangularSequence;
import org.junit.Test;

public class TriangleSequenceTest {
    TriangularSequence triangle = new TriangularSequence();

    @Test
    public void definesTheFirstTermToBeOne() {
        assertEquals(1, triangle.term(1));
    }

    @Test
    public void hasEachTermEqualProductOfNextTwoHalved() {
        assertEquals(3, triangle.term(2));
        assertEquals(6, triangle.term(3));
        assertEquals(10, triangle.term(4));
        assertEquals(15, triangle.term(5));
        assertEquals(21, triangle.term(6));
        assertEquals(28, triangle.term(7));
    }

    @Test
    public void noNegativeTerms() {
        try {
            triangle.term(-1);
            fail("Expected Exception");
        } catch (IllegalArgumentException i) {
            assertEquals("Error 1 : Term cannot be negative or Zero",
                    i.getMessage());
        }
    }

    @Test
    public void canBeIteratedThrough() {
        Iterable<Integer> sequence = triangle;
        Iterator<Integer> iterator = sequence.iterator();

        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        // assertThat(iterator.next(), is(6));
        // assertThat(iterator.next(), is(10));
        assertTrue(iterator.hasNext());

    }

    @Test
    public void canHaveMultipleIndependentIterators() {

        Iterator<Integer> iterator_one = triangle.iterator();
        Iterator<Integer> iterator_two = triangle.iterator();

        assertThat(iterator_one.next(), is(1));
        assertThat(iterator_one.next(), is(1));

        assertThat(iterator_two.next(), is(1));
        assertThat(iterator_two.next(), is(1));
        assertThat(iterator_two.next(), is(2));
        assertThat(iterator_two.next(), is(3));

        assertThat(iterator_one.next(), is(2));
        assertThat(iterator_one.next(), is(3));
    }
}