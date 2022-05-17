package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.printf("Input id(%s): ", getData().size());
                int id = scanner.nextInt();
                if (id == -1) break;
                if (id == 0) showData(getData());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (true);
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
