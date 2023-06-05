package back.sql;
import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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

    public boolean userFound = false;
    
    public JDBC() {
    } 

    public JDBC(Object[] newUser){
    this.name = newUser[0].toString();
    this.password = newUser[5].toString();
    this.ra = newUser[1].toString();
    this.entity = newUser[2].toString();
    this.area = newUser[3].toString();
    this.project = newUser[4].toString();
    }

    public JDBC(String ra, String password){
    this.ra = ra;
    this.password = password;
    
    }

    public JDBC(String ra){
        this.ra = ra;
        }

    public JDBC(String ra, String hours, String desc){
        this.ra = ra;
        this.hours = hours;
        this.desc = desc;        
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
    public boolean getUserFound() {
        return this.userFound;
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
    "INSERT INTO hours (login_ra, hours, description) VALUES (?,?,?)";  
    
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, getRa());
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
    
public boolean loadLogin(Connection conn){
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
            this.userFound = true;
        }
        
    }
    catch (Exception e) {
        e.printStackTrace();
        return false;
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
    return this.userFound;
}
public ArrayList<Object[]> loadHours(Connection conn){
    ArrayList<Object[]> hoursList = new ArrayList<>();
    String sqlSelect = "SELECT id, description, hours FROM hours WHERE login_ra = ?";
    PreparedStatement stm = null;
    ResultSet rs = null;
    try {
        stm = conn.prepareStatement(sqlSelect);
        stm.setString(1, getRa());
        rs = stm.executeQuery();
        while (rs.next()) {
            
            String id = rs.getString(1);
            String description = rs.getString(2);
            String hour = rs.getString(3);
            String[] hourData = {id,description,hour};
            hoursList.add(hourData);
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
    return hoursList;
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
