import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        Random random = new Random();
        // Генерація матриці без явних циклів через Arrays.setAll
        int[][] matrix = new int[rows][cols];
        Arrays.setAll(matrix, i -> {
            int[] row = new int[cols];
            // Заповнюємо рядок випадковими числами від 0 до 10 для наочності дублікатів
            Arrays.setAll(row, j -> random.nextInt(11)); 
            return row;
        });
        System.out.println("Згенерована матриця:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        try {
            int result = MatrixTask.findMostFrequent(matrix);
            System.out.println("\nЧисло, що повторюється найчастіше: " + result);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}