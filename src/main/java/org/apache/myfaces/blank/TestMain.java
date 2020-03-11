package org.apache.myfaces.blank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        Integer[] tempArray = {1, 3, 6, 2, 3, 4, 7, 9, 0};

        List<Integer> listTemp= Arrays.asList(tempArray);

        Collections.sort(listTemp);

        Integer[] xxxx=(Integer[])listTemp.toArray();
        System.out.println(xxxx.toString());

        System.out.println(binarySearch(xxxx,3));
    }

    public static int binarySearch(Integer[] tempArray, int value) {
        int low=0;
        int len=tempArray.length;
        int high=len-1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (tempArray[mid] == value) {
                return mid;
            } else if (tempArray[mid] < value) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
}
