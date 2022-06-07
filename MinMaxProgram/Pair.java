package MinMaxProgram;

public class Pair {
    public int max;
    public int min;

    public Pair() {
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return (Integer.toString(this.min) + ", " + Integer.toString(this.max));
    }
}
