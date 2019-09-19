package io.xiaoyao.algorithm;

import java.util.Arrays;

/**
 * 小顶堆实现
 */
public class MinHeap {

    public int capacity = 16;
    private int size = 0;
    private int[] arr = new int[capacity];

    public MinHeap() {

    }

    private void ensureCapacity() {
        if (size == capacity) {
            arr = Arrays.copyOf(arr, capacity*2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (arr.length == 0) throw new IllegalStateException();
        return arr[0];
    }

    public int poll() {
        if (arr.length == 0) throw new IllegalStateException();
        int item = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (index < size - 1 && hasLeftChild(index)) {
            int childIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && arr[childIndex] > arr[getRightChildIndex(index)]) {
                childIndex = getRightChildIndex(index);
            }
            if (arr[index] < arr[childIndex]) {
                break;
            } else {
                swap(index, childIndex);
            }
            index = childIndex;
        }
    }

    private boolean hasRightChild(int index) {
        return (index * 2 + 2) < size;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private boolean hasLeftChild(int index) {
        return (index * 2 + 1) < size;
    }

    public void add(int num) {
        ensureCapacity();
        arr[size] = num;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (arr[index] < arr[getParentIndex(index)] && index > 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 8, 12, 4, 6};
        MinHeap heap = new MinHeap();

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(heap.poll());
        }
    }
}
