package e_commerce;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDetails {
    public static void insertLoginDetails(String userName)
    {
        try
        {
            Scanner sc= new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
            Statement stm = con.createStatement();
            String sql=("select * from user_list;");
            ResultSet rs=stm.executeQuery(sql);

            int count=0;

            while(rs.next())
            {
                if(rs.getString("Mob_Num").equals(userName))
                {
                    System.out.println("Enter your Password");
                    String pass="";
                    count++;
                    while(!pass.equals(rs.getString("Password")))
                    {
                        pass = sc.next();
                        if(rs.getString("Password").equals(pass))
                        {
                            System.out.println("\nLogin Successfully...\n\nStart your Shopping with E_Shop...\n");

                            System.out.println("Items to Purchase : ");
                            ItemListforPurchase.getItemList();
                            return;

                        }else
                        {
                            System.out.println("Enter correct password\n");
                        }
                    }
                }
            }
            if(count==0)
            {
                System.out.println();
                System.out.println("You are not registered user");
                System.out.println();
                System.out.println("Enter details for Registration");
                Registration.getRegistration();

            }
            stm.close();
            con.close();
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
