package app;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        showData(getData());
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
