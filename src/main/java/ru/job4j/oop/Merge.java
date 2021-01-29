package ru.job4j.oop;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < result.length; k++) {
            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
            } else if (i < left.length && j == right.length) {
                result[k] = left[i];
                i++;
            } else if (j < right.length && i == left.length) {
                result[k] = right[j];
                j++;
            }
        }
        return result;
    }
}
