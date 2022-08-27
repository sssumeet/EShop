package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistrationData {
    PreparedStatement prs=null;
    Connection con=null;

    public void insertUserDetails(String Name, String Mob_Num, String  Email_Id, String Address, String Password)
    {
        try
        {
            Conn connectionTest=new Conn();
            con=connectionTest.getConnectionDetails();
            prs=con.prepareStatement("insert into user_list(Name,Mob_Num,Email_Id,Address,Password)values(?,?,?,?,?)");
            prs.setString(1,Name);
            prs.setString(2,Mob_Num);
            prs.setString(3,Email_Id);
            prs.setString(4,Address);
            prs.setString(5,Password);

            int i=prs.executeUpdate();
            System.out.println("\nRegistration Completed\n");

            System.out.println("--------------------------");
            System.out.println("Enter details for Login");
            System.out.println("--------------------------");
            Login.getLogin();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void getdetailsExistingUser(String Mob_Num)
    {
        String str=Mob_Num;

        try
        {

            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from user_list;");
            while(rs.next())
            {
                if(rs.getString("Mob_Num").equals(str))
                {

                    System.out.println("Already Registered,Please Login");
                    System.out.println("Enter details for Login\n");
                    Login.getLogin();

                }

            }
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
