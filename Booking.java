import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Booking {
    String Name;
    int busNo;
    Date date;

    Booking() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your name : ");
        Name = scanner.next();

        System.out.println("Enter bus No : ");
        busNo = scanner.nextInt();

        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public  boolean isAvailable(ArrayList<Booking> bookings, ArrayList<busDetails> buses) {

        int capacity = 0;

        for(busDetails bus: buses) {
            if (bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
            }
        }

        int booked = 0;

        for(Booking b: bookings) {
            if (b.busNo == busNo && b.date.equals((date))) {
                booked++;
            }
        }

        return booked<capacity?true:false;
    }
}
