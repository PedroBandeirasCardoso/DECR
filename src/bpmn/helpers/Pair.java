package helpers;

public class Pair<E, K> {

	private E first;
	private K second;

	public Pair(E first, K second) {
		super();
		this.first = first;
		this.second = second;
	}

	public E getFirst() {
		return first;
	}

	public K getSecond() {
		return second;
	}
}
