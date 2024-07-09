import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PassengerDAO {
    private Connection connection;
    public PassengerDAO(Connection connection) {
        this.connection = connection;
    }    


    // add passenger
    public void add_passenger(String passenger_name,int bus_no) throws SQLException {   
            String query = "insert into passenger(passenger_name,bus_no) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, passenger_name);
            preparedStatement.setInt(2, bus_no);
            int add_status = preparedStatement.executeUpdate();
            if(add_status > 0) {
                System.out.println("added passenger succesfully");
            }else {
                System.out.println("unable to add passenger");
            }
            preparedStatement.close();
            DatabaseConnection.closeConnection(connection);
    }


    // update detail of passenger
    public void update_passenger(int passenger_id) throws SQLException {
        String query0 = "select * from passenger where passenger_id="+passenger_id;
        PreparedStatement preparedStatement0 = connection.prepareStatement(query0);
        ResultSet resultSet = preparedStatement0.executeQuery();
        if(resultSet.next()) {
            System.out.println("Passenger "+passenger_id+" details-> "+" Passenger ID: "+passenger_id+" Name: "+resultSet.getString("passenger_name")+"\\ Bus number: "+resultSet.getInt("bus_no"));
        }else
        {
            System.out.println("Passenger_id doesn't exists");
            System.exit(0);
        }
        String query = "update passenger set passenger_name=?,bus_no=? where passenger_id="+passenger_id;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter all the details of the Passenger, if no change then add previous details flashing above!!");
        System.out.println("*******************");
        System.out.print("Enter name: ");
        preparedStatement.setString(1, scanner.next());
        System.out.print("Enter bus number:v");
        preparedStatement.setInt(2, scanner.nextInt());
        int updatePassenger = preparedStatement.executeUpdate();
        if(updatePassenger > 0) {
            System.out.println("updated successfully");
        }else {
            System.out.println("unable to update check input");
        }

        scanner.close();
        preparedStatement0.close();
        preparedStatement.close();
        DatabaseConnection.closeConnection(connection);
    }


    //delete passenger
    public void delete_passenger(int passenger_id) throws SQLException {
        String query = "delete from passenger where passenger_id="+passenger_id;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int deleteStatus = preparedStatement.executeUpdate();
        if (deleteStatus > 0) {
            System.out.println("passenger deleted!");
        }else {
            System.out.println("passenger does not exists");
            System.exit(0);
        }  
        preparedStatement.close();
        DatabaseConnection.closeConnection(connection);
    }


    // display passengers:
    public void display_by_ID(int passenger_id) throws SQLException{
        String query = "select passenger.passenger_name,passenger.bus_no,bus.destination,bus.price from passenger inner join bus on passenger.bus_no = bus.bus_no where passenger_id="+passenger_id;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            System.out.println("Passenger details: ");
            System.out.println("      ID      Name      Bus Number      Destination      Ticket price      ");
            System.out.println("      "+passenger_id+"       "+resultSet.getString("passenger_name")+"      "+resultSet.getInt("bus_no")+"              "+resultSet.getString("destination")+"           "+resultSet.getInt("price")+"   ");
        }else {
            System.out.println("Passenger does not exists");
            System.exit(0);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    
}
