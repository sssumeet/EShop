package e_commerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Shopping {
    static ArrayList<Items> a= new ArrayList<Items>();

    public static void getShoppingDetails()
    {

        String i="";
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("\nPress 1 for adding Item in Cart");
            System.out.println("press 2 for Item List");
            i=scanner.next();

            if(i.equals("1"))
            {


                System.out.println("\nEnter Qunatity of Items to add");
                int Q=scanner.nextInt();

                if(Q<=ItemListDetails.Qty)
                {
                    int uq = ItemListDetails.Qty - Q;
                    a.add(new Items(ItemListDetails.name,Q,ItemListDetails.price*Q,uq));
                    String j="";
                    System.out.println("\nItem added in Cart...\n");
                    do {
                        System.out.println("press 1 to go to cart");
                        System.out.println("press 2 for Shopping");
                        j=scanner.next();

                        if(j.equals("1"))
                        {
                            Cart.getCartDetails();
                        }
                        else if(j.equals("2")){

                            ItemListforPurchase.getItemList();
                        }
                        else {
                            System.out.println("Enter correct input");
                        }
                    }while(!j.equals("1") && !j.equals("2"));

                }else {
                    System.out.println("Stock not available, Please decrease quantity of items.");
                    ItemListforPurchase.getItemList();
                }
            }
            else if(i.equals("2"))
            {
                ItemListforPurchase.getItemList();
            }
            else
            {
                System.out.println("Enter correct input");
            }

        }while(!i.equals("1") && !i.equals("2"));

    }
}
