import java.util.Scanner;

public class Menu {

    @SuppressWarnings("unused")
    public Menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {  
            System.out.println("*");
            System.out.println("*");
            System.out.println("*");
            System.out.println("*******Bus travel agency*******");
            System.out.println("1. Check about bus");
            System.out.println("2. Check about Passenger reservation");
            System.out.println("3. Exit ");
            System.out.print("Enter choice: ");

            int choice0 = scanner.nextInt();
            if (choice0 == 1) {
                System.out.println("1. Add a new bus");
                System.out.println("2. See all available buses");
                System.out.println("3. Update bus Details");
                System.out.println("4. Delete a bus");
                int choice = scanner.nextInt();
                if(choice == 1) {
                    System.out.print("Enter bus Number: ");
                    int bus_no= scanner.nextInt();
                    System.out.print("Enter bus capacity");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter destination: ");
                    String destination = scanner.next();
                    System.out.print("Enter ticket price");
                    int price = scanner.nextInt();
                    Bus bus = new Bus(bus_no, capacity, destination, price);
                }else if (choice == 2) {
                    Bus.all_buses();
                }else if (choice == 3) {
                    System.out.print("Enter Bus Number you want to update: ");
                    Bus.update_bus(scanner.nextInt());
                }else if (choice == 4){
                    System.out.print("Enber Bus Number you want to delete: ");
                    Bus.delete_bus(scanner.nextInt());
                }
            }else if (choice0 == 2) {
                System.out.println("1. Add new Passenger to a bus");
                System.out.println("2. See Passenger Detail");
                System.out.println("3. Update Passenger's Detail");
                System.out.println("4. Delete a Passenger's reservation");
                int choice = scanner.nextInt();
                if(choice == 1) {
                    System.out.print("Enter Passenger's Name: ");
                    String passenger_name = scanner.next();
                    System.out.print("Enter Bus Number: ");
                    int bus_no = scanner.nextInt();
                    Passenger passenger = new Passenger(passenger_name, bus_no);
                }else if (choice == 2) {
                    System.out.print("Enter Passenger's ID:");
                    Passenger.displayID(scanner.nextInt());
                }else if (choice == 3) {
                    System.out.print("Enter Passenger's ID u want to Update");
                    Passenger.updateP(scanner.nextInt());
                }else if (choice == 4) {
                    System.out.print("Enter Passenger's ID u want to Delete");
                    Passenger.deleteP(scanner.nextInt());
                }
            }else {
                scanner.close();
                break;
            }
        }

}
}

