package Utility;

public class Tuple {
    private float first;
    private float second;

    public Tuple(float f, float s) {
        first = f;
        second = s;
    }

    public Tuple() {
    }

    public void setFirst(float f) {
        first = f;
    }

    public void setSecond(float s) {
        second = s;
    }

    public float getFirst() {
        return first;
    }

    public float getSecond() {
        return second;
    }
}
