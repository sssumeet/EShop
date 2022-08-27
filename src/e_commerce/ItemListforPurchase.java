package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class ItemListforPurchase {

    public static void getItemList()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/E_Shop", "root", "root");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from items;");
            System.out.println("\n------------------------------");
            System.out.println("Id"+"\t"+"Product Name");
            System.out.println("------------------------------");
            while(rs.next())
            {
                System.out.println(rs.getInt("Serial_Num") + " \t" + rs.getString("Name"));
            }
            System.out.println("------------------------------");
            ItemListDetails.getItemPurchaseDetails();



        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
