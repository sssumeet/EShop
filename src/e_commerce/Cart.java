package e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.sql.SQLException;

public class Cart {

    static int BillAmount;
    public static void getCartDetails() {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        int i = 0;
        int k=2;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n...My Cart...\n");
        for(Items z: Shopping.a)
        {
            System.out.println(z);
            BillAmount += z.p;
            hm.put(k,z.n);
            k++;
        }

        System.out.println("\nTotal Bill Amount= "+BillAmount);
        System.out.println("\nTo Place Order, Select 1:");
        System.out.println("To Remove Item From Cart, Select 2:");

        i = sc.nextInt();

        if(i==2) {

            System.out.println();

            Set<Integer> set = hm.keySet();
            do {
                for(int g : set) {

                    System.out.println("Press "+(g-1)+" to Remove "+hm.get(g));
                }
                System.out.println("Press 0 to Discard And Place Order.");
                i = sc.nextInt();
                if(i==0) {
                    break;
                }

                BillAmount = BillAmount-Shopping.a.get(i-1).p;
                Shopping.a.remove(i-1);
                hm.clear();
                k=2;

                for(Items z: Shopping.a)
                {
                    hm.put(k,z.n);
                    k++;
                }
                System.out.println();

                for(Items z : Shopping.a)
                {
                    System.out.println(z);
                }
                if(Shopping.a.size()==0)
                {
                    System.out.println("Your Cart is Empty...");
                    break;
                }
                else
                {
                    System.out.println("\nTotal Bill Amount= "+BillAmount);
                    System.out.println("\nFor Removing Another Item, Select 1");
                    System.out.println("For Placing Order Select 2");
                }

                i = sc.nextInt();
                if(i==2) {
                    break;
                }

            }while(Shopping.a.size()!=0);

        }

        String a="";
        do {
            if(Shopping.a.size()!=0) {
                System.out.println("\nPress 1 to Place Order");
                System.out.println("Press 2 to Add Another Items\n");
            }else {
                do {
                    System.out.println("\nPress 2 to Add Items");
                    System.out.println("Press 0 For Exit Application");
                    a = sc.next();

                    if(a.equals("2"))
                    {
                        BillAmount=0;

                        ItemListforPurchase.getItemList();
                    }
                    else if(a.equals("0")) {
                        sc.close();
                        System.out.println("\nTHANK YOU FOR SHOPPING WITH US DO VISIT AGAIN");
                        System.exit(0);
                    }else {
                        System.out.println("Enter Correct Input");
                    }
                }while(!a.equals("2"));
            }

            a = sc.next();
            if(a.equals("1"))
            {

                DateAndTime.getDateAndTime();
                UpdateHistory.getUpdateHistoryDetails();

                for(Items z: Shopping.a)
                {
                    UpdateQty.updateQuantity(z.n,z.uq);
                }

                System.out.println("Order Placed Successfully...\n");
                System.out.println("THANK YOU FOR SHOPPING ON E-SHOP...\n");

                Shopping.a.clear();
                String m ="";
                do {
                    System.out.println("Enter 1 For E-Shop HomePage");
                    System.out.println("Enter 0 For Exit Application");
                    m = sc.next();

                    if(m.equals("1")) {
                        HomePage.getHomepage();
                    }else if(m.equals("0")) {
                        sc.close();
                        System.out.println("\nTHANK YOU FOR SHOPPING WITH US DO VISIT AGAIN");
                        System.exit(0);
                    }else {
                        System.out.println("Enter Correct Input");
                    }
                }while(!m.equals("1") && !m.equals("2"));


            }
            else if(a.equals("2"))
            {
                BillAmount=0;

                ItemListforPurchase.getItemList();
            }
            else if(a.equals("0")) {
                sc.close();
                System.out.println("\nTHANK YOU FOR SHOPPING WITH US DO VISIT AGAIN");
                System.exit(0);
            }

            else {
                System.out.println("Enter correct Input");
            }
        }while(!a.equals("1") && !a.equals("2"));
    }

}
