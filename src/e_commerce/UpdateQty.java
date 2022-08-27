package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdateQty {

    public static void updateQuantity(String name,int uq)
    {
        try
        {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
            PreparedStatement statement = connection.prepareStatement("Update Items set Quantity = ? where Name = ?;");
            statement.setInt(1, uq);
            statement.setString(2, name);
            statement.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
