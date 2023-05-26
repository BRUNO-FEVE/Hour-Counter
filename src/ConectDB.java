import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectDB {
   static
   {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
      }
      catch (ClassNotFoundException e)
      {
         throw new RuntimeException(e);
      }
   }

   public Connection conect() throws SQLException {
    String server = "localhost";
    String port = "3306";
    String database = "hours";
    String username = "root";
    String password = "senha123";
    return DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database+"?user="+username+"&password="+password);
}
}
