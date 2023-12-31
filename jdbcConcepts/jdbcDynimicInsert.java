package jdbcConcepts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class jdbcDynimicInsert {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:3306/testdb";
            String user="root";
            String password="root";
            String query="insert into student(name,emailid,phNumber) VALUES(?,?,?);";
            Connection con= DriverManager.getConnection(url,user,password);

            if(con.isClosed()){
                System.out.println("Connection is already closed");
            }else{
                System.out.println("yeh boiii!! Connection is open");
            }
            PreparedStatement pstmt=con.prepareStatement(query);

            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.printf("Enter Name");
            String name=br.readLine();
            System.out.println("Enter Email");
            String email=br.readLine();
            System.out.println("Enter Phone Number");
            String phone=br.readLine();

            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,phone);
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
