package Utility;

public class Tuple<E> {
    private E first;
    private E second;

    public Tuple(E f, E s) {
        first = f;
        second = s;
    }

    public Tuple() {
    }

    public void setFirst(E f) {
        first = f;
    }

    public void setSecond(E s) {
        second = s;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }
}
