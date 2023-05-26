import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBC {
    
    private String name;
    private String password;
    private String ra;
    private String entity;
    private String area;
    private String project;
    
    public JDBC()
    {
    } 
    public JDBC(String name, String password, String ra, String entity, String area, String project){
    this.name = name;
    this.password = password;
    this.ra = ra;
    this.entity = entity;
    this.area = area;
    this.project = project;
    }
    
   //gets
   public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getRa(){
        return ra;
    }
    public String getEntity(){
        return entity;
    }
    public String getArea(){
        return area;
    }
    public String getProject(){
        return project;
    }
    
    //sets
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRa(String ra){
        this.ra = ra;
    }
    public void setEntity(String entity){
        this.entity = entity;
    }
    public void setArea(String area){
        this.area = area;
    }
    public void setProject(String project){
        this.project = project;
    }
    
    

public void insert(Connection conn){
    String sqlInsert = 
    "INSERT INTO login (name,password,ra,entity,area,project) VALUES (?,?,?,?,?,?)";
    PreparedStatement stm = null;
    try {
        stm = conn.prepareStatement(sqlInsert);
        stm.setString(1, getName());
        stm.setString(2, getPassword());
        stm.setString(3, getRa());
        stm.setString(4, getEntity());
        stm.setString(5, getArea());
        stm.setString(6, getProject());
        stm.execute();
        }
    catch (Exception e) {
        e.printStackTrace();
        try{
            conn.rollback();
        }
        catch (SQLException e1){
            System.out.print(e1.getStackTrace());
        }
}
finally {
    if (stm != null) {
        try {
            stm.close();
        }
        catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
    }
}
}
public void load(Connection conn){
    String sqlSelect = "SELECT name, password, ra, entity, area, project FROM login";
    PreparedStatement stm = null;
    ResultSet rs = null;
    try {
        stm = conn.prepareStatement(sqlSelect);
        rs = stm.executeQuery();
        while (rs.next()) {
            setName(rs.getString(1));
            setPassword(rs.getString(2));
            setRa(rs.getString(3));
            setEntity(rs.getString(4));
            setArea(rs.getString(5));
            setProject(rs.getString(6));
        }
    }
    catch (Exception e) {
        e.printStackTrace();
        try {
            conn.rollback();
        }
        catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
    }
    finally {
        if (stm != null) {
            try {
                stm.close();
            }
            catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
        }
    }
}
}
