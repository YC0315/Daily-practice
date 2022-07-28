/**
 * 二分查找:二分查找针对的是一个有序的数据集合!!否则做折半时不能保证左边的都比当前值小，右边的都比当前值大
 */
public class binarySearchs {
    /**
     * 迭代法二分查找
     * @param arr
     * @param target
     */
    public static int binarySearch01(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        // 不要用下面这种写法，如果left和right比较大时，求和可能会溢出
        // int mid = (left + right) / 2;
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) {
            return binarySearch01(arr, target, left, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearch01(arr, target, mid + 1, right);
        } else {
            return mid;
        }
    }

    /**
     * 使用while循环进行二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch02(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (left > right) {
            return -1;
        }
        // 这块有等于！！
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 二分查找变形问题,数组中有重复元素

    /**
     * 查找第一个值等于给定值的元素的索引
     * @return
     */
    public static int binarySearch03(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int find = -1;
        // 对于左闭右闭的区间使用left<=right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    find = mid;
                    break;
                } else {
                    // 因为要找的元素肯定出现在[left, mid-1]之间。
                    right = mid - 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return find;
    }

    /**
     * 查找最后一个值等于给定值的元素的索引
     * @return
     */
    public static int binarySearch04(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int find = -1;
        // 对于左闭右闭的区间使用left<=right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (mid == right || arr[mid + 1] != target) {
                    find = mid;
                    break;
                } else {
                    // 因为要找的元素肯定出现在[mid+1, right]之间。
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return find;
    }

    /**
     * 查找第一个大于等于给定值的元素索引
     * @return
     */
    public static int binarySearch05(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int find = -1;
        // 对于左闭右闭的区间使用left<=right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 注意这块的条件可以这样写，因为相等或者大于target都是去寻找左区间，所以可以合并
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    find = mid;
                    break;
                } else {
                    // 因为要找的元素肯定出现在[left, mid-1]之间。
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return find;
    }
    /**
     * 查找最后一个小于等于给定值的元素索引
     * @return
     */
    public static int binarySearch06(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int find = -1;
        // 对于左闭右闭的区间使用left<=right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 注意这块的条件可以这样写，因为相等或者小于target都是去寻找右区间，所以可以合并！！
            if (arr[mid] <= target) {
                if (mid == right || arr[mid + 1] > target) {
                    find = mid;
                    break;
                } else {
                    // 因为要找的元素肯定出现在[mid+1, right]之间，所以继续二分法寻找以下区间。
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return find;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 3, 3, 5, 6, 7, 8};
        int k = 3;
        // 静态方法无法调用实例成员方法
        int search01 = binarySearch01(nums, k, 0, nums.length - 1);
        System.out.println("迭代法查找到的索引：" + search01);

        int search02 = binarySearch02(nums, k);
        System.out.println("while循环查找的索引：" + search02);

        int search03 = binarySearch03(nums, k);
        System.out.println("给定元素的第一个值的索引为：" + search03);

        int search04 = binarySearch04(nums, k);
        System.out.println("给定元素的最后一个值的索引为：" + search04);

        int search05 = binarySearch05(nums, k);
        System.out.println("查找第一个大于等于给定值的元素索引为：" + search05);

        int search06 = binarySearch06(nums, k);
        System.out.println("查找最后一个小于等于给定值的元素索引为：" + search06);
    }
}
