import java.util.Arrays;

public class SnakeMatrix implements IntegerMatrix {
    private final int[][] matrix;

    public SnakeMatrix(int rowNumber, int columnNumber){
        matrix = new int[rowNumber][columnNumber];

        int rowIndex = 0;
        int columnIndex = 0;
        int[] direction = new int[]{0, 1};

        for (int nextNumber = 1; nextNumber <= rowNumber * columnNumber; nextNumber++) {
            matrix[rowIndex][columnIndex] = nextNumber;

            if(rowIndex + direction[0] == rowNumber || columnIndex + direction[1] == columnNumber || // выход за пределы
                    rowIndex + direction[0] < 0 || columnIndex + direction[1] < 0 ||
                    matrix[rowIndex + direction[0]][columnIndex + direction[1]] != 0){ // змея стукнулась в себя
                turnRight(direction);
            }

            rowIndex += direction[0];
            columnIndex += direction[1];
        }
    }

    private void turnRight(int[] direction){
        if(direction[0] == 0 && direction[1] == 1) {
            direction[0] = 1;
            direction[1] = 0;
        } else if(direction[0] == 0 && direction[1] == -1){
            direction[0] = -1;
            direction[1] = 0;
        } else if(direction[0] == 1 && direction[1] == 0) {
            direction[0] = 0;
            direction[1] = -1;
        } else if(direction[0] == -1 && direction[1] == 0){
            direction[0] = 0;
            direction[1] = 1;
        }
    }

    @Override
    public int[][] getMatrix(){
        return Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
    }
}
