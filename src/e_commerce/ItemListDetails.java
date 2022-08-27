package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ItemListDetails {
    static int Qty ;
    static String name=" ";
    static int price;
    static int i;

    public static void getItemPurchaseDetails()
    {
        do
        {
            System.out.println("\nSelect Serial Number to Buy Item");
            Scanner scanner= new Scanner(System.in);
            i = scanner.nextInt();
            if(i>=1 && i<=10)
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/E_Shop", "root", "root");
                    Statement statement = connection.createStatement();

                    ResultSet rs = statement.executeQuery("select * from items;");
                    System.out.println("\nProduct Description...\n");
                    while(rs.next())
                    {
                        if(rs.getInt("Serial_Num")==i)
                        {
                            System.out.println("Item Id: " + rs.getString("Id") + "\nFeatures: " + rs.getString("Description"));
                            System.out.println("Item Price: " + rs.getInt("Price") + "\nQuantity Available: " + rs.getInt("Quantity"));
                            Qty=rs.getInt("Quantity");
                            name=rs.getString("Name");
                            price=rs.getInt("Price");
                        }
                    }

                    Shopping.getShoppingDetails();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Incorrect Serial Number\n");
            }
        }while(i<1 || i>10);

    }
}
