package io.xiaoyao.algorithm;

import java.util.Arrays;

/**
 * 快速排序java实现
 */
public class QuickSortExample {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int pivotPosition = left;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, pivotPosition, left);
        return left;
    }


    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 2, 3, 2, 45, 4, 5, 1};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}