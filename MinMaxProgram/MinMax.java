package MinMaxProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMax {
    public final int startIndex = 0;
    public final int endIndex;
    public List<Integer> array;
    public Pair pair = new Pair();

    public MinMax(List<Integer> array) {
        this.array = array;
        this.endIndex = array.size() - 1;
    }

    public Pair findElements() {
        findElementsInternal(this.array, startIndex, endIndex);
        return pair;
    }

    private void findElementsInternal(List<Integer> userArray, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            if (pair.min > userArray.get(startIndex)) {
                pair.min = userArray.get(startIndex);
            }
            if (pair.max < userArray.get(startIndex)) {
                pair.max = userArray.get(startIndex);
            }
            return;
        }
        if (endIndex - startIndex == 1) {
            if (userArray.get(startIndex) < userArray.get(endIndex)) {
                if (pair.min > userArray.get(startIndex)) {
                    pair.min = userArray.get(startIndex);
                }
                if (pair.max < userArray.get(endIndex)) {
                    pair.max = userArray.get(endIndex);
                }
            }else{
                if (pair.min > userArray.get(endIndex)) {
                    pair.min = userArray.get(endIndex);
                }
                if (pair.max < userArray.get(startIndex)) {
                    pair.max = userArray.get(startIndex);
                }
            }
            return;
        }
        int mid = (startIndex + endIndex) / 2;
        findElementsInternal(userArray, startIndex, mid);
        findElementsInternal(userArray, (mid + 1), endIndex);
    }
}
