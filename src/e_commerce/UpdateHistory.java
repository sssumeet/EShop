package e_commerce;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateHistory {

    public static void getUpdateHistoryDetails()
    {
        try {int count=0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/E_Shop", "root","root");
            PreparedStatement ps=connection.prepareStatement("insert into purchase_history (name,user_name,item_name,quantity,item_price,total_amount,Date_And_Time) values (?,?,?,?,?,?,?);");

            for(Items z: Shopping.a)
            {
                if(count==0) {


                    ps.setString(1,Login.name);
                    ps.setString(2,Login.uName);
                    ps.setInt(6, Cart.BillAmount);
                    ps.setString(7, DateAndTime.dt);
                }
                ps.setString(3,z.n);
                ps.setInt(4,z.q);
                ps.setInt(5, z.p);
                ps.executeUpdate();

                count++;
                ps.setString(1,"-");
                ps.setString(2,"-");
                ps.setInt(6,0);
                ps.setString(7, "--/--/--   --:--:--");
            }

            connection.close();
            ps.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
