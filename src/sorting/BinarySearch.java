package sorting;

/**
 * @author Jason Xiao
 * @date 2019/10/12
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] < x) {
                low = mid + 1;
            } else if (nums[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1; //未找到
    }

    //递归方式
    public static int binarySearchRecursively(int[] nums, int x, int low, int high) {
        if (low >= high) return -1;
        int mid = (low + high) / 2;

        if (nums[mid] < x) {
            return binarySearchRecursively(nums, x, mid + 1, high);
        } else if (nums[mid] > x) {
            return binarySearchRecursively(nums, x, low, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(binarySearch(nums, 4));
        System.out.println(binarySearchRecursively(nums, 4, 0, nums.length - 1));
    }
}
