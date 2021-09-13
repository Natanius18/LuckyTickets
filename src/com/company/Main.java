package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(luckyTickets(8));
    }

    public static int luckyTickets(int length) {
        if (length % 2 != 0) return 0;
        if (length == 2) return 10;

        int res = 0, tmpSum = 0;
        int[] arrayNn = new int[(length / 2) * 9 + 1], arrayNnPrev;

        for (int i = 0; i <= 9; i++) {
            arrayNn[i] = 1;                 // заполнили единицами первые 10 элементов
        }

        arrayNnPrev = Arrays.copyOf(arrayNn, arrayNn.length);

        for (int n = 1; n < length / 2; n++) {
            for (int k = 0; k <= length / 2 * 9; k++) {
                for (int l = 0; l < 10; l++) {                  //  считаем сумму 10-ти чисел из предыдущего массива,
                    if (l <= k) {                              //   получаем значение k-го элемента настоящего массива
                        tmpSum += arrayNnPrev[k - l];
                    }
                }
                arrayNn[k] = tmpSum;
                tmpSum = 0;
            }
            arrayNnPrev = Arrays.copyOf(arrayNn, arrayNn.length);
        }
        for (int i = 0; i <= 9 * length / 2; i++) {
            res += arrayNn[i] * arrayNn[i];
        }
        return res;
    }
}