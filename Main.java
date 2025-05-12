import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<busDetails> buses = new ArrayList<busDetails>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new busDetails(1,true,50));
        buses.add(new busDetails(2,false,55));
        buses.add(new busDetails(3,true,53));

        for(busDetails b: buses) {
            b.DisplayBusDetails();
        }

        int userResponse = 1;

        while (userResponse == 1) {
            System.out.println("1 for booking and 0 for booking stop : ");
            Scanner scanner = new Scanner(System.in);
            userResponse = scanner.nextInt();

            if(userResponse == 1) {
                Booking booking = new Booking();
                if(booking.isAvailable(bookings, buses)) {
                    bookings.add(booking);
                    System.out.println("Your booking is confirmed");
                }
                else {
                    System.out.println("Sorry, Bus is full. Try another Bus or Date");
                }
            }
        }

    }
}