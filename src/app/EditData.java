package app;

import java.sql.SQLException;

public class EditData {
    public static void useCMD(String cmd) {
        try {
            DbConn.connect().createStatement().execute(cmd);
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
