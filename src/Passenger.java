import java.sql.SQLException;
    public class Passenger {
    public int passenger_id;
    public  String passenger_name;
    public  int bus_no;


    public Passenger(String passenger_name,int bus_no) {
        
        this.passenger_name = passenger_name;
        this.bus_no = bus_no;
            try {
                PassengerDAO passenger = new PassengerDAO(DatabaseConnection.getConnection());
                passenger.add_passenger(passenger_name, bus_no);
            }catch (SQLException e ) {
                System.out.println(e.getMessage()); 
            }
        }
    

    public static void updateP(int passenger_id) {
        try {
            PassengerDAO passenger = new PassengerDAO(DatabaseConnection.getConnection());
            passenger.update_passenger(passenger_id);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteP(int passenger_id) {
        try {
            PassengerDAO passenger = new PassengerDAO(DatabaseConnection.getConnection());
            passenger.delete_passenger(passenger_id);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }    

    public static void displayID(int passenger_id) {
        try {
            PassengerDAO passenger = new PassengerDAO(DatabaseConnection.getConnection());
            passenger.display_by_ID(passenger_id);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
