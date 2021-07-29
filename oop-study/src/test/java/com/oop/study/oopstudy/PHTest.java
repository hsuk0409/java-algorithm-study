package com.oop.study.oopstudy;

import org.junit.jupiter.api.Test;

public class PHTest {
    @Test
    void test() {
        int[] arr = {2, 7, 9, 13, 20};
//        int index = getIndex(9, arr);

//        System.out.println(index);

        System.out.println("--------- Recursive --------");
        int index = getIndexRecursive(9, arr, 0, arr.length - 1);
        System.out.println(index);

        index = getIndexRecursive(20, arr, 0, arr.length - 1);
        System.out.println(index);

        index = getIndexRecursive(2, arr, 0, arr.length - 1);
        System.out.println(index);

        index = getIndexRecursive(200, arr, 0, arr.length - 1);
        System.out.println(index);

        System.out.println("--------- Loop --------");
        index = getIndexBinarySearchLoop(13, arr);
        System.out.println(index);

        index = getIndexBinarySearchLoop(2, arr);
        System.out.println(index);

        index = getIndexBinarySearchLoop(2000, arr);
        System.out.println(index);
    }

    public int getIndex(int num , int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == num) {
                return i;
            }
        }

        return -1;
    }

    public int getIndexRecursive(int num, int[] arr, int s, int e) {
        if (s <= e) {
            int mid = (s + e) / 2;

            if (arr[mid] == num) return mid;

            if (arr[mid] > num) {
                return getIndexRecursive(num, arr, s, mid - 1);
            } else {
                return getIndexRecursive(num, arr, mid + 1, e);
            }
        }

        return -1;
    }

    public int getIndexBinarySearchLoop(int num, int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        int mid = 0;

        while (s <= e) {
            mid = (s + e) / 2;

            if (arr[mid] == num) return mid;
            if (arr[mid] > num) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }
}
