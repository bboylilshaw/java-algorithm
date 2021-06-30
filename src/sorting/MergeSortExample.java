package sorting;

import java.util.Arrays;

/**
 * 归并排序java实现
 */
public class MergeSortExample {

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // 0或1个元素不需排序
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length];
        // 将数组copy至tmp，从tmp中比较大小，写回arr中
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int current = left;
        while (i <= mid && j <= right) {
            if (tmp[i] < tmp[j]) {
                arr[current++] = tmp[i++];
            } else {
                arr[current++] = tmp[j++];
            }
        }

        while (i <= mid) {
            arr[current++] = tmp[i++];
        }

        while (j <= right) {
            arr[current++] = tmp[j++];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 2, 1, 3};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}