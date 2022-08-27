package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Admin {
    public static void getAdminLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Admin UserName");
        String uName = "";

        while(!uName.equals("admin")) {
            uName = sc.next();

            if(uName.equals("admin")) {
                System.out.println("Enter Admin Password");
                String pass = "";
                while(!pass.equals("admin"))
                {
                    pass =sc.next();
                    if(pass.equals("admin"))
                    {
                        Admin.getDetails();
                    }
                    else
                    {
                        System.out.println("Enter Correct Admin Password");
                    }
                }
            }
            else
            {
                System.out.println("Enter Correct Admin UserName");
            }
        }
    }

    public static void getDetails()
    {
        String i;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nPress 1 for Registered User Details");
            System.out.println("Press 2 for Product Details");
            System.out.println("Press 3 for User Purchase History Details");
            i = sc.next();

            if(i.equals("1")) {
                Admin.getUserListDetails();
                do{
                    System.out.println("Press 1 For HomePage");
                    System.out.println("Press 2 for Admin Details");
                    System.out.println("Press 0 For Exit Application");
                    i = sc.next();

                    if(i.equals("1")) {
                        HomePage.getHomepage();
                    }else if(i.equals("2")){
                        Admin.getDetails();
                    }else if(i.equals("0")){
                        System.out.println("\nTHANK YOU FOR VISIT..!!");
                        System.exit(0);
                    }else {
                        System.out.println("Enter Correct Input");
                    }
                }while(!i.equals("1") && !i.equals("2"));

            }

            else if(i.equals("2")) {
                Admin.getItemListDeatils();
                do {
                    System.out.println("Press 1 For HomePage");
                    System.out.println("Press 2 for Admin Details");
                    System.out.println("Press 0 For Exit Application");
                    i = sc.next();

                    if(i.equals("1")) {
                        HomePage.getHomepage();
                    }else if(i.equals("2")){
                        Admin.getDetails();
                    }else if(i.equals("0")){
                        System.out.println("\nTHANK YOU FOR VISIT..!!");
                        System.exit(0);
                    }else {
                        System.out.println("Enter Correct Input");
                    }
                }while(!i.equals("1") && !i.equals("2"));
            }

            else if(i.equals("3")) {
                Admin.getPurchaseHistoryDetails();
                do {
                    System.out.println("Press 1 For HomePage");
                    System.out.println("Press 2 for Admin Details");
                    System.out.println("Press 0 For Exit Application");
                    i = sc.next();
                    if(i.equals("1")) {
                        HomePage.getHomepage();
                    }else if(i.equals("2")){
                        Admin.getDetails();
                    }
                    else if(i.equals("0")){
                        System.out.println("\nTHANK YOU FOR VISIT..!!");
                        System.exit(0);
                    }
                    else {
                        System.out.println("Enter Correct Input");
                    }
                }while(!i.equals("1") && !i.equals("2"));
            }
            else {
                System.out.println("Enter Correct Input");
            }
        }while(!i.equals("1") && !i.equals("2"));
    }

    public static void getUserListDetails() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("Select * from user_list");
            System.out.println("\n--------------------------------------------------");
            System.out.println(String.format("%-10s","Sr.No")+ String.format("%-20s","Name")+ String.format("%-20s","UserName"));
            System.out.println("--------------------------------------------------");
            while(rs.next()) {
                System.out.println(String.format("%-10s",rs.getInt("Serial_No"))+String.format("%-20s",rs.getString("Name"))+String.format("%-20s",rs.getString("Mob_Num")));
            }
            System.out.println("--------------------------------------------------\n");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void getItemListDeatils() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("Select * from items");
            System.out.println("\n------------------------------------------------------");
            System.out.println(String.format("%-15s","Product Id")+String.format("%-24s","Product Name")+"Quantity");
            System.out.println("------------------------------------------------------");
            while(rs.next()) {
                System.out.println(String.format("%-15s",rs.getString("id"))+String.format("%-27s",rs.getString("Name"))+rs.getInt("Quantity"));
            }

            System.out.println("------------------------------------------------------\n");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void getPurchaseHistoryDetails() {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","root");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("Select * from purchase_history");
            System.out.println("\n---------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("%-20s","User Name")+String.format("%-23s","Product Name")+String.format("%-12s","Quantity")+String.format("%-18s","Product Price")+String.format("%-25s","Total Bill Amount")+"Date And Time");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            while(rs.next()) {
                System.out.println(String.format("%-20s", rs.getString("name"))+String.format("%-26s",rs.getString("item_name"))+String.format("%-12s",rs.getInt("quantity"))+String.format("%-18s",rs.getInt("item_price"))+String.format("%-20s",rs.getInt("total_amount"))+rs.getString("Date_And_Time"));
            }

            System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
