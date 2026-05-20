import java.util.Scanner;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<MatrixFactory> factories = MatrixFactory.Registry.getAll();
        
        int answer;

        do {
            printMainMenu(factories);
            System.out.print("Ответ: ");
            answer = inputInt(0, factories.size());

            if (answer > 0) {
                MatrixFactory factory = factories.get(answer - 1);
                
                System.out.print("Введите число строк матрицы: ");
                int rowNumber = inputInt(1, 20);
                System.out.print("Введите число столбцов матрицы: ");
                int columnNumber = inputInt(1, 20);

                var matrix = factory.create(rowNumber, columnNumber);
                System.out.printf("\nМатрица %s размером %d×%d\n", factory.getTypeName(), rowNumber, columnNumber);
                MatrixPrinter.print(matrix);
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

    public static void printMainMenu(List<MatrixFactory> factories){
        StringBuilder menu = new StringBuilder("\n");
        for (int i = 0; i < factories.size(); i++) {
            menu.append(i + 1).append(". Показать ").append(factories.get(i).getTypeName()).append(".\n");
        }
        menu.append("0. Выход.\n");
        System.out.println(menu.toString());
    }
}