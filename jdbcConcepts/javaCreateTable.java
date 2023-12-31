package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class javaCreateTable {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:3306/testdb";
            String user="root";
            String password="root";
            String query="create table student(adm_id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(30) NOT NULL);";
            Connection con= DriverManager.getConnection(url,user,password);

            if(con.isClosed()){
                System.out.println("Connection is already closed");
            }else{
                System.out.println("yh boiii!! Connection is open");
            }
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
