import java.util.Arrays;

public class PyramidMatrix implements IntegerMatrix {
    private final int[][] matrix;

    public PyramidMatrix(int rowNumber, int columnNumber){
        matrix = new int[rowNumber][columnNumber];
        int averageRowNumber = (int) Math.round(rowNumber/2.);
        int averageColumnNumber = (int) Math.round(columnNumber/2.);

        for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++) {

                if(rowIndex < averageRowNumber && columnIndex < averageColumnNumber){
                    matrix[rowIndex][columnIndex] = Math.min(rowIndex, columnIndex) + 1;
                } else if (rowIndex < averageRowNumber){
                    matrix[rowIndex][columnIndex] = Math.min(columnNumber - columnIndex, rowIndex + 1);
                } else if (columnIndex < averageColumnNumber){
                    matrix[rowIndex][columnIndex] = Math.min(rowNumber - rowIndex, columnIndex + 1);
                } else {
                    matrix[rowIndex][columnIndex] = Math.min(rowNumber - rowIndex, columnNumber - columnIndex);
                }
            }
        }
    }

    @Override
    public int[][] getMatrix(){
        return Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
    }
}