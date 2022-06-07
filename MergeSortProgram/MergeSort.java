package MergeSortProgram;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private final List<Integer> array;
    private final int startIndex = 0;
    private final int endIndex;

    public MergeSort(List<Integer> array) {
        this.array = array;
        this.endIndex = this.array.size() - 1;
    }

    public void sortRecursively() {
        System.out.println(sortRecursivelyInternal(this.array, startIndex, endIndex));
    }

    private List<Integer> sortRecursivelyInternal(List<Integer> sortArray, int start, int end) {
        if (start == end) {
            return sortArray;
        }
        int mid = (start + end) / 2;
        sortRecursivelyInternal(sortArray, start, mid);
        sortRecursivelyInternal(sortArray, mid + 1, end);

        merge(sortArray, start, mid, end);
        return sortArray;
    }

    private void merge(List<Integer> sortArray, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int temp = 0;
        List<Integer> auxiliaryArray = new ArrayList<>();

        while (i <= mid && j <= end) {
            int list1Element = sortArray.get(i);
            int list2Element = sortArray.get(j);
            if (list1Element <= list2Element) {
                auxiliaryArray.add(list1Element);
                i++;
            } else {
                auxiliaryArray.add(list2Element);
                j++;
            }
        }
        while (i <= mid) {
            auxiliaryArray.add(sortArray.get(i));
            i++;
        }
        while (j <= end) {
            auxiliaryArray.add(sortArray.get(j));
            j++;
        }
        for (int x = start; x <= end; x++) {
            sortArray.set(x, auxiliaryArray.get(temp));
            temp++;
        }
    }
}
