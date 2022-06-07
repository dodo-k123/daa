package MinMaxProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 7, 8, 4));
        MinMax minMax = new MinMax(array);
        Pair result = minMax.findElements();
        System.out.println(result);
    }
}
