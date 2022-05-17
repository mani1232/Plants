package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Чтение данных из БД.
// https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html
// >> интерфейс Statement
// Объект, используемый для выполнения статического оператора SQL и
// возврата результатов, которые он выдает. По умолчанию только один
// объект ResultSet на объект Statement может быть открыт одновременно.
// >> интерфейс ResultSet
// Таблица данных, представляющая набор результатов базы данных, который
// обычно генерируется путем выполнения оператора, который запрашивает
// базу данных.
public class ReadData {

    public List<DataBase> selectAll() {

        // Создание списка-коллекции
        List<DataBase> DataBase = new ArrayList<>();
        // Формируем SQL-запрос в БД
        String sql = "SELECT name, description FROM " + Constants.TABLE_NAME;

        try (Statement stmt = DbConn.connect().createStatement()) {
            // Осуществляем SQL-запрос в БД
            try (ResultSet rs = stmt.executeQuery(sql)) {
                // Цикл вывода данных
                while (rs.next()) {
                    DataBase.add(new DataBase(
                                    rs.getString("name"),
                                    rs.getString("description")
                            )
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Если ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
        // Возвращаем список
        return DataBase;
    }
}
