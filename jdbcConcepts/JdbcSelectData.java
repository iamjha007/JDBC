package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelectData {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:3306/testdb";
            String user="root";
            String password="root";
            String query="SELECT * FROM STUDENT";
            Connection con= DriverManager.getConnection(url,user,password);

            if(con.isClosed()){
                System.out.println("Connection is already closed");
            }else{
                System.out.println("yh boiii!! Connection is open");
            }
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            while (resultSet.next()){

                System.out.print(resultSet.getInt(1));
                System.out.print(resultSet.getString(2));
                System.out.print(resultSet.getString(3));
                System.out.print(resultSet.getString(4));
                System.out.println("");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
