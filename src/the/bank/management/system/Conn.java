
package the.bank.management.system;

import java.sql.*; 

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebankmanagementsystem?useSSL=false","root","Anamika@1901");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
