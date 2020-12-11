package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Base {
    public static String connectionString = "jdbc:mysql://localhost:3306/Examo";
    private static Connection con;

    public static Connection GetConnection(){
        if(con != null){
            return con;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connectionString,"root", "1234");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}