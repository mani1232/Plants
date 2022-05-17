package app;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isWorking = true;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.printf("Input id(%s): ", getData().size());
                int id = scanner.nextInt();
                switch (id) {
                    case 0: showData(getData());
                    case -1: isWorking = false;
                    case -2:
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (isWorking);
    }

    // Метод получения данных
    private static List<Fruit> getData() {
        // Создаем экземпляр по работе с БД
        ReadData readData = new ReadData();
        // Получаем результаты
        return readData.selectAll();
    }

    // Метод вывода данных
    private static void showData(List<Fruit> fruits) {
        int count = 0;
        for (Fruit fruit : fruits) {
            count++;
            System.out.printf("%d. %s%n%s%n%n", count, fruit.name, fruit.description);
        }
    }
}
