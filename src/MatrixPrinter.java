import java.util.Arrays;

public class MatrixPrinter {
    private MatrixPrinter(){}

    public static void print(IntegerMatrix integerMatrix){
        int[][] matrix = integerMatrix.getMatrix();
        int maxNumberOfMatrix = Arrays.stream(matrix).flatMapToInt(Arrays::stream).max().orElse(0);
        int cellLength = Math.max(2, (maxNumberOfMatrix + "").length());  // определяю длинну ячейки матрицы при выводе

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length - 1; columnIndex++) {
                System.out.printf("%0," + cellLength + "d,", matrix[rowIndex][columnIndex]);
            }
            System.out.printf("%0," + cellLength + "d\n", matrix[rowIndex][matrix[rowIndex].length - 1]);
        }
    }
}
