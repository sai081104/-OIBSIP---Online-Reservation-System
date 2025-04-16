import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, source, destination, date;

        System.out.println("Welcome to the Online Reservation System");

        System.out.print("Enter Passenger Name: ");
        name = sc.nextLine();
        System.out.print("Enter Source Station: ");
        source = sc.nextLine();
        System.out.print("Enter Destination Station: ");
        destination = sc.nextLine();
        System.out.print("Enter Date of Journey (dd-mm-yyyy): ");
        date = sc.nextLine();

        System.out.println("\nReservation Successful!");
        System.out.println("Passenger: " + name);
        System.out.println("From: " + source + " To: " + destination);
        System.out.println("Journey Date: " + date);
        sc.close();
    }
}