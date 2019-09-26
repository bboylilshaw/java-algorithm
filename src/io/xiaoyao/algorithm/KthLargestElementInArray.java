package io.xiaoyao.algorithm;

import io.xiaoyao.algorithm.common.SwapUtil;

import java.util.PriorityQueue;

/**
 * 找出数组中第K个大的元素
 * 例如，给出[1, 4, 6, 5], 找出第2大的元素，返回5
 */
public class KthLargestElementInArray {


    /**
     * 方法1
     * 快排的变种，在快排寻找pivot的过程中找到第k大的数字
     */
    public static int find(int[] arr, int k) {
        if (k > arr.length) throw new RuntimeException();
        return find(arr, 0, arr.length - 1, k);
    }

    public static int find(int[] arr, int left, int right, int k) {
        int index = partition(arr, 0, arr.length - 1);
        while (index != arr.length - k) {
            if (index > arr.length - k) {
                index = partition(arr, left, index - 1);
            } else {
                index = partition(arr, index + 1, right);
            }
        }
        return arr[index];
    }

    public static int partition(int[] arr, int left, int right) {
        int pivotPos = left;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            SwapUtil.swap(arr, left, right);
        }
        SwapUtil.swap(arr, pivotPos, left);
        return pivotPos;
    }


    /**
     * 方法2
     * 用最小顶堆实现，一个个数字加到堆里，堆里保持k个元素，遍历完，堆顶就是第k大的数字
     *
     * ps，取第k大的用小顶堆，取第k小的用大顶堆
     */
    public static int findKth(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 2, 3, 4, 4, 4, 7};
        System.out.println(find(nums, 2));//第二大应该输出5
        System.out.println(findKth(nums, 2));//第二大应该输出5
    }
}
