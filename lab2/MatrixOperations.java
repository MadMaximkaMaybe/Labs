import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
    private static final int MAX_SIZE = 20; // Максимальный размер матрицы
    private static final int RANDOM_MIN = 1; // Минимальное случайное значение для элементов матрицы
    private static final int RANDOM_MAX = 100; // Максимальное случайное значение для элементов матрицы

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width, height;

        // Ввод ширины и высоты матрицы
        System.out.print("Введите ширину матрицы: ");
        width = scanner.nextInt();
        System.out.print("Введите высоту матрицы: ");
        height = scanner.nextInt();

        // Проверка размеров матрицы
        if (width <= 0 || height <= 0 || width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Некорректный размер матрицы.");
            return;
        }

        // Создание матрицы
        int[][] matrix = createMatrix(width, height);
        System.out.println("Матрица создана:");

        // Вывод матрицы
        printMatrix(matrix);

        // Поиск минимального и максимального элементов
        int min = findMin(matrix);
        int max = findMax(matrix);
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);

        // Вычисление среднего арифметического
        double average = calculateAverage(matrix);
        System.out.println("Среднее арифметическое: " + average);
    }

    // Метод для создания матрицы
    private static int[][] createMatrix(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
            }
        }

        return matrix;
    }

    // Метод для вывода матрицы
    private static void printMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для поиска минимального элемента в матрице
    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    // Метод для поиска максимального элемента в матрице
    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    // Метод для вычисления среднего арифметического элементов матрицы
    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sum += matrix[i][j];
                count++;
            }
        }

        return (double) sum / count;
    }
}
