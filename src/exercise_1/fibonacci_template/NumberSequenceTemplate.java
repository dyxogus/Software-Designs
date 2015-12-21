package exercise_1.fibonacci_template;

import java.util.Iterator;

public abstract class NumberSequenceTemplate implements Iterable<Integer> {

	// Template Method, which will be overwritten in the subclasses
	public abstract int term(int n);

	// Hook Method, which classes have in common, therefore don't have to
	// implement everytime I make a similar class.
	@Override
	public Iterator<Integer> iterator(){
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
