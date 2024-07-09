import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BusDAO {
    private Connection connection;
    public BusDAO(Connection connection) {
        this.connection = connection;
    }
    //create bus
    public void add_Bus(int bus_no,int capacity,String destination,int price) throws SQLException {
        try {
        String query = "insert into bus(bus_no,capacity,destination,price) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bus_no);
        preparedStatement.setInt(2, capacity);
        preparedStatement.setString(3, destination);
        preparedStatement.setInt(4, price);

        int busStatus = preparedStatement.executeUpdate();
        if(busStatus > 0) {
            System.out.println("bus added successfully");
        }else {
            System.out.println("bus not added");
        }
        preparedStatement.close();
    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }finally {
        DatabaseConnection.closeConnection(connection);
    }
    }


    // read operation for all buses
    public void bus_details() throws SQLException {
    try {
        String query = "select * from bus";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        int i=1;
        while(resultSet.next()){
            System.out.print(i+" bus_no: "+resultSet.getInt("bus_no")+"\\ capacity: "+resultSet.getInt("capacity")+"\\ destination: "+resultSet.getString("destination")+"\\ price per ticket: "+resultSet.getInt("price"));
            System.out.println();
            i++;
        }
        resultSet.close();
        preparedStatement.close();
    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }finally {
        DatabaseConnection.closeConnection(connection);
    }
}

    // update operation for buses :
    public void update_details(int bus_no) throws SQLException {
        try {
        
        //showing details of the bus which user have requested!
        String query0 = "select capacity,destination,price from bus where bus_no = "+bus_no;
        PreparedStatement preparedStatement2 = connection.prepareStatement(query0);
        ResultSet resultSet = preparedStatement2.executeQuery();
        if(resultSet.next()) {
            System.out.println("bus details-> capacity: "+resultSet.getInt("capacity")+"\\ destination: "+resultSet.getString("destination")+"\\ price: "+resultSet.getInt("price"));
            preparedStatement2.close();
        }else {
            System.out.println("enter bus number properly");
            System.exit(0);
        }
        String query = "update bus set capacity=?,destination=?,price=? where bus_no="+bus_no;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter all the details of the bus, if no change then add previous details flashing above!!");
        System.out.println("*******************");
        System.out.println("Enter capacity: ");
        preparedStatement.setInt(1, scanner.nextInt()); //capacity
        System.out.println("Enter Destination: ");
        preparedStatement.setString(2, scanner.next()); //destination
        System.out.println("Enter price for ticket: ");
        preparedStatement.setInt(3, scanner.nextInt()); //price
        int updateStatus = preparedStatement.executeUpdate();
        if(updateStatus > 0 ) {
            System.out.println("bus detail updated! ");
        }else {
            System.out.println("unable to update details,kindly enter details proplerly");
            System.exit(0);
        }
        preparedStatement.close();
        scanner.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
    }



    // delete operation for buses 
    public void delete_bus(int bus_no) throws SQLException {
        
        String query = "delete from bus where bus_no="+bus_no;
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        int deleteStatus = preparedStatement.executeUpdate();
        if(deleteStatus > 0) {
            System.out.println("Bus deleted Successfully");
        }else {
            System.out.println("Bus does not exists");
            System.exit(0);
        }
        preparedStatement.close();
        DatabaseConnection.closeConnection(connection);
    }
}