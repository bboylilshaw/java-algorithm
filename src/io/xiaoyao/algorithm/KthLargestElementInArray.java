package io.xiaoyao.algorithm;

import io.xiaoyao.algorithm.common.SwapUtil;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 找出数组中第K个大的元素
 * 例如，给出[1, 4, 6, 5], 找出第2大的元素，返回5
 */
public class KthLargestElementInArray {


    /**
     * 方法1
     * 快排的变种，在快排寻找pivot的过程中找到第k大的数字
     */
    public static int findKth1(int[] nums, int k) {
        if (k <=0 || k > nums.length) throw new IllegalArgumentException();
        //因为数组中有重复元素，先去重
        Set<Integer> sets = new HashSet<>(nums.length);
        int[] dedupedNums = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (!sets.contains(num)) {
                sets.add(num);
                dedupedNums[i++] = num;
            }
        }

        return find(dedupedNums, 0, dedupedNums.length - 1, k);
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
     * ps，取第k大的用小顶堆，取第k小的用大顶堆
     */
    public static int findKth2(int[] nums, int k) {
        if (k <= 0 || k > nums.length) throw new IllegalArgumentException();
        Set<Integer> numSet = new HashSet<>(nums.length);
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i : nums) {
            //处理重复元素，若数组没有重复，直接queue.offer(i)
            if (!numSet.contains(i)) {
                numSet.add(i);
                queue.offer(i);
            }

            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2, 3, 4, 4, 4, 5};
        int[] nums2 = new int[]{4, 1, 2, 3, 4, 4, 4};
        System.out.println(findKth1(nums1, 2));//第二大应该输出4
        System.out.println(findKth2(nums1, 2));//第二大应该输出4
        System.out.println(findKth2(nums2, 2));//第二大应该输出3
        System.out.println(findKth2(nums2, 2));//第二大应该输出3
    }
}
