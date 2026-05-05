import java.util.Arrays;
/**
 * Клас MatrixTask містить методи для поглибленої роботи з масивами.
 * Реалізує логіку пошуку статистичних даних у матрицях без використання інтерфейсу користувача.
 */
public class MatrixTask {
    /**
     * Знаходить число, що повторюється найчастіше у матриці розміром N x M.
     * 
     * Алгоритм:
     * 1. Вирівнює двовимірну матрицю в одновимірний масив за допомогою Stream API.
     * 2. Сортує масив для групування однакових елементів.
     * 3. Знаходить найдовшу послідовність однакових чисел.
     * 
     * @param matrix двовимірний масив цілих чисел розміром N x M
     * @return число, яке зустрічається у матриці найбільшу кількість разів
     * @throws IllegalArgumentException якщо матриця порожня або дорівнює null
     */
    public static int findMostFrequent(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матриця порожня");
        }

        // Перетворюємо матрицю на одновимірний масив без використання звичайних циклів (Stream API)
        int[] flatArray = Arrays.stream(matrix)
                                .flatMapToInt(Arrays::stream)
                                .toArray();

        // Сортуємо для групування однакових чисел поруч
        Arrays.sort(flatArray);

        int mostFrequent = flatArray[0];
        int maxCount = 1;
        int currentCount = 1;

        // Пошук найдовшої серії однакових елементів у відсортованому масиві
        for (int i = 1; i < flatArray.length; i++) {
            if (flatArray[i] == flatArray[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostFrequent = flatArray[i - 1];
                }
                currentCount = 1;
            }
        }

        // Фінальна перевірка для останнього елемента
        return (currentCount > maxCount) ? flatArray[flatArray.length - 1] : mostFrequent;
    }
}