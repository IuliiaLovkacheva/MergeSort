package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


// Метод merge реализован на языке Java как часть класса MergeSort.
// В main приведен пример использования сортировки.
public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(23, 4, 5, 1, -898, 0, 12, 4));
        sort(a, 1, a.size());
        a.forEach(System.out::println);
    }

    public static void sort(ArrayList<Integer> a, int p, int r) {
        if (p < r) {
            int q = BigDecimal.valueOf((p + r) / 2.0).setScale(0, RoundingMode.HALF_DOWN).intValue();
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    // Для сохранения для p, q и r индексации, приведенной в задании (индексов, начинающихся с 1)
    // преобразование от таких индексов к индексам, начинающимся с 0, происходит при обращении к
    // элементам temp и a (например, a.get(j - 1))
    private static void merge(ArrayList<Integer> a, int p, int q, int r) {
        List<Integer> temp = new ArrayList<>(r - p + 1);
        int i = p;
        int j = q + 1;
        while (i < (q + 1) && j < (r + 1)) {
            if (a.get(i - 1) >= a.get(j - 1)) {
                temp.add(a.get(j - 1));
                ++j;
            } else {
                temp.add(a.get(i - 1));
                ++i;
            }
        }
        if (i == (q + 1)) {
            while (j < (r + 1)) {
                temp.add(a.get(j - 1));
                ++j;
            }
        } else {
            while (i < (q + 1)) {
                temp.add(a.get(i - 1));
                ++i;
            }
        }
        for (i = 0, j = p; i < temp.size(); ++i, ++j) {
            a.set(j - 1, temp.get(i));
        }
    }
}