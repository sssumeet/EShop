package e_commerce;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {
    public static void getRegistration()
    {
        UserRegistrationData  urd = new  UserRegistrationData();

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name");
        String name = sc.next();

        System.out.println("Enter your Mobile Number");
        String mob = sc.next();
        urd.getdetailsExistingUser(mob);


        System.out.println("Enter your Email Id");
        String email = sc.next();

        System.out.println("Enter your Address");
        String addss = sc.next();

        System.out.println("Enter your Password");
        String pass = sc.next();

        System.out.println("Confirm your Password");
        String cpass = sc.next();


        if(cpass.equals(pass))
        {
            urd.insertUserDetails(name, mob, email, addss, pass);
        }
        else
        {
            while(!cpass.equals(pass))
            {
                System.out.println("Entered password are different,please enter password again");
                System.out.println("confirm password");
                cpass = sc.next();
            }
            urd.insertUserDetails(name, mob, email, addss, pass);
        }
        sc.close();
    }
}
