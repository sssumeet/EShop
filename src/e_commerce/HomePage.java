package e_commerce;

import java.util.Scanner;

public class HomePage {
    public static void getHomepage() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n<<<...Welcome to E-Shop...>>>\n");
        System.out.println();
        String i="";
        do
        {
            System.out.println("Press 1 For Admin Login\n");

            System.out.println("Press 2 For User Login\n");

            System.out.println("Press 3 For New Registration\n");

            System.out.println("Press 0 For Exit Application");

            i=sc.next();

            switch(i)
            {
                case "1" :
                    Admin.getAdminLogin();
                    break;

                case "2" :
                    Login.getLogin();
                    break;

                case "3" :
                    Registration.getRegistration();
                    break;

                case "0":
                    System.out.println("\nTHANK YOU FOR SHOPPING WITH US DO VISIT AGAIN");
                    System.exit(0);
                    break;

                default :
                    System.out.println("Enter correct input");
                    break;
            }
        }while(!i.equals("1") && !i.equals("2") && !i.equals("3"));
        sc.close();

    }
}
