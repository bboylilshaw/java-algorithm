package common;

/**
 * @author Jason Xiao
 * @date 2019/9/20
 */
public class SwapUtil {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
