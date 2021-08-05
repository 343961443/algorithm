package com.zs.algorithm.sort;

/**
 * 从数列中挑出一个元素，称为 "基准"（pivot）;
 * <p>
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * <p>
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 */
public class QuickSort implements SortInterface {
    @Override
    public int[] sort(int[] array) {
        sortInternal(array, 0, array.length - 1);
        return array;
    }

    public void sortInternal(int[] array, int left, int right) {
        if (left < right) {
            int point = partition(array, left, right);
            // point 就在 中间 ，不用管它，排序两边的值 就行
            sortInternal(array, left, point - 1);
            sortInternal(array, point + 1, right);
        }

    }

    public int partition(int[] array, int left, int right) {
        // 左指针已经拿出来了。暂时放到了point里
        int point = array[left];
        while (left < right) {
            //  从右边找到小于基准值的第一个值
            while (left < right && point <= array[right]) {
                right--;
            }
            // 赋值给左指针,此时右指针值已经copy走了
            array[left] = array[right];

            //  从左边找到大于基准值的第一个值
            while (left < right && point >= array[left]) {
                left++;
            }
            //  放在空出来的右指针里面
            array[right] = array[left];
        }
        //  最终一定会空出来左指针
        array[left] = point;
        return left;
    }

    public static void main(String[] args) {
        PrintUtil.print(new QuickSort());
    }

}
