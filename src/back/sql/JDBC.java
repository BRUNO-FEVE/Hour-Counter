package back.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.ConnectionEventListener;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBC {
    
    private String name;
    private String password;
    private String ra;
    private String entity;
    private String area;
    private String project;
    private String id;
    private String id_hours;
    private String hours;
    private String desc;
    
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

    public JDBC(String ra, String password){
    this.ra = ra;
    this.password = password;
    
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
    public String getId(){
        return id;
    }
    public String getHours(){
        return hours;
    }
    public String getDesc(){
        return desc;
    }
    public String getId_hours(){
        return id_hours;
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
    public void setId(String id){
        this.id = id;
    }
    public void setHours(String hours){
        this.hours = hours;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setId_hours(String id_hours){
        this.id_hours = id_hours;
    }
       
    

public void insertLogin(Connection conn){
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

public void insertHours(Connection conn){
    String sqlInsert = 
    "INSERT INTO hours (login_id, hours, description) VALUES (?,?,?)";  
    
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, getId());
            stm.setString(2, getHours());
            stm.setString(3, getDesc());
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
    
public void loadLogin(Connection conn){
    String sqlSelect = "SELECT name, password, entity, area, project, ra, id FROM login WHERE ra = ? AND PASSWORD = ?";
    PreparedStatement stm = null;
    ResultSet rs = null;
    try  {
        stm = conn.prepareStatement(sqlSelect);
        stm.setString(1, getRa());
        stm.setString(2, getPassword());
        rs = stm.executeQuery();
        
        while (rs.next()) {
            setName(rs.getString(1));
            setPassword(rs.getString(2));
            setEntity(rs.getString(3));
            setArea(rs.getString(4));
            setProject(rs.getString(5));
            setRa(rs.getString(6));
            setId(rs.getString(7));
            

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
public void loadHours(Connection conn){
    String sqlSelect = "SELECT id, hours, description FROM hours WHERE login_id = ?";
    PreparedStatement stm = null;
    ResultSet rs = null;
    try {
        stm = conn.prepareStatement(sqlSelect);
        stm.setString(1, getId());
        rs = stm.executeQuery();
        while (rs.next()) {
            setId_hours(rs.getString(1));
            setHours(rs.getString(2));
            setDesc(rs.getString(3));
            
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
public void update(Connection conn){
    String sqlUpdate = "UPDATE login SET name = ?, password = ?, ra = ?, entity = ?, area = ?, project = ?" + "WHERE id = ?";
    PreparedStatement stm = null;
    try{
        stm = conn.prepareStatement(sqlUpdate);
        stm.setString(1, getName());
        stm.setString(2, getPassword());
        stm.setString(3, getRa());
        stm.setString(4, getEntity());
        stm.setString(5, getArea());
        stm.setString(6, getProject());
        stm.setString(7, getId());
        stm.execute();

    }
    catch(Exception e){
        e.printStackTrace();
        try{
            conn.rollback();
        }
        catch(SQLException e1){
            System.out.print(e1.getStackTrace());
        }
    }
    finally{
        if(stm != null){
            try{
                stm.close();
            }
            catch(SQLException e1){
                System.out.print(e1.getStackTrace());
            }
        }
    }
}
}
