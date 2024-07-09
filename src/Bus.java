import java.sql.SQLException;

public class Bus extends SQLException{
    public int capacity;
    public int bus_no;
    public String destination;
    public int price;
    public  int passenger_count;

    public Bus() {

    }
    public Bus(int bus_no,int capacity,String destination,int price) {
        this.capacity = capacity;
        this.bus_no = bus_no;
        this.destination = destination;
        this.price = price;
        try {
            BusDAO bus = new BusDAO(DatabaseConnection.getConnection());
            bus.add_Bus(bus_no,capacity,destination,price);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static void all_buses() {
        try {
            BusDAO bus = new BusDAO(DatabaseConnection.getConnection());
            bus.bus_details();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update_bus(int bus_no) {
        try {
            BusDAO bus = new BusDAO(DatabaseConnection.getConnection());
            bus.update_details(bus_no);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete_bus(int bus_no){
        try {
            BusDAO bus = new BusDAO(DatabaseConnection.getConnection());
            bus.delete_bus(bus_no);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
