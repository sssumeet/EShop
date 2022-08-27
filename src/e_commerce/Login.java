package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    static String uName;
    static String name;
    public static void getLogin() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter UserName to Login");
        uName = sc.next();
        try
        {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from user_list;");
            while(rs.next())
            {
                if(uName.equals("admin")) {
                    System.out.println("Enter Admin Password");
                    String pass =sc.next();
                    if(pass.equals("admin")){
                        Admin.getDetails();
                        return;
                    }
                }
                else if(rs.getString("Mob_Num").equals(uName))
                {
                    name = rs.getString("Name");
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        LoginDetails.insertLoginDetails(uName);
        sc.close();
    }
}
