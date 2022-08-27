package e_commerce;

import java.time.LocalDateTime;
import java.time.format.*;

public class DateAndTime {
    static String dt;
    public static void getDateAndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dt = dtf.format(now);

    }
}
