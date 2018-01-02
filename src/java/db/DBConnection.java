package db;

import com.mysql.jdbc.Driver;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anil
 */
public class DBConnection implements Serializable{
    private final String db_url="jdbc:mysql://localhost:3307/e-commerce";
    private final String db_username="root";
    private final String db_password="377238";
    
    private Connection connection=null;
    protected PreparedStatement ps=null;
    
    protected ResultSet rs=null;
    
    public Connection connect() throws SQLException {
      DriverManager.registerDriver(new Driver());
      connection=DriverManager.getConnection(db_url,db_username,db_password);
      return connection;
    }
    public void disconnect(){
    try {
        connection.close();
        ps.close();
        rs.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    
    
}
