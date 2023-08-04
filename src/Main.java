import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int answer;

        do {
            printMainMenu();
            System.out.print("Ответ: ");
            answer = inputInt(0, 3);

            switch (answer) {
                case 1 -> {
                    System.out.print("Введите размер матрицы: ");
                    int size = inputInt(1, 20);

                    var snakeMatrix = new SnakeMatrix(size, size);
                    var pyramidMatrix = new PyramidMatrix(size, size);
                    System.out.println("\nМатрица змейка со сторонами размером " + size);
                    MatrixPrinter.print(snakeMatrix);
                    System.out.println("\nМатрица пирамидка со сторонами размером " + size);
                    MatrixPrinter.print(pyramidMatrix);
                }
                case 2 -> {
                    System.out.print("введите число строк матрицы: ");
                    int rowNumber = inputInt(1, 20);
                    System.out.print("Введите число столбцов матрицы: ");
                    int columnNumber = inputInt(1, 20);

                    var snakeMatrix = new SnakeMatrix(rowNumber, columnNumber);
                    System.out.printf("\nМатрица змейка размером %d\u00D7%d\n", rowNumber, columnNumber);
                    MatrixPrinter.print(snakeMatrix);
                }
                case 3 -> {
                    System.out.print("Введите число строк матрицы: ");
                    int rowNumber = inputInt(1, 20);
                    System.out.print("Введите число столбцов матрицы: ");
                    int columnNumber = inputInt(1, 20);

                    var pyramidMatrix = new PyramidMatrix(rowNumber, columnNumber);
                    System.out.printf("\nМатрица пирамидка размером %d\u00D7%d\n", rowNumber, columnNumber);
                    MatrixPrinter.print(pyramidMatrix);
                }
            }
        }
        while (answer != 0);

        System.out.println("Пока");
    }

    public static int inputInt(int minimum, int maximum){
        int input;

        while (true) {
            try {
                input = new Scanner(System.in).nextInt();
                if (input < minimum || input > maximum) {
                    System.out.printf("Ожидается число в пределах от %d до %d, попробуйте еще раз\n", minimum, maximum);
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Необходимо ввести целое число, попробуйте еще раз");
            }
        }
        return input;
    }

    public static void printMainMenu(){
        String menu = """
                
                1. Показать квадратные матрицы змейку и пирамидку.
                2. Показать змейку.
                3. Показать пирамидку.
                0. Выход.
                """;
        System.out.println(menu);
    }
}