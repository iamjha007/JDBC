package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionSetup {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:3306/testdb";
            String user="root";
            String password="root";
            Connection con= DriverManager.getConnection(url,user,password);

            if(con.isClosed()){
                System.out.println("Connection is already closed");
            }else{
                System.out.println("yh boiii!! Connection is open");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
