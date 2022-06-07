package MergeSortProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 7, 8, 4));
        MergeSort ms = new MergeSort(array);
        ms.sortRecursively();
        System.out.println(array);
    }
}
