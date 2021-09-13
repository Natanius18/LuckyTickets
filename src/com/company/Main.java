package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(luckyTickets(18));
    }

    public static long luckyTickets(int length) {
        if (length % 2 != 0) return 0;
        if (length == 2) return 10;

        long res = 0, tmpSum = 0;
        long[] arrayNn = new long[(length / 2) * 9 + 1], arrayNnPrev;

        for (long i = 0; i <= 9; i++) {
            arrayNn[(int) i] = 1;                 // заполнили единицами первые 10 элементов
        }

        arrayNnPrev = Arrays.copyOf(arrayNn, arrayNn.length);

        for (long n = 1; n < length / 2; n++) {
            for (long k = 0; k <= length / 2 * 9L; k++) {
                for (long l = 0; l < 10; l++) {                  //  считаем сумму 10-ти чисел из предыдущего массива,
                    if (l <= k) {                              //   получаем значение k-го элемента настоящего массива
                        tmpSum += arrayNnPrev[(int) (k - l)];
                    }
                }
                arrayNn[(int) k] = tmpSum;
                tmpSum = 0;
            }
            arrayNnPrev = Arrays.copyOf(arrayNn, arrayNn.length);
        }
        for (long i = 0; i <= 9L * length / 2; i++) {
            res += arrayNn[(int) i] * arrayNn[(int) i];
        }
        return res;
    }
}