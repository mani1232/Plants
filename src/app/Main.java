package app;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isWorking = true;
        Scanner scanner = new Scanner(System.in);
        showInfo();

        try {
            do {
                System.out.printf("Input id (%s): ", getData().size());
                int choose = scanner.nextInt();
                switch (choose) {
                    case (0) -> showData(getData());
                    case (-1) -> isWorking = false;
                    case (-2) -> showInfo();
                    case (-3) -> {
                        System.out.println("Enter id: ");
                        int id = scanner.nextInt();
                        String sql = "DELETE FROM " + Constants.TABLE_NAME + " WHERE id = " + id + ";";
                        EditData.useCMD(sql);
                    }
                    case (-4) -> {
                        System.out.println("Enter name: ");
                        String name = scanner.next();
                        System.out.println("Enter description: ");
                        String description = scanner.next();
                        String sql = "INSERT INTO " + Constants.TABLE_NAME + " (name, description) VALUES (\"" + name + "\", \"" + description + "\");";
                        EditData.useCMD(sql);
                    }
                    case (-5) -> {
                        System.out.println("Enter id: ");
                        int id = scanner.nextInt();
                        System.out.println("Enter name: ");
                        String name = scanner.next();
                        System.out.println("Enter description: ");
                        String description = scanner.next();
                        String sql = "UPDATE " + Constants.TABLE_NAME + " SET name = \"" + name + "\", description = \"" + description + "\" WHERE id = " + id + ";";
                        EditData.useCMD(sql);
                    }
                    case (-6) -> {
                        System.out.println("Enter cmd: ");
                        System.out.println("""
                                UPDATE table
                                SET column_1 = 'value 1', column_2 = 'value 2', column_3 = 'value 3'
                                WHERE condition
                                """);
                        String sql = scanner.next();
                        EditData.useCMD(sql);
                    }
                    default -> {
                        System.out.println("Name: " + getData().get(choose).name + " Description: " + getData().get(choose).description );
                    }
                }
            } while (isWorking);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод получения данных
    private static List<DataBase> getData() {
        // Создаем экземпляр по работе с БД
        ReadData readData = new ReadData();
        // Получаем результаты
        return readData.selectAll();
    }

    // Метод вывода данных
    private static void showData(List<DataBase> objectsList) {
        int count = 0;
        for (DataBase o : objectsList) {
            count++;
            System.out.printf("%d. Name: %s%nDescription: %s%n", count, o.name, o.description);
        }
    }


    public static void showInfo() {
        System.out.println("""
                0 - show all data
                -1 - stop app
                -2 - show this info
                -3 - delete by id
                -4 - add
                -5 - set by id
                -6 - custom cmd
                """);
    }
}
