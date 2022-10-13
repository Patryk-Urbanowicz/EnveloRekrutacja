/*
Złożoność obliczeniowa: O(log n)
Złożoność pamięciowa: O(n)
n - liczba elementów w tablicy numbers
 */

public class Zadanie2 {

    private boolean search(int[] numbers, int x) {
        int l = 0, m, r = numbers.length;

        while (l != r) {
            m = (l + r) / 2;
            if (numbers[m] == x) return true;
            if (numbers[m] > x) l = m + 1;
            else r = m - 1;
        }
        if (numbers[l] == x) return true;
        return false;
    }
}
