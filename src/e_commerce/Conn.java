package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    Connection con = null;
    public Connection getConnectionDetails()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
